/* gnu.classpath.tools.gjdoc.DocImpl
   Copyright (C) 2001 Free Software Foundation, Inc.

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
Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA
02111-1307 USA. */

package gnu.classpath.tools.gjdoc;

import com.sun.javadoc.*;
import java.util.*;
import java.text.*;

/**
 *  Represents the least common denominator of all Javadoc
 *  comment classes.
 */
public abstract class DocImpl implements Doc {

   protected static Tag[] seeTagEmptyArr = new SeeTagImpl[0];
   protected static Tag[] linkTagEmptyArr = new LinkTagImpl[0];
   protected static Tag[] paramTagEmptyArr = new ParamTagImpl[0];
   protected static Tag[] throwsTagEmptyArr = new ThrowsTagImpl[0];

   // Return the text of the comment for this doc item. 
   public String commentText() {

      StringBuffer rc=new StringBuffer();

      Tag[] textTags=(Tag[])tagMap.get("text");
      if (textTags!=null) {
	 for (int i=0; i<textTags.length; ++i) {
	    rc.append(textTags[i].text());
	 }
      }
      return rc.toString();
   }

   // Compares this Object with the specified Object for order. 
   public int compareTo(java.lang.Object obj) {
      return 0;
   } 

   // Return the first sentence of the comment as tags. 
   public Tag[] firstSentenceTags() {

      Tag[] rc=(Tag[])tagMap.get("first");
      if (rc==null) rc=new Tag[0];
      return rc;
   }

   // Return the full unprocessed text of the comment. 
   public String getRawCommentText() {
      if (rawDocumentation!=null)
	  return rawDocumentation;
      else if (rawDocOffset>=0)
	 return Main.getRootDoc().readRawComment(rawDocOffset);      
      else
	 return null;
   } 

   // Return comment as tags. 
   public Tag[] inlineTags() {

      Tag[] rc=(Tag[])tagMap.get("inline");
      if (rc==null) rc=new Tag[0];
      return rc;
   }

   // Is this Doc item a class. 
   public boolean isClass() {
      return false;
   } 

   // Is this Doc item a constructor? False until overridden. 
   public boolean isConstructor() {
      return false;
   } 

   // Is this Doc item a error class? False until overridden. 
   public boolean isError() {
      return false;
   } 

   // Is this Doc item a exception class? False until overridden. 
   public boolean isException() {
      return false;
   } 

   // Is this Doc item a field? False until overridden. 
   public boolean isField() {
      return false;
   } 

   // return true if this Doc is include in the active set. 
   public boolean isIncluded() {
      return false;
   } 

   // Is this Doc item a interface? False until overridden. 
   public boolean isInterface() {
      return false;
   } 

   // Is this Doc item a simple method (i.e. 
   public boolean isMethod() {
      return false;
   } 

   public boolean isPackage() {
      return false;
   } 

   // Is this Doc item a ordinary class (i.e. 
   public boolean isOrdinaryClass() {
      return false;
   } 

   // Return the see also tags in this Doc item. 
   public SeeTag[] seeTags() {
      return (SeeTag[])getTagArr("see", seeTagEmptyArr);
   }

   protected Tag[] getTagArr(String kindOfTag, Tag[] defaultRc) {
      Tag[] rc=(Tag[])tagMap.get(kindOfTag);
      if (rc==null) rc=defaultRc;
      return rc;
   } 

   // Set the full unprocessed text of the comment. 
   public void setRawCommentText(String rawDocumentation) {
      this.rawDocumentation=rawDocumentation;
   } 

   public void resolveComments() {
      if (rawDocumentation!=null && tagMap.isEmpty()) {
	 this.tagMap=parseCommentTags(rawDocumentation.toCharArray(),
				      3,
				      rawDocumentation.length()-2,
				      getContextClass());

	 rawDocOffset=Main.getRootDoc().writeRawComment(rawDocumentation);
	 rawDocumentation=null;

	 resolveTags();
      }
   }

   public static int skipHtmlWhitespace(char[] buffer, int startIndex) {
      boolean inTag=false;
      for (int index=startIndex; index<buffer.length; ++index) {
	 char c=buffer[index];
	 if (inTag) {
	    if (c=='>') inTag=false;
	 }
	 else {
	    if (c=='<') inTag=true;
	    else if (!Parser.isWhitespace(c))
	       return index;
	 }
      }
      return buffer.length;
   }
   
   /**
    *  Looks for an end-of-sentence marker in <code>text</code>,
    *  starting at <code>startIndex</code> and stopping at
    *  <code>endIndex</code>. 
    *
    *  @param text  the text to be searched
    *  @param startIndex  index in <code>text</code> at which to start
    *  @param endIndex  index in <code>text</code> at which to stop
    *
    *  @return the index of the character following the end-of-sentence 
    *    marker, <code>endIndex</code> if no end-of-sentence
    *    marker could be found, or -1 if not implemented.
    */
   private static int findEndOfSentence(char[] text, int startIndex,
		   			int endIndex)
   {
      while (startIndex < endIndex)
	{
	  if (text[startIndex] == '.'
	    && (startIndex+1 == endIndex
		|| Character.isWhitespace(text[startIndex+1])
		|| isHTMLBreakTag(text, startIndex+1, endIndex)))
	    return startIndex;

	    startIndex++;
	}
      return endIndex;
   }

   /**
    * Returns true is the text from start to end begins with a 'p' or 'br' tag.
    */
   private static boolean isHTMLBreakTag(char[] text, int start, int end)
   {
     return
	(text[start] == '<'
	 &&
	  (
	   (
	    start+2 < end
	    && (text[start+1] == 'p' || text[start+1] == 'P')
	    && (text[start+2] == '>' || Character.isWhitespace(text[start+2]))
	   )
	  ||
	   (
	    start+3 < end
	    && (text[start+1] == 'b' || text[start+1] == 'B')
	    && (text[start+2] == 'r' || text[start+2] == 'R')
	    && (text[start+3] == '>' || Character.isWhitespace(text[start+3]))
	   )
	  )
	);
   }

   public static Map parseCommentTags(char[] comment, int startIndex, int endIndex, 
				      ClassDocImpl contextClass) {

      int rawDocStart=skipHtmlWhitespace(comment, startIndex);

      int firstSentenceEnd = 0;

      if (comment.length>rawDocStart) {

	 firstSentenceEnd = findEndOfSentence(comment, rawDocStart, comment.length);
	 
	 if (firstSentenceEnd < 0) {
	    BreakIterator boundary = BreakIterator.getSentenceInstance(Locale.ENGLISH);
	    boundary.setText(new ArrayCharacterIterator(comment, rawDocStart));
	    boundary.first();
	    boundary.next();
	    firstSentenceEnd = boundary.current();
	 }

	 // Always include period at end of sentence if there is one.
	 if (firstSentenceEnd < comment.length
			 && '.' == comment[firstSentenceEnd]) {
	    ++ firstSentenceEnd;
	 }
      }

      final int	STATE_BEGOFLINE		   = 1;
      final int	STATE_TEXT		   = 2;
      final int	STATE_PARAM		   = 3;
      final int	STATE_PARAMVALUE	   = 4;
      final int	STATE_PARAMWRAP		   = 5;
      final int	STATE_INLINEPARAM	   = 6;
      final int	STATE_INLINEPARAMVALUE	   = 7;
      final int	STATE_WHITESPACE	   = 8;
      final int	STATE_INLINEPARAMVALUE_BOL = 9;
      final int	STATE_IPV_WHITESPACE       = 10;

      int state=STATE_BEGOFLINE;
      int prevState=STATE_TEXT;

      StringBuffer buf=new StringBuffer();
      StringBuffer whitespaceBuf=new StringBuffer();

      String paramName="", paramValue="";

      Map tags=new HashMap();
      tags.put("inline", new LinkedList());
      tags.put("first", new LinkedList());
      tags.put("all", new LinkedList());

      final char EOL=(char)-1;

      for (int i=rawDocStart; i<=endIndex; ++i) {
	 char c=(i<endIndex)?comment[i]:EOL;
	 char peek=(i<endIndex-1)?comment[i+1]:EOL;

	 switch (state){

	 case STATE_BEGOFLINE:
	    if (i==firstSentenceEnd) {
	       addTag(tags, "text", buf.toString(), true, contextClass);
	       buf.setLength(0);
	    }

	    if (Parser.isWhitespace(c)) {
	       // ignore
	    }
	    else if (c=='*') {
	       // ignore, but go to STATE_TEXT
	       if (peek!='*' && peek!='@' && peek!=EOL) {
		  state=STATE_WHITESPACE;
	       }
	    }
	    else if (c=='@' || (c=='{' && peek=='@') || c==EOL) {
	       if (buf.length()>0) { 
		  addTag(tags, "text", buf.toString(), i<firstSentenceEnd, contextClass);
		  buf.setLength(0);
	       }
	       if (c=='{') {
		  ++i;
		  state=STATE_INLINEPARAM;
	       }
	       else {
		  state=STATE_PARAM;
	       }
	    }
	    else {
	       state=STATE_TEXT;
	       buf.append(whitespaceBuf);
	       whitespaceBuf.setLength(0);
	       buf.append(c);
	    }
	    break;

	 case STATE_WHITESPACE:
	    if (i==firstSentenceEnd) {
	       addTag(tags, "text", buf.toString(), true, contextClass);
	       buf.setLength(0);
	    }

	    if (c=='\n') {
	       whitespaceBuf.append(c);
	       state=STATE_BEGOFLINE;
	    }
	    else if (Parser.isWhitespace(c)) {
	       whitespaceBuf.append(c);
	    }
	    else if (c=='@' || (c=='{' && peek=='@') || c==EOL) {
	       if (buf.length()>0) { 
		  addTag(tags, "text", buf.toString(), i<firstSentenceEnd, contextClass);
		  buf.setLength(0);
	       }
	       if (c=='{') {
		  ++i;
		  state=STATE_INLINEPARAM;
	       }
	       else {
		  state=STATE_PARAM;
	       }
	    }
	    else {
	       buf.append(whitespaceBuf);
	       whitespaceBuf.setLength(0);
	       buf.append(c);
	       state=STATE_TEXT;
	    }
	    break;

	 case STATE_PARAMWRAP:
	    if (c=='\n') {
	       buf.append(c);
	    }
	    else if (Parser.isWhitespace(c)) {
	       // ignore
	    }
	    else if (c=='*') {
	       // ignore, but go to STATE_TEXT
	       /*
	       if (i<endIndex && comment[i+1]!='*' && comment[i+1]!='@') {
		  state=STATE_PARAMVALUE;
	       }
	       */
	    }
	    else if (c=='@' || (c=='{' && peek=='@') || c==EOL) {
	       paramValue=buf.toString();
	       addTag(tags, paramName, paramValue, i<firstSentenceEnd, contextClass);
	       buf.setLength(0);
	       if (c=='{') {
		  ++i;
		  state=STATE_INLINEPARAM;
	       }
	       else {
		  state=STATE_PARAM;
	       }
	    }
	    else {
	       state=STATE_PARAMVALUE;
	       buf.append(c);
	    }
	    break;

	 case STATE_PARAM:
	    if (!(c==EOL || Parser.isWhitespace(c))) {
	       buf.append(c);
	    }
	    else if (c=='\n') {
	       paramName=buf.toString();
	       buf.setLength(0);
	       state=STATE_PARAMWRAP;
	    }
	    else {
	       paramName=buf.toString();
	       buf.setLength(0);
	       state=STATE_PARAMVALUE;
	    }
	    break;

	 case STATE_INLINEPARAM:
	    if (!(c==EOL || Parser.isWhitespace(c))) {
	       buf.append(c);
	    }
	    else if (c=='\n') {
	       paramName=buf.toString();
	       buf.setLength(0);
	       state=STATE_INLINEPARAMVALUE_BOL;
	    }
	    else {
	       paramName=buf.toString();
	       buf.setLength(0);
	       state=STATE_INLINEPARAMVALUE;
	    }
	    break;

	 case STATE_PARAMVALUE:
	    if (c==EOL) {
	       paramValue=buf.toString();
	       addTag(tags, paramName, paramValue, i<firstSentenceEnd, contextClass);
	    }
	    else if (c=='\n') {
	       buf.append(c);
	       state=STATE_PARAMWRAP;
	    }
	    else {
	       buf.append(c);
	    }
	    break;

	 case STATE_INLINEPARAMVALUE:
	    if (c=='\n') {
	       buf.append(c);
	       state=STATE_INLINEPARAMVALUE_BOL;
	    }
	    else if (c==EOL || c=='}') {
	       paramValue=buf.toString();
	       addTag(tags, "link", paramValue, i<firstSentenceEnd, contextClass);
	       state=prevState;
	       buf.setLength(0);
	    }
	    else {
	       buf.append(c);
	    }
	    break;

	 case STATE_INLINEPARAMVALUE_BOL:
	    if (Parser.isWhitespace(c)) {
	       // ignore
	    }
	    else if (c=='*') {
	       // ignore, but go to STATE_TEXT
	       if (i<endIndex && peek!='*') {
		  state=STATE_IPV_WHITESPACE;
	       }
	    }
	    else if (c==EOL) {
	       if (buf.length()>0) { 
		  addTag(tags, "text", buf.toString(), i<firstSentenceEnd, contextClass);
	       }
	    }
	    else {
	       state=STATE_INLINEPARAMVALUE;
	       buf.append(whitespaceBuf);
	       whitespaceBuf.setLength(0);
	       buf.append(c);
	    }
	    break;

	 case STATE_IPV_WHITESPACE:
	    if (c=='\n') {
	       whitespaceBuf.append(c);
	       state=STATE_INLINEPARAMVALUE_BOL;
	    }
	    else if (Parser.isWhitespace(c)) {
	       whitespaceBuf.append(c);
	    }
	    else if (c==EOL) {
	       if (buf.length()>0) { 
		  addTag(tags, "text", buf.toString(), i<firstSentenceEnd, contextClass);
		  buf.setLength(0);
	       }
	    }
	    else {
	       buf.append(whitespaceBuf);
	       whitespaceBuf.setLength(0);
	       buf.append(c);
	       state=STATE_INLINEPARAMVALUE;
	    }
	    break;

	 case STATE_TEXT:
	    if (i==firstSentenceEnd) {
	       addTag(tags, "text", buf.toString(), true, contextClass);
	       buf.setLength(0);
	    }

	    if (c==EOL) {
	       paramValue=buf.toString();
	       addTag(tags, "text", paramValue, i<firstSentenceEnd, contextClass);
	    }
	    else if (c=='\n') {
	       buf.append(c);
	       state=STATE_BEGOFLINE;
	    }
	    else if (c=='{' && peek=='@') {
	       paramValue=buf.toString();
	       addTag(tags, "text", paramValue, i<firstSentenceEnd, contextClass);
	       ++i;
	       state=STATE_INLINEPARAM;
	    }
	    else {
	       buf.append(c);
	    }
	    break;

	 default:
	    throw new Error("illegal state "+state);
	 }
      }

      Map rc=new HashMap();

      for (Iterator it=tags.keySet().iterator(); it.hasNext(); ) {
	 String key=(String)it.next();
	 Tag[] templateArr;
	 List list=(List)tags.get(key);

	 if ("see".equals(key))
	    templateArr=new SeeTag[list.size()];
	 else if ("param".equals(key))
	    templateArr=new ParamTag[list.size()];
	 else if ("serialField".equals(key))
	    templateArr=new SerialFieldTag[list.size()];
	 else if ("throws".equals(key) || "exception".equals(key))
	    templateArr=new ThrowsTag[list.size()];
	 else {
	    templateArr=new Tag[list.size()];
	 }

	 rc.put(key, list.toArray(templateArr));
      }

      return rc;
   }

   private ClassDocImpl getContextClass() {
      if (isClass() || isInterface()) {
	 return (ClassDocImpl)this;
      }
      else if (isField() || isMethod() || isConstructor()) {
	 return (ClassDocImpl)((MemberDocImpl)this).containingClass();
      }
      else {
	 //System.err.println("No context class for " + this);
	 return null;
      }
   }

   private static void addTag(Map tags, String name,
			      String value, boolean isFirstSentence,
			      ClassDocImpl contextClass) {

      Tag tag;
      if (name.equals("param")) {
	 tag=new ParamTagImpl(value);
      }
      else if (name.equals("see")) {
	 tag=new SeeTagImpl(value, contextClass);
      }
      else if (name.equals("link")) {
	 tag=new LinkTagImpl(value, contextClass);
      }
      else if (name.equals("serialField")) {
	 tag=new SerialFieldTagImpl(value, contextClass);
      }
      else if (name.equals("throws") || name.equals("exception")) {
	 Debug.log(1,"adding tag '"+name+"' value '"+value+"'");
	 tag=new ThrowsTagImpl(value, contextClass);
	 name="throws";
      }
      else if (name.equals("text")) {
	 tag=new TextTagImpl(value);
      }
      else {
	 tag=new TagImpl("@"+name, value.trim());
      }

      if (name.equals("text") || name.equals("link")) {
	 ((List)tags.get("inline")).add(tag);
	 if (isFirstSentence) {
	    ((List)tags.get("first")).add(tag);	 
	 }
      }

      else
	 ((List)tags.get("all")).add(tag);

      List l=((List)tags.get(name));
      if (l==null) {
	 l=new LinkedList();
	 tags.put(name,l);
      }
      l.add(tag);
   }

   // Return all tags in this Doc item. 
   public Tag[] tags() {
      Tag[] rc=(Tag[])tagMap.get("all");
      if (rc==null) rc=new Tag[0];
      return rc;
   } 

   // Return tags of the specified kind in this Doc item. 
   public Tag[] tags(java.lang.String tagname) {
      Tag[] rc=(Tag[])tagMap.get(tagname);
      if (rc==null) rc=new Tag[0];
      return rc;
   } 

   protected String rawDocumentation;
   protected long rawDocOffset=-1;

   protected Map tagMap = new HashMap();


   protected void resolveTags() {

      Tag[] tags=tags();
      for (int i=0; i<tags.length; ++i) {
	 ((AbstractTagImpl)tags[i]).resolve();
      }

      Tag[] inlineTags=inlineTags();
      for (int i=0; i<inlineTags.length; ++i) {
	 ((AbstractTagImpl)inlineTags[i]).resolve();
      }
   }
}
