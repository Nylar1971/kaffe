/* LocaleInformation_lt.java --
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

public class LocaleInformation_lt extends ListResourceBundle
{
  private static final String currenciesDisplayNameKeys = "LTL";

  private static final String currenciesDisplayNameValues = "LTL";

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

  private static final String currenciesSymbolKeys = "LTL";

  private static final String currenciesSymbolValues = "Lt";

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
    "Sau",
    "Vas",
    "Kov",
    "Bal",
    "Geg",
    "Bir",
    "Lie",
    "Rgp",
    "Rgs",
    "Spa",
    "Lap",
    "Grd",
    null,
  };

  private static final String[] months = {
    "Sausio",
    "Vasario",
    "Kovo",
    "Baland\u017eio",
    "Gegu\u017e\u0117s",
    "Bir\u017eelio",
    "Liepos",
    "Rugpj\u016b\u010dio",
    "Rugs\u0117jo",
    "Spalio",
    "Lapkri\u010dio",
    "Gruod\u017eio",
    null,
  };

  private static final String[] shortWeekdays = {
    null,
    "Sk",
    "Pr",
    "An",
    "Tr",
    "Kt",
    "Pn",
    "\u0160t",
  };

  private static final String[] weekdays = {
    null,
    "Sekmadienis",
    "Pirmadienis",
    "Antradienis",
    "Tre\u010diadienis",
    "Ketvirtadienis",
    "Penktadienis",
    "\u0160e\u0161tadienis",
  };

  private static final String[] eras = {
    "pr.Kr.",
    "po.Kr.",
  };

  private static final String territoriesKeys = "TL\u00A6TK\u00A6TJ\u00A6TH\u00A6TG\u00A6TF\u00A6GY\u00A6TD\u00A6TC\u00A6GW\u00A6GU\u00A6GT\u00A6GS\u00A6GR\u00A6GQ\u00A6GP\u00A6SZ\u00A6SY\u00A6GN\u00A6GM\u00A6GL\u00A6SV\u00A6ST\u00A6GI\u00A6GH\u00A6SR\u00A6GF\u00A6GE\u00A6SO\u00A6GD\u00A6SN\u00A6SM\u00A6GB\u00A6SL\u00A6GA\u00A6SK\u00A6SJ\u00A6SI\u00A6SH\u00A6SG\u00A6SE\u00A6SD\u00A6SC\u00A6SB\u00A6SA\u00A6FR\u00A6FO\u00A6FM\u00A6RW\u00A6FK\u00A6RU\u00A6FJ\u00A6FI\u00A6RO\u00A6RE\u00A6ET\u00A6ES\u00A6ER\u00A6EH\u00A6EG\u00A6EE\u00A6EC\u00A6DZ\u00A6QA\u00A6DO\u00A6PY\u00A6DM\u00A6PW\u00A6DK\u00A6DJ\u00A6PT\u00A6PS\u00A6PR\u00A6DE\u00A6PN\u00A6PM\u00A6PL\u00A6PK\u00A6PH\u00A6PG\u00A6PF\u00A6CZ\u00A6PE\u00A6CY\u00A6CX\u00A6CV\u00A6PA\u00A6CU\u00A6CR\u00A6CO\u00A6CN\u00A6CM\u00A6CL\u00A6CK\u00A6CI\u00A6CH\u00A6CG\u00A6CF\u00A6CD\u00A6CC\u00A6OM\u00A6CA\u00A6BZ\u00A6BY\u00A6BW\u00A6BV\u00A6BT\u00A6BS\u00A6BR\u00A6NZ\u00A6BO\u00A6BN\u00A6BM\u00A6NU\u00A6BJ\u00A6BI\u00A6BH\u00A6NR\u00A6BG\u00A6BF\u00A6NP\u00A6BE\u00A6NO\u00A6BD\u00A6BB\u00A6ZW\u00A6NL\u00A6BA\u00A6NI\u00A6NG\u00A6NF\u00A6AZ\u00A6NE\u00A6NC\u00A6AW\u00A6ZM\u00A6NA\u00A6AU\u00A6AT\u00A6AS\u00A6AR\u00A6AQ\u00A6MZ\u00A6AO\u00A6MY\u00A6AN\u00A6MX\u00A6AM\u00A6MW\u00A6AL\u00A6MV\u00A6ZA\u00A6MU\u00A6MT\u00A6AI\u00A6MS\u00A6MR\u00A6AG\u00A6MQ\u00A6AF\u00A6MP\u00A6AE\u00A6MO\u00A6AD\u00A6MN\u00A6MM\u00A6ML\u00A6MK\u00A6YU\u00A6YT\u00A6MH\u00A6MG\u00A6MD\u00A6MC\u00A6MA\u00A6YE\u00A6LY\u00A6LV\u00A6LU\u00A6LT\u00A6LS\u00A6LR\u00A6LK\u00A6LI\u00A6LC\u00A6LB\u00A6LA\u00A6KZ\u00A6KY\u00A6KW\u00A6KR\u00A6KP\u00A6KN\u00A6KM\u00A6KI\u00A6WS\u00A6KH\u00A6KG\u00A6KE\u00A6WF\u00A6JP\u00A6JO\u00A6JM\u00A6VU\u00A6VN\u00A6VI\u00A6VG\u00A6VE\u00A6VC\u00A6VA\u00A6IT\u00A6IS\u00A6IR\u00A6IQ\u00A6UZ\u00A6IO\u00A6UY\u00A6IN\u00A6IL\u00A6US\u00A6IE\u00A6ID\u00A6UM\u00A6UG\u00A6UA\u00A6HU\u00A6HT\u00A6HR\u00A6TZ\u00A6HN\u00A6HM\u00A6TW\u00A6TV\u00A6HK\u00A6TT\u00A6TR\u00A6TO\u00A6TN\u00A6TM";

  private static final String territoriesValues = "Ryt\u0173 Timoras\u00A6Tokelau\u00A6Tad\u017eikija\u00A6Tailandas\u00A6Togas\u00A6Pranc\u016bz\u0173 pietin\u0117s teritorijos\u00A6Gviana\u00A6\u010cadas\u00A6Turks ir Kaikos salos\u00A6Gvin\u0117ja-Bisau\u00A6Guamas\u00A6Gvatemala\u00A6Ryt\u0173 D\u017eord\u017eija ir Ryt\u0173 Sandwich salos\u00A6Graikija\u00A6Ekvatorin\u0117 Gvin\u0117ja\u00A6Gvadelup\u0117\u00A6Svazilendas\u00A6Sirija\u00A6Gvin\u0117ja\u00A6Gambija\u00A6Grenlandija\u00A6El Salvadoras\u00A6San Tom\u0117 ir Princip\u0117\u00A6Gibraltaras\u00A6Gana\u00A6Surinamas\u00A6Pranc\u016bzijos Gviana\u00A6Gruzija\u00A6Somalis\u00A6Grenada\u00A6Senegalas\u00A6San Marinas\u00A6Did\u017eioji Britanija\u00A6Siera Leon\u0117\u00A6Gabonas\u00A6Slovakia\u00A6Svalbardo ir Jan Majen salos\u00A6Slov\u0117nija\u00A6\u0160ventoji Elena\u00A6Singap\u016bras\u00A6\u0160vedija\u00A6Sudanas\u00A6Sei\u0161eliai\u00A6Saliamono salos\u00A6Saudo Arabija\u00A6Pranc\u016bzija\u00A6Farer\u0173 salos\u00A6Mikronezijos Federacin\u0117s Valstijos\u00A6Ruanda\u00A6Folklendo salos (Malvinai)\u00A6Rusijos Federacija\u00A6Fid\u017eis\u00A6Suomija\u00A6Rumunija\u00A6Rejunjonas\u00A6Etiopija\u00A6Ispanija\u00A6Eritr\u0117ja\u00A6Vakar\u0173 Sachara\u00A6Egiptas\u00A6Estija\u00A6Ekvadoras\u00A6Al\u017eyras\u00A6Kataras\u00A6Dominikos Respublika\u00A6Paragvajus\u00A6Dominika\u00A6Palau\u00A6Danija\u00A6D\u017eibutis\u00A6Portugalija\u00A6Palestinos teritorija\u00A6Puerto Rikas\u00A6Vokietija\u00A6Pitkernas\u00A6Sen Pjeras ir Mikelonas\u00A6Lenkija\u00A6Pakistanas\u00A6Filipinai\u00A6Papua Naujoji Gvin\u0117ja\u00A6Pranc\u016bz\u0173 Polinezija\u00A6\u010cekijos respublika\u00A6Peru\u00A6Kipras\u00A6Kal\u0117d\u0173 sala\u00A6\u017daliojo Ky\u0161ulio salos\u00A6Panama\u00A6Kuba\u00A6Kosta Rika\u00A6Kolumbija\u00A6Kinija\u00A6Kamer\u016bnas\u00A6\u010cil\u0117\u00A6Kuko salos\u00A6Kot d\u2019Ivuar\u00A6\u0160veicarija\u00A6Kongas\u00A6Centrin\u0117s Afrikos Respublika\u00A6Kongo Demokratin\u0117 Respublika\u00A6Kokos\u0173 salos\u00A6Omanas\u00A6Kanada\u00A6Belizas\u00A6Baltarusija\u00A6Botsvana\u00A6Bouvet sala\u00A6Butanas\u00A6Bahamai\u00A6Brazilija\u00A6Naujoji Zelandija\u00A6Bolivija\u00A6Brun\u0117jus\u00A6Bermudai\u00A6Niuj\u0117\u00A6Beninas\u00A6Burundis\u00A6Bahreinas\u00A6Nauru\u00A6Bulgarija\u00A6Burkina Fasas\u00A6Nepalas\u00A6Belgija\u00A6Norvegija\u00A6Banglade\u0161as\u00A6Barbadosas\u00A6Zimbabv\u0117\u00A6Nyderlandai\u00A6Bosnija ir Hercegovina\u00A6Nikaragva\u00A6Nigerija\u00A6Norfolko sala\u00A6Azerbaid\u017eanas\u00A6Nigeris\u00A6Naujoji Kaledonija\u00A6Aruba\u00A6Zambija\u00A6Namibija\u00A6Australija\u00A6Austrija\u00A6Amerikos Samoa\u00A6Argentina\u00A6Antarktika\u00A6Mozambikas\u00A6Angola\u00A6Malaizija\u00A6Nyderland\u0173 Antilai\u00A6Meksika\u00A6Arm\u0117nija\u00A6Malavis\u00A6Albanija\u00A6Maldivai\u00A6Piet\u0173 Afrika\u00A6Mauricijus\u00A6Malta\u00A6Angvila\u00A6Montserat\u00A6Mauritanija\u00A6Antigva ir Barbuda\u00A6Martinika\u00A6Afganistanas\u00A6\u0160iaurin\u0117s Marianos salos\u00A6Jungtiniai Arab\u0173 Emyratai\u00A6Kinijos S.A.R. Makao\u00A6Andora\u00A6Mongolija\u00A6Mjanma\u00A6Malis\u00A6Makedonijos Respublika\u00A6Jugoslavija\u00A6Majot\u0117\u00A6Mar\u0161alo salos\u00A6Madagaskaras\u00A6Moldovos Respublika\u00A6Monakas\u00A6Marokas\u00A6Jemenas\u00A6Libijos Arab\u0173 D\u017eamahirija\u00A6Latvija\u00A6Liuksemburgas\u00A6Lietuva\u00A6Lesotas\u00A6Liberija\u00A6\u0160ri Lanka\u00A6Lichten\u0161teinas\u00A6\u0160ventoji Liucija\u00A6Libanas\u00A6Laoso Liaudies Demokratin\u0117 Respublika\u00A6Kazachstanas\u00A6Kaiman\u0173 salos\u00A6Kuveitas\u00A6Piet\u0173 Kor\u0117ja\u00A6\u0160iaur\u0117s Kor\u0117ja\u00A6Sent Kitsas ir Nevis\u00A6Komorai\u00A6Kiribatis\u00A6Samoa\u00A6Kambod\u017ea\u00A6Kirgiztanas\u00A6Kenija\u00A6Valiso ir Futuna salos\u00A6Japonija\u00A6Jordanija\u00A6Jamaika\u00A6Vanuatu\u00A6Vietnamas\u00A6JAV Virginijos salos\u00A6Brit\u0173 Virginijos salos\u00A6Venesuela\u00A6\u0160ventasis Vincentas ir Grenadinai\u00A6Vatikano Miesto Valstija\u00A6Italija\u00A6Islandija\u00A6Irano\u00A6Irakas\u00A6Uzbekija\u00A6Brit\u0173 Indijos vandenyno teritorija\u00A6Urugvajus\u00A6Indija\u00A6Izraelis\u00A6United States\u00A6Airija\u00A6Indonezija\u00A6JAV antraeil\u0117s teritorijos salos\u00A6Uganda\u00A6Ukraina\u00A6Vengrija\u00A6Haitis\u00A6Kroatija\u00A6Tanzanija\u00A6Hond\u016bras\u00A6Heard ir McDonald salos\u00A6Taivanis\u00A6Tuvalu\u00A6Kinijos S.A.R.Honkongas\u00A6Trinidadas ir Tobagas\u00A6Turkija\u00A6Tonga\u00A6Tunisas\u00A6Turkm\u0117nistanas";

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

  private static final String languagesValues = "Japon\u0173\u00A6Angl\u0173\u00A6Turk\u0173\u00A6Kor\u0117jie\u010di\u0173\u00A6Norveg\u0173\u00A6Graik\u0173\u00A6Oland\u0173\u00A6Bulgar\u0173\u00A6Latvi\u0173\u00A6Hebraj\u0173\u00A6\u010cekijos\u00A6Ital\u0173\u00A6Lietuvi\u0173\u00A6Pranc\u016bz\u0173\u00A6Kin\u0173\u00A6Rus\u0173\u00A6Rumun\u0173\u00A6Suomi\u0173\u00A6Arab\u0173\u00A6\u0160ved\u0173\u00A6Portugal\u0173\u00A6Lenk\u0173\u00A6Slov\u0117n\u0173\u00A6Slovak\u0173\u00A6Vokie\u010di\u0173\u00A6Vengr\u0173\u00A6Est\u0173\u00A6Ispan\u0173\u00A6Kroat\u0173\u00A6Dan\u0173";

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
    { "minNumberOfDaysInFirstWeek", "4" },
    { "firstDayOfWeek", "mon" },
    { "eras", eras },
    { "shortDateFormat", "yyyy.MM.dd" },
    { "mediumDateFormat", "yyyy.MM.dd" },
    { "longDateFormat", "yyyy 'm.' MMMM d 'd.'" },
    { "fullDateFormat", "yyyy 'm.' MMMM d 'd.',EEEE" },
    { "territories", territories },
    { "languages", languages },
  };

  public Object[][] getContents() { return contents; }
}
