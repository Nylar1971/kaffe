/* LocaleInformation_lo.java --
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

public class LocaleInformation_lo extends ListResourceBundle
{
  private static final String currenciesDisplayNameKeys = "LAK";

  private static final String currenciesDisplayNameValues = "\u0e81\u0eb5\u0e9a";

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

  private static final String currenciesSymbolKeys = "LAK";

  private static final String currenciesSymbolValues = "\u20ad";

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
    "\u0ea1.\u0e81.",
    "\u0e81.\u0e9e.",
    "\u0ea1\u0eb5.\u0e99.",
    "\u0ea1.\u0eaa..",
    "\u0e9e.\u0e9e.",
    "\u0ea1\u0eb4.\u0e96.",
    "\u0e81.\u0ea5.",
    "\u0eaa.\u0eab.",
    "\u0e81.\u0e8d.",
    "\u0e95.\u0ea5.",
    "\u0e9e.\u0e88.",
    "\u0e97.\u0ea7.",
    null,
  };

  private static final String[] months = {
    "\u0ea1\u0eb1\u0e87\u0e81\u0ead\u0e99",
    "\u0e81\u0eb8\u0ea1\u0e9e\u0eb2",
    "\u0ea1\u0eb5\u0e99\u0eb2",
    "\u0ec0\u0ea1\u0eaa\u0eb2",
    "\u0e9e\u0eb6\u0e94\u0eaa\u0eb0\u0e9e\u0eb2",
    "\u0ea1\u0eb4\u0e96\u0eb8\u0e99\u0eb2",
    "\u0e81\u0ecd\u0ea5\u0eb0\u0e81\u0ebb\u0e94",
    "\u0eaa\u0eb4\u0e87\u0eab\u0eb2",
    "\u0e81\u0eb1\u0e99\u0e8d\u0eb2",
    "\u0e95\u0eb8\u0ea5\u0eb2",
    "\u0e9e\u0eb0\u0e88\u0eb4\u0e81",
    "\u0e97\u0eb1\u0e99\u0ea7\u0eb2",
    null,
  };

  private static final String[] shortWeekdays = {
    null,
    "\u0ead\u0eb2.",
    "\u0e88.",
    "\u0ead.",
    "\u0e9e.",
    "\u0e9e\u0eab.",
    "\u0eaa\u0e81.",
    "\u0eaa.",
  };

  private static final String[] weekdays = {
    null,
    "\u0ea7\u0eb1\u0e99\u0ead\u0eb2\u0e97\u0eb4\u0e94",
    "\u0ea7\u0eb1\u0e99\u0e88\u0eb1\u0e99",
    "\u0ea7\u0eb1\u0e99\u0ead\u0eb1\u0e87\u0e84\u0eb2\u0e99",
    "\u0ea7\u0eb1\u0e99\u0e9e\u0eb8\u0e94",
    "\u0ea7\u0eb1\u0e99\u0e9e\u0eb0\u0eab\u0eb1\u0e94",
    "\u0ea7\u0eb1\u0e99\u0eaa\u0eb8\u0e81",
    "\u0ea7\u0eb1\u0e99\u0ec0\u0eaa\u0ebb\u0eb2",
  };

  private static final String[] ampms = {
    "\u0e81\u0ec8\u0ead\u0e99\u0e97\u0ec8\u0ebd\u0e87",
    "\u0eab\u0ea5\u0eb1\u0e87\u0e97\u0ec8\u0ebd\u0e87",
  };

  private static final String territoriesKeys = "TL\u00A6TK\u00A6TJ\u00A6TH\u00A6TG\u00A6TF\u00A6GY\u00A6TD\u00A6GW\u00A6GT\u00A6GR\u00A6GQ\u00A6GP\u00A6SZ\u00A6SY\u00A6GN\u00A6GM\u00A6SV\u00A6GH\u00A6SR\u00A6GF\u00A6GE\u00A6SO\u00A6SN\u00A6GB\u00A6SL\u00A6GA\u00A6SK\u00A6SI\u00A6SG\u00A6SE\u00A6SD\u00A6SC\u00A6SA\u00A6FR\u00A6FM\u00A6RW\u00A6RU\u00A6FJ\u00A6FI\u00A6RO\u00A6ET\u00A6ES\u00A6ER\u00A6EH\u00A6EG\u00A6EE\u00A6EC\u00A6DZ\u00A6QA\u00A6DO\u00A6PY\u00A6DM\u00A6DK\u00A6DJ\u00A6PT\u00A6PR\u00A6DE\u00A6PL\u00A6PK\u00A6PH\u00A6PG\u00A6PF\u00A6CZ\u00A6PE\u00A6CY\u00A6CV\u00A6PA\u00A6CU\u00A6CR\u00A6CO\u00A6CN\u00A6CM\u00A6CL\u00A6CI\u00A6CH\u00A6CG\u00A6CF\u00A6OM\u00A6CA\u00A6BZ\u00A6BY\u00A6BW\u00A6BT\u00A6BS\u00A6BR\u00A6NZ\u00A6BO\u00A6BN\u00A6BM\u00A6NU\u00A6BJ\u00A6BI\u00A6BH\u00A6BG\u00A6BF\u00A6NP\u00A6BE\u00A6NO\u00A6BD\u00A6BB\u00A6ZW\u00A6NL\u00A6BA\u00A6NI\u00A6NG\u00A6AZ\u00A6NE\u00A6NC\u00A6AW\u00A6ZM\u00A6AU\u00A6NA\u00A6AT\u00A6AR\u00A6MZ\u00A6AO\u00A6MY\u00A6AN\u00A6MX\u00A6AM\u00A6AL\u00A6ZA\u00A6MU\u00A6MT\u00A6AI\u00A6MS\u00A6MR\u00A6MQ\u00A6AF\u00A6AE\u00A6MO\u00A6AD\u00A6MN\u00A6MM\u00A6ML\u00A6MK\u00A6YU\u00A6YT\u00A6MG\u00A6MD\u00A6MC\u00A6MA\u00A6YE\u00A6LY\u00A6LV\u00A6LU\u00A6LT\u00A6LS\u00A6LR\u00A6LK\u00A6LI\u00A6LB\u00A6LA\u00A6KZ\u00A6KW\u00A6KR\u00A6KP\u00A6KM\u00A6KI\u00A6KH\u00A6KG\u00A6KE\u00A6JP\u00A6JO\u00A6JM\u00A6VU\u00A6VN\u00A6VI\u00A6VG\u00A6VE\u00A6VA\u00A6IT\u00A6IS\u00A6IR\u00A6IQ\u00A6UZ\u00A6UY\u00A6IN\u00A6IL\u00A6US\u00A6IE\u00A6ID\u00A6UG\u00A6UA\u00A6HU\u00A6HT\u00A6HR\u00A6TZ\u00A6HN\u00A6TW\u00A6HK\u00A6TT\u00A6TR\u00A6TO\u00A6TN\u00A6TM";

  private static final String territoriesValues = "\u0e95\u0eb4\u0ea1\u0ecd\u0e95\u0eb2\u0ec0\u0ea7\u0eb1\u0e99\u0ead\u0ead\u0e81\u00A6\u0ec2\u0e97\u0e81\u0eb4\u0ec2\u0ea5\u00A6\u0e97\u0eb2\u0e88\u0eb4\u0e81\u0eb4\u0eaa\u0eb0\u0e96\u0eb2\u0e99\u00A6\u0e9b\u0eb0\u0ec0\u0e97\u0e94\u0ec4\u0e97\u00A6\u0ec2\u0e95\u0ec2\u0e81\u00A6\u0ead\u0eb2\u0e99\u0eb2\u0ec0\u0e82\u0e94\u0e97\u0eb2\u0e87\u0ec3\u0e95\u0ec9\u0e82\u0ead\u0e87\u0e9d\u0ea5\u0eb1\u0ec8\u0e87\u0ec0\u0eaa\u0e94\u00A6\u0e81\u0eb9\u0ea2\u0eb2\u0e99\u0eb2\u00A6\u0e8a\u0eb2\u0e94\u00A6\u0e81\u0eb4\u0ea7\u0e99\u0eb5-\u0e9a\u0eb4\u0eaa\u0ec2\u0e8a\u00A6\u0e81\u0ebb\u0ea7\u0ec0\u0e95\u0ea1\u0eb2\u0ea5\u0eb2\u00A6\u0e81\u0eb4\u0ebc\u0e81\u00A6\u0ec0\u0ead\u0e84\u0ebb\u0ea7\u0ec2\u0e97\u0ec0\u0ea5\u0e8d\u0ea5\u0eb0\u0e81\u0eb4\u0e99\u0eb5\u00A6\u0e81\u0ebb\u0ea7\u0ec0\u0e94\u0eb5\u0ea5\u0eb9\u0e9a\u00A6\u0eaa\u0eb0\u0ea7\u0eb2\u0e8a\u0eb4\u0ec1\u0ea5\u0e99\u00A6\u0e8a\u0eb4\u0ec0\u0ea5\u0e8d\u00A6\u0e81\u0eb4\u0ea7\u0e99\u0eb5\u00A6\u0ec1\u0e81\u0ea1\u0ec0\u0e9a\u0e8d\u00A6\u0ec0\u0ead\u0e8a\u0eb2\u0ea7\u0eb2\u0e94\u0ecd\u00A6\u0e81\u0eb2\u0e99\u0ec8\u0eb2\u00A6\u0e8a\u0eb9\u0ea5\u0eb4\u0e99\u0eb2\u0ea1\u0eb4\u00A6\u0ec0\u0e9f\u0eb1\u0e99\u0eaa\u0e81\u0eb4\u0ea7\u0e99\u0eb2\u00A6\u0e88\u0ecd\u0ec0\u0e88\u0e8d\u00A6\u0ec2\u0e8a\u0ea1\u0eb2\u0ec0\u0ea5\u0e8d\u00A6\u0e8a\u0eb4\u0e99\u0eb5\u0e81\u0eb1\u0e99\u00A6\u0eaa\u0eb0\u0eab\u0eb0\u0ea5\u0eb2\u0e94\u0e8a\u0eb0\u0ead\u0eb2\u0e99\u0eb2\u0e88\u0eb1\u0e81\u00A6\u0ec0\u0e8a\u0e8d\u0ea5\u0eb2\u0eaa\u0eb4\u0ead\u0ead\u0e99\u00A6\u0e81\u0eb2\u0e9a\u0ead\u0e99\u00A6\u0eaa\u0eb0\u0ec2\u0ea5\u0ea7\u0eb2\u0ec0\u0e81\u0e8d\u00A6\u0eaa\u0eb0\u0ec2\u0ea5\u0ec0\u0ea7\u0ec0\u0e99\u0e8d\u00A6\u0eaa\u0eb4\u0e87\u0e81\u0eb0\u0ec2\u0e9b\u00A6\u0eaa\u0eb0\u0ea7\u0eb4\u0ec0\u0e94\u0eb1\u0e99\u00A6\u0e8a\u0eb9\u0e94\u0eb2\u0e99\u00A6\u0ec0\u0e8a\u0ec1\u0e8a\u0ea7\u00A6\u0e8a\u0eb2\u0ead\u0eb8\u0e94\u0eb4\u0ead\u0eb2\u0ea5\u0eb0\u0ec0\u0e9a\u0e8d\u00A6\u0e9d\u0ea5\u0eb1\u0ec8\u0e87\u00A6\u0ec4\u0ea1\u0ec2\u0e84\u0e99\u0eb4\u0ec0\u0e8a\u0e8d\u00A6\u0ea5\u0eb2\u0ea7\u0eb1\u0e99\u0e94\u0eb2\u00A6\u0ea5\u0eb1\u0e94\u0ec0\u0e8a\u0e8d\u00A6\u0e9f\u0eb4\u0e88\u0eb4\u00A6\u0e9f\u0eb4\u0e99\u0ec1\u0ea5\u0e99\u00A6\u0ea5\u0eb9\u0ec0\u0ea1\u0ec0\u0e99\u0e8d\u00A6\u0ec0\u0ead\u0e97\u0eb4\u0ec2\u0ead\u0ec0\u0e9b\u0e8d\u00A6\u0eaa\u0eb0\u0ec0\u0e9b\u0e99\u00A6\u0ead\u0eb4\u0e99\u0e8a\u0eb5\u00A6\u0e8a\u0eb2\u0eae\u0eb2\u0ea5\u0eb2\u0e95\u0eb0\u0ec0\u0ea7\u0eb1\u0e99\u0e95\u0ebb\u0e81\u00A6\u0ead\u0eb5\u0ea2\u0eb4\u0e9a\u00A6\u0ec0\u0ead\u0eaa\u0ec2\u0e95\u0ec0\u0e99\u0e8d\u00A6\u0ec0\u0ead\u0e81\u0ea7\u0eb2\u0e94\u0ecd\u00A6\u0ec1\u0ead\u0ea5\u0e88\u0eb4\u0ec0\u0ea5\u0e8d\u00A6\u0e81\u0eb2\u0e95\u0eb2\u00A6\u0eaa\u0eb2\u0e97\u0eb2\u0ea5\u0eb0\u0e99\u0eb0\u0ea5\u0eb1\u0e94\u0ec2\u0e94\u0ea1\u0eb4\u0e99\u0eb4\u0e81\u0eb1\u0e99\u00A6\u0e9b\u0eb2\u0ea5\u0eb2\u0e81\u0ea7\u0e8d\u00A6\u0ec2\u0e94\u0ec0\u0ea1\u0e99\u0eb4\u0e81\u0eb2\u00A6\u0ec0\u0e94\u0e99\u0ea1\u0eb2\u0e81\u00A6\u0e84\u0eb4\u0ec2\u0e9a\u0e95\u0eb4\u00A6\u0ec2\u0e9b\u0e95\u0eb8\u0e81\u0e81\u0eb1\u0e99\u00A6\u0ec0\u0e9b\u0eb5\u0ec2\u0e95\u0ea5\u0eb4\u0ec2\u0e81\u00A6\u0ec0\u0ea2\u0e8d\u0ea5\u0eb0\u0ea1\u0eb1\u0e99\u00A6\u0ec2\u0e9b\u0ec1\u0ea5\u0e99\u00A6\u0e9b\u0eb2\u0e81\u0eb4\u0eaa\u0e96\u0eb2\u0e99\u00A6\u0e9f\u0eb4\u0ea5\u0eb4\u0e9b\u0eb4\u0e99\u00A6\u0e9b\u0eb2\u0e9b\u0ebb\u0ea7\u0e99\u0eb4\u0ea7\u0e81\u0eb5\u0e99\u0eb5\u00A6\u0ec0\u0e9f\u0eb1\u0e99\u0ea3\u0ec2\u0e9e\u0ea5\u0eb4\u0e99\u0eb5\u0ec0\u0e8a\u0e8d\u00A6\u0eaa\u0eb2\u0e97\u0eb2\u0ea5\u0eb0\u0e99\u0eb0\u0ea5\u0eb1\u0e94\u0ec0\u0e8a\u0eb1\u0e81\u00A6\u0ec0\u0e9b\u0ea5\u0eb9\u00A6\u0ec4\u0e8a\u0e9b\u0eb1\u0ebc\u0e94\u00A6\u0ec0\u0e84\u0e9a\u0ea7\u0ead\u0e94\u00A6\u0e9b\u0eb2\u0e99\u0eb2\u0ea1\u0eb2\u00A6\u0e84\u0eb4\u0ea7\u0e9a\u0eb2\u00A6\u0e84\u0ead\u0eaa\u0e95\u0eb2\u0ea5\u0eb4\u0e81\u0eb2\u00A6\u0ec2\u0e84\u0ea5\u0eb3\u0ec0\u0e9a\u0e8d\u00A6\u0e88\u0eb5\u0e99\u00A6\u0e84\u0eb2\u0ec0\u0ea1\u0ea5\u0eb9\u0e99\u00A6\u0e8a\u0eb4\u0eaa\u0eb4\u00A6\u0e9d\u0eb1\u0ec8\u0e87\u0e97\u0eb0\u0ec0\u0ea5\u0ec4\u0ead\u0ea7\u0ecd\u0ea5\u0eb4\u00A6\u0eaa\u0eb0\u0ea7\u0eb4\u0e94\u0ec0\u0e8a\u0eb5\u0ec1\u0ea5\u0e99\u00A6\u0e84\u0ead\u0e87\u0ec2\u0e81\u00A6\u0eaa\u0eb2\u0e97\u0eb2\u0ea5\u0eb0\u0e99\u0eb0\u0ea5\u0eb1\u0e94\u0ead\u0eb1\u0e9a\u0e9f\u0ebc\u0eb4\u0e81\u0e81\u0eb2\u0e81\u0eb2\u0e87\u00A6\u0ec2\u0ead\u0ea1\u0eb2\u0e99\u00A6\u0e81\u0eb2\u0e99\u0eb2\u0e94\u0eb2\u00A6\u0ec0\u0e9a\u0ea5\u0eb4\u0e8a\u00A6\u0ec0\u0e9a\u0e99\u0ea5\u0eb2\u0eae\u0eb1\u0eaa\u00A6\u0e9a\u0ead\u0eb1\u0e94\u0eaa\u0eb0\u0ea7\u0eb2\u0e99\u0eb2\u00A6\u0e9e\u0eb9\u0e96\u0eb2\u0e99\u00A6\u0e9a\u0eb2\u0eae\u0eb2\u0ea1\u0eb2\u0eaa\u00A6\u0e9a\u0ebc\u0eb2\u0e8a\u0eb4\u0ea7\u00A6\u0e99\u0eb4\u0ea7\u0e8a\u0eb5\u0ec1\u0ea5\u0e99\u00A6\u0ec2\u0e9a\u0ea5\u0eb4\u0ec0\u0ea7\u0e8d\u00A6\u0e9a\u0eb9\u0eae\u0ec4\u0e99\u00A6\u0ec0\u0e9a\u0eb5\u0ea1\u0eb4\u0ea7\u0e94\u0eb2\u00A6\u0e99\u0eb5\u0ea2\u0eb9\u00A6\u0ec0\u0e9a\u0e99\u0eb4\u0e99\u00A6\u0e9a\u0eb9\u0ea5\u0eb1\u0e99\u0e95\u0eb4\u00A6\u0e9a\u0eb2\u0ec0\u0ea5\u0e99\u00A6\u0e9a\u0eb1\u0e87\u0e81\u0eb2\u0ec0\u0ea5\u0e8d\u00A6\u0ec0\u0e9a\u0eb5\u0e81\u0eb4\u0e99\u0eb2\u0e9f\u0eb2\u0ec2\u0e8a\u00A6\u0ec0\u0e99\u0e9b\u0eb2\u0e99\u00A6\u0ec0\u0e9a\u0ea7\u0ea2\u0ebd\u0ea1\u00A6\u0e99\u0ecd\u0ec0\u0ea7\u00A6\u0e9a\u0eb1\u0e87\u0e81\u0eb0\u0ea5\u0eb2\u0ec0\u0e97\u0e94\u00A6\u0e9a\u0eb2\u0e9a\u0eb2\u0e84\u0eb1\u0ead\u0e94\u00A6\u0e8a\u0eb4\u0ea1\u0e9a\u0eb1\u0e9a\u0ec0\u0ea7\u00A6\u0ec0\u0e99\u0ec0\u0e97\u0eb5\u0ec1\u0ea5\u0e99\u00A6\u0e9a\u0eb1\u0ead\u0e94\u0eaa\u0ec0\u0e99\u0e8d \u0ec1\u0ea5\u0eb0 \u0ec0\u0eae\u0eb5\u0e94\u0ec2\u0e81\u0ea7\u0eb4\u0ec0\u0e99\u0e8d\u00A6\u0e99\u0eb4\u0e84\u0eb2\u0ea5\u0eb2\u0e81\u0ebb\u0ea7\u00A6\u0ec4\u0e99\u0e88\u0eb5\u0ec0\u0ea5\u0e8d\u00A6\u0ead\u0eb2\u0ec0\u0e8a\u0eb5\u0ec4\u0e9a\u0e88\u0eb1\u0e99\u00A6\u0ec4\u0e99\u0ec0\u0e88\u0eb5\u00A6\u0e99\u0eb4\u0ea7\u0e84\u0eb2\u0ea5\u0eb4\u0ec2\u0e84\u0ec0\u0e99\u0e8d\u00A6\u0ead\u0eb2\u0ea5\u0eb9\u0e9a\u0eb2\u00A6\u0ec1\u0e8a\u0ea1\u0ec0\u0e9a\u0e8d\u00A6\u0ead\u0ebb\u0ead\u0e94\u0eaa\u0eb0\u0e95\u0eb2\u0ea5\u0eb5\u00A6\u0e99\u0eb2\u0ea1\u0eb4\u0ec0\u0e9a\u0e8d\u00A6\u0ead\u0ebb\u0ead\u0e94\u0eaa\u0eb0\u0ec0\u0e95\u0ebc\u0e8d\u00A6\u0ead\u0eb2\u0ec0\u0e88\u0e99\u0e95\u0eb4\u0e99\u0eb2\u0ec8\u00A6\u0ec2\u0ea1\u0ec1\u0e8a\u0ea1\u0e9a\u0eb4\u0e81\u00A6\u0ead\u0eb1\u0e99\u0ec2\u0e81\u0ea5\u0eb2\u00A6\u0ea1\u0eb2\u0ec0\u0ea5\u0ec0\u0e8a\u0e8d\u00A6\u0ec0\u0e99\u0ec0\u0e97\u0eb5\u0ec1\u0ea5\u0e99\u0ec1\u0ead\u0e99\u0ec0\u0e97\u0eb4\u0e99\u00A6\u0ec1\u0ea1\u0eb1\u0e81\u0e8a\u0eb4\u0ec2\u0e81\u00A6\u0ead\u0eb2\u0ea1\u0eb4\u0ec0\u0e99\u0e8d\u00A6\u0ec1\u0ead\u0ea5\u0ec0\u0e9a\u0ec0\u0e99\u0e8d\u00A6\u0ead\u0eb2\u0e9f\u0eb0\u0ea5\u0eb4\u0e81\u0eb2\u0ec3\u0e95\u0ec9\u00A6\u0ea1\u0ecd\u0ea3\u0eb4\u0e95\u0ebd\u0e94\u00A6\u0ea1\u0eb1\u0e99\u0e95\u0eb2\u00A6\u0ead\u0eb1\u0e99\u0e81\u0eb4\u0ea5\u0eb2\u00A6\u0ea1\u0ead\u0e99\u0ec0\u0e8a\u0eb5\u0ea5\u0eb2\u0e94\u00A6\u0ea1\u0ecd\u0ea5\u0eb4\u0e81\u0e97\u0eb2\u0ec0\u0e99\u0e8d\u00A6\u0ea1\u0eb2\u0e95\u0eb4\u0e99\u0eb4\u0e81\u00A6\u0ead\u0eb1\u0e9f\u0e81\u0eb2\u0e99\u0eb4\u0e94\u0eaa\u0eb0\u0e96\u0eb2\u0e99\u00A6\u0eaa\u0eb0\u0eab\u0eb0\u0ea5\u0eb1\u0e94\u0ead\u0eb2\u0eab\u0ea5\u0eb1\u0e9a\u0ec0\u0ead\u0ea1\u0eb4\u0ec0\u0ea5\u0e94\u00A6\u0ea1\u0eb2\u0ec0\u0e81\u0ebb\u0ec9\u0eb2\u00A6\u0ead\u0eb1\u0e99\u0e94\u0ecd\u0ea5\u0eb2\u00A6\u0ea1\u0ebb\u0e87\u0ec2\u0e81\u0ea5\u0eb5\u00A6\u0eaa\u0eb0\u0eab\u0eb0\u0e9e\u0eb2\u0e9a\u0e9e\u0eb0\u0ea1\u0ec9\u0eb2\u00A6\u0ea1\u0eb2\u0ea5\u0eb4\u00A6\u0ec1\u0ea1\u0e8a\u0eb4\u0ec2\u0e84\u0ec0\u0e99\u0e8d\u00A6\u0ea2\u0eb9\u0ec2\u0e81\u0eaa\u0eb0\u0ea5\u0eb2\u0ec0\u0ea7\u0e8d\u00A6\u0ea1\u0eb2\u0ea2\u0ead\u0e94\u00A6\u0ea1\u0eb2\u0e84\u0eb2\u0e81\u0eb1\u0eaa\u0e81\u0eb2\u00A6\u0ec2\u0ea1\u0e99\u0ec2\u0e84\u0ea7\u0eb2\u00A6\u0ec2\u0ea1\u0e99\u0eb2\u0ec2\u0e81\u00A6\u0ec2\u0ea1\u0ea5\u0eb1\u0ead\u0e81\u0ec2\u0e84\u00A6\u0ec0\u0ea2\u0ec0\u0ea1\u0e99\u00A6\u0ea5\u0eb4\u0ec0\u0e9a\u0e8d\u00A6\u0ea5\u0ebc\u0eb2\u0e94\u0ec0\u0ea7\u0e8d\u00A6\u0ea5\u0eb8\u0e81\u0ec1\u0e8a\u0ea1\u0ec0\u0e9a\u0eb5\u0e81\u00A6\u0ea5\u0eb4\u0ec0\u0e97\u0eb5\u0ec0\u0e99\u0e8d\u00A6\u0ec0\u0ea5\u0ec2\u0e8a\u0ec2\u0e97\u00A6\u0ea5\u0eb4\u0ec0\u0e9a\u0eb5\u0ec0\u0ea5\u0e8d\u00A6\u0eaa\u0eb5\u0ea5\u0eb1\u0e87\u0e81\u0eb2\u00A6\u0ec4\u0ea5\u0ec0\u0e97\u0e99\u0eaa\u0eb0\u0ec4\u0e95\u00A6\u0ec0\u0ea5\u0e9a\u0eb2\u0e99\u0ead\u0e99\u00A6\u0ea5\u0eb2\u0ea7\u00A6\u0e84\u0eb2\u0e8a\u0eb1\u0e94\u0eaa\u0eb0\u0e96\u0eb2\u0e99\u00A6\u0e84\u0eb9\u0ec0\u0ea7\u0e94\u00A6\u0ec0\u0e81\u0ebb\u0eb2\u0eab\u0ea5\u0eb5\u0ec3\u0e95\u0ec9\u00A6\u0ec0\u0e81\u0ebb\u0eb2\u0eab\u0ea5\u0eb5\u0ec0\u0edc\u0eb7\u0ead\u00A6\u0ec2\u0e84\u0ec2\u0ea1\u0ea3\u0ead\u0e94\u00A6\u0e84\u0eb5\u0ea5\u0eb4\u0e9a\u0eb2\u0e94\u00A6\u0e81\u0eb3\u0e9b\u0eb9\u0ec0\u0e88\u0e8d\u00A6\u0ec0\u0e94\u0eb5\u0e81\u0eb4\u0e94\u0eaa\u0eb0\u0e96\u0eb2\u0e99\u00A6\u0ec0\u0e84\u0e99\u0ea2\u0ec8\u0eb2\u00A6\u0e8d\u0eb5\u0ec8\u0e9b\u0ec8\u0eb8\u0e99\u00A6\u0e88\u0ecd\u0ec1\u0e94\u0e99\u00A6\u0e88\u0eb2\u0ec4\u0ea1\u0e81\u0eb2\u00A6\u0ea7\u0eb2\u0e99\u0ebb\u0ea7\u0e95\u0eb9\u00A6\u0eab\u0ea7\u0ebd\u0e94\u0e99\u0eb2\u0ea1\u00A6\u0ea2\u0eb9\u0ec0\u0ead\u0eaa\u0ec0\u0ea7\u0eb5\u0e88\u0eb4\u0e99\u0ec4\u0ead\u0ec1\u0ea5\u0e99\u00A6\u0e9a\u0ea3\u0eb4\u0e97\u0eb4\u0e94\u0ec0\u0ea7\u0eb5\u0e88\u0eb4\u0e99\u0ec4\u0ead\u0ec1\u0ea5\u0e99\u00A6\u0ec0\u0ea7\u0ec0\u0e99\u0e8a\u0eb9\u0ec0\u0ead\u0ea5\u0eb2\u00A6\u0ea7\u0eb2\u0e95\u0eb4\u0e81\u0eb1\u0e99\u00A6\u0ead\u0eb4\u0e95\u0eb2\u0ea5\u0eb5\u00A6\u0ec4\u0ead\u0eaa\u0ec1\u0ea5\u0e99\u00A6\u0ead\u0eb5\u0ea5\u0ec8\u0eb2\u0e99\u00A6\u0ead\u0eb5\u0ea5\u0eb1\u0e81\u00A6\u0ead\u0eb8\u0e94\u0ec0\u0e9a\u0e81\u0eb4\u0eaa\u0eb0\u0e96\u0eb2\u0e99\u00A6\u0ea5\u0eb9\u0e81\u0ea7\u0e8d\u0ead\u0eb8\u0ea3\u00A6\u0ead\u0eb4\u0e99\u0ec0\u0e94\u0e8d\u00A6\u0ead\u0eb4\u0eaa\u0ea5\u0eb0\u0ec0\u0ead\u0ea7\u00A6\u0eaa\u0eb0\u0eab\u0eb0\u0ea5\u0eb1\u0e94\u0ead\u0eb2\u0ec0\u0ea1\u0ea5\u0eb4\u0e81\u0eb2\u00A6\u0ec4\u0ead\u0ec1\u0ea5\u0e99\u00A6\u0ead\u0eb4\u0e99\u0ec2\u0e94\u0ec0\u0e99\u0ec0\u0e8a\u0e8d\u00A6\u0ead\u0eb9\u0e81\u0eb2\u0e99\u0e94\u0eb2\u00A6\u0ea2\u0eb9\u0ec0\u0e84\u0ebc\u0e99\u00A6\u0eae\u0ebb\u0e87\u0e81\u0eb2\u0ea3\u0eb5\u00A6\u0ec4\u0ead\u0e97\u0eb5\u00A6\u0ec2\u0e84\u0ec0\u0ead\u0ec0\u0e8a\u0e8d\u00A6\u0e97\u0eb2\u0e99\u0e8a\u0eb2\u0ec0\u0e99\u0e8d\u00A6\u0ead\u0ea7\u0e99\u0e84\u0eb9\u0ea3\u0eb1\u0eaa\u00A6\u0ec4\u0e95\u0ec9\u0eab\u0ea7\u0eb1\u0e99\u00A6\u0eae\u0ec8\u0ead\u0e87\u0e81\u0ebb\u0e87\u00A6\u0e97\u0eb4\u0e99\u0eb4\u0ec1\u0e94\u0e94\u00A6\u0e95\u0eb8\u0e99\u0e81\u0eb5\u00A6\u0e97\u0ead\u0e87\u0e81\u0ec9\u0eb2\u00A6\u0e95\u0eb9\u0e99\u0eb4\u0ec0\u0e8a\u0e8d\u00A6\u0ec0\u0e95\u0ea3\u0eb5\u0e81\u0ec0\u0ea1\u0e99\u0eb4\u0eaa\u0eb0\u0e96\u0eb2\u0e99";

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

  private static final String languagesKeys = "es\u00A6ku\u00A6eo\u00A6ks\u00A6en\u00A6el\u00A6qu\u00A6ko\u00A6kn\u00A6km\u00A6kl\u00A6kk\u00A6wo\u00A6ka\u00A6dz\u00A6jv\u00A6pt\u00A6ps\u00A6de\u00A6pl\u00A6da\u00A6vo\u00A6ja\u00A6vi\u00A6cy\u00A6pa\u00A6cs\u00A6iu\u00A6it\u00A6co\u00A6is\u00A6uz\u00A6or\u00A6ik\u00A6ur\u00A6om\u00A6ca\u00A6ie\u00A6id\u00A6uk\u00A6ia\u00A6oc\u00A6ug\u00A6hy\u00A6br\u00A6hu\u00A6bo\u00A6bn\u00A6hr\u00A6bi\u00A6tw\u00A6bh\u00A6bg\u00A6tt\u00A6no\u00A6be\u00A6ts\u00A6hi\u00A6tr\u00A6nl\u00A6zu\u00A6ba\u00A6to\u00A6he\u00A6tn\u00A6tl\u00A6tk\u00A6ha\u00A6ne\u00A6az\u00A6ti\u00A6ay\u00A6th\u00A6tg\u00A6na\u00A6te\u00A6zh\u00A6as\u00A6ar\u00A6ta\u00A6gu\u00A6my\u00A6am\u00A6za\u00A6mt\u00A6ms\u00A6gn\u00A6sw\u00A6mr\u00A6sv\u00A6gl\u00A6su\u00A6af\u00A6st\u00A6mo\u00A6ss\u00A6mn\u00A6sr\u00A6sq\u00A6ml\u00A6ab\u00A6mk\u00A6aa\u00A6so\u00A6sn\u00A6mi\u00A6gd\u00A6sm\u00A6sl\u00A6mg\u00A6sk\u00A6ga\u00A6yo\u00A6si\u00A6sh\u00A6sg\u00A6yi\u00A6sd\u00A6fy\u00A6sa\u00A6fr\u00A6lv\u00A6lt\u00A6fo\u00A6rw\u00A6ru\u00A6lo\u00A6fj\u00A6ln\u00A6fi\u00A6ro\u00A6rn\u00A6rm\u00A6fa\u00A6la\u00A6xh\u00A6eu\u00A6ky\u00A6et";

  private static final String languagesValues = "\u0eaa\u0eb0\u0ec0\u0e9b\u0e99\u00A6\u0ec0\u0e84\u0eb5\u0e94\u00A6\u0ec0\u0ead\u0eaa\u0ec0\u0e9b\u0eb5\u0ea5\u0eb1\u0e99\u0ec2\u0e95\u00A6\u0e84\u0eb1\u0e94\u0e8a\u0eb0\u0ea1\u0eb5\u0ea5\u0eb5\u00A6\u0ead\u0eb1\u0e87\u0e81\u0eb4\u0e94\u00A6\u0e81\u0eb5\u0e81\u00A6\u0e84\u0eb4\u0ea7\u0e8a\u0ebb\u0ea7\u00A6\u0ec0\u0e81\u0ebb\u0eb2\u0eab\u0ea5\u0eb5\u00A6\u0e81\u0eb2\u0e99\u0eb2\u0e94\u0eb2\u00A6\u0e82\u0eb0\u0ec0\u0edd\u0e99\u00A6\u0e81\u0ebc\u0eb5\u0e99\u0ec1\u0ea5\u0e99\u0e94\u0eb4\u0e94\u00A6\u0e84\u0eb2\u0e8a\u0eb1\u0e81\u00A6\u0ea7\u0eb9\u0e9a\u00A6\u0e88\u0ecd\u0ec0\u0e88\u0e8d\u00A6\u0e9e\u0eb9\u0e96\u0eb2\u0e99\u0eb5\u00A6\u0e8a\u0eb0\u0ea7\u0eb2\u00A6\u0ec2\u0e9b\u0e95\u0eb8\u0ec0\u0e81\u0e94\u00A6\u0e9e\u0eb2\u0eaa\u0ec2\u0e95(\u0e9e\u0eb8\u0e94\u0ec2\u0e95)\u00A6\u0ec0\u0ea2\u0e8d\u0ea5\u0eb0\u0ea1\u0eb1\u0e99\u00A6\u0ec2\u0e9b\u0ec1\u0ea5\u0e99\u00A6\u0ec0\u0e94\u0e99\u0edd\u0eb2\u0e81\u00A6\u0ec2\u0ea7\u0ea5\u0eb2\u0e9e\u0eb8\u0e81\u00A6\u0e8d\u0eb5\u0ec8\u0e9b\u0eb8\u0ec8\u0e99\u00A6\u0ea7\u0ebd\u0e94\u0e99\u0eb2\u0ea1\u00A6\u0ec0\u0ea7\u0ea7\u00A6\u0e9b\u0eb1\u0e99\u0e88\u0eb2\u00A6\u0ec0\u0e8a\u0eb1\u0e81\u00A6\u0ec4\u0ead\u0e99\u0eb8\u0e81\u0e95\u0eb4\u0e95\u0eb1\u0e81\u00A6\u0ead\u0eb4\u0e95\u0eb2\u0eaa\u0eb4\u00A6\u0e84\u0ecd\u0e8a\u0eb4\u0e81\u0ec9\u0eb2\u00A6\u0ec4\u0ead\u0ec1\u0ea5\u0e99\u0e94\u0eb4\u0e94\u00A6\u0ead\u0eb8\u0e94\u0eaa\u0eb0\u0ec0\u0e9a\u0e94\u00A6\u0ec2\u0ead\u0ea5\u0eb4\u0e8d\u0eb2\u00A6\u0ec4\u0ead\u0e99\u0eb9\u0e9b\u0ebd\u0e81\u00A6\u0ead\u0eb4\u0e99\u0e94\u0eb9\u00A6\u0ec2\u0ead\u0ec2\u0ea5\u0ec2\u0ea1(\u0ead\u0eb2\u0e9f\u0eb2\u0e99)\u00A6\u0ec1\u0e84\u0e95\u0eb2\u0ec1\u0ea5\u0e99\u00A6\u0ead\u0eb4\u0e99\u0ec0\u0e95\u0eb5\u0ea5\u0eb4\u0e87\u00A6\u0ead\u0eb4\u0e99\u0ec2\u0e94\u0ec0\u0e99\u0ec0\u0e8a\u0e8d\u00A6\u0ea2\u0eb9\u0ec0\u0e84\u0ebc\u0e99\u00A6\u0ead\u0eb4\u0e99\u0ec0\u0e95\u0eb5\u0ea5\u0eb4\u0e87\u0e81\u0ea7\u0eb2\u00A6\u0ead\u0ead\u0eb1\u0e81\u0e8a\u0eb4\u0e97\u0eb1\u0e99\u00A6\u0ead\u0eb8\u0e8d\u0e81\u0ebb\u0ea7\u00A6\u0ead\u0eb2\u0ea1\u0eb4\u0ec0\u0e99\u0e8d\u00A6\u0e9a\u0eb5\u0e97\u0eb1\u0e99\u00A6\u0eae\u0ebb\u0e87\u0e81\u0eb2\u0ea5\u0eb5\u00A6\u0e97\u0eb4\u0ec0\u0e9a\u0e94\u00A6\u0e9a\u0eb8\u0e99\u0e81\u0eb2\u0ea5\u0eb5\u00A6\u0ec2\u0e84\u0ec0\u0ead\u0ec0\u0e8a\u0e8d\u00A6\u0e9a\u0eb4\u0eaa\u0ea5\u0eb2\u0ea1\u0eb2\u00A6\u0e97\u0eb0\u0ea7\u0eb5\u00A6\u0e9a\u0eb4\u0eae\u0eb2\u0ea5\u0eb4\u00A6\u0e9a\u0eb1\u0e87\u0e81\u0eb2\u0ec0\u0ea5\u0e8d\u00A6\u0e95\u0eb2\u0e94\u00A6\u0e99\u0ecd\u0ec0\u0ea7\u0ea7\u00A6\u0e9a\u0eb2\u0e8d\u0ec2\u0ea5\u0ea5\u0eb1\u0e94\u0ec0\u0e8a\u0e8d\u00A6\u0e8a\u0ead\u0e87\u0e81\u0eb2\u00A6\u0eae\u0eb4\u0e99\u0e94\u0eb4\u00A6\u0e95\u0eb8\u0ea5\u0eb2\u0e81\u0eb5\u00A6\u0ead\u0ecd\u0ea5\u0eb1\u0e99\u0e94\u0eb2\u00A6\u0e8a\u0eb9\u0ea5\u0eb9\u00A6\u0e9a\u0eb2\u0eaa\u0eaa\u0eb5\u00A6\u0e97\u0ead\u0e87\u0e81\u0ec9\u0eb2\u00A6\u0ea2\u0eb4\u0ea7\u00A6\u0ec0\u0e8a\u0e95\u0eb0\u0eaa\u0eb0\u0ea7\u0eb2\u0e99\u0eb2\u00A6\u0e95\u0eb2\u0e81\u0eb2\u0ea5\u0eb1\u0ead\u0e81\u00A6\u0ec0\u0e95\u0eb5\u0e81\u0ec0\u0ea1\u0e99\u00A6\u0ec2\u0ead\u0e8a\u0eb2\u00A6\u0ec0\u0e99\u0e9b\u0eb2\u0e99\u00A6\u0ead\u0eb2\u0ec0\u0e8a\u0eb5\u0ec4\u0e9a\u0e88\u0eb2\u0e99\u0eb5\u00A6\u0e97\u0eb4\u0e81\u0eb4\u0e99\u0ea2\u0eb2\u00A6\u0ec4\u0ead\u0ea1\u0eb2\u0ea5\u0eb2\u00A6\u0ec4\u0e97\u00A6\u0e97\u0eb2\u0e88\u0eb4\u0e94\u00A6\u0e99\u0ecd\u0ea5\u0eb9\u00A6\u0e97\u0eb4\u0ea5\u0eb9\u0e81\u0eb9\u00A6\u0e88\u0eb5\u0e99\u00A6\u0ead\u0eb1\u0e94\u0eaa\u0eb3\u0ea1\u0eb4\u0e94\u00A6\u0ead\u0eb2\u0ea5\u0eb2\u0ec0\u0e9a\u0e8d\u00A6\u0e97\u0eb0\u0ea1\u0eb4\u0e9a\u00A6\u0e81\u0eb9\u0e88\u0eb2\u0ea5\u0eb2\u0e95\u0eb5\u00A6\u0e9e\u0eb0\u0ea1\u0ec8\u0eb2\u00A6\u0ead\u0eb3\u0eae\u0eb2\u0ea5\u0eb4\u0e94\u00A6\u0e88\u0ea7\u0e87\u00A6\u0ea1\u0ead\u0e99\u0e95\u0eb2\u00A6\u0ea1\u0eb2\u0ea5\u0eb2\u0ea2\u0eb9\u00A6\u0e81\u0ebb\u0ea7\u0ea5\u0eb2\u0e99\u0eb5\u00A6\u0e8a\u0eb0\u0ea7\u0eb2\u0eae\u0eb4\u0ea5\u0eb5\u00A6\u0ea1\u0eb2\u0ea5\u0eb2\u0e97\u0eb4\u00A6\u0eaa\u0eb0\u0ea7\u0eb5\u0ec0\u0e94\u0e99\u00A6\u0e81\u0eb0\u0eaa\u0eb4\u0ec0\u0e8a\u0e8d\u00A6\u0e8a\u0eb1\u0e99\u0e94\u0eb2\u0e99\u0eb4\u0eaa\u00A6\u0ead\u0eb2\u0e9f\u0eb4\u0ebc\u0e81\u0e81\u0eb2\u00A6\u0ec0\u0e8a\u0ec2\u0eaa\u0ec2\u0e97\u00A6\u0ec2\u0ea1\u0e84\u0eb2\u0ec0\u0ea7\u0e8d\u00A6\u0e8a\u0eb4\u0eaa\u0ea7\u0eb2\u0e95\u0eb4\u00A6\u0ea1\u0ead\u0e87\u0ec2\u0e81\u0ebc\u00A6\u0ec0\u0e8a\u0eb5\u0ec0\u0e9a\u0e8d\u00A6\u0ec1\u0ead\u0ea5\u0ec0\u0e9a\u0ec0\u0e99\u0e8d\u00A6\u0ec1\u0ea1\u0ea5\u0eb0\u0ea2\u0eb2\u0ea5\u0eb3\u00A6\u0ec1\u0ead\u0e9a\u0e84\u0eb2\u0ec0\u0e8a\u0e8d\u00A6\u0ec1\u0ea1\u0eb1\u0e81\u0e8a\u0eb4\u0ec2\u0e94\u0ec0\u0e99\u0e8d\u00A6\u0ead\u0eb2\u0e9f\u0eb2\u00A6\u0ec2\u0e8a\u0ea1\u0eb2\u0eaa\u0eb4\u00A6\u0ec2\u0e8a\u0e99\u0eb2\u00A6\u0ec0\u0ea1\u0ebb\u0eb2\u0ea5\u0eb5\u00A6\u0eaa\u0eb0\u0e81\u0eb1\u0ead\u0e94\u0ec0\u0e84\u0eb5\u0e94\u00A6\u0e8a\u0eb2\u0ea1\u0ebb\u0ea7\u00A6\u0eaa\u0eb0\u0ec2\u0ea5\u0ea7\u0eb2\u0ec0\u0e99\u0e8d\u00A6\u0ea1\u0eb2\u0ea5\u0eb2\u0e81\u0eb2\u0e8a\u0eb4\u00A6\u0eaa\u0eb0\u0ec2\u0ea5\u0ea7\u0eb1\u0e81\u00A6\u0ec4\u0ead\u0ea5\u0eb4\u0e94\u00A6\u0ec2\u0ea2\u0ea5\u0eb9\u0e9a\u0eb2\u00A6\u0eaa\u0eb4\u0e87\u0eab\u0ea5\u0ecd\u00A6\u0ec0\u0e8a\u0eb5\u0ec2\u0e9a-\u0ec2\u0e84\u0ec0\u0ead\u0e97\u0ebd\u0e99\u00A6\u0eaa\u0eb1\u0e99\u0ec2\u0e84\u00A6\u0ea2\u0eb5\u0e84\u0eb4\u0e94\u00A6\u0e8a\u0eb4\u0e99\u0e94\u0eb4\u00A6\u0e9f\u0eb4\u0e99\u0ec1\u0ea5\u0e99\u00A6\u0eaa\u0eb1\u0e99\u0eaa\u0eb0\u0e81\u0eb4\u0e94\u00A6\u0e9d\u0eb1\u0ec8\u0ea5\u0e87\u0ec0\u0eaa\u0e94\u00A6\u0ec1\u0ea5\u0e95\u0eb0\u0ec0\u0ea7\u0e8d(\u0ec0\u0ea5\u0e94\u0e97\u0eb0\u0ea7\u0eb4\u0e94)\u00A6\u0ea5\u0eb4\u0e97\u0ebb\u0ea7\u0ec0\u0e99\u0e8d\u00A6\u0e9f\u0eb2\u0ec2\u0ea5\u0e94\u00A6\u0e84\u0eb4\u0e99\u0e8d\u0eb2\u0ea7\u0eb1\u0e99\u0e94\u0eb2\u00A6\u0ea5\u0eb1\u0e94\u0ec0\u0e8a\u0e8d\u00A6\u0ea5\u0eb2\u0ea7\u00A6\u0e9f\u0eb4\u0e88\u0eb4\u00A6\u0ea5\u0eb4\u0e87\u0e81\u0eb2\u0ea5\u0eb2\u00A6\u0e9f\u0eb4\u0e99\u00A6\u0ec2\u0ea5\u0ea1\u0eb1\u0e99\u00A6\u0e84\u0eb4\u0ea5\u0eb1\u0e99\u0eaa\u0eb5\u00A6\u0ec0\u0ea5\u0ec2\u0e95-\u0ec2\u0ea5\u0ec1\u0ea1\u0e99\u00A6\u0ec0\u0e9b\u0eb5\u0ec0\u0e8a\u0e8d\u00A6\u0ea5\u0eb2\u0e95\u0eb4\u0e99\u00A6\u0ec2\u0e8a\u0eaa\u0eb2\u00A6\u0ec1\u0e9a\u0eaa\u00A6\u0ec0\u0e84\u0ea7\u0e81\u0eb4\u0e94\u00A6\u0ec0\u0ead\u0eaa\u0ec2\u0e95\u0ec0\u0e99\u0e8d";

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
    { "localPatternChars", "GanjkHmsSEDFwWxhKzAeugXZ" },
    { "currenciesDisplayName", currenciesDisplayName },
    { "currenciesSymbol", currenciesSymbol },
    { "shortMonths", shortMonths },
    { "months", months },
    { "shortWeekdays", shortWeekdays },
    { "weekdays", weekdays },
    { "ampms", ampms },
    { "shortDateFormat", "d/M/yyyy" },
    { "mediumDateFormat", "d MMM yyyy" },
    { "longDateFormat", "d MMMM yyyy" },
    { "fullDateFormat", "EEEE'\u0e97\u0eb5  'd MMMM G yyyy" },
    { "shortTimeFormat", "H:mm" },
    { "mediumTimeFormat", "H:mm:ss" },
    { "longTimeFormat", "H' \u0ec2\u0ea1\u0e87 'm'\u0e99\u0eb2\u0e97\u0eb5'" },
    { "fullTimeFormat", "H'\u0ec2\u0ea1\u0e87 'm'\u0e99\u0eb2\u0e97\u0eb5 'ss' \u0ea7\u0eb4\u0e99\u0eb2\u0e97\u0eb5" },
    { "territories", territories },
    { "languages", languages },
  };

  public Object[][] getContents() { return contents; }
}
