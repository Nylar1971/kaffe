/* LocaleInformation_kn.java --
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
Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA
02111-1307 USA.

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
exception statement from your version. */


// This file was automatically generated by gnu.localegen from LDML

package gnu.java.locale;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.ListResourceBundle;

public class LocaleInformation_kn extends ListResourceBundle
{
  private static final String currenciesDisplayNameKeys = "";

  private static final String currenciesDisplayNameValues = "";

  private static final Hashtable currenciesDisplayName;
  static
  {
    currenciesDisplayName = new Hashtable();
    Enumeration keys = new StringTokenizer(currenciesDisplayNameKeys, "\u00A6");
    Enumeration values = new StringTokenizer(currenciesDisplayNameValues, "\u00A6");
    while (keys.hasMoreElements())
      {
         String key = (String) keys.nextElement();
         String value = (String) values.nextElement();
         currenciesDisplayName.put(key, value);
      }
  }

  private static final String currenciesSymbolKeys = "INR";

  private static final String currenciesSymbolValues = "\u0930\u0941";

  private static final Hashtable currenciesSymbol;
  static
  {
    currenciesSymbol = new Hashtable();
    Enumeration keys = new StringTokenizer(currenciesSymbolKeys, "\u00A6");
    Enumeration values = new StringTokenizer(currenciesSymbolValues, "\u00A6");
    while (keys.hasMoreElements())
      {
         String key = (String) keys.nextElement();
         String value = (String) values.nextElement();
         currenciesSymbol.put(key, value);
      }
  }

  private static final String[] shortMonths = {
    "\u0c9c\u0ca8\u0cb5\u0cb0\u0cc0",
    "\u0cab\u0cc6\u0cac\u0ccd\u0cb0\u0cb5\u0cb0\u0cc0",
    "\u0cae\u0cbe\u0cb0\u0ccd\u0c9a\u0ccd",
    "\u0c8e\u0caa\u0ccd\u0cb0\u0cbf\u0cb2\u0ccd",
    "\u0cae\u0cc6",
    "\u0c9c\u0cc2\u0ca8\u0ccd",
    "\u0c9c\u0cc1\u0cb2\u0cc8",
    "\u0c86\u0c97\u0cb8\u0ccd\u0c9f\u0ccd",
    "\u0cb8\u0caa\u0ccd\u0c9f\u0cc6\u0c82\u0cac\u0cb0\u0ccd",
    "\u0c85\u0c95\u0ccd\u0c9f\u0ccb\u0cac\u0cb0\u0ccd",
    "\u0ca8\u0cb5\u0cc6\u0c82\u0cac\u0cb0\u0ccd",
    "\u0ca1\u0cbf\u0cb8\u0cc6\u0c82\u0cac\u0cb0\u0ccd",
    null,
  };

  private static final String[] months = {
    "\u0c9c\u0ca8\u0cb5\u0cb0\u0cc0",
    "\u0cab\u0cc6\u0cac\u0ccd\u0cb0\u0cb5\u0cb0\u0cc0",
    "\u0cae\u0cbe\u0cb0\u0ccd\u0c9a\u0ccd",
    "\u0c8e\u0caa\u0ccd\u0cb0\u0cbf\u0cb2\u0ccd",
    "\u0cae\u0cc6",
    "\u0c9c\u0cc2\u0ca8\u0ccd",
    "\u0c9c\u0cc1\u0cb2\u0cc8",
    "\u0c86\u0c97\u0cb8\u0ccd\u0c9f\u0ccd",
    "\u0cb8\u0caa\u0ccd\u0c9f\u0cc6\u0c82\u0cac\u0cb0\u0ccd",
    "\u0c85\u0c95\u0ccd\u0c9f\u0ccb\u0cac\u0cb0\u0ccd",
    "\u0ca8\u0cb5\u0cc6\u0c82\u0cac\u0cb0\u0ccd",
    "\u0ca1\u0cbf\u0cb8\u0cc6\u0c82\u0cac\u0cb0\u0ccd",
    null,
  };

  private static final String[] shortWeekdays = {
    null,
    "\u0cb0.",
    "\u0cb8\u0ccb.",
    "\u0cae\u0c82.",
    "\u0cac\u0cc1.",
    "\u0c97\u0cc1.",
    "\u0cb6\u0cc1.",
    "\u0cb6\u0ca8\u0cbf.",
  };

  private static final String[] weekdays = {
    null,
    "\u0cb0\u0cb5\u0cbf\u0cb5\u0cbe\u0cb0",
    "\u0cb8\u0ccb\u0cae\u0cb5\u0cbe\u0cb0",
    "\u0cae\u0c82\u0c97\u0cb3\u0cb5\u0cbe\u0cb0",
    "\u0cac\u0cc1\u0ca7\u0cb5\u0cbe\u0cb0",
    "\u0c97\u0cc1\u0cb0\u0cc1\u0cb5\u0cbe\u0cb0",
    "\u0cb6\u0cc1\u0c95\u0ccd\u0cb0\u0cb5\u0cbe\u0cb0",
    "\u0cb6\u0ca8\u0cbf\u0cb5\u0cbe\u0cb0",
  };

  private static final String[] ampms = {
    "\u0caa\u0cc2\u0cb0\u0ccd\u0cb5\u0cbe\u0cb9\u0ccd\u0ca8",
    "\u0c85\u0caa\u0cb0\u0cbe\u0cb9\u0ccd\u0ca8",
  };

  private static final String territoriesKeys = "CN\u00A6AU\u00A6MV\u00A6IN\u00A6EE\u00A6SG\u00A6TR\u00A6NP";

  private static final String territoriesValues = "\u0c9a\u0cc0\u0ca8\u00A6\u0c86\u0cb8\u0ccd\u0c9f\u0ccd\u0cb0\u0cc6\u0cb2\u0cbf\u0caf\u00A6\u0cae\u0cbe\u0cb2\u0ccd\u0ca1\u0cbf\u0cb5 \u0ca6\u0ccd\u0cb5\u0cc0\u0caa\u0c97\u0cb3\u0cc1\u00A6\u0cad\u0cbe\u0cb0\u0ca4\u00A6\u0c8e\u0cb8\u0ccd\u0ca4\u0cca\u0ca8\u0cbf\u0caf\u00A6\u0cb8\u0cbf\u0c82\u0c97\u0caa\u0cc1\u0cb0\u00A6\u0ca4\u0cc1\u0cb0\u0ccd\u0c95\u0cbf\u00A6\u0ca8\u0cc6\u0caa\u0cbe\u0cb3";

  private static final Hashtable territories;
  static
  {
    territories = new Hashtable();
    Enumeration keys = new StringTokenizer(territoriesKeys, "\u00A6");
    Enumeration values = new StringTokenizer(territoriesValues, "\u00A6");
    while (keys.hasMoreElements())
      {
         String key = (String) keys.nextElement();
         String value = (String) values.nextElement();
         territories.put(key, value);
      }
  }

  private static final String languagesKeys = "kn";

  private static final String languagesValues = "\u0c95\u0ca8\u0ccd\u0ca8\u0ca1";

  private static final Hashtable languages;
  static
  {
    languages = new Hashtable();
    Enumeration keys = new StringTokenizer(languagesKeys, "\u00A6");
    Enumeration values = new StringTokenizer(languagesValues, "\u00A6");
    while (keys.hasMoreElements())
      {
         String key = (String) keys.nextElement();
         String value = (String) values.nextElement();
         languages.put(key, value);
      }
  }

  private static final Object[][] contents =
  {
    { "currenciesDisplayName", currenciesDisplayName },
    { "currenciesSymbol", currenciesSymbol },
    { "shortMonths", shortMonths },
    { "months", months },
    { "shortWeekdays", shortWeekdays },
    { "weekdays", weekdays },
    { "ampms", ampms },
    { "territories", territories },
    { "languages", languages },
  };

  public Object[][] getContents() { return contents; }
}
