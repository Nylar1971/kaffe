/* XMLParser.java -- 
   Copyright (C) 2005  Free Software Foundation, Inc.

This file is part of GNU Classpath.

GNU Classpath is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 2, or (at your option)
any later version.

GNU Classpath is distributed in the hope that it will be useful, but
WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
General Public License for more details.

You should have received a copy of the GNU General Public License
along with GNU Classpath; see the file COPYING.  If not, write to the
Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
02110-1301 USA.

Linking this library statically or dynamically with other modules is
making a combined work based on this library.  Thus, the terms and
conditions of the GNU General Public License cover the whole
combination.

As a special exception, the copyright holders of this library give you
permission to link this library with independent modules to produce an
executable, regardless of the license terms of these independent
modules, and to copy and distribute the resulting executable under
terms of your choice, provided that you also meet, for each linked
independent module, the terms and conditions of the license of that
module.  An independent module is a module which is not derived from
or based on this library.  If you modify this library, you may extend
this exception to your version of the library, but you are not
obligated to do so.  If you do not wish to do so, delete this
exception statement from your version.

Partly derived from code which carried the following notice:

  Copyright (c) 1997, 1998 by Microstar Software Ltd.

  AElfred is free for both commercial and non-commercial use and
  redistribution, provided that Microstar's copyright and disclaimer are
  retained intact.  You are free to modify AElfred for your own use and
  to redistribute AElfred with your modifications, provided that the
  modifications are clearly documented.

  This program is distributed in the hope that it will be useful, but
  WITHOUT ANY WARRANTY; without even the implied warranty of
  merchantability or fitness for a particular purpose.  Please use it AT
  YOUR OWN RISK.
*/

package gnu.xml.stream;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLReporter;
import javax.xml.stream.XMLResolver;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import gnu.java.net.CRLFInputStream;

/**
 * An XML parser.
 *
 * @author <a href='mailto:dog@gnu.org'>Chris Burdess</a>
 */
public class XMLParser
  implements XMLStreamReader, NamespaceContext
{

  private static final int INIT = 0;
  private static final int PROLOG = 1;
  private static final int CONTENT = 2;
  private static final int EMPTY_ELEMENT = 3;
  private static final int MISC = 4;

  private final static int LIT_ENTITY_REF = 2;
  private final static int LIT_NORMALIZE = 4;
  private final static int LIT_ATTRIBUTE = 8;
  private final static int LIT_DISABLE_PE = 16;
  private final static int LIT_DISABLE_CREF = 32;
  private final static int LIT_DISABLE_EREF = 64;
  private final static int LIT_PUBID = 256;

  final static int ATTRIBUTE_DEFAULT_UNDECLARED = 30;
  final static int ATTRIBUTE_DEFAULT_SPECIFIED = 31;
  final static int ATTRIBUTE_DEFAULT_IMPLIED = 32;
  final static int ATTRIBUTE_DEFAULT_REQUIRED = 33;
  final static int ATTRIBUTE_DEFAULT_FIXED = 34;

  private Input input;
  private LinkedList inputStack = new LinkedList();
  private LinkedList startEntityStack = new LinkedList();
  private LinkedList endEntityStack = new LinkedList();
  
  private int state = INIT;
  private int event;
  private boolean lookahead;
  private LinkedList stack = new LinkedList();
  private LinkedList namespaces = new LinkedList();
  private LinkedList bases = new LinkedList();
  private ArrayList attrs = new ArrayList();
  private StringBuffer buf = new StringBuffer();
  private StringBuffer nmtokenBuf = new StringBuffer();
  private StringBuffer literalBuf = new StringBuffer();
  private char[] tmpBuf = new char[1024];
  
  private ContentModel currentContentModel;
  private LinkedList validationStack = new LinkedList();

  private String piTarget, piData;

  private String xmlVersion;
  private String xmlEncoding;
  private Boolean xmlStandalone;

  Doctype doctype;
  private boolean expandPE, peIsError;

  private final boolean validating;
  private final boolean stringInterning;
  private final boolean coalescing;
  private final boolean replaceERefs;
  private final boolean externalEntities;
  private final boolean supportDTD;
  private final boolean namespaceAware;
  private final boolean baseAware;

  final XMLReporter reporter;
  final XMLResolver resolver;

  private static final String TEST_START_ELEMENT = "<";
  private static final String TEST_END_ELEMENT = "</";
  private static final String TEST_COMMENT = "<!--";
  private static final String TEST_PI = "<?";
  private static final String TEST_CDATA = "<![CDATA[";
  private static final String TEST_XML_DECL = "<?xml";
  private static final String TEST_DOCTYPE_DECL = "<!DOCTYPE";
  private static final String TEST_ELEMENT_DECL = "<!ELEMENT";
  private static final String TEST_ATTLIST_DECL = "<!ATTLIST";
  private static final String TEST_ENTITY_DECL = "<!ENTITY";
  private static final String TEST_NOTATION_DECL = "<!NOTATION";
  private static final String TEST_KET = ">";
  private static final String TEST_END_COMMENT = "--";
  private static final String TEST_END_PI = "?>";
  private static final String TEST_END_CDATA = "]]>";

  private static final LinkedHashMap PREDEFINED_ENTITIES = new LinkedHashMap();
  static
  {
    PREDEFINED_ENTITIES.put("amp", "&");
    PREDEFINED_ENTITIES.put("lt", "<");
    PREDEFINED_ENTITIES.put("gt", ">");
    PREDEFINED_ENTITIES.put("apos", "'");
    PREDEFINED_ENTITIES.put("quot", "\"");
  }

  public XMLParser(InputStream in, String systemId,
                   boolean validating,
                   boolean namespaceAware,
                   boolean coalescing,
                   boolean replaceERefs,
                   boolean externalEntities,
                   boolean supportDTD,
                   boolean baseAware,
                   boolean stringInterning,
                   XMLReporter reporter,
                   XMLResolver resolver)
  {
    this.validating = validating;
    this.namespaceAware = namespaceAware;
    this.coalescing = coalescing;
    this.replaceERefs = replaceERefs;
    this.externalEntities = externalEntities;
    this.supportDTD = supportDTD;
    this.baseAware = baseAware;
    this.stringInterning = stringInterning;
    this.reporter = reporter;
    this.resolver = resolver;
    pushInput(new Input(in, null, systemId, null));
  }

  public XMLParser(Reader reader, String systemId,
                   boolean validating,
                   boolean namespaceAware,
                   boolean coalescing,
                   boolean replaceERefs,
                   boolean externalEntities,
                   boolean supportDTD,
                   boolean baseAware,
                   boolean stringInterning,
                   XMLReporter reporter,
                   XMLResolver resolver)
  {
    this.validating = validating;
    this.namespaceAware = namespaceAware;
    this.coalescing = coalescing;
    this.replaceERefs = replaceERefs;
    this.externalEntities = externalEntities;
    this.supportDTD = supportDTD;
    this.baseAware = baseAware;
    this.stringInterning = stringInterning;
    this.reporter = reporter;
    this.resolver = resolver;
    pushInput(new Input(null, reader, null, systemId, null));
  }

  // -- NamespaceContext --

  public String getNamespaceURI(String prefix)
  {
    if (XMLConstants.XML_NS_PREFIX.equals(prefix))
      return XMLConstants.XML_NS_URI;
    for (Iterator i = namespaces.iterator(); i.hasNext(); )
      {
        LinkedHashMap ctx = (LinkedHashMap) i.next();
        String namespaceURI = (String) ctx.get(prefix);
        if (namespaceURI != null)
          return namespaceURI;
      }
    return null;
  }

  public String getPrefix(String namespaceURI)
  {
    if (XMLConstants.XML_NS_URI.equals(namespaceURI))
      return XMLConstants.XML_NS_PREFIX;
    for (Iterator i = namespaces.iterator(); i.hasNext(); )
      {
        LinkedHashMap ctx = (LinkedHashMap) i.next();
        if (ctx.containsValue(namespaceURI))
          {
            for (Iterator j = ctx.entrySet().iterator(); j.hasNext(); )
              {
                Map.Entry entry = (Map.Entry) i.next();
                String uri = (String) entry.getValue();
                if (uri.equals(namespaceURI))
                  return (String) entry.getKey();
              }
          }
      }
    return null;
  }

  public Iterator getPrefixes(String namespaceURI)
  {
    if (XMLConstants.XML_NS_URI.equals(namespaceURI))
      return Collections.singleton(XMLConstants.XML_NS_PREFIX).iterator();
    LinkedList acc = new LinkedList();
    for (Iterator i = namespaces.iterator(); i.hasNext(); )
      {
        LinkedHashMap ctx = (LinkedHashMap) i.next();
        if (ctx.containsValue(namespaceURI))
          {
            for (Iterator j = ctx.entrySet().iterator(); j.hasNext(); )
              {
                Map.Entry entry = (Map.Entry) i.next();
                String uri = (String) entry.getValue();
                if (uri.equals(namespaceURI))
                  acc.add(entry.getKey());
              }
          }
      }
    return acc.iterator();
  }

  // -- XMLStreamReader --

  public void close()
    throws XMLStreamException
  {
    stack = null;
    namespaces = null;
    bases = null;
    buf = null;
    attrs = null;
    doctype = null;
  }

  public NamespaceContext getNamespaceContext()
  {
    return this;
  }

  public int getAttributeCount()
  {
    return attrs.size();
  }

  public String getAttributeName(int index)
  {
    Attribute a = (Attribute) attrs.get(index);
    return a.localName;
  }

  public String getAttributeNamespace(int index)
  {
    String prefix = getAttributePrefix(index);
    return getNamespaceURI(prefix);
  }

  public String getAttributePrefix(int index)
  {
    Attribute a = (Attribute) attrs.get(index);
    return a.prefix;
  }

  public QName getAttributeQName(int index)
  {
    Attribute a = (Attribute) attrs.get(index);
    String namespaceURI = getNamespaceURI(a.prefix);
    return new QName(namespaceURI, a.localName, a.prefix);
  }

  public String getAttributeType(int index)
  {
    Attribute a = (Attribute) attrs.get(index);
    return a.type;
  }

  private String getAttributeType(String elementName, String attName)
  {
    if (doctype != null)
      {
        AttributeDecl att = doctype.getAttributeDecl(elementName, attName);
        if (att != null)
          return att.type;
      }
    return "CDATA";
  }

  public String getAttributeValue(int index)
  {
    Attribute a = (Attribute) attrs.get(index);
    return a.value;
  }

  public String getAttributeValue(String namespaceURI, String localName)
  {
    for (Iterator i = attrs.iterator(); i.hasNext(); )
      {
        Attribute a = (Attribute) i.next();
        if (a.localName.equals(localName))
          {
            String uri = getNamespaceURI(a.prefix);
            if ((uri == null && namespaceURI == null) ||
                (uri != null && uri.equals(namespaceURI)))
              return a.value;
          }
      }
    return null;
  }

  boolean isAttributeDeclared(int index)
  {
    if (doctype == null)
      return false;
    Attribute a = (Attribute) attrs.get(index);
    String qn = ("".equals(a.prefix)) ? a.localName :
      a.prefix + ":" + a.localName;
    String elementName = buf.toString();
    return doctype.isAttributeDeclared(elementName, qn);
  }
  
  public String getCharacterEncodingScheme()
  {
    return xmlEncoding;
  }

  public String getElementText()
    throws XMLStreamException
  {
    if (event != XMLStreamConstants.START_ELEMENT)
      throw new XMLStreamException("current event must be START_ELEMENT");
    StringBuffer elementText = new StringBuffer();
    int depth = stack.size();
    while (event != XMLStreamConstants.END_ELEMENT || stack.size() > depth)
      {
        switch (next())
          {
          case XMLStreamConstants.CHARACTERS:
          case XMLStreamConstants.SPACE:
            elementText.append(buf.toString());
          }
      }
    return elementText.toString();
  }

  public String getEncoding()
  {
    if (input.forceReader)
      return null;
    return (input.inputEncoding == null) ? "UTF-8" : input.inputEncoding;
  }

  public int getEventType()
  {
    return event;
  }

  public String getLocalName()
  {
    switch (event)
      {
      case XMLStreamConstants.START_ELEMENT:
      case XMLStreamConstants.END_ELEMENT:
        String qName = buf.toString();
        int ci = qName.indexOf(':');
        return (ci == -1) ? qName : qName.substring(ci + 1);
      default:
        return null;
      }
  }

  public Location getLocation()
  {
    return input;
  }

  public QName getName()
  {
    switch (event)
      {
      case XMLStreamConstants.START_ELEMENT:
      case XMLStreamConstants.END_ELEMENT:
        String qName = buf.toString();
        int ci = qName.indexOf(':');
        String localName = (ci == -1) ? qName : qName.substring(ci + 1);
        String prefix = (ci == -1) ?
          (namespaceAware ? XMLConstants.DEFAULT_NS_PREFIX : null) :
          qName.substring(0, ci);
        String namespaceURI = getNamespaceURI(prefix);
        return new QName(namespaceURI, localName, prefix);
      default:
        return null;
      }
  }

  public int getNamespaceCount()
  {
    if (!namespaceAware)
      return 0;
    switch (event)
      {
      case XMLStreamConstants.START_ELEMENT:
      case XMLStreamConstants.END_ELEMENT:
        LinkedHashMap ctx = (LinkedHashMap) namespaces.getFirst();
        return ctx.size();
      default:
        return 0;
      }
  }

  public String getNamespacePrefix(int index)
  {
    LinkedHashMap ctx = (LinkedHashMap) namespaces.getFirst();
    int count = 0;
    for (Iterator i = ctx.keySet().iterator(); i.hasNext(); )
      {
        String prefix = (String) i.next();
        if (count++ == index)
          return prefix;
      }
    return null;
  }

  public String getNamespaceURI()
  {
    switch (event)
      {
      case XMLStreamConstants.START_ELEMENT:
      case XMLStreamConstants.END_ELEMENT:
        String qName = buf.toString();
        int ci = qName.indexOf(':');
        if (ci == -1)
          return null;
        String prefix = qName.substring(0, ci);
        return getNamespaceURI(prefix);
      default:
        return null;
      }
  }

  public String getNamespaceURI(int index)
  {
    LinkedHashMap ctx = (LinkedHashMap) namespaces.getFirst();
    int count = 0;
    for (Iterator i = ctx.values().iterator(); i.hasNext(); )
      {
        String uri = (String) i.next();
        if (count++ == index)
          return uri;
      }
    return null;
  }

  public String getPIData()
  {
    return piData;
  }

  public String getPITarget()
  {
    return piTarget;
  }

  public String getPrefix()
  {
    switch (event)
      {
      case XMLStreamConstants.START_ELEMENT:
      case XMLStreamConstants.END_ELEMENT:
        String qName = buf.toString();
        int ci = qName.indexOf(':');
        return (ci == -1) ?
          (namespaceAware ? XMLConstants.DEFAULT_NS_PREFIX : null) :
          qName.substring(0, ci);
      default:
        return null;
      }
  }

  public Object getProperty(String name)
    throws IllegalArgumentException
  {
    if (name == null)
      throw new IllegalArgumentException("name is null");
    if (XMLInputFactory.ALLOCATOR.equals(name))
      return null;
    if (XMLInputFactory.IS_COALESCING.equals(name))
      return coalescing ? Boolean.TRUE : Boolean.FALSE;
    if (XMLInputFactory.IS_NAMESPACE_AWARE.equals(name))
      return namespaceAware ? Boolean.TRUE : Boolean.FALSE;
    if (XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES.equals(name))
      return replaceERefs ? Boolean.TRUE : Boolean.FALSE;
    if (XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES.equals(name))
      return externalEntities ? Boolean.TRUE : Boolean.FALSE;
    if (XMLInputFactory.IS_VALIDATING.equals(name))
      return Boolean.FALSE;
    if (XMLInputFactory.REPORTER.equals(name))
      return reporter;
    if (XMLInputFactory.RESOLVER.equals(name))
      return resolver;
    if (XMLInputFactory.SUPPORT_DTD.equals(name))
      return supportDTD ? Boolean.TRUE : Boolean.FALSE;
    // TODO stringInterning
    return null;
  }

  public String getText()
  {
    return buf.toString();
  }

  public char[] getTextCharacters()
  {
    return buf.toString().toCharArray();
  }

  public int getTextCharacters(int sourceStart, char[] target,
                               int targetStart, int length)
    throws XMLStreamException
  {
    length = Math.min(sourceStart + buf.length(), length);
    int sourceEnd = sourceStart + length;
    buf.getChars(sourceStart, sourceEnd, target, targetStart);
    return length;
  }

  public int getTextLength()
  {
    return buf.length();
  }

  public int getTextStart()
  {
    return 0;
  }

  public String getVersion()
  {
    return (xmlVersion == null) ? "1.0" : xmlVersion;
  }

  public boolean hasName()
  {
    switch (event)
      {
      case XMLStreamConstants.START_ELEMENT:
      case XMLStreamConstants.END_ELEMENT:
        return true;
      default:
        return false;
      }
  }

  public boolean hasText()
  {
    switch (event)
      {
      case XMLStreamConstants.CHARACTERS:
      case XMLStreamConstants.SPACE:
        return true;
      default:
        return false;
      }
  }

  public boolean isAttributeSpecified(int index)
  {
    Attribute a = (Attribute) attrs.get(index);
    return a.specified;
  }

  public boolean isCharacters()
  {
    return (event == XMLStreamConstants.CHARACTERS);
  }

  public boolean isEndElement()
  {
    return (event == XMLStreamConstants.END_ELEMENT);
  }

  public boolean isStandalone()
  {
    return Boolean.TRUE.equals(xmlStandalone);
  }

  public boolean isStartElement()
  {
    return (event == XMLStreamConstants.START_ELEMENT);
  }

  public boolean isWhiteSpace()
  {
    return (event == XMLStreamConstants.SPACE);
  }

  public int nextTag()
    throws XMLStreamException
  {
    do
      {
        switch (next())
          {
          case XMLStreamConstants.START_ELEMENT:
          case XMLStreamConstants.END_ELEMENT:
          case XMLStreamConstants.CHARACTERS:
          case XMLStreamConstants.SPACE:
          case XMLStreamConstants.COMMENT:
          case XMLStreamConstants.PROCESSING_INSTRUCTION:
            break;
          default:
            throw new XMLStreamException("Unexpected event type: " + event);
          }
      }
    while (event != XMLStreamConstants.START_ELEMENT &&
           event != XMLStreamConstants.END_ELEMENT);
    return event;
  }

  public void require(int type, String namespaceURI, String localName)
    throws XMLStreamException
  {
    if (event != type)
      throw new XMLStreamException("Current event type is " + event);
    if (event == XMLStreamConstants.START_ELEMENT ||
        event == XMLStreamConstants.END_ELEMENT)
      {
        String ln = getLocalName();
        if (!ln.equals(localName))
          throw new XMLStreamException("Current local-name is " + ln);
        String uri = getNamespaceURI();
        if ((uri == null && namespaceURI != null) ||
            (uri != null && !uri.equals(namespaceURI)))
          throw new XMLStreamException("Current namespace URI is " + uri);
      }
  }

  public boolean standaloneSet()
  {
    return (xmlStandalone != null);
  }

  public boolean hasNext()
    throws XMLStreamException
  {
    if (!lookahead)
      {
        try
          {
            next();
          }
        catch (NoSuchElementException e)
          {
            event = -1;
          }
        lookahead = true;
      }
    return event != -1;
  }
  
  public int next()
    throws XMLStreamException
  {
    if (lookahead)
      {
        lookahead = false;
        return event;
      }
    if (event == XMLStreamConstants.END_ELEMENT)
      {
        // Pop namespace context
        if (namespaceAware)
          namespaces.removeFirst();
        // Pop base context
        if (baseAware)
          bases.removeFirst();
      }
    if (!startEntityStack.isEmpty())
      {
        String entityName = (String) startEntityStack.removeFirst();
        buf.setLength(0);
        buf.append(entityName);
        event = XMLStreamConstants.START_ENTITY;
        return event;
      }
    else if (!endEntityStack.isEmpty())
      {
        String entityName = (String) endEntityStack.removeFirst();
        if (entityName == null)
          return next();
        buf.setLength(0);
        buf.append(entityName);
        event = XMLStreamConstants.END_ENTITY;
        return event;
      }
    try
      {
        if (!input.initialized)
          input.init();
        //System.out.println("input="+input.name+" "+input.inputEncoding);
        switch (state)
          {
          case CONTENT:
            if (tryRead(TEST_END_ELEMENT))
              {
                readEndElement();
                if (stack.isEmpty())
                  state = MISC;
                event = XMLStreamConstants.END_ELEMENT;
              }
            else if (tryRead(TEST_COMMENT))
              {
                readComment(false);
                event = XMLStreamConstants.COMMENT;
              }
            else if (tryRead(TEST_PI))
              {
                readPI(false);
                event = XMLStreamConstants.PROCESSING_INSTRUCTION;
              }
            else if (tryRead(TEST_CDATA))
              {
                readCDSect();
                event = XMLStreamConstants.CDATA;
              }
            else if (tryRead(TEST_START_ELEMENT))
              {
                state = readStartElement();
                event = XMLStreamConstants.START_ELEMENT;
              }
            else
              {
                // Check for character reference or predefined entity
                mark(8);
                char c = readCh();
                if (c == '&')
                  {
                    c = readCh();
                    if (c == '#')
                      {
                        reset();
                        event = readCharData(null);
                      }
                    else
                      {
                        // entity reference
                        reset();
                        readCh(); // &
                        readReference();
                        String ref = buf.toString();
                        String text = (String) PREDEFINED_ENTITIES.get(ref);
                        if (text != null)
                          {
                            event = readCharData(text);
                          }
                        else if (replaceERefs)
                          {
                            expandEntity(ref, false); //report start-entity
                            event = next();
                          }
                        else
                          {
                            event = XMLStreamConstants.ENTITY_REFERENCE;
                          }
                      }
                  }
                else
                  {
                    reset();
                    event = readCharData(null);
                    if (validating)
                      validatePCData(buf.toString());
                  }
              }
            break;
          case EMPTY_ELEMENT:
            String elementName = (String) stack.removeLast();
            buf.setLength(0);
            buf.append(elementName);
            state = stack.isEmpty() ? MISC : CONTENT;
            event = XMLStreamConstants.END_ELEMENT;
            if (validating)
              endElementValidationHook();
            break;
          case INIT: // XMLDecl?
            if (tryRead(TEST_XML_DECL))
              readXMLDecl();
            event = XMLStreamConstants.START_DOCUMENT;
            state = PROLOG;
            break;
          case PROLOG: // Misc* (doctypedecl Misc*)?
            skipWhitespace();
            if (doctype == null && tryRead(TEST_DOCTYPE_DECL))
              {
                readDoctypeDecl();
                event = XMLStreamConstants.DTD;
              }
            else if (tryRead(TEST_COMMENT))
              {
                readComment(false);
                event = XMLStreamConstants.COMMENT;
              }
            else if (tryRead(TEST_PI))
              {
                readPI(false);
                event = XMLStreamConstants.PROCESSING_INSTRUCTION;
              }
            else if (tryRead(TEST_START_ELEMENT))
              {
                state = readStartElement();
                event = XMLStreamConstants.START_ELEMENT;
              }
            else
              {
                char c = readCh();
                error("no root element: +U"+Integer.toHexString(c));
              }
            break;
          case MISC: // Comment | PI | S
            skipWhitespace();
            if (tryRead(TEST_COMMENT))
              {
                readComment(false);
                event = XMLStreamConstants.COMMENT;
              }
            else if (tryRead(TEST_PI))
              {
                readPI(false);
                event = XMLStreamConstants.PROCESSING_INSTRUCTION;
              }
            else
              {
                if (event == XMLStreamConstants.END_DOCUMENT)
                  throw new NoSuchElementException();
                char c = readCh();
                if (c != '\uffff')
                  error("Only comments and PIs may appear after " +
                        "the root element");
                event = XMLStreamConstants.END_DOCUMENT;
              }
            break;
          default:
            event = -1;
          }
        return event;
      }
    catch (IOException e)
      {
        XMLStreamException e2 = new XMLStreamException();
        e2.initCause(e);
        throw e2;
      }
  }

  // private

  private void mark(int limit)
    throws IOException
  {
    input.mark(limit);
    //System.out.println("\t(mark:"+limit+")");
  }

  private void reset()
    throws IOException
  {
    input.reset();
    //System.out.println("\t(reset)");
  }

  private int read()
    throws IOException
  {
    int ret = input.read();
    //System.out.println("read1:"+(char) ret);
    return ret;
  }

  private int read(char[] b, int off, int len)
    throws IOException
  {
    int ret = input.read(b, off, len);
    //System.out.println("read("+len+")="+ret+":"+new String(b, off, ret));
    return ret;
  }
  
  /**
   * Parsed character read.
   */
  private char readCh()
    throws IOException, XMLStreamException
  {
    char c = (char) read();
    if (expandPE && c == '%')
      {
        if (peIsError)
          error("PE reference within decl in internal subset.");
        parsePEReference();
        return readCh();
      }
    return c;
  }

  private void require(char delim)
    throws IOException, XMLStreamException
  {
    mark(1);
    char c = readCh();
    if (delim != c)
      {
        reset();
        error("required character (got U+"+Integer.toHexString(c)+")", new Character(delim));
      }
  }

  private void require(String delim)
    throws IOException, XMLStreamException
  {
    char[] chars = delim.toCharArray();
    int len = chars.length;
    mark(len);
    int l2 = read(tmpBuf, 0, len);
    if (l2 != len)
      {
        reset();
        error("EOF before required string", delim);
      }
    else
      {
        for (int i = 0; i < chars.length; i++)
          {
            if (chars[i] != tmpBuf[i])
              {
                reset();
                error("required string", delim);
              }
          }
      }
  }

  /**
   * Try to read a single character.
   */
  private boolean tryRead(char delim)
    throws IOException, XMLStreamException
  {
    mark(1);
    char c = readCh();
    if (delim != c)
      {
        reset();
        return false;
      }
    return true;
  }

  /**
   * Tries to read the specified characters.
   * If successful, the stream is positioned after the last character,
   * otherwise it is reset.
   */
  private boolean tryRead(String test)
    throws IOException
  {
    char[] chars = test.toCharArray();
    int len = chars.length;
    mark(len);
    int l2 = read(tmpBuf, 0, len);
    if (l2 < len)
      {
        reset();
        return false;
      }
    for (int i = 0; i < len; i++)
      {
        if (chars[i] != tmpBuf[i])
          {
            reset();
            return false;
          }
      }
    return true;
  }

  private void readUntil(String delim)
    throws IOException, XMLStreamException
  {
    int startLine = input.line;
    try
      {
        while (!tryRead(delim))
          {
            char c = readCh();
            if (c == '\uffff')
              throw new EOFException();
            else if (input.xml11)
              {
                if (!isXML11Char((int) c))
                  error("illegal XML 1.1 character", Character.toString(c));
              }
            else
              {
                if (c < 32 && c != 10 && c != 9 && c != 13)
                  error("illegal XML character", Character.toString(c));
                else if (c > '\ud7ff' && c < '\ue000')
                  error("illegal XML character", Character.toString(c));
                else if (c > '\ufffd')
                  error("illegal XML character", Character.toString(c));
              }
            buf.append(c);
          }
      }
    catch (EOFException e)
      {
        error("end of input while looking for delimiter "+
              "(started on line " + startLine + ')', delim);
      }
  }

  private boolean tryWhitespace()
    throws IOException, XMLStreamException
  {
    boolean white;
    boolean ret = false;
    do
      {
        mark(1);
        char c = readCh();
        white = (c == ' ' || c == '\t' || c == '\n' || c == '\r');
        if (white)
          ret = true;
        else if (c == '\uffff')
          {
            if (inputStack.size() > 1)
              popInput();
            else
              throw new EOFException();
          }
      }
    while (white);
    reset();
    return ret;
  }

  /**
   * Skip over any whitespace characters.
   */
  private void skipWhitespace()
    throws IOException, XMLStreamException
  {
    boolean white;
    do
      {
        mark(1);
        char c = readCh();
        while (c == '\uffff' && inputStack.size() > 1)
          {
            popInput();
            c = readCh();
          }
        white = (c == ' ' || c == '\t' || c == '\n' || c == '\r');
      }
    while (white);
    reset();
  }

  private void requireWhitespace()
    throws IOException, XMLStreamException
  {
    if (!tryWhitespace())
      error("whitespace required");
  }

  /**
   * Returns the current base URI for resolving external entities.
   */
  private String getXMLBase()
  {
    if (baseAware)
      {
        for (Iterator i = bases.iterator(); i.hasNext(); )
          {
            String base = (String) i.next();
            if (base != null)
              return base;
          }
      }
    return input.systemId;
  }

  /**
   * Push the specified text input source.
   */
  private void pushInput(String name, String text)
    throws IOException, XMLStreamException
  {
    // Check for recursion
    for (Iterator i = inputStack.iterator(); i.hasNext(); )
      {
        Input ctx = (Input) i.next();
        if (name.equals(ctx.name))
          error("entities may not be self-recursive", name);
      }
    pushInput(new Input(null, new StringReader(text), input.publicId,
                        input.systemId, name, input.inputEncoding));
    //System.out.println("pushInput "+name+" "+text);
  }

  /**
   * Push the specified external input source.
   */
  private void pushInput(String name, ExternalIds ids)
    throws IOException, XMLStreamException
  {
    if (!externalEntities)
      return;
    InputStream in = null;
    String base = getXMLBase();
    String url = absolutize(base, ids.systemId);
    // Unparsed entity?
    boolean unparsedEntity = false;
    if (ids.notationName != null)
      {
        ExternalIds notation = doctype.getNotation(ids.notationName);
        if (notation == null)
          error("reference to undeclared notation", ids.notationName);
        unparsedEntity = true;
      }
    // Check for recursion
    for (Iterator i = inputStack.iterator(); i.hasNext(); )
      {
        Input ctx = (Input) i.next();
        if (url.equals(ctx.systemId))
          error("entities may not be self-recursive", url);
        if (name.equals(ctx.name))
          error("entities may not be self-recursive", name);
      }
    if (in == null && url != null && resolver != null)
      {
        if (resolver instanceof XMLResolver2)
          in = ((XMLResolver2) resolver).resolve(ids.publicId, url);
        else
          in = resolver.resolve(url);
      }
    if (in == null)
      in = resolve(url);
    if (in == null)
      error("unable to resolve external entity",
            (ids.systemId != null) ? ids.systemId : ids.publicId);
    if (unparsedEntity)
      {
        // TODO read unparsed entity into buf
      }
    else
      {
        pushInput(new Input(in, ids.publicId, url, name, input.inputEncoding));
        input.init();
        if (tryRead(TEST_XML_DECL))
          readTextDecl();
      }
    //System.out.println("pushInput "+name+" "+url);
  }

  private void pushInput(Input input)
  {
    inputStack.addLast(input);
    if (this.input != null)
      input.xml11 = this.input.xml11;
    this.input = input;
    //System.out.println("\n(input:"+input.systemId+")"); 
  }

  static String absolutize(String base, String href)
  {
    if (href == null)
      return null;
    int ci = href.indexOf(':');
    if (ci > 1 && isLowercaseAscii(href.substring(0, ci)))
      {
        // href is absolute already
        return href;
      }
    if (base == null)
      base = "";
    else
      {
        int i = base.lastIndexOf('/');
        if (i != -1)
          base = base.substring(0, i + 1);
        else
          base = "";
      }
    if ("".equals(base))
      {
        // assume file URL relative to current directory
        base = System.getProperty("user.dir");
        if (base.charAt(0) == '/')
          base = base.substring(1);
        base = "file:///" + base.replace(File.separatorChar, '/');
        if (!base.endsWith("/"))
          base += "/";
      }
    if (href.startsWith("/"))
      {
        if (base.startsWith("file:"))
          return "file://" + href;
        int i = base.indexOf("://");
        if (i != -1)
          {
            i = base.indexOf('/', i + 3);
            if (i != -1)
              base = base.substring(0, i);
          }
      }
    else
      {
        while (href.startsWith(".."))
          {
            int i = base.lastIndexOf('/', base.length() - 2);
            if (i != -1)
              base = base.substring(0, i + 1);
            href = href.substring(2);
            if (href.startsWith("/"))
              href = href.substring(1);
          }
      }
    return base + href;
  }

  private static boolean isLowercaseAscii(String text)
  {
    int len = text.length();
    for (int i = 0; i < len; i++)
      {
        char c = text.charAt(i);
        if (c < 97 || c > 122)
          return false;
      }
    return true;
  }

  private InputStream resolve(String url)
    throws IOException
  {
    try
      {
        return new URL(url).openStream();
      }
    catch (MalformedURLException e)
      {
        return null;
      }
  }

  private void popInput()
  {
    Input old = (Input) inputStack.removeLast();
    if (!"".equals(old.name))
      endEntityStack.addFirst(old.name);
    input = (Input) inputStack.getLast();
    //System.out.print("\n(-input:"+input.systemId+")"); 
    //System.out.println("popInput "+old.name);
  }

  /**
   * Parse an entity text declaration.
   */
  private void readTextDecl()
    throws IOException, XMLStreamException
  {
    final int flags = LIT_DISABLE_CREF | LIT_DISABLE_PE | LIT_DISABLE_EREF;
    requireWhitespace();
    if (tryRead("version"))
      {
        readEq();
        String v = readLiteral(flags);
        if ("1.0".equals(v))
          input.xml11 = false;
        else if ("1.1".equals(v))
          {
            Input i1 = (Input) inputStack.getFirst();
            if (!i1.xml11)
              error("external entity specifies later version number");
            input.xml11 = true;
          }
        else
          throw new XMLStreamException("illegal XML version: " + v);
        requireWhitespace();
      }
    require("encoding");
    readEq();
    String enc = readLiteral(flags);
    if (!input.forceReader)
      input.setInputEncoding(enc);
    skipWhitespace();
    require("?>");
  }

  /**
   * Parse the XML declaration.
   */
  private void readXMLDecl()
    throws IOException, XMLStreamException
  {
    final int flags = LIT_DISABLE_CREF | LIT_DISABLE_PE | LIT_DISABLE_EREF;
    
    requireWhitespace();
    require("version");
    readEq();
    xmlVersion = readLiteral(flags);
    if ("1.0".equals(xmlVersion))
      input.xml11 = false;
    else if ("1.1".equals(xmlVersion))
      input.xml11 = true;
    else
      throw new XMLStreamException("illegal XML version: " + xmlVersion);
    
    boolean white = tryWhitespace();
    
    if (tryRead("encoding"))
      {
        if (!white)
          error("whitespace required before 'encoding='");
        readEq();
        xmlEncoding = readLiteral(flags);
        if (!input.forceReader)
          input.setInputEncoding(xmlEncoding);
        white = tryWhitespace();
      }
    
    if (tryRead("standalone"))
      {
        if (!white)
          error("whitespace required before 'standalone='");
        readEq();
        String standalone = readLiteral(flags);
        if ("yes".equals(standalone))
          xmlStandalone = Boolean.TRUE;
        else if ("no".equals(standalone))
          xmlStandalone = Boolean.FALSE;
        else
          error("standalone flag must be 'yes' or 'no'", standalone);
      }

    skipWhitespace();
    require("?>");
  }

  /**
   * Parse the DOCTYPE declaration.
   */
  private void readDoctypeDecl()
    throws IOException, XMLStreamException
  {
    if (!supportDTD)
      error("parser was configured not to support DTDs");
    requireWhitespace();
    String rootName = readNmtoken(true);
    skipWhitespace();
    ExternalIds ids = readExternalIds(false, true);
    doctype =
      this.new Doctype(rootName, ids.publicId, ids.systemId);
    
    // Parse internal subset first
    skipWhitespace();
    if (tryRead('['))
      {
        while (true)
          {
            expandPE = true;
            skipWhitespace();
            expandPE = false;
            if (tryRead(']'))
              break;
            else
              {
                peIsError = expandPE = true;
                readMarkupdecl(false);
                peIsError = expandPE = false;
              }
          }
      }
    skipWhitespace();
    require('>');

    // Parse external subset
    if (ids.systemId != null && externalEntities)
      {
        pushInput("", ">");
        pushInput("[dtd]", ids);
        // loop until we get back to ">"
        while (true)
          {
            expandPE = true;
            skipWhitespace();
            expandPE = false;
            mark(1);
            char c = readCh();
            if (c == '>')
              break;
            else if (c == '\uffff')
              popInput();
            else
              {
                reset();
                //peIsError = expandPE = true;
                expandPE = true;
                readMarkupdecl(true);
                //peIsError = expandPE = false;
                expandPE = true;
              }
          }
        if (inputStack.size() != 2)
          error("external subset has unmatched '>'");
        popInput();
      }

    // Make rootName available for reading
    buf.setLength(0);
    buf.append(rootName);
  }

  private void readMarkupdecl(boolean inExternalSubset)
    throws IOException, XMLStreamException
  {
    boolean saved = expandPE;
    mark(1);
    require('<');
    reset();
    expandPE = false;
    if (tryRead(TEST_ELEMENT_DECL))
      {
        expandPE = saved;
        readElementDecl();
      }
    else if (tryRead(TEST_ATTLIST_DECL))
      {
        expandPE = saved;
        readAttlistDecl();
      }
    else if (tryRead(TEST_ENTITY_DECL))
      {
        expandPE = saved;
        readEntityDecl(inExternalSubset);
      }
    else if (tryRead(TEST_NOTATION_DECL))
      {
        expandPE = saved;
        readNotationDecl(inExternalSubset);
      }
    else if (tryRead(TEST_PI))
      {
        expandPE = saved;
        readPI(true);
      }
    else if (tryRead(TEST_COMMENT))
      {
        expandPE = saved;
        readComment(true);
      }
    else if (tryRead("<!["))
      {
        // conditional section
        expandPE = saved;
        if (inputStack.size() < 2)
          error("conditional sections illegal in internal subset");
        skipWhitespace();
        if (tryRead("INCLUDE"))
          {
            skipWhitespace();
            require('[');
            skipWhitespace();
            while (!tryRead("]]>"))
              {
                readMarkupdecl(inExternalSubset);
                skipWhitespace();
              }
          }
        else if (tryRead("IGNORE"))
          {
            skipWhitespace();
            require('[');
            expandPE = false;
            for (int nesting = 1; nesting > 0; )
              {
                char c = readCh();
                switch (c)
                  {
                  case '<':
                    if (tryRead("!["))
                      nesting++;
                    break;
                  case ']':
                    if (tryRead("]>"))
                      nesting--;
                    break;
                  case '\uffff':
                    throw new EOFException();
                  }
              }
            expandPE = true;
          }
        else
          error("conditional section must begin with INCLUDE or IGNORE");
      }
    else
      error("expected markup declaration");
  }

  private void readElementDecl()
    throws IOException, XMLStreamException
  {
    requireWhitespace();
    String name = readNmtoken(true);
    requireWhitespace();
    readContentspec(name);
    skipWhitespace();
    require('>');
    //System.out.println("ElementDecl "+name);
  }

  private void readContentspec(String elementName)
    throws IOException, XMLStreamException
  {
    if (tryRead("EMPTY"))
      doctype.addElementDecl(elementName, "EMPTY", new EmptyContentModel());
    else if (tryRead("ANY"))
      doctype.addElementDecl(elementName, "ANY", new AnyContentModel());
    else
      {
        ContentModel model;
        StringBuffer acc = new StringBuffer();
        require('(');
        acc.append('(');
        skipWhitespace();
        if (tryRead("#PCDATA"))
          {
            // mixed content
            acc.append("#PCDATA");
            MixedContentModel mm = new MixedContentModel();
            model = mm;
            skipWhitespace();
            if (tryRead(')'))
              {
                acc.append(")");
                if (tryRead('*'))
                  {
                    mm.min = 0;
                    mm.max = -1;
                  }
              }
            else
              {
                while (!tryRead(")"))
                  {
                    require('|');
                    acc.append('|');
                    skipWhitespace();
                    String name = readNmtoken(true);
                    acc.append(name);
                    mm.addName(name);
                    skipWhitespace();
                  }
                require('*');
                acc.append(")*");
                mm.min = 0;
                mm.max = -1;
              }
          }
        else
          model = readElements(acc);
        doctype.addElementDecl(elementName, acc.toString(), model);
      }
  }

  private ElementContentModel readElements(StringBuffer acc)
    throws IOException, XMLStreamException
  {
    char separator;
    ElementContentModel model = new ElementContentModel();
    
    // Parse first content particle
    skipWhitespace();
    model.addContentParticle(readContentParticle(acc));
    // End or separator
    skipWhitespace();
    char c = readCh();
    switch (c)
      {
      case ')':
        acc.append(')');
        mark(1);
        c = readCh();
        switch (c)
          {
          case '?':
            acc.append(c);
            model.min = 0;
            model.max = 1;
            break;
          case '*':
            acc.append(c);
            model.min = 0;
            model.max = -1;
            break;
          case '+':
            acc.append(c);
            model.min = 1;
            model.max = -1;
            break;
          default:
            reset();
          }
        return model; // done
      case ',':
      case '|':
        separator = c;
        acc.append(c);
        break;
      default:
        error("bad separator in content model", new Character(c));
        return model;
      }
    // Parse subsequent content particles
    while (true)
      {
        skipWhitespace();
        model.addContentParticle(readContentParticle(acc));
        skipWhitespace();
        c = readCh();
        if (c == ')')
          {
            acc.append(')');
            break;
          }
        else if (c != separator)
          {
            error("bad separator in content model", new Character(c));
            return model;
          }
        else
          acc.append(c);
      }
    // Check for occurrence indicator
    mark(1);
    c = readCh();
    switch (c)
      {
      case '?':
        acc.append(c);
        model.min = 0;
        model.max = 1;
        break;
      case '*':
        acc.append(c);
        model.min = 0;
        model.max = -1;
        break;
      case '+':
        acc.append(c);
        model.min = 1;
        model.max = -1;
        break;
      default:
        reset();
      }
    return model;
  }

  private ContentParticle readContentParticle(StringBuffer acc)
    throws IOException, XMLStreamException
  {
    ContentParticle cp = new ContentParticle();
    if (tryRead('('))
      {
        acc.append('(');
        cp.content = readElements(acc);
      }
    else
      {
        String name = readNmtoken(true);
        acc.append(name);
        cp.content = name;
        mark(1);
        char c = readCh();
        switch (c)
          {
          case '?':
            acc.append(c);
            cp.min = 0;
            cp.max = 1;
            break;
          case '*':
            acc.append(c);
            cp.min = 0;
            cp.max = -1;
            break;
          case '+':
            acc.append(c);
            cp.min = 1;
            cp.max = -1;
            break;
          default:
            reset();
          }
      }
    return cp;
  }

  /**
   * Parse an attribute-list definition.
   */
  private void readAttlistDecl()
    throws IOException, XMLStreamException
  {
    requireWhitespace();
    String elementName = readNmtoken(true);
    boolean white = tryWhitespace();
    while (!tryRead('>'))
      {
        if (!white)
          error("whitespace required before attribute definition");
        readAttDef(elementName);
        white = tryWhitespace();
      }
    //System.out.println("AttlistDecl "+elementName);
  }

  /**
   * Parse a single attribute definition.
   */
  private void readAttDef(String elementName)
    throws IOException, XMLStreamException
  {
    String name = readNmtoken(true);
    requireWhitespace();
    StringBuffer acc = new StringBuffer();
    String type = readAttType(acc);
    String enumer = null;
    if ("ENUMERATION".equals(type) || "NOTATION".equals(type))
      enumer = acc.toString();
    requireWhitespace();
    readDefault(elementName, name, type, enumer);
  }

  /**
   * Parse an attribute type.
   */
  private String readAttType(StringBuffer acc)
    throws IOException, XMLStreamException
  {
    if (tryRead('('))
      {
        readEnumeration(false, acc);
        return "ENUMERATION";
      }
    else
      {
        String typeString = readNmtoken(true);
        if ("NOTATION".equals(typeString))
          {
            readNotationType(acc);
            return typeString;
          }
        else if ("CDATA".equals(typeString) ||
                 "ID".equals(typeString) ||
                 "IDREF".equals(typeString) ||
                 "IDREFS".equals(typeString) ||
                 "ENTITY".equals(typeString) ||
                 "ENTITIES".equals(typeString) ||
                 "NMTOKEN".equals(typeString) ||
                 "NMTOKENS".equals(typeString))
          return typeString;
        else
          {
            error("illegal attribute type", typeString);
            return null;
          }
      }
  }

  /**
   * Parse an enumeration.
   */
  private void readEnumeration(boolean isNames, StringBuffer acc)
    throws IOException, XMLStreamException
  {
    acc.append('(');
    // first token
    skipWhitespace();
    acc.append(readNmtoken(isNames));
    // subsequent tokens
    skipWhitespace();
    while (!tryRead(')'))
      {
        require('|');
        acc.append('|');
        skipWhitespace();
        acc.append(readNmtoken(isNames));
        skipWhitespace();
      }
    acc.append(')');
  }

  /**
   * Parse a notation type for an attribute.
   */
  private void readNotationType(StringBuffer acc)
    throws IOException, XMLStreamException
  {
    requireWhitespace();
    require('(');
    readEnumeration(true, acc);
  }

  /**
   * Parse the default value for an attribute.
   */
  private void readDefault(String elementName, String name,
                           String type, String enumeration)
    throws IOException, XMLStreamException
  {
    int valueType = ATTRIBUTE_DEFAULT_SPECIFIED;
    int flags = LIT_ATTRIBUTE;
    String value = null, defaultType = null;
    boolean saved = expandPE;
    
    if (!"CDATA".equals(type))
      flags |= LIT_NORMALIZE;

    expandPE = false;
    if (tryRead('#'))
      {
        if (tryRead("FIXED"))
          {
            defaultType = "#FIXED";
            valueType = ATTRIBUTE_DEFAULT_FIXED;
            requireWhitespace();
            value = readLiteral(flags);
          }
        else if (tryRead("REQUIRED"))
          {
            defaultType = "#REQUIRED";
            valueType = ATTRIBUTE_DEFAULT_REQUIRED;
          }
        else if (tryRead("IMPLIED"))
          {
            defaultType = "#IMPLIED";
            valueType = ATTRIBUTE_DEFAULT_IMPLIED;
          }
        else
          error("illegal keyword for attribute default value");
      }
    else
      value = readLiteral(flags);
    expandPE = saved;
    // Register attribute def
    AttributeDecl attribute =
      new AttributeDecl(type, value, valueType, enumeration);
    doctype.addAttributeDecl(elementName, name, attribute);
  }

  private void readEntityDecl(boolean inExternalSubset)
    throws IOException, XMLStreamException
  {
    int flags = 0;
    // Check if parameter entity
    boolean peFlag = false;
    expandPE = false;
    requireWhitespace();
    if (tryRead('%'))
      {
        peFlag = true;
        requireWhitespace();
      }
    expandPE = true;
    // Read entity name
    String name = readNmtoken(true);
    if (name.indexOf(':') != -1)
      error("illegal character ':' in entity name", name);
    if (peFlag)
      name = "%" + name;
    requireWhitespace();
    mark(1);
    char c = readCh();
    reset();
    if (c == '"' || c == '\'')
      {
        // Internal entity replacement text
        String value = readLiteral(flags | LIT_DISABLE_EREF);
        doctype.addEntityDecl(name, value, inExternalSubset);
      }
    else
      {
        ExternalIds ids = readExternalIds(false, false);
        // Check for NDATA
        boolean white = tryWhitespace();
        if (!peFlag && tryRead("NDATA"))
          {
            if (!white)
              error("whitespace required before NDATA");
            requireWhitespace();
            ids.notationName = readNmtoken(true);
          }
        doctype.addEntityDecl(name, ids, inExternalSubset);
      }
    // finish
    skipWhitespace();
    require('>');
  }

  private void readNotationDecl(boolean inExternalSubset)
    throws IOException, XMLStreamException
  {
    requireWhitespace();
    String notationName = readNmtoken(true);
    if (notationName.indexOf(':') != -1)
      error("illegal character ':' in notation name", notationName);
    requireWhitespace();
    ExternalIds ids = readExternalIds(true, false);
    ids.notationName = notationName;
    doctype.addNotationDecl(notationName, ids, inExternalSubset);
    skipWhitespace();
    require('>');
  }

  /**
   * Returns a tuple {publicId, systemId}.
   */
  private ExternalIds readExternalIds(boolean inNotation, boolean isSubset)
    throws IOException, XMLStreamException
  {
    char c;
    int flags = LIT_DISABLE_CREF | LIT_DISABLE_PE | LIT_DISABLE_EREF;
    ExternalIds ids = new ExternalIds();
    
    if (tryRead("PUBLIC"))
      {
        requireWhitespace();
        ids.publicId = readLiteral(LIT_NORMALIZE | LIT_PUBID | flags);
        if (inNotation)
          {
            skipWhitespace();
            mark(1);
            c = readCh();
            reset();
            if (c == '"' || c == '\'')
              ids.systemId = absolutize(input.systemId, readLiteral(flags));
          }
        else
          {
            requireWhitespace();
            ids.systemId = absolutize(input.systemId, readLiteral(flags));
          }

        for (int i = 0; i < ids.publicId.length(); i++)
          {
            c = ids.publicId.charAt(i);
            if (c >= 'a' && c <= 'z')
              continue;
            if (c >= 'A' && c <= 'Z')
              continue;
            if (" \r\n0123456789-' ()+,./:=?;!*#@$_%".indexOf(c) != -1)
              continue;
            error("illegal PUBLIC id character",
                  "U+" + Integer.toHexString(c));
          }
      }
    else if (tryRead("SYSTEM"))
      {
        requireWhitespace();
        ids.systemId = absolutize(input.systemId, readLiteral(flags));
      }
    else if (!isSubset)
      {
        error("missing SYSTEM or PUBLIC keyword");
      }
    if (ids.systemId != null)
      {
        if (ids.systemId.indexOf('#') != -1)
          error("SYSTEM id has a URI fragment", ids.systemId);
      }
    return ids;
  }

  /**
   * Parse the start of an element.
   * @return the state of the parser afterwards (EMPTY_ELEMENT or CONTENT)
   */
  private int readStartElement()
    throws IOException, XMLStreamException
  {
    //System.err.println("readStartElement");
    // Read element name
    String elementName = readNmtoken(true);
    attrs.clear();
    // Push namespace context
    if (namespaceAware)
      {
        if (elementName.charAt(0) == ':' ||
            elementName.charAt(elementName.length() - 1) == ':')
          error("not a QName", elementName);
        namespaces.addFirst(new LinkedHashMap());
      }
    // Read element content
    boolean white = tryWhitespace();
    mark(1);
    char c = readCh();
    while (c != '/' && c != '>')
      {
        // Read attribute
        reset();
        if (!white)
          error("need whitespace between attributes");
        readAttribute(elementName);
        white = tryWhitespace();
        mark(1);
        c = readCh();
      }
    // supply defaulted attributes
    if (doctype != null)
      {
        for (Iterator i = doctype.attlistIterator(elementName); i.hasNext(); )
          {
            Map.Entry entry = (Map.Entry) i.next();
            String attName = (String) entry.getKey();
            if (namespaceAware && attName.equals("xmlns"))
              {
                LinkedHashMap ctx =
                  (LinkedHashMap) namespaces.getFirst();
                if (ctx.containsKey(XMLConstants.DEFAULT_NS_PREFIX))
                  continue; // namespace was specified
              }
            else if (namespaceAware && attName.startsWith("xmlns:"))
              {
                LinkedHashMap ctx =
                  (LinkedHashMap) namespaces.getFirst();
                if (ctx.containsKey(attName.substring(6)))
                  continue; // namespace was specified
              }
            else if (attributeSpecified(attName))
              continue;
            AttributeDecl decl = (AttributeDecl) entry.getValue();
            if (decl.value == null)
              continue;
            Attribute attr =
              new Attribute(attName, decl.type, false, decl.value);
            if (namespaceAware)
              {
                if (!addNamespace(attr))
                  attrs.add(attr);
              }
            else
              attrs.add(attr);
          }
      }
    if (baseAware)
      {
        String base = getAttributeValue(XMLConstants.XML_NS_URI, "base");
        bases.addFirst(base);
      }
    if (namespaceAware)
      {
        // check prefix bindings
        int ci = elementName.indexOf(':');
        if (ci != -1)
          {
            String prefix = elementName.substring(0, ci);
            if (getNamespaceURI(prefix) == null)
              error("unbound element prefix", prefix);
          }
        for (Iterator i = attrs.iterator(); i.hasNext(); )
          {
            Attribute attr = (Attribute) i.next();
            if (attr.prefix != null && getNamespaceURI(attr.prefix) == null &&
                !XMLConstants.XMLNS_ATTRIBUTE.equals(attr.prefix))
              error("unbound attribute prefix", attr.prefix);
          }
      }
    if (validating)
      {
        validateStartElement(elementName);
        currentContentModel = doctype.getElementModel(elementName);
        if (currentContentModel == null)
          error("no element declaration", elementName);
        validationStack.add(new LinkedList());
      }
    // make element name available for read
    buf.setLength(0);
    buf.append(elementName);
    // push element onto stack
    stack.addLast(elementName);
    switch (c)
      {
      case '>':
        return CONTENT;
      case '/':
        require('>');
        return EMPTY_ELEMENT;
      }
    return -1; // to satisfy compiler
  }

  private boolean attributeSpecified(String attName)
  {
    for (Iterator j = attrs.iterator(); j.hasNext(); )
      {
        Attribute a = (Attribute) j.next();
        if (attName.equals(a.name))
          return true;
      }
    return false;
  }

  /**
   * Parse an attribute.
   */
  private void readAttribute(String elementName)
    throws IOException, XMLStreamException
  {
    //System.err.println("readAttribute");
    // Read attribute name
    String attributeName = readNmtoken(true);
    String type = getAttributeType(elementName, attributeName);
    readEq();
    // Read literal
    final int flags = LIT_ATTRIBUTE |  LIT_ENTITY_REF;
    String value = (type == null || "CDATA".equals(type)) ?
      readLiteral(flags) : readLiteral(flags | LIT_NORMALIZE);
    // add attribute event
    Attribute attr = this.new Attribute(attributeName, type, true, value);
    if (namespaceAware)
      {
        if (attributeName.charAt(0) == ':' ||
            attributeName.charAt(attributeName.length() - 1) == ':')
          error("not a QName", attributeName);
        else if (attributeName.equals("xmlns"))
          {
            LinkedHashMap ctx = (LinkedHashMap) namespaces.getFirst();
            if (ctx.containsKey(XMLConstants.DEFAULT_NS_PREFIX))
              error("duplicate default namespace");
          }
        else if (attributeName.startsWith("xmlns:"))
          {
            LinkedHashMap ctx = (LinkedHashMap) namespaces.getFirst();
            if (ctx.containsKey(attributeName.substring(6)))
              error("duplicate namespace", attributeName.substring(6));
          }
        else if (attrs.contains(attr))
          error("duplicate attribute", attributeName);
      }
    else if (attrs.contains(attr))
      error("duplicate attribute", attributeName);
    if (namespaceAware)
      {
        if (!addNamespace(attr))
          attrs.add(attr);
      }
    else
      attrs.add(attr);
  }

  private boolean addNamespace(Attribute attr)
    throws XMLStreamException
  {
    if ("xmlns".equals(attr.name))
      {
        LinkedHashMap ctx = (LinkedHashMap) namespaces.getFirst();
        if (ctx.get(XMLConstants.DEFAULT_NS_PREFIX) != null)
          error("Duplicate default namespace declaration");
        if (XMLConstants.XML_NS_URI.equals(attr.value))
          error("can't bind XML namespace");
        ctx.put(XMLConstants.DEFAULT_NS_PREFIX, attr.value);
        return true;
      }
    else if ("xmlns".equals(attr.prefix))
      {
        LinkedHashMap ctx = (LinkedHashMap) namespaces.getFirst();
        if (ctx.get(attr.localName) != null)
          error("Duplicate namespace declaration for prefix",
                attr.localName);
        if (XMLConstants.XML_NS_PREFIX.equals(attr.localName))
          {
            if (!XMLConstants.XML_NS_URI.equals(attr.value))
              error("can't redeclare xml prefix");
            else
              return false; // treat as attribute
          }
        if (XMLConstants.XML_NS_URI.equals(attr.value))
          error("can't bind non-xml prefix to XML namespace");
        if (XMLConstants.XMLNS_ATTRIBUTE.equals(attr.localName))
          error("can't redeclare xmlns prefix");
        if (XMLConstants.XMLNS_ATTRIBUTE_NS_URI.equals(attr.value))
          error("can't bind non-xmlns prefix to XML Namespace namespace");
        ctx.put(attr.localName, attr.value);
        return true;
      }
    return false;
  }

  /**
   * Parse a closing tag.
   */
  private void readEndElement()
    throws IOException, XMLStreamException
  {
    //System.err.println("readEndElement");
    // pop element off stack
    String expected = (String) stack.removeLast();
    require(expected);
    skipWhitespace();
    require('>');
    // Make element name available
    buf.setLength(0);
    buf.append(expected);
    if (validating)
      endElementValidationHook();
  }

  private void endElementValidationHook()
    throws XMLStreamException
  {
    validateEndElement();
    validationStack.removeLast();
    if (stack.isEmpty())
      currentContentModel = null;
    else
      {
        String parent = (String) stack.getLast();
        currentContentModel = doctype.getElementModel(parent);
      }
  }

  /**
   * Parse a comment.
   */
  private void readComment(boolean inDTD)
    throws IOException, XMLStreamException
  {
    boolean saved = expandPE;
    expandPE = false;
    buf.setLength(0);
    readUntil(TEST_END_COMMENT);
    require('>');
    expandPE = saved;
    if (inDTD)
      doctype.addComment(buf.toString());
  }

  /**
   * Parse a processing instruction.
   */
  private void readPI(boolean inDTD)
    throws IOException, XMLStreamException
  {
    boolean saved = expandPE;
    expandPE = false;
    piTarget = readNmtoken(true);
    if (piTarget.indexOf(':') != -1)
      error("illegal character in PI target", new Character(':'));
    if ("xml".equalsIgnoreCase(piTarget))
      error("illegal PI target", piTarget);
    if (tryRead(TEST_END_PI))
      piData = null;
    else
      {
        if (!tryWhitespace())
          error("whitespace required between PI target and data");
        buf.setLength(0);
        readUntil(TEST_END_PI);
        piData = buf.toString();
      }
    expandPE = saved;
    if (inDTD)
      doctype.addPI(piTarget, piData);
  }

  /**
   * Parse an entity reference.
   */
  private void readReference()
    throws IOException, XMLStreamException
  {
    buf.setLength(0);
    String entityName = readNmtoken(true);
    require(';');
    buf.setLength(0);
    buf.append(entityName);
  }

  /**
   * Read an CDATA section.
   */
  private void readCDSect()
    throws IOException, XMLStreamException
  {
    buf.setLength(0);
    readUntil(TEST_END_CDATA);
  }

  /**
   * Read character data.
   * @return the type of text read (CHARACTERS or SPACE)
   */
  private int readCharData(String prefix)
    throws IOException, XMLStreamException
  {
    boolean white = true;
    buf.setLength(0);
    if (prefix != null)
      buf.append(prefix);
    boolean done = false;
    boolean entities = false;
    //System.out.println("readCharData input="+input.name+" line="+input.line+" col="+input.column);
    while (!done)
      {
        // Block read
        mark(tmpBuf.length);
        int len = read(tmpBuf, 0, tmpBuf.length);
        if (len == -1)
          {
            if (inputStack.size() > 1)
              {
                popInput();
                // report end-entity
                done = true;
              }
            else
              throw new EOFException();
          }
        for (int i = 0; i < len && !done; i++)
          {
            char c = tmpBuf[i];
            switch (c)
              {
              case ' ':
              case '\t':
              case '\n':
              case '\r':
                buf.append(c);
                break; // whitespace
              case '&':
                reset();
                read(tmpBuf, 0, i);
                // character reference?
                mark(3);
                c = readCh(); // &
                c = readCh();
                if (c == '#')
                  {
                    mark(1);
                    c = readCh();
                    boolean hex = (c == 'x');
                    if (!hex)
                      reset();
                    char[] ch = readCharacterRef(hex ? 16 : 10);
                    buf.append(ch, 0, ch.length);
                    for (int j = 0; j < ch.length; j++)
                      {
                        switch (ch[j])
                          {
                          case ' ':
                          case '\t':
                          case '\n':
                          case '\r':
                            break; // whitespace
                          default:
                            white = false;
                          }
                      }
                  }
                else
                  {
                    // entity reference
                    reset();
                    c = readCh(); // &
                    String entityName = readNmtoken(true);
                    require(';');
                    String text =
                      (String) PREDEFINED_ENTITIES.get(entityName);
                    if (text != null)
                      buf.append(text);
                    else
                      {
                        //if (replaceERefs)
                        //  expandEntity(entityName, false); //report start-entity
                        //else
                        //  reset(); // report reference
                        pushInput("", "&" + entityName + ";");
                        done = true;
                        break;
                      }
                  }
                // continue processing
                i = -1;
                mark(tmpBuf.length);
                len = read(tmpBuf, 0, tmpBuf.length);
                if (len == -1)
                  {
                    if (inputStack.size() > 1)
                      {
                        popInput();
                        done = true;
                      }
                    else
                      throw new EOFException();
                  }
                entities = true;
                break; // end of text sequence
              case '>':
                int l = buf.length();
                if (l > 1 &&
                    buf.charAt(l - 1) == ']' &&
                    buf.charAt(l - 2) == ']')
                  error("Character data may not contain unescaped ']]>'");
                buf.append(c);
                break;
              case '<':
                reset();
                read(tmpBuf, 0, i);
                done = true;
                break; // end of text sequence
              default:
                if ((c < 0x0020 || c > 0xfffd) ||
                    (input.xml11 && (c >= 0x007f) &&
                     (c <= 0x009f) && (c != 0x0085)))
                  {
                    error("illegal XML character",
                          "U+" + Integer.toHexString(c));
                  }
                white = false;
                buf.append(c);
              }
          }
        // if text buffer >= 2MB, return it as a chunk
        // to avoid excessive memory use
        if (!coalescing && buf.length() >= 2097152)
          done = true;
      }
    if (entities)
      normalizeCRLF(buf);
    return white ? XMLStreamConstants.SPACE : XMLStreamConstants.CHARACTERS;
  }

  /**
   * Expands the specified entity.
   */
  private void expandEntity(String name, boolean inAttr)
    throws IOException, XMLStreamException
  {
    if (doctype != null)
      {
        Object value = doctype.getEntity(name);
        if (value != null)
          {
            if (xmlStandalone == Boolean.TRUE)
              {
                if (doctype.isEntityExternal(name))
                  error("reference to external entity in standalone document");
                else if (value instanceof ExternalIds)
                  {
                    ExternalIds ids = (ExternalIds) value;
                    if (ids.notationName != null &&
                        doctype.isNotationExternal(ids.notationName))
                      error("reference to external notation in " +
                            "standalone document");
                  }
              }
            if (value instanceof String)
              {
                String text = (String) value;
                if (inAttr && text.indexOf('<') != -1)
                  error("< in attribute value");
                pushInput(name, text);
              }
            else if (inAttr)
              error("reference to external entity in attribute value", name);
            else
              pushInput(name, (ExternalIds) value);
            if (name != null)
              startEntityStack.addFirst(name);
            return;
          }
      }
    error("reference to undeclared entity", name);
  }

  /**
   * Read an equals sign.
   */
  private void readEq()
    throws IOException, XMLStreamException
  { 
    skipWhitespace();
    require('=');
    skipWhitespace();
  }

  private char literalReadCh()
    throws IOException, XMLStreamException
  {
    char c = readCh();
    while (c == '\uffff')
      {
        if (inputStack.size() > 1)
          {
            inputStack.removeLast();
            input = (Input) inputStack.getLast();
            // Don't issue end-entity
            c = readCh();
          }
        else
          throw new EOFException();
      }
    return c;
  }

  private String readLiteral(int flags)
    throws IOException, XMLStreamException
  {
    boolean saved = expandPE;
    char delim = readCh();
    if (delim != '\'' && delim != '"')
      error("expected '\"' or \"'\"", new Character(delim));
    literalBuf.setLength(0);
    if ((flags & LIT_DISABLE_PE) != 0)
      expandPE = false;
    boolean entities = false;
    int inputStackSize = inputStack.size();
    do
      {
        char c = literalReadCh();
        if (c == delim && inputStackSize == inputStack.size())
          break;
        switch (c)
          {
          case '\n':
          case '\r':
            if ((flags & (LIT_ATTRIBUTE | LIT_PUBID)) != 0)
              c = ' '; // normalize to space
            break;
          case '\t':
            if ((flags & LIT_ATTRIBUTE) != 0)
              c = ' '; // normalize to space
            break;
          case '&':
            mark(2);
            c = readCh();
            if (c == '#')
              {
                if ((flags & LIT_DISABLE_CREF) != 0)
                  {
                    reset();
                    c = '&';
                  }
                else
                  {
                    mark(1);
                    c = readCh();
                    boolean hex = (c == 'x');
                    if (!hex)
                      reset();
                    char[] ref = readCharacterRef(hex ? 16 : 10);
                    for (int i = 0; i < ref.length; i++)
                      {
                        c = ref[i];
                        if ((flags & (LIT_ATTRIBUTE | LIT_PUBID)) != 0 &&
                            (c == '\n' || c == '\r'))
                          c = ' '; // normalize
                        else if ((flags & LIT_ATTRIBUTE) != 0 && c == '\t')
                          c = ' '; // normalize
                        literalBuf.append(c);
                      }
                    entities = true;
                    continue;
                  }
              }
            else
              {
                if ((flags & LIT_DISABLE_EREF) != 0)
                  {
                    reset();
                    c = '&';
                  }
                else
                  {
                    reset();
                    if (replaceERefs || (flags & LIT_NORMALIZE) > 0)
                      {
                        String entityName = readNmtoken(true);
                        require(';');
                        String text =
                          (String) PREDEFINED_ENTITIES.get(entityName);
                        if (text != null)
                          literalBuf.append(text);
                        else
                          expandEntity(entityName,
                                       (flags & LIT_ATTRIBUTE) != 0);
                        entities = true;
                        continue;
                      }
                    else
                      error("parser is configured not to replace entity " +
                            "references");
                  }
              }
            break;
          case '<':
            if ((flags & LIT_ATTRIBUTE) != 0)
              error("attribute values may not contain '<'");
            break;
          case '\uffff':
            if (inputStack.size() > 1)
              {
                popInput();
                continue;
              }
            throw new EOFException();
          }
        literalBuf.append(c);
      }
    while (true);
    expandPE = saved;
    if (entities)
      normalizeCRLF(literalBuf);
    if ((flags & LIT_NORMALIZE) > 0)
      literalBuf = normalize(literalBuf);
    return literalBuf.toString();
  }

  /**
   * Performs attribute-value normalization of the text buffer.
   * This discards leading and trailing whitespace, and replaces sequences
   * of whitespace with a single space.
   */
  private StringBuffer normalize(StringBuffer buf)
  {
    StringBuffer acc = new StringBuffer();
    int len = buf.length();
    int avState = 0;
    for (int i = 0; i < len; i++)
      {
        char c = buf.charAt(i);
        if (c == ' ')
          avState = (avState == 0) ? 0 : 1;
        else
          {
            if (avState == 1)
              acc.append(' ');
            acc.append(c);
            avState = 2;
          }
      }
    return acc;
  }

  /**
   * Replace any CR/LF pairs in the buffer with LF.
   * This may be necessary if combinations of CR or LF were declared as
   * (character) entity references in the input.
   */
  private void normalizeCRLF(StringBuffer buf)
  {
    int len = buf.length() - 1;
    for (int i = 0; i < len; i++)
      {
        char c = buf.charAt(i);
        if (c == '\r' && buf.charAt(i + 1) == '\n')
          {
            buf.deleteCharAt(i--);
            len--;
          }
      }
  }

  /**
   * Parse and expand a parameter entity reference.
   */
  private void parsePEReference()
    throws IOException, XMLStreamException
  {
    String name = readNmtoken(true);
    require(';');
    mark(1); // ensure we don't reset to before the semicolon
    if (doctype != null)
      {
        String entityName = "%" + name;
        Object entity = doctype.getEntity(entityName);
        if (entity != null)
          {
            if (xmlStandalone == Boolean.TRUE)
              {
                if (doctype.isEntityExternal(entityName))
                  error("reference to external parameter entity in " +
                        "standalone document");
              }
            if (entity instanceof String)
              pushInput(name, (String) entity);
            else
              pushInput(name, (ExternalIds) entity);
          }
        else
          error("reference to undeclared parameter entity", name);
      }
    else
      error("reference to parameter entity without doctype", name);
  }

  private char[] readCharacterRef(int base)
    throws IOException, XMLStreamException
  {
    StringBuffer b = new StringBuffer();
    for (char c = readCh(); c != ';' && c != '\uffff'; c = readCh())
      b.append(c);
    try
      {
        int ord = Integer.parseInt(b.toString(), base);
        if (input.xml11)
          {
            if (!isXML11Char(ord))
              error("illegal XML 1.1 character reference " +
                    "U+" + Integer.toHexString(ord));
          }
        else
          {
            if ((ord < 0x20 && !(ord == 0x0a || ord == 0x09 || ord == 0x0d))
                || (ord >= 0xd800 && ord <= 0xdfff)
                || ord == 0xfffe || ord == 0xffff
                || ord > 0x0010ffff)
              error("illegal XML character reference " +
                    "U+" + Integer.toHexString(ord));
          }
        return Character.toChars(ord);
      }
    catch (NumberFormatException e)
      {
        error("illegal characters in character reference", b.toString());
        return null;
      }
  }

  private String readNmtoken(boolean isName)
    throws IOException, XMLStreamException
  {
    nmtokenBuf.setLength(0);
    char c = readCh();
    if (isName)
      {
        if (!isNameStartCharacter(c))
          error("not a name start character",
                "U+" + Integer.toHexString(c));
      }
    else
      {
        if (!isNameCharacter(c))
          error("not a name character",
                "U+" + Integer.toHexString(c));
      }
    nmtokenBuf.append(c);
    do
      {
        mark(1);
        c = readCh();
        switch (c)
          {
          case '%':
          case '<':
          case '>':
          case '&':
          case ',':
          case '|':
          case '*':
          case '+':
          case '?':
          case ')':
          case '=':
          case '\'':
          case '"':
          case '[':
          case ' ':
          case '\t':
          case '\n':
          case '\r':
          case ';':
          case '/':
            reset();
            return intern(nmtokenBuf.toString());
          default:
            if (!isNameCharacter(c))
              error("not a name character",
                    "U+" + Integer.toHexString(c));
            else
              nmtokenBuf.append(c);
          }
      }
    while (true);
  }

  private boolean isXML11Char(int c)
  {
    return ((c >= 0x0001 && c <= 0xD7FF) ||
            (c >= 0xE000 && c <= 0xFFFD) ||
            (c >= 0x10000 && c <= 0x10FFFF));
  }

  private boolean isXML11RestrictedChar(int c)
  {
    return ((c >= 0x0001 && c <= 0x0008) ||
            (c >= 0x000B && c <= 0x000C) ||
            (c >= 0x000E && c <= 0x001F) ||
            (c >= 0x007F && c <= 0x0084) ||
            (c >= 0x0086 && c <= 0x009F));
  }

  private boolean isNameStartCharacter(char c)
  {
    if (input.xml11)
      return ((c >= 0x0041 && c <= 0x005a) ||
              (c >= 0x0061 && c <= 0x007a) ||
              c == ':' |
              c == '_' |
              (c >= 0xC0 && c <= 0xD6) ||
              (c >= 0xD8 && c <= 0xF6) ||
              (c >= 0xF8 && c <= 0x2FF) ||
              (c >= 0x370 && c <= 0x37D) ||
              (c >= 0x37F && c <= 0x1FFF) ||
              (c >= 0x200C && c <= 0x200D) ||
              (c >= 0x2070 && c <= 0x218F) ||
              (c >= 0x2C00 && c <= 0x2FEF) ||
              (c >= 0x3001 && c <= 0xD7FF) ||
              (c >= 0xF900 && c <= 0xFDCF) ||
              (c >= 0xFDF0 && c <= 0xFFFD) ||
              (c >= 0x10000 && c <= 0xEFFFF));
    else
      return (c == '_' || c == ':' || isLetter(c));
  }

  private boolean isNameCharacter(char c)
  {
    if (input.xml11)
      return ((c >= 0x0041 && c <= 0x005a) ||
              (c >= 0x0061 && c <= 0x007a) ||
              (c >= 0x0030 && c <= 0x0039) ||
              c == ':' |
              c == '_' |
              c == '-' |
              c == '.' |
              c == 0xB7 |
              (c >= 0xC0 && c <= 0xD6) ||
              (c >= 0xD8 && c <= 0xF6) ||
              (c >= 0xF8 && c <= 0x2FF) ||
              (c >= 0x300 && c <= 0x37D) ||
              (c >= 0x37F && c <= 0x1FFF) ||
              (c >= 0x200C && c <= 0x200D) ||
              (c >= 0x203F && c <= 0x2040) ||
              (c >= 0x2070 && c <= 0x218F) ||
              (c >= 0x2C00 && c <= 0x2FEF) ||
              (c >= 0x3001 && c <= 0xD7FF) ||
              (c >= 0xF900 && c <= 0xFDCF) ||
              (c >= 0xFDF0 && c <= 0xFFFD) ||
              (c >= 0x10000 && c <= 0xEFFFF));
    else
      return (c == '.' || c == '-' || c == '_' || c == ':' ||
              isLetter(c) || isDigit(c) ||
              isCombiningChar(c) || isExtender(c));
  }

  public static boolean isLetter(char c)
  {
    if ((c >= 0x0041 && c <= 0x005A) ||
        (c >= 0x0061 && c <= 0x007A) ||
        (c >= 0x00C0 && c <= 0x00D6) ||
        (c >= 0x00D8 && c <= 0x00F6) ||
        (c >= 0x00F8 && c <= 0x00FF) ||
        (c >= 0x0100 && c <= 0x0131) ||
        (c >= 0x0134 && c <= 0x013E) ||
        (c >= 0x0141 && c <= 0x0148) ||
        (c >= 0x014A && c <= 0x017E) ||
        (c >= 0x0180 && c <= 0x01C3) ||
        (c >= 0x01CD && c <= 0x01F0) ||
        (c >= 0x01F4 && c <= 0x01F5) ||
        (c >= 0x01FA && c <= 0x0217) ||
        (c >= 0x0250 && c <= 0x02A8) ||
        (c >= 0x02BB && c <= 0x02C1) ||
        c == 0x0386 ||
        (c >= 0x0388 && c <= 0x038A) ||
        c == 0x038C ||
        (c >= 0x038E && c <= 0x03A1) ||
        (c >= 0x03A3 && c <= 0x03CE) ||
        (c >= 0x03D0 && c <= 0x03D6) ||
        c == 0x03DA ||
      c == 0x03DC ||
        c == 0x03DE ||
        c == 0x03E0 ||
        (c >= 0x03E2 && c <= 0x03F3) ||
        (c >= 0x0401 && c <= 0x040C) ||
        (c >= 0x040E && c <= 0x044F) ||
        (c >= 0x0451 && c <= 0x045C) ||
        (c >= 0x045E && c <= 0x0481) ||
        (c >= 0x0490 && c <= 0x04C4) ||
        (c >= 0x04C7 && c <= 0x04C8) ||
        (c >= 0x04CB && c <= 0x04CC) ||
        (c >= 0x04D0 && c <= 0x04EB) ||
        (c >= 0x04EE && c <= 0x04F5) ||
        (c >= 0x04F8 && c <= 0x04F9) ||
        (c >= 0x0531 && c <= 0x0556) ||
        c == 0x0559 ||
        (c >= 0x0561 && c <= 0x0586) ||
        (c >= 0x05D0 && c <= 0x05EA) ||
        (c >= 0x05F0 && c <= 0x05F2) ||
        (c >= 0x0621 && c <= 0x063A) ||
        (c >= 0x0641 && c <= 0x064A) ||
        (c >= 0x0671 && c <= 0x06B7) ||
        (c >= 0x06BA && c <= 0x06BE) ||
        (c >= 0x06C0 && c <= 0x06CE) ||
        (c >= 0x06D0 && c <= 0x06D3) ||
        c == 0x06D5 ||
        (c >= 0x06E5 && c <= 0x06E6) ||
        (c >= 0x0905 && c <= 0x0939) ||
        c == 0x093D ||
        (c >= 0x0958 && c <= 0x0961) ||
        (c >= 0x0985 && c <= 0x098C) ||
        (c >= 0x098F && c <= 0x0990) ||
        (c >= 0x0993 && c <= 0x09A8) ||
        (c >= 0x09AA && c <= 0x09B0) ||
        c == 0x09B2 ||
        (c >= 0x09B6 && c <= 0x09B9) ||
        (c >= 0x09DC && c <= 0x09DD) ||
        (c >= 0x09DF && c <= 0x09E1) ||
        (c >= 0x09F0 && c <= 0x09F1) ||
        (c >= 0x0A05 && c <= 0x0A0A) ||
        (c >= 0x0A0F && c <= 0x0A10) ||
        (c >= 0x0A13 && c <= 0x0A28) ||
        (c >= 0x0A2A && c <= 0x0A30) ||
        (c >= 0x0A32 && c <= 0x0A33) ||
        (c >= 0x0A35 && c <= 0x0A36) ||
        (c >= 0x0A38 && c <= 0x0A39) ||
        (c >= 0x0A59 && c <= 0x0A5C) ||
        c == 0x0A5E ||
        (c >= 0x0A72 && c <= 0x0A74) ||
        (c >= 0x0A85 && c <= 0x0A8B) ||
        c == 0x0A8D ||
        (c >= 0x0A8F && c <= 0x0A91) ||
        (c >= 0x0A93 && c <= 0x0AA8) ||
        (c >= 0x0AAA && c <= 0x0AB0) ||
        (c >= 0x0AB2 && c <= 0x0AB3) ||
        (c >= 0x0AB5 && c <= 0x0AB9) ||
        c == 0x0ABD ||
        c == 0x0AE0 ||
        (c >= 0x0B05 && c <= 0x0B0C) ||
        (c >= 0x0B0F && c <= 0x0B10) ||
        (c >= 0x0B13 && c <= 0x0B28) ||
        (c >= 0x0B2A && c <= 0x0B30) ||
        (c >= 0x0B32 && c <= 0x0B33) ||
        (c >= 0x0B36 && c <= 0x0B39) ||
        c == 0x0B3D ||
        (c >= 0x0B5C && c <= 0x0B5D) ||
        (c >= 0x0B5F && c <= 0x0B61) ||
        (c >= 0x0B85 && c <= 0x0B8A) ||
        (c >= 0x0B8E && c <= 0x0B90) ||
        (c >= 0x0B92 && c <= 0x0B95) ||
        (c >= 0x0B99 && c <= 0x0B9A) ||
        c == 0x0B9C ||
        (c >= 0x0B9E && c <= 0x0B9F) ||
        (c >= 0x0BA3 && c <= 0x0BA4) ||
        (c >= 0x0BA8 && c <= 0x0BAA) ||
        (c >= 0x0BAE && c <= 0x0BB5) ||
        (c >= 0x0BB7 && c <= 0x0BB9) ||
        (c >= 0x0C05 && c <= 0x0C0C) ||
        (c >= 0x0C0E && c <= 0x0C10) ||
        (c >= 0x0C12 && c <= 0x0C28) ||
        (c >= 0x0C2A && c <= 0x0C33) ||
        (c >= 0x0C35 && c <= 0x0C39) ||
        (c >= 0x0C60 && c <= 0x0C61) ||
        (c >= 0x0C85 && c <= 0x0C8C) ||
        (c >= 0x0C8E && c <= 0x0C90) ||
        (c >= 0x0C92 && c <= 0x0CA8) ||
        (c >= 0x0CAA && c <= 0x0CB3) ||
        (c >= 0x0CB5 && c <= 0x0CB9) ||
        c == 0x0CDE ||
        (c >= 0x0CE0 && c <= 0x0CE1) ||
        (c >= 0x0D05 && c <= 0x0D0C) ||
        (c >= 0x0D0E && c <= 0x0D10) ||
        (c >= 0x0D12 && c <= 0x0D28) ||
        (c >= 0x0D2A && c <= 0x0D39) ||
        (c >= 0x0D60 && c <= 0x0D61) ||
        (c >= 0x0E01 && c <= 0x0E2E) ||
        c == 0x0E30 ||
        (c >= 0x0E32 && c <= 0x0E33) ||
        (c >= 0x0E40 && c <= 0x0E45) ||
        (c >= 0x0E81 && c <= 0x0E82) ||
        c == 0x0E84 ||
        (c >= 0x0E87 && c <= 0x0E88) ||
        c == 0x0E8A ||
        c == 0x0E8D ||
        (c >= 0x0E94 && c <= 0x0E97) ||
        (c >= 0x0E99 && c <= 0x0E9F) ||
        (c >= 0x0EA1 && c <= 0x0EA3) ||
        c == 0x0EA5 ||
        c == 0x0EA7 ||
        (c >= 0x0EAA && c <= 0x0EAB) ||
        (c >= 0x0EAD && c <= 0x0EAE) ||
        c == 0x0EB0 ||
        (c >= 0x0EB2 && c <= 0x0EB3) ||
        c == 0x0EBD ||
        (c >= 0x0EC0 && c <= 0x0EC4) ||
        (c >= 0x0F40 && c <= 0x0F47) ||
        (c >= 0x0F49 && c <= 0x0F69) ||
        (c >= 0x10A0 && c <= 0x10C5) ||
        (c >= 0x10D0 && c <= 0x10F6) ||
        c == 0x1100 ||
        (c >= 0x1102 && c <= 0x1103) ||
        (c >= 0x1105 && c <= 0x1107) ||
        c == 0x1109 ||
        (c >= 0x110B && c <= 0x110C) ||
        (c >= 0x110E && c <= 0x1112) ||
        c == 0x113C ||
        c == 0x113E ||
        c == 0x1140 ||
        c == 0x114C ||
        c == 0x114E ||
        c == 0x1150 ||
        (c >= 0x1154 && c <= 0x1155) ||
        c == 0x1159 ||
        (c >= 0x115F && c <= 0x1161) ||
        c == 0x1163 ||
        c == 0x1165 ||
        c == 0x1167 ||
        c == 0x1169 ||
        (c >= 0x116D && c <= 0x116E) ||
        (c >= 0x1172 && c <= 0x1173) ||
        c == 0x1175 ||
        c == 0x119E ||
        c == 0x11A8 ||
        c == 0x11AB ||
        (c >= 0x11AE && c <= 0x11AF) ||
        (c >= 0x11B7 && c <= 0x11B8) ||
        c == 0x11BA ||
        (c >= 0x11BC && c <= 0x11C2) ||
        c == 0x11EB ||
        c == 0x11F0 ||
        c == 0x11F9 ||
        (c >= 0x1E00 && c <= 0x1E9B) ||
        (c >= 0x1EA0 && c <= 0x1EF9) ||
        (c >= 0x1F00 && c <= 0x1F15) ||
        (c >= 0x1F18 && c <= 0x1F1D) ||
        (c >= 0x1F20 && c <= 0x1F45) ||
        (c >= 0x1F48 && c <= 0x1F4D) ||
        (c >= 0x1F50 && c <= 0x1F57) ||
        c == 0x1F59 ||
        c == 0x1F5B ||
        c == 0x1F5D ||
        (c >= 0x1F5F && c <= 0x1F7D) ||
        (c >= 0x1F80 && c <= 0x1FB4) ||
        (c >= 0x1FB6 && c <= 0x1FBC) ||
        c == 0x1FBE ||
        (c >= 0x1FC2 && c <= 0x1FC4) ||
        (c >= 0x1FC6 && c <= 0x1FCC) ||
        (c >= 0x1FD0 && c <= 0x1FD3) ||
        (c >= 0x1FD6 && c <= 0x1FDB) ||
        (c >= 0x1FE0 && c <= 0x1FEC) ||
        (c >= 0x1FF2 && c <= 0x1FF4) ||
        (c >= 0x1FF6 && c <= 0x1FFC) ||
        c == 0x2126 ||
        (c >= 0x212A && c <= 0x212B) ||
        c == 0x212E ||
        (c >= 0x2180 && c <= 0x2182) ||
        (c >= 0x3041 && c <= 0x3094) ||
        (c >= 0x30A1 && c <= 0x30FA) ||
        (c >= 0x3105 && c <= 0x312C) ||
        (c >= 0xAC00 && c <= 0xD7A3))
        return true; // BaseChar
    if ((c >= 0x4e00 && c <= 0x9fa5) ||
        c == 0x3007 ||
        (c >= 0x3021 && c <= 0x3029))
      return true; // Ideographic
    return false;
  }

  public static boolean isDigit(char c)
  {
    return ((c >= 0x0030 && c <= 0x0039) ||
            (c >= 0x0660 && c <= 0x0669) ||
            (c >= 0x06F0 && c <= 0x06F9) ||
            (c >= 0x0966 && c <= 0x096F) ||
            (c >= 0x09E6 && c <= 0x09EF) ||
            (c >= 0x0A66 && c <= 0x0A6F) ||
            (c >= 0x0AE6 && c <= 0x0AEF) ||
            (c >= 0x0B66 && c <= 0x0B6F) ||
            (c >= 0x0BE7 && c <= 0x0BEF) ||
            (c >= 0x0C66 && c <= 0x0C6F) ||
            (c >= 0x0CE6 && c <= 0x0CEF) ||
            (c >= 0x0D66 && c <= 0x0D6F) ||
            (c >= 0x0E50 && c <= 0x0E59) ||
            (c >= 0x0ED0 && c <= 0x0ED9) ||
            (c >= 0x0F20 && c <= 0x0F29));
  }

  public static boolean isCombiningChar(char c)
  {
    return ((c >= 0x0300 && c <= 0x0345) ||
            (c >= 0x0360 && c <= 0x0361) ||
            (c >= 0x0483 && c <= 0x0486) ||
            (c >= 0x0591 && c <= 0x05A1) ||
            (c >= 0x05A3 && c <= 0x05B9) ||
            (c >= 0x05BB && c <= 0x05BD) ||
            c == 0x05BF ||
            (c >= 0x05C1 && c <= 0x05C2) ||
            c == 0x05C4 ||
            (c >= 0x064B && c <= 0x0652) ||
            c == 0x0670 ||
            (c >= 0x06D6 && c <= 0x06DC) ||
            (c >= 0x06DD && c <= 0x06DF) ||
            (c >= 0x06E0 && c <= 0x06E4) ||
            (c >= 0x06E7 && c <= 0x06E8) ||
            (c >= 0x06EA && c <= 0x06ED) ||
            (c >= 0x0901 && c <= 0x0903) ||
            c == 0x093C ||
            (c >= 0x093E && c <= 0x094C) ||
            c == 0x094D ||
            (c >= 0x0951 && c <= 0x0954) ||
            (c >= 0x0962 && c <= 0x0963) ||
            (c >= 0x0981 && c <= 0x0983) ||
            c == 0x09BC ||
            c == 0x09BE ||
            c == 0x09BF ||
            (c >= 0x09C0 && c <= 0x09C4) ||
            (c >= 0x09C7 && c <= 0x09C8) ||
            (c >= 0x09CB && c <= 0x09CD) ||
            c == 0x09D7 ||
            (c >= 0x09E2 && c <= 0x09E3) ||
            c == 0x0A02 ||
            c == 0x0A3C ||
            c == 0x0A3E ||
            c == 0x0A3F ||
            (c >= 0x0A40 && c <= 0x0A42) ||
            (c >= 0x0A47 && c <= 0x0A48) ||
            (c >= 0x0A4B && c <= 0x0A4D) ||
            (c >= 0x0A70 && c <= 0x0A71) ||
            (c >= 0x0A81 && c <= 0x0A83) ||
            c == 0x0ABC ||
            (c >= 0x0ABE && c <= 0x0AC5) ||
            (c >= 0x0AC7 && c <= 0x0AC9) ||
            (c >= 0x0ACB && c <= 0x0ACD) ||
            (c >= 0x0B01 && c <= 0x0B03) ||
            c == 0x0B3C ||
            (c >= 0x0B3E && c <= 0x0B43) ||
            (c >= 0x0B47 && c <= 0x0B48) ||
            (c >= 0x0B4B && c <= 0x0B4D) ||
            (c >= 0x0B56 && c <= 0x0B57) ||
            (c >= 0x0B82 && c <= 0x0B83) ||
            (c >= 0x0BBE && c <= 0x0BC2) ||
            (c >= 0x0BC6 && c <= 0x0BC8) ||
            (c >= 0x0BCA && c <= 0x0BCD) ||
            c == 0x0BD7 ||
            (c >= 0x0C01 && c <= 0x0C03) ||
            (c >= 0x0C3E && c <= 0x0C44) ||
            (c >= 0x0C46 && c <= 0x0C48) ||
            (c >= 0x0C4A && c <= 0x0C4D) ||
            (c >= 0x0C55 && c <= 0x0C56) ||
            (c >= 0x0C82 && c <= 0x0C83) ||
            (c >= 0x0CBE && c <= 0x0CC4) ||
            (c >= 0x0CC6 && c <= 0x0CC8) ||
            (c >= 0x0CCA && c <= 0x0CCD) ||
            (c >= 0x0CD5 && c <= 0x0CD6) ||
            (c >= 0x0D02 && c <= 0x0D03) ||
            (c >= 0x0D3E && c <= 0x0D43) ||
            (c >= 0x0D46 && c <= 0x0D48) ||
            (c >= 0x0D4A && c <= 0x0D4D) ||
            c == 0x0D57 ||
            c == 0x0E31 ||
            (c >= 0x0E34 && c <= 0x0E3A) ||
            (c >= 0x0E47 && c <= 0x0E4E) ||
            c == 0x0EB1 ||
            (c >= 0x0EB4 && c <= 0x0EB9) ||
            (c >= 0x0EBB && c <= 0x0EBC) ||
            (c >= 0x0EC8 && c <= 0x0ECD) ||
            (c >= 0x0F18 && c <= 0x0F19) ||
            c == 0x0F35 ||
            c == 0x0F37 ||
            c == 0x0F39 ||
            c == 0x0F3E ||
            c == 0x0F3F ||
            (c >= 0x0F71 && c <= 0x0F84) ||
            (c >= 0x0F86 && c <= 0x0F8B) ||
            (c >= 0x0F90 && c <= 0x0F95) ||
            c == 0x0F97 ||
            (c >= 0x0F99 && c <= 0x0FAD) ||
            (c >= 0x0FB1 && c <= 0x0FB7) ||
            c == 0x0FB9 ||
            (c >= 0x20D0 && c <= 0x20DC) ||
            c == 0x20E1 ||
            (c >= 0x302A && c <= 0x302F) ||
            c == 0x3099 ||
            c == 0x309A);
  }

  public static boolean isExtender(char c)
  {
    return (c == 0x00B7 ||
            c == 0x02D0 ||
            c == 0x02D1 ||
            c == 0x0387 ||
            c == 0x0640 ||
            c == 0x0E46 ||
            c == 0x0EC6 ||
            c == 0x3005 ||
            (c >= 0x3031 && c <= 0x3035) ||
            (c >= 0x309D && c <= 0x309E) ||
            (c >= 0x30FC && c <= 0x30FE));
  }
  
  private String intern(String text)
  {
    return stringInterning ? text.intern() : text;
  }

  private void error(String message)
    throws XMLStreamException
  {
    error(message, null);
  }
  
  private void error(String message, Object info)
    throws XMLStreamException
  {
    if (info != null)
      {
        if (info instanceof String)
          message += ": \"" + ((String) info) + "\"";
        else if (info instanceof Character)
          message += ": '" + ((Character) info) + "'";
      }
    throw new XMLStreamException(message);
  }

  private void validateStartElement(String elementName)
    throws XMLStreamException
  {
    if (currentContentModel == null)
      return; // root element
    if (doctype == null)
      error("document does not specify a DTD");
    switch (currentContentModel.type)
      {
      case ContentModel.EMPTY:
        error("child element found in empty element", elementName);
        break;
      case ContentModel.ELEMENT:
        LinkedList ctx = (LinkedList) validationStack.getLast();
        ctx.add(elementName);
        break;
      case ContentModel.MIXED:
        MixedContentModel mm = (MixedContentModel) currentContentModel;
        if (!mm.containsName(elementName))
          error("illegal element for content model", elementName);
        break;
      }
  }

  private void validateEndElement()
    throws XMLStreamException
  {
    if (currentContentModel == null)
      return; // root element
    switch (currentContentModel.type)
      {
      case ContentModel.ELEMENT:
        LinkedList ctx = (LinkedList) validationStack.getLast();
        ElementContentModel ecm = (ElementContentModel) currentContentModel;
        validateElementContent(ecm, ctx);
        break;
      }
  }

  private void validatePCData(String text)
    throws XMLStreamException
  {
    switch (currentContentModel.type)
      {
      case ContentModel.EMPTY:
        error("character data found in empty element", text);
        break;
      case ContentModel.ELEMENT:
        boolean white = true;
        int len = text.length();
        for (int i = 0; i < len; i++)
          {
            char c = text.charAt(i);
            if (c != ' ' && c != '\t' && c != '\n' && c != '\r')
              {
                white = false;
                break;
              }
          }
        if (!white)
          error("character data found in element with element content", text);
        break;
      }
  }

  private void validateElementContent(ElementContentModel model,
                                      LinkedList children)
    throws XMLStreamException
  {
    // Use regular expression
    StringBuffer buf = new StringBuffer();
    for (Iterator i = children.iterator(); i.hasNext(); )
      {
        buf.append((String) i.next());
        buf.append(' ');
      }
    String c = buf.toString();
    String regex = createRegularExpression(model);
    if (!c.matches(regex))
      error("element content does not match expression "+regex, c);
  }

  private String createRegularExpression(ElementContentModel model)
  {
    if (model.regex == null)
      {
        StringBuffer buf = new StringBuffer();
        buf.append('(');
        for (Iterator i = model.contentParticles.iterator(); i.hasNext(); )
          {
            ContentParticle cp = (ContentParticle) i.next();
            if (cp.content instanceof String)
              {
                buf.append('(');
                buf.append((String) cp.content);
                buf.append(' ');
                buf.append(')');
                if (cp.max == -1)
                  {
                    if (cp.min == 0)
                      buf.append('*');
                    else
                      buf.append('+');
                  }
                else if (cp.min == 0)
                  buf.append('?');
              }
            else
              {
                ElementContentModel ecm = (ElementContentModel) cp.content;
                buf.append(createRegularExpression(ecm));
              }
            if (i.hasNext())
              buf.append('|');
          }
        buf.append(')');
        if (model.max == -1)
          {
            if (model.min == 0)
              buf.append('*');
            else
              buf.append('+');
          }
        else if (model.min == 0)
          buf.append('?');
        model.regex = buf.toString();
      }
    return model.regex;
  }

  public static void main(String[] args)
    throws Exception
  {
    boolean xIncludeAware = false;
    if (args.length > 1 && "-x".equals(args[1]))
      xIncludeAware = true;
    XMLParser p = new XMLParser(new java.io.FileInputStream(args[0]),
                                absolutize(null, args[0]),
                                true, // validating
                                true, // namespaceAware
                                true, // coalescing,
                                true, // replaceERefs
                                true, // externalEntities
                                true, // supportDTD
                                false, // baseAware
                                true, // stringInterning
                                null,
                                null);
    XMLStreamReader reader = p;
    if (xIncludeAware)
      reader = new XIncludeFilter(p, args[0], true, true, true);
    try
      {
        int event;
        //do
        while (reader.hasNext())
          {
            event = reader.next();
            switch (event)
              {
              case XMLStreamConstants.START_DOCUMENT:
                System.out.println("START_DOCUMENT version="+reader.getVersion()+
                                   " encoding="+reader.getEncoding());
                break;
              case XMLStreamConstants.END_DOCUMENT:
                System.out.println("END_DOCUMENT");
                break;
              case XMLStreamConstants.START_ELEMENT:
                System.out.println("START_ELEMENT "+reader.getName());
                int l = reader.getNamespaceCount();
                for (int i = 0; i < l; i++)
                  System.out.println("\tnamespace "+reader.getNamespacePrefix(i)+
                                     "='"+reader.getNamespaceURI(i)+"'");
                l = reader.getAttributeCount();
                for (int i = 0; i < l; i++)
                  System.out.println("\tattribute "+reader.getAttributeQName(i)+
                                     "='"+reader.getAttributeValue(i)+"'");
                break;
              case XMLStreamConstants.END_ELEMENT:
                System.out.println("END_ELEMENT "+reader.getName());
                break;
              case XMLStreamConstants.CHARACTERS:
                System.out.println("CHARACTERS '"+reader.getText()+"'");
                break;
              case XMLStreamConstants.CDATA:
                System.out.println("CDATA '"+reader.getText()+"'");
                break;
              case XMLStreamConstants.SPACE:
                System.out.println("SPACE '"+reader.getText()+"'");
                break;
              case XMLStreamConstants.DTD:
                System.out.println("DTD "+reader.getText());
                break;
              case XMLStreamConstants.ENTITY_REFERENCE:
                System.out.println("ENTITY_REFERENCE "+reader.getText());
                break;
              case XMLStreamConstants.COMMENT:
                System.out.println("COMMENT '"+reader.getText()+"'");
                break;
              case XMLStreamConstants.PROCESSING_INSTRUCTION:
                System.out.println("PROCESSING_INSTRUCTION "+reader.getPITarget()+
                                   " "+reader.getPIData());
                break;
              case XMLStreamConstants.START_ENTITY:
                System.out.println("START_ENTITY "+reader.getText());
                break;
              case XMLStreamConstants.END_ENTITY:
                System.out.println("END_ENTITY "+reader.getText());
                break;
              default:
                System.out.println("Unknown event: "+event);
              }
          }
        //while (event != XMLStreamConstants.END_DOCUMENT);
      }
    catch (XMLStreamException e)
      {
        Location l = reader.getLocation();
        System.out.println("At line "+l.getLineNumber()+
                           ", column "+l.getColumnNumber()+
                           " of "+l.getLocationURI());
        throw e;
      }
  }

  class Attribute
  {

    final String name;
    final String type;
    final boolean specified;
    final String value;
    final String prefix;
    final String localName;

    Attribute(String name, String type, boolean specified, String value)
    {
      this.name = name;
      this.type = type;
      this.specified = specified;
      this.value = value;
      int ci = name.indexOf(':');
      if (ci == -1)
        {
          prefix = null;
          localName = intern(name);
        }
      else
        {
          prefix = intern(name.substring(0, ci));
          localName = intern(name.substring(ci + 1));
        }
    }

    public boolean equals(Object other)
    {
      if (other instanceof Attribute)
        {
          return ((Attribute) other).name.equals(name);
        }
      return false;
    }
    
  }

  class Doctype
  {

    final String rootName;
    final String publicId;
    final String systemId;
    private final LinkedHashMap elements = new LinkedHashMap();
    private final LinkedHashMap attlists = new LinkedHashMap();
    private final LinkedHashMap entities = new LinkedHashMap();
    private final LinkedHashMap notations = new LinkedHashMap();
    private final LinkedHashMap comments = new LinkedHashMap();
    private final LinkedHashMap pis = new LinkedHashMap();
    private final LinkedList entries = new LinkedList();
    private final HashSet externalEntities = new HashSet();
    private final HashSet externalNotations = new HashSet();
    private int anon = 1;

    Doctype(String rootName, String publicId, String systemId)
    {
      this.rootName = rootName;
      this.publicId = publicId;
      this.systemId = systemId;
    }

    void addElementDecl(String name, String text, ContentModel model)
    {
      if (elements.containsKey(name))
        return;
      model.text = text;
      elements.put(name, model);
      entries.add("E" + name);
    }

    void addAttributeDecl(String ename, String aname, AttributeDecl decl)
    {
      LinkedHashMap attlist = (LinkedHashMap) attlists.get(ename);
      if (attlist == null)
        {
          attlist = new LinkedHashMap();
          attlists.put(ename, attlist);
        }
      else if (attlist.containsKey(aname))
        return;
      attlist.put(aname, decl);
      String key = "A" + ename;
      if (!entries.contains(key))
        entries.add(key);
    }

    void addEntityDecl(String name, String text, boolean inExternalSubset)
    {
      if (entities.containsKey(name))
        return;
      entities.put(name, text);
      entries.add("e" + name);
      if (inExternalSubset)
        externalEntities.add(name);
    }
    
    void addEntityDecl(String name, ExternalIds ids, boolean inExternalSubset)
    {
      if (entities.containsKey(name))
        return;
      entities.put(name, ids);
      entries.add("e" + name);
      if (inExternalSubset)
        externalEntities.add(name);
    }

    void addNotationDecl(String name, ExternalIds ids, boolean inExternalSubset)
    {
      if (notations.containsKey(name))
        return;
      notations.put(name, ids);
      entries.add("n" + name);
      if (inExternalSubset)
        externalNotations.add(name);
    }

    void addComment(String text)
    {
      String key = Integer.toString(anon++);
      comments.put(key, text);
      entries.add("c" + key);
    }

    void addPI(String target, String data)
    {
      String key = Integer.toString(anon++);
      pis.put(key, new String[] {target, data});
      entries.add("p" + key);
    }

    ContentModel getElementModel(String name)
    {
      return (ContentModel) elements.get(name);
    }

    AttributeDecl getAttributeDecl(String ename, String aname)
    {
      LinkedHashMap attlist = (LinkedHashMap) attlists.get(ename);
      return (attlist == null) ? null : (AttributeDecl) attlist.get(aname);
    }

    boolean isAttributeDeclared(String ename, String aname)
    {
      LinkedHashMap attlist = (LinkedHashMap) attlists.get(ename);
      return (attlist == null) ? false : attlist.containsKey(aname);
    }

    Iterator attlistIterator(String ename)
    {
      LinkedHashMap attlist = (LinkedHashMap) attlists.get(ename);
      return (attlist == null) ? Collections.EMPTY_LIST.iterator() :
        attlist.entrySet().iterator();
    }

    Object getEntity(String name)
    {
      return entities.get(name);
    }

    boolean isEntityExternal(String name)
    {
      return externalEntities.contains(name);
    }

    ExternalIds getNotation(String name)
    {
      return (ExternalIds) notations.get(name);
    }

    boolean isNotationExternal(String name)
    {
      return externalNotations.contains(name);
    }

    String getComment(String key)
    {
      return (String) comments.get(key);
    }

    String[] getPI(String key)
    {
      return (String[]) pis.get(key);
    }

    Iterator entryIterator()
    {
      return entries.iterator();
    }
    
  }

  class ExternalIds
  {
    String publicId;
    String systemId;
    String notationName;
  }

  abstract class ContentModel
  {
    static final int EMPTY = 0;
    static final int ANY = 1;
    static final int ELEMENT = 2;
    static final int MIXED = 3;
    
    int min;
    int max;
    final int type;
    String text;

    ContentModel(int type)
    {
      this.type = type;
      min = 1;
      max = 1;
    }
    
  }

  class EmptyContentModel
    extends ContentModel
  {
    
    EmptyContentModel()
    {
      super(ContentModel.EMPTY);
      min = 0;
      max = 0;
    }
    
  }

  class AnyContentModel
    extends ContentModel
  {
    
    AnyContentModel()
    {
      super(ContentModel.ANY);
      min = 0;
      max = -1;
    }
    
  }

  class ElementContentModel
    extends ContentModel
  {

    LinkedList contentParticles;
    String regex; // regular expression cache
    
    ElementContentModel()
    {
      super(ContentModel.ELEMENT);
      contentParticles = new LinkedList();
    }

    void addContentParticle(ContentParticle cp)
    {
      contentParticles.add(cp);
    }
    
  }

  class ContentParticle
  {

    int min = 1;
    int max = 1;
    Object content; // Name (String) or ElementContentModel
    
  }

  class MixedContentModel
    extends ContentModel
  {

    private HashSet names;
    
    MixedContentModel()
    {
      super(ContentModel.MIXED);
      names = new HashSet();
    }

    void addName(String name)
    {
      names.add(name);
    }

    boolean containsName(String name)
    {
      return names.contains(name);
    }
    
  }

  class AttributeDecl
  {
    
    final String type;
    final String value;
    final int valueType;
    final String enumeration;

    AttributeDecl(String type, String value,
                  int valueType, String enumeration)
    {
      this.type = type;
      this.value = value;
      this.valueType = valueType;
      this.enumeration = enumeration;
    }
    
  }

  interface XMLResolver2
    extends XMLResolver
  {

    InputStream resolve(String publicId, String systemId)
      throws XMLStreamException;

  }

  static class Input
    implements Location
  {
    
    int line = 1, markLine;
    int column, markColumn;
    int offset, markOffset;
    final String publicId, systemId, name;
    
    InputStream in;
    Reader reader;
    boolean forceReader, initialized;
    String inputEncoding;
    boolean xml11;

    Input(InputStream in, String publicId, String systemId, String name)
    {
      this(in, null, publicId, systemId, name, null);
    }
    
    Input(InputStream in, String publicId, String systemId, String name,
          String inputEncoding)
    {
      this(in, null, publicId, systemId, name, inputEncoding);
    }
    
    Input(InputStream in, Reader reader, String publicId, String systemId,
          String name)
    {
      this(in, reader, publicId, systemId, name, null);
    }
    
    Input(InputStream in, Reader reader, String publicId, String systemId,
          String name, String defaultEncoding)
    {
      if (defaultEncoding == null)
        defaultEncoding = "UTF-8";
      if (in != null && !in.markSupported())
        in = new BufferedInputStream(in);
      this.in = in;
      this.publicId = publicId;
      this.systemId = systemId;
      this.name = name;
      if (reader == null)
        {
          try
            {
              in = new CRLFInputStream(in);
              reader = new XMLInputStreamReader(in, defaultEncoding);
            }
          catch (UnsupportedEncodingException e)
            {
              RuntimeException e2 =
                new RuntimeException(defaultEncoding +
                                     " charset not supported");
              e2.initCause(e);
              throw e2;
            }
        }
      else
        {
          forceReader = true;
          reader = new CRLFReader(reader);
        }
      this.reader = reader;
      initialized = false;
    }

    // -- Location --
    
    public int getCharacterOffset()
    {
      return offset;
    }
    
    public int getColumnNumber()
    {
      return column;
    }

    public int getLineNumber()
    {
      return line;
    }

    public String getLocationURI()
    {
      return systemId;
    }

    void init()
      throws IOException
    {
      if (initialized)
        return;
      if (!forceReader && in != null)
        detectEncoding();
      initialized = true;
    }

    void mark(int len)
      throws IOException
    {
      //System.out.println("  mark:"+len);
      markOffset = offset;
      markLine = line;
      markColumn = column;
      reader.mark(len);
    }

    /**
     * Character read.
     */
    int read()
      throws IOException
    {
      offset++;
      int ret = reader.read();
      //System.out.println("read1:"+((char) ret));
      if (ret == 0x0d || (xml11 && ret == 0x85))
        ret = 0x0a;
      if (ret == 0x0a)
        {
          line++;
          column = 0;
        }
      else
        column++;
      return ret;
    }

    /**
     * Block read.
     */
    int read(char[] b, int off, int len)
      throws IOException
    {
      int ret = reader.read(b, off, len);
      if (ret != -1)
        {
          //System.out.println("read:"+new String(b, off, ret));
          for (int i = 0; i < ret; i++)
            {
              char c = b[off + i];
              if (c == 0x0d || (xml11 && c == 0x85))
                {
                  c = 0x0a;
                  b[off + i] = c;
                }
              if (c == 0x0a)
                {
                  line++;
                  column = 0;
                }
              else
                column++;
            }
        }
      return ret;
    }

    void reset()
      throws IOException
    {
      //System.out.println("  reset");
      reader.reset();
      offset = markOffset;
      line = markLine;
      column = markColumn;
    }

    // Detection of input encoding
    
    private static final int[] SIGNATURE_UCS_4_1234 =
      new int[] { 0x00, 0x00, 0x00, 0x3c };
    private static final int[] SIGNATURE_UCS_4_4321 =
      new int[] { 0x3c, 0x00, 0x00, 0x00 };
    private static final int[] SIGNATURE_UCS_4_2143 =
      new int[] { 0x00, 0x00, 0x3c, 0x00 };
    private static final int[] SIGNATURE_UCS_4_3412 =
      new int[] { 0x00, 0x3c, 0x00, 0x00 };
    private static final int[] SIGNATURE_UCS_2_12 =
      new int[] { 0xfe, 0xff };
    private static final int[] SIGNATURE_UCS_2_21 =
      new int[] { 0xff, 0xfe };
    private static final int[] SIGNATURE_UCS_2_12_NOBOM =
      new int[] { 0x00, 0x3c, 0x00, 0x3f };
    private static final int[] SIGNATURE_UCS_2_21_NOBOM =
      new int[] { 0x3c, 0x00, 0x3f, 0x00 };
    private static final int[] SIGNATURE_UTF_8 =
      new int[] { 0x3c, 0x3f, 0x78, 0x6d };
    private static final int[] SIGNATURE_UTF_8_BOM =
      new int[] { 0xef, 0xbb, 0xbf };
    
    /**
     * Detect the input encoding.
     */
    private void detectEncoding()
      throws IOException
    {
      int[] signature = new int[4];
      in.mark(4);
      for (int i = 0; i < 4; i++)
        signature[i] = in.read();
      in.reset();

      // 4-byte encodings
      if (equals(SIGNATURE_UCS_4_1234, signature))
        setInputEncoding("UTF-32BE");
      else if (equals(SIGNATURE_UCS_4_4321, signature))
        setInputEncoding("UTF-32LE");
      else if (equals(SIGNATURE_UCS_4_2143, signature) ||
               equals(SIGNATURE_UCS_4_3412, signature))
        throw new UnsupportedEncodingException("unsupported UCS-4 byte ordering");
      // 2-byte encodings
      else if (equals(SIGNATURE_UCS_2_12, signature))
        {
          setInputEncoding("UTF-16BE");
          in.read();
          in.read();
        }
      else if (equals(SIGNATURE_UCS_2_21, signature))
        {
          setInputEncoding("UTF-16LE");
          in.read();
          in.read();
        }
      else if (equals(SIGNATURE_UCS_2_12_NOBOM, signature))
        {
          setInputEncoding("UTF-16BE");
          throw new UnsupportedEncodingException("no byte-order mark for UCS-2 entity");
        }
      else if (equals(SIGNATURE_UCS_2_21_NOBOM, signature))
        {
          setInputEncoding("UTF-16LE");
          throw new UnsupportedEncodingException("no byte-order mark for UCS-2 entity");
        }
      // ASCII-derived encodings
      else if (equals(SIGNATURE_UTF_8, signature))
        {
          // UTF-8 input encoding implied, TextDecl
        }
      else if (equals(SIGNATURE_UTF_8_BOM, signature))
        {
          setInputEncoding("UTF-8");
          in.read();
          in.read();
          in.read();
        }
    }

    private static boolean equals(int[] b1, int[] b2)
    {
      for (int i = 0; i < b1.length; i++)
        {
          if (b1[i] != b2[i])
            return false;
        }
      return true;
    }
    
    private void setInputEncoding(String encoding)
      throws UnsupportedEncodingException
    {
      if (!encoding.equals(inputEncoding) &&
          reader instanceof XMLInputStreamReader)
        {
          if (inputEncoding == "UTF-8" &&
              (encoding.startsWith("UTF-16") ||
               encoding.startsWith("UTF-32")))
            throw new UnsupportedEncodingException("document is not in its " +
                                                   "declared encoding");
          inputEncoding = encoding;
          reader = new XMLInputStreamReader((XMLInputStreamReader) reader,
                                            encoding);
        }
      else
        {
          /*if (reporter != null)
            {
            try
            {
            reporter.report("unable to set input encoding '" + encoding +
            "': input is specified as reader", "WARNING",
            encoding, this);
            }
            catch (XMLStreamException e)
            {
          // Am I bothered?
          }}*/
          System.err.println("Can't set input encoding "+encoding);
        }
    }

  }

}
