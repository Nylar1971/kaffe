/* LocaleInformation_sq.java --
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

public class LocaleInformation_sq extends ListResourceBundle
{
  private static final String currenciesDisplayNameKeys = "ALL";

  private static final String currenciesDisplayNameValues = "ALL";

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

  private static final String currenciesSymbolKeys = "ALL";

  private static final String currenciesSymbolValues = "Lek";

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
    "Jan",
    "Shk",
    "Mar",
    "Pri",
    "Maj",
    "Qer",
    "Kor",
    "Gsh",
    "Sht",
    "Tet",
    "N\u00ebn",
    "Dhj",
    null,
  };

  private static final String[] months = {
    "janar",
    "shkurt",
    "mars",
    "prill",
    "maj",
    "qershor",
    "korrik",
    "gusht",
    "shtator",
    "tetor",
    "n\u00ebntor",
    "dhjetor",
    null,
  };

  private static final String[] shortWeekdays = {
    null,
    "Die",
    "H\u00ebn",
    "Mar",
    "M\u00ebr",
    "Enj",
    "Pre",
    "Sht",
  };

  private static final String[] weekdays = {
    null,
    "e diel",
    "e h\u00ebn\u00eb",
    "e mart\u00eb",
    "e m\u00ebrkur\u00eb",
    "e enjte",
    "e premte",
    "e shtun\u00eb",
  };

  private static final String[] eras = {
    "p.e.r.",
    "n.e.r.",
  };

  private static final String[] ampms = {
    "PD",
    "MD",
  };

  private static final String territoriesKeys = "TJ\u00A6TH\u00A6TG\u00A6GY\u00A6TD\u00A6GW\u00A6GT\u00A6GR\u00A6GQ\u00A6SZ\u00A6SY\u00A6GN\u00A6GM\u00A6ST\u00A6GH\u00A6GE\u00A6SO\u00A6SL\u00A6GA\u00A6SK\u00A6SI\u00A6SG\u00A6SE\u00A6SC\u00A6SB\u00A6SA\u00A6FR\u00A6FM\u00A6RW\u00A6RU\u00A6FJ\u00A6FI\u00A6RO\u00A6ET\u00A6ES\u00A6ER\u00A6EH\u00A6EG\u00A6EE\u00A6EC\u00A6DZ\u00A6QA\u00A6DO\u00A6PY\u00A6DM\u00A6DK\u00A6DJ\u00A6PT\u00A6DE\u00A6PL\u00A6PH\u00A6PG\u00A6CZ\u00A6CY\u00A6CV\u00A6CU\u00A6CR\u00A6CO\u00A6CN\u00A6CM\u00A6CL\u00A6CI\u00A6CH\u00A6CG\u00A6CF\u00A6CA\u00A6BY\u00A6BW\u00A6BT\u00A6NZ\u00A6BO\u00A6BN\u00A6BH\u00A6BG\u00A6BE\u00A6NO\u00A6ZW\u00A6NL\u00A6BA\u00A6NI\u00A6NG\u00A6AZ\u00A6ZM\u00A6AU\u00A6NA\u00A6AT\u00A6AR\u00A6MZ\u00A6AO\u00A6MY\u00A6MX\u00A6AM\u00A6MW\u00A6AL\u00A6MV\u00A6ZA\u00A6MT\u00A6MR\u00A6AG\u00A6AF\u00A6AE\u00A6AD\u00A6MN\u00A6MK\u00A6YU\u00A6MH\u00A6MG\u00A6MD\u00A6MC\u00A6MA\u00A6YE\u00A6LY\u00A6LV\u00A6LU\u00A6LT\u00A6LS\u00A6LR\u00A6LI\u00A6LB\u00A6KZ\u00A6KW\u00A6KR\u00A6KP\u00A6KN\u00A6KM\u00A6KI\u00A6KH\u00A6KG\u00A6KE\u00A6JP\u00A6JO\u00A6JM\u00A6VE\u00A6VC\u00A6VA\u00A6IT\u00A6IS\u00A6IQ\u00A6UY\u00A6IN\u00A6IL\u00A6US\u00A6IE\u00A6ID\u00A6UA\u00A6HU\u00A6HR\u00A6TZ\u00A6TW\u00A6TT\u00A6TR\u00A6TN";

  private static final String territoriesValues = "Taxhikistan\u00A6Tajland\u00eb\u00A6Togo\u00A6Guajana\u00A6\u00c7ad\u00A6Guine Bisau\u00A6Guatemal\u00eb\u00A6Greqi\u00A6Guineja Ekuatoriale\u00A6Svaziland\u00eb\u00A6Siri\u00A6Guine\u00A6Gambi\u00A6Sao Tome e Prinsipe\u00A6Gan\u00eb\u00A6Gjeorgji\u00A6Somali\u00A6Siera Leone\u00A6Gjabon\u00A6Sllovaki\u00A6Slloveni\u00A6Singapor\u00A6Suedi\u00A6Sishel\u00A6Ishujt Solomon\u00A6Arabia Saudite\u00A6Franc\u00eb\u00A6Mikronezi\u00A6Ruanda\u00A6Rusi\u00A6Fixhi\u00A6Finland\u00eb\u00A6Rumani\u00A6Etiopi\u00A6Spanj\u00eb\u00A6Eritre\u00A6Saharaja Per\u00ebndimore\u00A6Egjipt\u00A6Estoni\u00A6Ekuator\u00A6Algjeri\u00A6Katar\u00A6Republika Dominikan\u00eb\u00A6Paraguaj\u00A6Dominik\u00eb\u00A6Danimark\u00eb\u00A6Xhibuti\u00A6Portugali\u00A6Gjermani\u00A6Poloni\u00A6Filipine\u00A6Papua Guineja e Re\u00A6Republika e \u00c7ekis\u00eb\u00A6Qipro\u00A6Kap Verde\u00A6Kub\u00eb\u00A6Kosta Rika\u00A6Kolumbi\u00A6Kin\u00eb\u00A6Kamerun\u00A6Kili\u00A6Bregu i Fildisht\u00eb\u00A6Zvic\u00ebr\u00A6Kongo\u00A6Republika Qendrore e Afrik\u00ebs\u00A6Kanada\u00A6Bjellorusi\u00A6Botsvana\u00A6Butan\u00A6Zelanda e Re\u00A6Bolivi\u00A6Brunej\u00A6Bahrein\u00A6Bullgari\u00A6Belgjik\u00eb\u00A6Norvegji\u00A6Zimbabve\u00A6Vendet e Ul\u00ebta\u00A6Bosnja dhe Hercegovina\u00A6Nikaragua\u00A6Nigeri\u00A6Azerbajxhan\u00A6Zambi\u00A6Australi\u00A6Namibi\u00A6Austri\u00A6Argjentin\u00eb\u00A6Mozambik\u00A6Angol\u00eb\u00A6Malajzi\u00A6Meksik\u00eb\u00A6Armeni\u00A6Malavi\u00A6Shqip\u00ebria\u00A6Maldivit\u00A6Afrika e Jugut\u00A6Malt\u00eb\u00A6Mauritani\u00A6Antigua e Barbuda\u00A6Afganistan\u00A6Emiratet Arabe te Bashkuara\u00A6Andorr\u00eb\u00A6Mongoli\u00A6Maqedoni\u00A6Serbi\u00eb\u00A6Ishujt Marshall\u00A6Madagaskar\u00A6Moldavi\u00A6Monako\u00A6Maroko\u00A6Jemen\u00A6Libi\u00A6Letoni\u00A6Luksemburg\u00A6Lituani\u00A6Lesoto\u00A6Liberi\u00A6Liht\u00ebnshtajn\u00A6Liban\u00A6Kazakistan\u00A6Kuvajt\u00A6Koreja e Jugut\u00A6Koreja e Veriut\u00A6Saint Kitts e Nevis\u00A6Komore\u00A6Qiribati\u00A6Kamboxhi\u00A6Kirgistan\u00A6Kenia\u00A6Japoni\u00A6Jordani\u00A6Xhamajk\u00eb\u00A6Venezuel\u00eb\u00A6Saint Vincent e Grenadinet\u00A6Vatikan\u00A6Itali\u00A6Island\u00eb\u00A6Irak\u00A6Uruguaj\u00A6Indi\u00A6Izrael\u00A6Shtetet e Bashkuara t\u00eb Amerik\u00ebs\u00A6Irland\u00eb\u00A6Indonezi\u00A6Ukrain\u00eb\u00A6Hungari\u00A6Kroaci\u00A6Tanzani\u00A6Tajvan\u00A6Trinidad e Tobago\u00A6Turqi\u00A6Tunisi";

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

  private static final String languagesKeys = "sq";

  private static final String languagesValues = "shqipe";

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
    { "decimalSeparator", "," },
    { "groupingSeparator", "." },
    { "localPatternChars", "GanjkHmsSEDFwWxhKzAeugXZ" },
    { "currenciesDisplayName", currenciesDisplayName },
    { "currenciesSymbol", currenciesSymbol },
    { "shortMonths", shortMonths },
    { "months", months },
    { "shortWeekdays", shortWeekdays },
    { "weekdays", weekdays },
    { "firstDayOfWeek", "mon" },
    { "eras", eras },
    { "ampms", ampms },
    { "shortDateFormat", "yy-MM-dd" },
    { "mediumDateFormat", "yyyy-MM-dd" },
    { "longDateFormat", "dd MMMM yyyy" },
    { "fullDateFormat", "EEEE, dd MMMM yyyy" },
    { "shortTimeFormat", "h.mm.a" },
    { "mediumTimeFormat", "h:mm:ss.a" },
    { "longTimeFormat", "h.mm.ss.a z" },
    { "fullTimeFormat", "h.mm.ss.a z" },
    { "territories", territories },
    { "languages", languages },
  };

  public Object[][] getContents() { return contents; }
}
