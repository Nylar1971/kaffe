/* LocaleInformation_sl.java --
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

public class LocaleInformation_sl extends ListResourceBundle
{
  private static final String currenciesDisplayNameKeys = "SIT";

  private static final String currenciesDisplayNameValues = "Slovenski tolar";

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

  private static final String currenciesSymbolKeys = "SIT";

  private static final String currenciesSymbolValues = "SIT";

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
    "jan",
    "feb",
    "mar",
    "apr",
    "maj",
    "jun",
    "jul",
    "avg",
    "sep",
    "okt",
    "nov",
    "dec",
    null,
  };

  private static final String[] months = {
    "januar",
    "februar",
    "marec",
    "april",
    "maj",
    "junij",
    "julij",
    "avgust",
    "september",
    "oktober",
    "november",
    "december",
    null,
  };

  private static final String[] shortWeekdays = {
    null,
    "ned",
    "pon",
    "tor",
    "sre",
    "\u010det",
    "pet",
    "sob",
  };

  private static final String[] weekdays = {
    null,
    "nedelja",
    "ponedeljek",
    "torek",
    "sreda",
    "\u010detrtek",
    "petek",
    "sobota",
  };

  private static final String[] eras = {
    "pr.n.\u0161.",
    "po Kr.",
  };

  private static final String territoriesKeys = "TL\u00A6TK\u00A6TJ\u00A6TH\u00A6TG\u00A6TF\u00A6GY\u00A6TD\u00A6TC\u00A6GW\u00A6GU\u00A6GT\u00A6GS\u00A6GR\u00A6GQ\u00A6GP\u00A6SZ\u00A6SY\u00A6GN\u00A6GM\u00A6GL\u00A6SV\u00A6ST\u00A6GI\u00A6GH\u00A6SR\u00A6GF\u00A6GE\u00A6SO\u00A6GD\u00A6SN\u00A6SM\u00A6GB\u00A6SL\u00A6GA\u00A6SK\u00A6SJ\u00A6SI\u00A6SH\u00A6SG\u00A6SE\u00A6SD\u00A6SC\u00A6SB\u00A6SA\u00A6FR\u00A6FO\u00A6FM\u00A6RW\u00A6FK\u00A6RU\u00A6FJ\u00A6FI\u00A6RO\u00A6RE\u00A6ET\u00A6ES\u00A6ER\u00A6EH\u00A6EG\u00A6EE\u00A6EC\u00A6DZ\u00A6QA\u00A6DO\u00A6PY\u00A6DM\u00A6PW\u00A6DK\u00A6DJ\u00A6PT\u00A6PS\u00A6PR\u00A6DE\u00A6PN\u00A6PM\u00A6PL\u00A6PK\u00A6PH\u00A6PG\u00A6PF\u00A6CZ\u00A6PE\u00A6CY\u00A6CX\u00A6CV\u00A6PA\u00A6CU\u00A6CR\u00A6CO\u00A6CN\u00A6CM\u00A6CL\u00A6CK\u00A6CI\u00A6CH\u00A6CG\u00A6CF\u00A6CD\u00A6CC\u00A6OM\u00A6CA\u00A6BZ\u00A6BY\u00A6BW\u00A6BV\u00A6BT\u00A6BS\u00A6BR\u00A6NZ\u00A6BO\u00A6BN\u00A6BM\u00A6NU\u00A6BJ\u00A6BI\u00A6BH\u00A6NR\u00A6BG\u00A6BF\u00A6NP\u00A6BE\u00A6NO\u00A6BD\u00A6BB\u00A6ZW\u00A6NL\u00A6BA\u00A6NI\u00A6NG\u00A6NF\u00A6AZ\u00A6NE\u00A6NC\u00A6AW\u00A6ZM\u00A6NA\u00A6AU\u00A6AT\u00A6AS\u00A6AR\u00A6AQ\u00A6MZ\u00A6AO\u00A6MY\u00A6AN\u00A6MX\u00A6AM\u00A6MW\u00A6AL\u00A6MV\u00A6ZA\u00A6MU\u00A6MT\u00A6AI\u00A6MS\u00A6MR\u00A6AG\u00A6MQ\u00A6AF\u00A6MP\u00A6AE\u00A6MO\u00A6AD\u00A6MN\u00A6MM\u00A6ML\u00A6MK\u00A6YU\u00A6YT\u00A6MH\u00A6MG\u00A6MD\u00A6MC\u00A6MA\u00A6YE\u00A6LY\u00A6LV\u00A6LU\u00A6LT\u00A6LS\u00A6LR\u00A6LK\u00A6LI\u00A6LC\u00A6LB\u00A6LA\u00A6KZ\u00A6KY\u00A6KW\u00A6KR\u00A6KP\u00A6KN\u00A6KM\u00A6KI\u00A6WS\u00A6KH\u00A6KG\u00A6KE\u00A6WF\u00A6JP\u00A6JO\u00A6JM\u00A6VU\u00A6VN\u00A6VI\u00A6VG\u00A6VE\u00A6VC\u00A6VA\u00A6IT\u00A6IS\u00A6IR\u00A6IQ\u00A6UZ\u00A6IO\u00A6UY\u00A6IN\u00A6IL\u00A6US\u00A6IE\u00A6ID\u00A6UM\u00A6UG\u00A6UA\u00A6HU\u00A6HT\u00A6HR\u00A6TZ\u00A6HN\u00A6HM\u00A6TW\u00A6TV\u00A6HK\u00A6TT\u00A6TR\u00A6TO\u00A6TN\u00A6TM";

  private static final String territoriesValues = "Vzhodni Timor\u00A6Tokelau\u00A6Tad\u017eikistan\u00A6Tajska\u00A6Togo\u00A6Francoski ju\u017eni teritorij\u00A6Gvajana\u00A6\u010cad\u00A6Oto\u010dji Turks in Caicos\u00A6Gvineja Bissau\u00A6Guam\u00A6Gvatemala\u00A6Ju\u017ena Georgija in Ju\u017eni Sandwich Islands\u00A6Gr\u010dija\u00A6Ekvatorialna Gvineja\u00A6Guadeloupe\u00A6Svazi\u00A6Sirija\u00A6Gvineja\u00A6Gambija\u00A6Grenlandija\u00A6Salvador\u00A6Sao Tome in Principe\u00A6Gibraltar\u00A6Gana\u00A6Surinam\u00A6Francoska Gvajana\u00A6Gruzija\u00A6Somalija\u00A6Grenada\u00A6Senegal\u00A6San Marino\u00A6Velika Britanija\u00A6Sierra Leone\u00A6Gabon\u00A6Slova\u0161ka\u00A6Svalbard in Jan Mayen\u00A6Slovenija\u00A6Sveta Helena\u00A6Singapur\u00A6\u0160vedska\u00A6Sudan\u00A6Sej\u0161eli\u00A6Salomonovo oto\u010dje\u00A6Saudova Arabija\u00A6Francija\u00A6Fererski otoki\u00A6Mikronezija\u00A6Ruanda\u00A6Falklandski (Malvinski) otoki\u00A6Ruska federacija\u00A6Fid\u017ei\u00A6Finska\u00A6Romunija\u00A6Reunion\u00A6Etiopija\u00A6\u0160panija\u00A6Eritreja\u00A6Zahodna Sahara\u00A6Egipt\u00A6Estonija\u00A6Ekvador\u00A6Al\u017eirija\u00A6Katar\u00A6Dominikanska republika\u00A6Paragvaj\u00A6Dominika\u00A6Palau\u00A6Danska\u00A6D\u017eibuti\u00A6Portugalska\u00A6Palestinsko ozemlje\u00A6Portoriko\u00A6Nem\u010dija\u00A6Pitcairn\u00A6Saint Pierre in Miquelon\u00A6Poljska\u00A6Pakistan\u00A6Filipini\u00A6Papua Nova Gvineja\u00A6Francoska Polinezija\u00A6\u010ce\u0161ka\u00A6Peru\u00A6Ciper\u00A6Bo\u017ei\u010dni otok\u00A6Kapverdski otoki\u00A6Panama\u00A6Kuba\u00A6Kostarika\u00A6Kolumbija\u00A6Kitajska\u00A6Kamerun\u00A6\u010cile\u00A6Cookovi otoki\u00A6Slonoko\u0161\u010dena obala\u00A6\u0160vica\u00A6Kongo\u00A6Centralnoafri\u0161ka republika\u00A6Demokrati\u010dna republika Kongo\u00A6Kokosovi otoki\u00A6Oman\u00A6Kanada\u00A6Belize\u00A6Belorusija\u00A6Bocvana\u00A6Otok Bouvet\u00A6Butan\u00A6Bahami\u00A6Brazilija\u00A6Nova Zelandija\u00A6Bolivija\u00A6Brunej\u00A6Bermuda\u00A6Niue\u00A6Benin\u00A6Burundi\u00A6Bahrajn\u00A6Nauru\u00A6Bolgarija\u00A6Burkina Faso\u00A6Nepal\u00A6Belgija\u00A6Norve\u0161ka\u00A6Banglade\u0161\u00A6Barbados\u00A6Zimbabve\u00A6Nizozemska\u00A6Bosna in Hercegovina\u00A6Nikaragva\u00A6Nigerija\u00A6Otok Norfolk\u00A6Azerbajd\u017ean\u00A6Niger\u00A6Nova Kaledonija\u00A6Aruba\u00A6Zambija\u00A6Namibija\u00A6Avstralija\u00A6Avstrija\u00A6Ameri\u0161ka Samoa\u00A6Argentina\u00A6Antarktika\u00A6Mozambik\u00A6Angola\u00A6Malezija\u00A6Nizozemski Antili\u00A6Mehika\u00A6Armenija\u00A6Malavi\u00A6Albanija\u00A6Maldivi\u00A6Ju\u017ena Afrika\u00A6Mauritius\u00A6Malta\u00A6Angvila\u00A6Montserrat\u00A6Mavretanija\u00A6Antigva in Barbuda\u00A6Martinik\u00A6Afganistan\u00A6Severni Marianski otoki\u00A6Zdru\u017eeni arabski emirati\u00A6Makao S.A.R. Kitajske\u00A6Andora\u00A6Mongolija\u00A6Myanmar\u00A6Mali\u00A6Republika Makedonija\u00A6Jugoslavija\u00A6Mayotte\u00A6Marshallovi otoki\u00A6Madagaskar\u00A6Republika Moldova\u00A6Monako\u00A6Maroko\u00A6Jemen\u00A6Libija\u00A6Latvija\u00A6Luxemburg\u00A6Litva\u00A6Lesoto\u00A6Liberija\u00A6\u0160rilanka\u00A6Liechtenstein\u00A6Saint Lucia\u00A6Libanon\u00A6Ljudska demokrati\u010dna republika Laos\u00A6Kazahstan\u00A6Kajmanski otoki\u00A6Kuvajt\u00A6Ju\u017ena Koreja\u00A6Severna Koreja\u00A6Saint Kitts in Nevis\u00A6Komori\u00A6Kiribati\u00A6Samoa\u00A6Kambod\u017ea\u00A6Kirgizistan\u00A6Kenija\u00A6Wallis in Futuna\u00A6Japonska\u00A6Jordan\u00A6Jamajka\u00A6Vanuatu\u00A6Vietnam\u00A6Ameri\u0161ki Devi\u0161ki otoki\u00A6Britanski Devi\u0161ki otoki\u00A6Venezuela\u00A6Saint Vincent in Grenadine\u00A6Vatikan\u00A6Italija\u00A6Islandija\u00A6Iran\u00A6Irak\u00A6Uzbekistan\u00A6Britanska Indija\u00A6Urugvaj\u00A6Indija\u00A6Izrael\u00A6Zdru\u017eene dr\u017eave Amerike\u00A6Irska\u00A6Indonezija\u00A6Ameri\u0161ki manj\u0161i oddaljeni otoki\u00A6Uganda\u00A6Ukrajina\u00A6Mad\u017earska\u00A6Haiti\u00A6Hrva\u0161ka\u00A6Tanzanija\u00A6Honduras\u00A6Heardov otok in McDonaldovi otoki\u00A6Tajvan\u00A6Tuvalu\u00A6Hong Kong S.A.R. Kitajske\u00A6Trinidad in Tobago\u00A6Tur\u010dija\u00A6Tonga\u00A6Tunizija\u00A6Turkmenistan";

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

  private static final String languagesKeys = "ja\u00A6en\u00A6tr\u00A6ko\u00A6no\u00A6el\u00A6nl\u00A6bg\u00A6lv\u00A6he\u00A6cs\u00A6it\u00A6lt\u00A6fr\u00A6zh\u00A6ru\u00A6ro\u00A6fi\u00A6ar\u00A6sv\u00A6pt\u00A6pl\u00A6sl\u00A6sk\u00A6de\u00A6hu\u00A6et\u00A6es\u00A6hr\u00A6da";

  private static final String languagesValues = "Japon\u0161\u010dina\u00A6Angle\u0161\u010dina\u00A6Tur\u0161\u010dina\u00A6Korej\u0161\u010dina\u00A6Norve\u0161\u010dina\u00A6Gr\u0161\u010dina\u00A6Nizozem\u0161\u010dina\u00A6Bolgar\u0161\u010dina\u00A6Leton\u0161\u010dina\u00A6Hebrej\u0161\u010dina\u00A6\u010ce\u0161\u010dina\u00A6Italijan\u0161\u010dina\u00A6Litov\u0161\u010dina\u00A6Franco\u0161\u010dina\u00A6Kitaj\u0161\u010dina\u00A6Ru\u0161\u010dina\u00A6Romun\u0161\u010dina\u00A6Fin\u0161\u010dina\u00A6Arab\u0161\u010dina\u00A6\u0160ved\u0161\u010dina\u00A6Portugal\u0161\u010dina\u00A6Polj\u0161\u010dina\u00A6Sloven\u0161\u010dina\u00A6Slova\u0161\u010dina\u00A6Nem\u0161\u010dina\u00A6Mad\u017ear\u0161\u010dina\u00A6Eston\u0161\u010dina\u00A6\u0160pan\u0161\u010dina\u00A6Hrva\u0161\u010dina\u00A6Dan\u0161\u010dina";

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
    { "shortDateFormat", "yy.M.d" },
    { "mediumDateFormat", "yyyy.M.d" },
    { "longDateFormat", "dd. MMMM yyyy" },
    { "fullDateFormat", "EEEE, dd. MMMM yyyy" },
    { "shortTimeFormat", "H:mm" },
    { "mediumTimeFormat", "H:mm:ss" },
    { "longTimeFormat", "H:mm:ss z" },
    { "fullTimeFormat", "H:mm:ss z" },
    { "territories", territories },
    { "languages", languages },
  };

  public Object[][] getContents() { return contents; }
}
