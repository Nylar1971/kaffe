/* LocaleInformation_ga.java --
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

public class LocaleInformation_ga extends ListResourceBundle
{
  private static final String currenciesDisplayNameKeys = "JOD\u00A6BOV\u00A6XAU\u00A6FOK\u00A6LBP\u00A6EUR\u00A6VND\u00A6TZS\u00A6BOP\u00A6KHR\u00A6XAM\u00A6BOL\u00A6KHO\u00A6ZMP\u00A6AUP\u00A6XAF\u00A6MTP\u00A6GHR\u00A6ZMK\u00A6XAD\u00A6GHP\u00A6BOB\u00A6GHO\u00A6MTL\u00A6AUD\u00A6USS\u00A6ITL\u00A6USN\u00A6GHC\u00A6SGD\u00A6PAB\u00A6LAK\u00A6KGS\u00A6CHF\u00A6ATS\u00A6USD\u00A6ETD\u00A6BND\u00A6JMP\u00A6ETB\u00A6DZG\u00A6DZF\u00A6DZD\u00A6PYG\u00A6LYP\u00A6JMD\u00A6ISK\u00A6ESP\u00A6BMP\u00A6LYD\u00A6LYB\u00A6BMD\u00A6NLG\u00A6MRO\u00A6IRR\u00A6SEK\u00A6KES\u00A6CFF\u00A6ARS\u00A6ARP\u00A6ARM\u00A6TWD\u00A6SDP\u00A6GEL\u00A6GEK\u00A6MQF\u00A6FKP\u00A6ARA\u00A6SDD\u00A6IQD\u00A6TVD\u00A6SCR\u00A6LVR\u00A6FJP\u00A6LVL\u00A6CDL\u00A6CDG\u00A6CDF\u00A6FJD\u00A6NIO\u00A6MOP\u00A6NIG\u00A6NIC\u00A6XTR\u00A6FIN\u00A6FIM\u00A6SBD\u00A6LUF\u00A6TTO\u00A6AOS\u00A6AOR\u00A6MNT\u00A6HUF\u00A6BIF\u00A6AON\u00A6AOK\u00A6TTD\u00A6SZL\u00A6NHF\u00A6GBP\u00A6SAR\u00A6LTT\u00A6INR\u00A6PTE\u00A6AOA\u00A6PTC\u00A6LTL\u00A6KZT\u00A6KZR\u00A6VGD\u00A6NGP\u00A6MMX\u00A6NGN\u00A6HTG\u00A6SYP\u00A6PSP\u00A6BHD\u00A6MMK\u00A6ANG\u00A6CZK\u00A6IMP\u00A6BGX\u00A6LSL\u00A6GAF\u00A6BGO\u00A6BGN\u00A6BGM\u00A6CAD\u00A6BGL\u00A6TRL\u00A6KYD\u00A6CYP\u00A6ILS\u00A6GYD\u00A6AMD\u00A6ILP\u00A6MLF\u00A6ILL\u00A6VEB\u00A6ALX\u00A6LRD\u00A6ALV\u00A6HRK\u00A6REF\u00A6HRD\u00A6ALL\u00A6JEP\u00A6ALK\u00A6MKN\u00A6VDP\u00A6VDN\u00A6MKD\u00A6VDD\u00A6TPP\u00A6XPF\u00A6BEL\u00A6GWP\u00A6KWD\u00A6GWM\u00A6BEF\u00A6TPE\u00A6BEC\u00A6GWE\u00A6SVC\u00A6CWG\u00A6BDT\u00A6TOS\u00A6TOP\u00A6XOF\u00A6SUR\u00A6SUN\u00A6NCF\u00A6CVE\u00A6XNF\u00A6ZAR\u00A6DOP\u00A6CUX\u00A6ZAP\u00A6ZAL\u00A6TND\u00A6CUP\u00A6GUF\u00A6UGX\u00A6LNR\u00A6AIF\u00A6VAL\u00A6STE\u00A6UGS\u00A6STD\u00A6MHD\u00A6NZP\u00A6WST\u00A6WSP\u00A6HNL\u00A6XMF\u00A6TMM\u00A6GTQ\u00A6NZD\u00A6SSP\u00A6BBD\u00A6NAD\u00A6MGF\u00A6MGA\u00A6EGP\u00A6BZH\u00A6PLZ\u00A6BAN\u00A6PLX\u00A6BAM\u00A6BZD\u00A6BAD\u00A6PLN\u00A6YER\u00A6SRG\u00A6CSK\u00A6KRW\u00A6BYR\u00A6YEI\u00A6BYL\u00A6CSC\u00A6KRO\u00A6KRH\u00A6BYB\u00A6GRN\u00A6PKR\u00A6AFN\u00A6ZWD\u00A6LKR\u00A6GRD\u00A6IEP\u00A6AFA\u00A6YDD\u00A6RWF\u00A6CRC\u00A6TJS\u00A6TJR\u00A6EEK\u00A6GQP\u00A6MDR\u00A6HKD\u00A6DKK\u00A6MDL\u00A6GQF\u00A6GQE\u00A6IDR\u00A6AED\u00A6KPW\u00A6IDN\u00A6BWP\u00A6MDC\u00A6IDJ\u00A6KPP\u00A6IDG\u00A6VUV\u00A6XID\u00A6SOS\u00A6ADP\u00A6RUR\u00A6GPF\u00A6DJF\u00A6ADD\u00A6MCG\u00A6MCF\u00A6ECV\u00A6ECS\u00A6LIF\u00A6RUB\u00A6PHP\u00A6UZS\u00A6COP\u00A6THB\u00A6IBP\u00A6BUR\u00A6COF\u00A6BUK\u00A6COB\u00A6UZC\u00A6UAK\u00A6QAR\u00A6UAH\u00A6GNS\u00A6CNY\u00A6MZM\u00A6CNX\u00A6UYU\u00A6GNI\u00A6SML\u00A6CNP\u00A6MZE\u00A6GNF\u00A6OMS\u00A6PGK\u00A6OMR\u00A6UYP\u00A6XFU\u00A6BTR\u00A6ZRZ\u00A6MAF\u00A6MAD\u00A6BTN\u00A6XFO\u00A6UYF\u00A6MYR\u00A6ZRN\u00A6AZM\u00A6GMP\u00A6KMF\u00A6SLL\u00A6GMD\u00A6XEU\u00A6BSP\u00A6CMF\u00A6MXV\u00A6XEF\u00A6BSD\u00A6MXP\u00A6MXN\u00A6PES\u00A6GLK\u00A6BRZ\u00A6PEN\u00A6CLP\u00A6SKK\u00A6PEI\u00A6BRR\u00A6XDR\u00A6FRG\u00A6FRF\u00A6BRN\u00A6CLF\u00A6CLE\u00A6BRL\u00A6CLC\u00A6BRE\u00A6DES\u00A6MWP\u00A6BRC\u00A6BRB\u00A6MWK\u00A6PDR\u00A6DEM\u00A6TDF\u00A6PDN\u00A6PDK\u00A6NPR\u00A6CKD\u00A6JPY\u00A6MVR\u00A6XCF\u00A6MVP\u00A6XCD\u00A6SIT\u00A6YUR\u00A6AWG\u00A6YUO\u00A6DDM\u00A6YUN\u00A6YUM\u00A6YUG\u00A6YUF\u00A6RON\u00A6YUD\u00A6ROL\u00A6SIB\u00A6NOK\u00A6MUR\u00A6XBD\u00A6GIP\u00A6VNS\u00A6XBC\u00A6VNR\u00A6XBB\u00A6XBA\u00A6KID\u00A6SHP\u00A6VNN";

  private static final String currenciesDisplayNameValues = "D\u00ednear Iord\u00e1nach\u00A6Mvdol Bolavach\u00A6\u00d3r\u00A6Kronur Oile\u00e1in Fhar\u00f3\u00A6Punt na Liob\u00e1ine\u00A6Euro\u00A6Dong V\u00edtneamach\u00A6Scilling na Tans\u00e1ine\u00A6Peso na Bolaive\u00A6Riel na Camb\u00f3ide\u00A6Aonad Airgeada\u00edochta na h\u00c1ise\u00A6Boliviano (1863-1962)\u00A6Sean-Riel na Camb\u00f3ide\u00A6Punt Saimbiach\u00A6Punt Astr\u00e1lach\u00A6CFA Franc BEAC\u00A6Punt Maltach\u00A6Cedi Athluachtha Gh\u00e1na\u00A6Kwacha Saimbiach\u00A6D\u00ednear \u00c1iseach Unit of Account\u00A6Punt Gh\u00e1na\u00A6Boliviano\u00A6Sean-Cedi Gh\u00e1na\u00A6Lira Maltach\u00A6Dollar Astr\u00e1lach\u00A6Dollar S.A.M. (an la c\u00e9anna)\u00A6Lira Iod\u00e1lach\u00A6Dollar S.A.M. (an ch\u00e9ad l\u00e1 eile)\u00A6Cedi Gh\u00e1na\u00A6Dollar Singeap\u00f3ir\u00A6Balboa Panamach\u00A6Kip Laosach\u00A6Som na Cirgeast\u00e1ine\u00A6Franc na hEilv\u00e9ise\u00A6Scilling Ostarach\u00A6Dollar S.A.M.\u00A6Dollar na hAet\u00f3ipe\u00A6Dollar Bhr\u00fain\u00e9\u00A6Punt Iam\u00e1cach\u00A6Birr na hAet\u00f3ipe\u00A6Franc Germinal Ailg\u00e9rach\u00A6Franc Nua Ailg\u00e9rach\u00A6D\u00ednear na hAilg\u00e9ire\u00A6Guarani Pharagua\u00A6Punt Libia\u00A6Dollar Iam\u00e1cach\u00A6Krona \u00cdoslannach\u00A6Peseta Sp\u00e1inneach\u00A6Punt Bheirmi\u00fada\u00A6D\u00ednear Libia\u00A6Lira \u00dadar\u00e1s M\u00edleata Briotanach Libia\u00A6Dollar Bheirmi\u00fada\u00A6Guilder \u00cdsilt\u00edreach\u00A6Ouguiya na Marat\u00e1ine\u00A6Rial Iar\u00e1nach\u00A6Krona Sualannach\u00A6Scilling C\u00e9iniach\u00A6CFA Franc Phoblacht na hAfraice L\u00e1ir\u00A6Peso na Airgint\u00edne\u00A6Peso na Airgint\u00edne (1983-1985)\u00A6Peso Moneda Nacional Airgint\u00edneach\u00A6Dollar Nua na T\u00e9av\u00e1ine\u00A6Punt na S\u00fad\u00e1ine\u00A6Lari na Gr\u00faise\u00A6Kupon Larit na Gr\u00faise\u00A6Franc Martinique\u00A6Punt Oile\u00e1in Fh\u00e1clainne\u00A6Austral Airgint\u00edneach\u00A6D\u00ednear na S\u00fad\u00e1ine\u00A6D\u00ednear Ir\u00e1cach\u00A6Dollar Tuvalu\u00A6R\u00faip\u00ed na S\u00e9is\u00e9il\u00A6R\u00fabal Laitviach\u00A6Punt Fhids\u00ed\u00A6Lats Laitviach\u00A6Zaire an Chong\u00f3\u00A6Franc Phoblacht an Chong\u00f3\u00A6Franc Congolais an Chong\u00f3\u00A6Dollar Fhids\u00ed\u00A6Cordoba Oro Nicearagua\u00A6Pataca Macao\u00A6Cordoba \u00d3r Nicearagua\u00A6Cordoba Nicearagua\u00A6R\u00fabal Inaistrithe COMECON\u00A6Markka Fionnlannach (1860-1962)\u00A6Markka Fionnlannach\u00A6Dollar Oile\u00e1in Solomon\u00A6Franc Lucsamburg\u00A6Sean-Dollar Oile\u00e1in na Tr\u00edon\u00f3ide agus Tob\u00e1ga\u00A6Escudo Ang\u00f3lach\u00A6Kwanza Reajustado Ang\u00f3lach (1995-1999)\u00A6Tugrik Mong\u00f3lach\u00A6Forint Ung\u00e1rach\u00A6Franc na Bur\u00faine\u00A6Kwanza Nua Ang\u00f3lach (1990-2000)\u00A6Kwanza Ang\u00f3lach (1977-1990)\u00A6Dollar Oile\u00e1in na Tr\u00edon\u00f3ide agus Tob\u00e1ga\u00A6Lilangeni na Suasalainne\u00A6CFP Franc Nua-Inse Ghall\u00A6Punt Steirling\u00A6Riyal S\u00e1dach\u00A6Talonas Liotu\u00e1nach\u00A6R\u00faip\u00ed India\u00A6Escudo Portaing\u00e9lach\u00A6Kwanza Ang\u00f3lach\u00A6Conto Portaing\u00e9alach\u00A6Lita Liotu\u00e1nach\u00A6Tenge Casacst\u00e1nach\u00A6R\u00fabal Casacst\u00e1nach\u00A6Dollar Oile\u00e1in Bhriotanacha na Maighdean\u00A6Punt N\u00edg\u00e9arach\u00A6Teastais Airgeadra Dollar Mhaenmar\u00A6Naira N\u00edg\u00e9arach\u00A6Gourde H\u00e1it\u00ed\u00A6Punt Siria\u00A6Punt Pailist\u00edneach\u00A6D\u00ednear na Bair\u00e9ine\u00A6Kyat Mhaenmar\u00A6Guilder na nAntill\u00ed \u00cdsilt\u00edreach\u00A6Koruna Phoblacht na Seice\u00A6Punt Steirling Oile\u00e1n Mhanann\u00A6Teastais Airgeadra\u00ed Lev Bulg\u00e1rach\u00A6Loti Leos\u00f3ta\u00A6CFA Franc na Gab\u00faine\u00A6Lev Bulg\u00e1rach (1879-1952)\u00A6Lev Nua Bulg\u00e1rach\u00A6Lev Bulg\u00e1rach S\u00f3isiala\u00edoch\u00A6Dollar Ceanada\u00A6Lev Bulg\u00e1rach Crua\u00A6Lira Turcach\u00A6Dollar Oile\u00e1in Cayman\u00A6Punt na Cipire\u00A6Sheqel Nua Iosraelach\u00A6Dollar na Gu\u00e1ine\u00A6Dram Airm\u00e9anach\u00A6Punt Iosraelach\u00A6Franc Mhail\u00ed\u00A6Sheqel Iosraelach\u00A6Bolivar Veinis\u00e9ala\u00A6Teastais Airgeadra\u00ed Dollar na hAlb\u00e1ine\u00A6Dollar na Lib\u00e9ire\u00A6Lek Valute Alb\u00e1nach\u00A6Kuna Cr\u00f3tach\u00A6Franc R\u00e9union\u00A6D\u00ednear na Cr\u00f3ite\u00A6Lek Alb\u00e1nach\u00A6Punt Steirling Gheirs\u00ed\u00A6Lek Alb\u00e1nach (1946-1961)\u00A6Denar na Macad\u00f3ine (1992-1993)\u00A6Viet Minh Piastre Dong Viet V\u00edtneam Thuaidh\u00A6Dong Nua V\u00edtneam Thuaidh\u00A6Denar na Macad\u00f3ine\u00A6Piastre Dong Viet V\u00edtneam Thuaidh\u00A6Pataca T\u00edom\u00f3ir\u00A6CFP Franc\u00A6Franc Beilgeach (airgead\u00fail)\u00A6Peso Guine-Bhissau\u00A6D\u00ednear Cu\u00e1tach\u00A6Mil Reis na Guine Portaing\u00e9ala\u00ed\u00A6Franc Beilgeach\u00A6Escudo T\u00edom\u00f3ir\u00A6Franc Beilgeach (inathraithe)\u00A6Escudo na Guine Portaing\u00e9ala\u00ed\u00A6Colon na Salvad\u00f3ire\u00A6Guilder Curacao\u00A6Taka Bhanglaid\u00e9iseach\u00A6Punt Steirling Tonga\u00A6Pa\u02bbanga Tonga\u00A6CFA Franc BCEAO\u00A6R\u00fabal S\u00f3v\u00e9adach\u00A6R\u00fabal Nua S\u00f3v\u00e9adach\u00A6Franc Germinal na Nua-Chalad\u00f3ine\u00A6Escudo na Rinne Verde\u00A6CFA Franc na nAntill\u00ed Francach\u00A6Rand na hAfraice Theas\u00A6Peso Doimineacach\u00A6Teastais Airgeadra\u00ed Ch\u00faba\u00A6Punt na hAfraice Theas\u00A6Rand na hAfraice Theas (airgead\u00fail)\u00A6D\u00ednear na T\u00fain\u00e9ise\u00A6Peso C\u00faba\u00A6Franc Guiana na Gu\u00e1ine Franca\u00ed\u00A6Scilling Uganda\u00A6R\u00faip\u00ed na Sioli\u00f3ne\u00A6Franc Affars agus Issas\u00A6Lira na Vatac\u00e1ine\u00A6Escudo Sao Tome agus Principe\u00A6Scilling Uganda (1966-1987)\u00A6Dobra Sao Tome agus Principe\u00A6Dollar Oile\u00e1in Marshall\u00A6Punt na Nua-Sh\u00e9alainne\u00A6Tala Sam\u00f3 Thiar\u00A6Punt Sam\u00f3 Thiar\u00A6Lempira Hond\u00farais\u00A6Nouveau Franc Ceannchathartha Francach\u00A6Manat na An Tuircm\u00e9anast\u00e1ine\u00A6Quetzal Guatamala\u00A6Dollar na Nua-Sh\u00e9alainne\u00A6Punt Albanach\u00A6Dollar Bharbad\u00f3is\u00A6Dollar na Namaibe\u00A6Franc Madagascar\u00A6Ariary Madagascar\u00A6Punt na h\u00c9igipte\u00A6Dollar Hond\u00farais Bhriotanaigh\u00A6Zloty Polannach (1950-1995)\u00A6D\u00ednear Nua Bhoisnia-Heirseagaiv\u00e9in\u00A6Teastais Airgeadra Dollar SAM Polannach\u00A6Marc Inathraithe Bhoisnia-Heirseagaiv\u00e9in\u00A6Dollar na Beil\u00edse\u00A6D\u00ednear Bhoisnia-Heirseagaiv\u00e9in\u00A6Zloty Polannach\u00A6Rial \u00c9imin\u00A6Guilder Shuranaim\u00A6Koruna Crua na Seicsl\u00f3vaice\u00A6Won na C\u00f3ir\u00e9 Theas\u00A6R\u00fabal B\u00e9alar\u00faiseach\u00A6Imadi Riyal \u00c9imin\u00A6R\u00fabal B\u00e9alar\u00faiseach (1992-1994)\u00A6Koruna na Seicsl\u00f3vaice\u00A6Sean-Won na C\u00f3ir\u00e9 Theas\u00A6Hwan na C\u00f3ir\u00e9 Theas\u00A6R\u00fabal Nua B\u00e9alar\u00faiseach (1994-1999)\u00A6Drachma Nua Gr\u00e9agach\u00A6R\u00faip\u00ed na Pacast\u00e1ine\u00A6Afgain\u00ed\u00A6Dollar Siomb\u00e1bach\u00A6R\u00faip\u00ed Sr\u00ed Lanca\u00A6Drachma Gr\u00e9agach\u00A6Punt \u00c9ireannach\u00A6Afgain\u00ed (1927-2002)\u00A6D\u00ednear \u00c9imin\u00A6Franc Ruanda\u00A6Colon Ch\u00f3sta R\u00edce\u00A6Somoni na T\u00e1ids\u00edceast\u00e1ine\u00A6R\u00fabal na T\u00e1ids\u00edceast\u00e1ine\u00A6Kroon na hEast\u00f3ine\u00A6Peseta Guineana na Guine Me\u00e1nchriosa\u00ed\u00A6R\u00fabal C\u00fap\u00f3in Mold\u00f3vach\u00A6Dollar Hong Cong\u00A6Krone Danmhargach\u00A6Leu Mold\u00f3vach\u00A6Franco na Guine Me\u00e1nchriosa\u00ed\u00A6Ekwele Guineana na Guine Me\u00e1nchriosa\u00ed\u00A6Rupiah Indin\u00e9iseach\u00A6Dirham Aontas na n\u00c9im\u00edr\u00edochta\u00ed Arabacha\u00A6Won na C\u00f3ir\u00e9 Thuaidh\u00A6Rupiah Nua Indin\u00e9iseach\u00A6Pula Botsu\u00e1nach\u00A6Leu C\u00fap\u00f3in Mold\u00f3vach\u00A6Java Rupiah Indin\u00e9iseach\u00A6Won Na nDaoine na C\u00f3ir\u00e9 Thuaidh\u00A6Nica Guilder Indin\u00e9iseach\u00A6Vatu Vanuat\u00fa\u00A6D\u00ednear Ioslamach\u00A6Scilling na S\u00f3m\u00e1ile\u00A6Peseta And\u00f3ra\u00A6R\u00fabal R\u00faiseach (1991-1998)\u00A6Franc Guadeloupe\u00A6Franc Djibouti\u00A6D\u00ednear And\u00f3ra\u00A6Franc Germinal Mhonac\u00f3\u00A6Franc Nouveau Mhonac\u00f3\u00A6Unidad de Valor Constante (UVC) Eacuad\u00f3ir\u00A6Sucre Eacuad\u00f3ir\u00A6Franc Lichtinst\u00e9in\u00A6R\u00fabal R\u00faiseach\u00A6Peso Filip\u00edneach\u00A6Sum na h\u00daisb\u00e9iceast\u00e1ine\u00A6Peso na Col\u00f3ime\u00A6Baht na T\u00e9alainne\u00A6Punt Thuaisceart \u00c9ireann\u00A6R\u00faip\u00ed Bhurma\u00A6CFA Franc Chong\u00f3\u00A6Kyat Burmach\u00A6Peso P\u00e1ip\u00e9ir na Col\u00f3ime\u00A6Som C\u00fap\u00f3in na h\u00daisb\u00e9iceast\u00e1ine\u00A6Karbovanetz \u00dacr\u00e1nach\u00A6Rial Catarach\u00A6Hryvnia \u00dacr\u00e1nach\u00A6Syli Guine\u00A6Yuan Renminbi S\u00edneach\u00A6Metical M\u00f3saimb\u00edce\u00A6Teastais Airgeadra\u00ed Dollar SAM S\u00edneach\u00A6Peso Uruguayo Uragua\u00A6Franc Guine (1960-1972)\u00A6Lira San Marino\u00A6Jen Min Piao Yuan S\u00edneach\u00A6Escudo M\u00f3saimb\u00edce\u00A6Franc Guine\u00A6Rial Saidi Omain\u00A6Kina Nua-Ghuine Phapua\u00A6Rial Omain\u00A6Peso Uragua (1975-1993)\u00A6UIC-Franc Francach\u00A6R\u00faip\u00ed na B\u00fat\u00e1ine\u00A6Zaire S\u00e1\u00edreach\u00A6Franc Mharac\u00f3\u00A6Dirham Mharac\u00f3\u00A6Ngultrum B\u00fat\u00e1nach\u00A6Franc \u00d3r Francach\u00A6Peso Fuerte Uragua\u00A6Ringgit Malaeisia\u00A6Zaire Nua S\u00e1\u00edreach\u00A6Manat Asarbaise\u00e1nach\u00A6Punt Gaimbia\u00A6Franc Chom\u00f3ra\u00A6Leone Shiarra Leon\u00A6Dalasi Gaimbia\u00A6Aonad Airgeadra Eorpach\u00A6Punt na mBah\u00e1ma\u00ed\u00A6CFA Franc Chamar\u00fain\u00A6Unidad de Inversion (UDI) Meicsiceo\u00A6CFA Franc BCEAEC\u00A6Dollar na mBah\u00e1ma\u00ed\u00A6Peso Airgid Meicsiceo (1861-1992)\u00A6Peso Meicsiceo\u00A6Sol Pheiri\u00fa\u00A6Krone na Graonlainne\u00A6Cruzeiro Brasa\u00edleach (1942-1967)\u00A6Sol Nuevo Pheiri\u00fa\u00A6Peso na Sile\u00A6Koruna na Sl\u00f3vaice\u00A6Inti Pheiri\u00fa\u00A6Cruzeiro Brasa\u00edleach\u00A6Cearta Speisialta Tarraingthe\u00A6Franc Germinal Francach/Franc Poincare\u00A6Franc Francach\u00A6Cruzado Novo Brasa\u00edleach\u00A6Unidades de Fomento na Sile\u00A6Escudo na Sile\u00A6Real Brasa\u00edleach\u00A6Condor na Sile\u00A6Cruzeiro Brasa\u00edleach (1990-1993)\u00A6Sperrmark Gearm\u00e1nach\u00A6Punt na Mal\u00e1ive\u00A6Cruzado Brasa\u00edleach\u00A6Cruzeiro Novo Brasa\u00edleach (1967-1986)\u00A6Kwacha na Mal\u00e1ive\u00A6Transdniestria R\u00fabal\u00A6Deutsche Mark\u00A6CFA Franc Sead\u00A6R\u00fabal Nua Transdniestria\u00A6R\u00fabal Cup\u00f3in Transdniestria\u00A6R\u00faip\u00ed Neipe\u00e1il\u00A6Dollar Oile\u00e1in Cook\u00A6Yen Seap\u00e1nach\u00A6Maldive Islands Rufiyaa\u00A6CFA Nouveau Franc\u00A6Maldive Islands R\u00faip\u00ed\u00A6Dollar Oirthear na Cairibe\u00A6Tolar Sl\u00f3v\u00e9nach\u00A6D\u00ednear Leasaithe I\u00fagslavach\u00A6Guilder Aruba\u00A6D\u00ednear Dheireadh F\u00f3mhar I\u00fagslavach\u00A6Ostmark na hOirGhearm\u00e1ine\u00A6D\u00ednear Inathraithe I\u00fagslavach\u00A6Noviy Dinar I\u00fagslavach\u00A6D\u00ednear 1994 I\u00fagslavach\u00A6D\u00ednear Ch\u00f3naidhm na hI\u00fagslaive\u00A6Leu Nua R\u00f3m\u00e1nach\u00A6D\u00ednear Crua I\u00fagslavach\u00A6Leu R\u00f3m\u00e1nach\u00A6Tolar Bons Sl\u00f3v\u00e9anach\u00A6Krone Ioruach\u00A6R\u00faip\u00ed Oile\u00e1n Mhuir\u00eds\u00A6Aonad Cuntais Eorpach (XBD)\u00A6Punt Ghiobr\u00e1ltair\u00A6Dong N\u00e1isi\u00fanta V\u00edtneamach\u00A6Aonad Cuntais Eorpach (XBC)\u00A6Dong Phoblacht V\u00edtneaim\u00A6Aonad Airgeada\u00edochta Eorpach\u00A6Aonad Ilchodach Eorpach\u00A6Dollar Chireabait\u00ed\u00A6Punt San H\u00e9ilin\u00A6Dong Nua V\u00edtneamach";

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

  private static final String currenciesSymbolKeys = "JOD\u00A6BOV\u00A6XAU\u00A6FOK\u00A6LBP\u00A6VND\u00A6TZS\u00A6BOP\u00A6KHR\u00A6XAM\u00A6BOL\u00A6KHO\u00A6ZMP\u00A6AUP\u00A6XAF\u00A6MTP\u00A6GHR\u00A6ZMK\u00A6XAD\u00A6GHP\u00A6BOB\u00A6GHO\u00A6MTL\u00A6AUD\u00A6USS\u00A6USN\u00A6GHC\u00A6SGD\u00A6PAB\u00A6LAK\u00A6KGS\u00A6CHF\u00A6ATS\u00A6ETD\u00A6BND\u00A6JMP\u00A6ETB\u00A6DZG\u00A6DZF\u00A6DZD\u00A6PYG\u00A6LYP\u00A6JMD\u00A6ISK\u00A6ESP\u00A6BMP\u00A6LYD\u00A6LYB\u00A6BMD\u00A6NLG\u00A6MRO\u00A6IRR\u00A6SEK\u00A6KES\u00A6CFF\u00A6ARS\u00A6ARP\u00A6ARM\u00A6TWD\u00A6SDP\u00A6GEL\u00A6GEK\u00A6MQF\u00A6FKP\u00A6ARA\u00A6SDD\u00A6IQD\u00A6TVD\u00A6SCR\u00A6LVR\u00A6FJP\u00A6LVL\u00A6CDL\u00A6CDG\u00A6CDF\u00A6FJD\u00A6NIO\u00A6MOP\u00A6NIG\u00A6NIC\u00A6XTR\u00A6FIN\u00A6FIM\u00A6SBD\u00A6LUF\u00A6TTO\u00A6AOS\u00A6AOR\u00A6MNT\u00A6HUF\u00A6BIF\u00A6AON\u00A6AOK\u00A6TTD\u00A6SZL\u00A6NHF\u00A6SAR\u00A6LTT\u00A6PTE\u00A6AOA\u00A6PTC\u00A6LTL\u00A6KZT\u00A6KZR\u00A6VGD\u00A6NGP\u00A6MMX\u00A6NGN\u00A6HTG\u00A6SYP\u00A6PSP\u00A6BHD\u00A6MMK\u00A6ANG\u00A6CZK\u00A6IMP\u00A6BGX\u00A6LSL\u00A6GAF\u00A6BGO\u00A6BGN\u00A6BGM\u00A6CAD\u00A6BGL\u00A6TRL\u00A6KYD\u00A6CYP\u00A6ILS\u00A6GYD\u00A6AMD\u00A6ILP\u00A6MLF\u00A6ILL\u00A6VEB\u00A6ALX\u00A6LRD\u00A6ALV\u00A6HRK\u00A6REF\u00A6HRD\u00A6ALL\u00A6JEP\u00A6ALK\u00A6MKN\u00A6VDP\u00A6VDN\u00A6MKD\u00A6VDD\u00A6TPP\u00A6XPF\u00A6BEL\u00A6GWP\u00A6KWD\u00A6GWM\u00A6BEF\u00A6TPE\u00A6BEC\u00A6GWE\u00A6SVC\u00A6CWG\u00A6BDT\u00A6TOS\u00A6TOP\u00A6XOF\u00A6SUR\u00A6SUN\u00A6NCF\u00A6CVE\u00A6XNF\u00A6ZAR\u00A6DOP\u00A6CUX\u00A6ZAP\u00A6ZAL\u00A6TND\u00A6CUP\u00A6GUF\u00A6UGX\u00A6LNR\u00A6AIF\u00A6VAL\u00A6STE\u00A6UGS\u00A6STD\u00A6MHD\u00A6NZP\u00A6WST\u00A6WSP\u00A6HNL\u00A6XMF\u00A6TMM\u00A6GTQ\u00A6NZD\u00A6SSP\u00A6BBD\u00A6NAD\u00A6MGF\u00A6MGA\u00A6EGP\u00A6BZH\u00A6PLZ\u00A6BAN\u00A6PLX\u00A6BAM\u00A6BZD\u00A6BAD\u00A6PLN\u00A6YER\u00A6SRG\u00A6CSK\u00A6KRW\u00A6BYR\u00A6YEI\u00A6BYL\u00A6CSC\u00A6KRO\u00A6KRH\u00A6BYB\u00A6GRN\u00A6PKR\u00A6AFN\u00A6ZWD\u00A6LKR\u00A6GRD\u00A6IEP\u00A6AFA\u00A6YDD\u00A6RWF\u00A6CRC\u00A6TJS\u00A6TJR\u00A6EEK\u00A6GQP\u00A6MDR\u00A6HKD\u00A6DKK\u00A6MDL\u00A6GQF\u00A6GQE\u00A6IDR\u00A6AED\u00A6KPW\u00A6IDN\u00A6BWP\u00A6MDC\u00A6IDJ\u00A6KPP\u00A6IDG\u00A6VUV\u00A6XID\u00A6SOS\u00A6ADP\u00A6RUR\u00A6GPF\u00A6DJF\u00A6ADD\u00A6MCG\u00A6MCF\u00A6ECV\u00A6ECS\u00A6LIF\u00A6RUB\u00A6PHP\u00A6UZS\u00A6COP\u00A6THB\u00A6IBP\u00A6BUR\u00A6COF\u00A6BUK\u00A6COB\u00A6UZC\u00A6UAK\u00A6QAR\u00A6UAH\u00A6GNS\u00A6CNY\u00A6MZM\u00A6CNX\u00A6UYU\u00A6GNI\u00A6SML\u00A6MZE\u00A6CNP\u00A6PGK\u00A6OMS\u00A6GNF\u00A6OMR\u00A6UYP\u00A6XFU\u00A6BTR\u00A6ZRZ\u00A6MAF\u00A6MAD\u00A6BTN\u00A6XFO\u00A6UYF\u00A6MYR\u00A6ZRN\u00A6AZM\u00A6GMP\u00A6KMF\u00A6SLL\u00A6GMD\u00A6XEU\u00A6BSP\u00A6CMF\u00A6MXV\u00A6XEF\u00A6BSD\u00A6MXP\u00A6MXN\u00A6PES\u00A6GLK\u00A6BRZ\u00A6PEN\u00A6CLP\u00A6SKK\u00A6PEI\u00A6BRR\u00A6XDR\u00A6FRG\u00A6FRF\u00A6BRN\u00A6CLF\u00A6CLE\u00A6BRL\u00A6CLC\u00A6BRE\u00A6DES\u00A6MWP\u00A6BRC\u00A6BRB\u00A6MWK\u00A6PDR\u00A6DEM\u00A6TDF\u00A6PDN\u00A6PDK\u00A6NPR\u00A6CKD\u00A6MVR\u00A6XCF\u00A6MVP\u00A6XCD\u00A6SIT\u00A6YUR\u00A6AWG\u00A6YUO\u00A6DDM\u00A6YUN\u00A6YUM\u00A6YUG\u00A6YUF\u00A6RON\u00A6YUD\u00A6ROL\u00A6SIB\u00A6NOK\u00A6MUR\u00A6XBD\u00A6GIP\u00A6VNS\u00A6XBC\u00A6VNR\u00A6XBB\u00A6XBA\u00A6KID\u00A6SHP\u00A6VNN";

  private static final String currenciesSymbolValues = "JD\u00A6BOV\u00A6XAU\u00A6FOK\u00A6LL\u00A6VND\u00A6T Sh\u00A6BOP\u00A6CR\u00A6XAM\u00A6BOL\u00A6KHO\u00A6ZMP\u00A6AUP\u00A6XAF\u00A6MTP\u00A6GHR\u00A6ZMK\u00A6XAD\u00A6GHP\u00A6Bs\u00A6GHO\u00A6Lm\u00A6A$\u00A6USS\u00A6USN\u00A6GHC\u00A6S$\u00A6PAB\u00A6LAK\u00A6som\u00A6CHF\u00A6ATS\u00A6ETD\u00A6BND\u00A6JMP\u00A6Br\u00A6DZG\u00A6DZF\u00A6DA\u00A6PYG\u00A6LYP\u00A6J$\u00A6ISK\u00A6ESP\u00A6BMP\u00A6LD\u00A6LYB\u00A6Ber$\u00A6NLG\u00A6UM\u00A6RI\u00A6SKr\u00A6K Sh\u00A6CFF\u00A6Arg$\u00A6ARP\u00A6ARM\u00A6NT$\u00A6SDP\u00A6lari\u00A6GEK\u00A6MQF\u00A6FKP\u00A6ARA\u00A6SDD\u00A6ID\u00A6TVD\u00A6SR\u00A6LVR\u00A6FJP\u00A6LVL\u00A6CDL\u00A6CDG\u00A6CDF\u00A6F$\u00A6NIO\u00A6MOP\u00A6NIG\u00A6NIC\u00A6XTR\u00A6FIN\u00A6FIM\u00A6SI$\u00A6LUF\u00A6TTO\u00A6AOS\u00A6AOR\u00A6Tug\u00A6Ft\u00A6Fbu\u00A6AON\u00A6AOK\u00A6TT$\u00A6E\u00A6NHF\u00A6SRl\u00A6LTT\u00A6PTE\u00A6AOA\u00A6PTC\u00A6LTL\u00A6T\u00A6KZR\u00A6VGD\u00A6NGP\u00A6MMX\u00A6NGN\u00A6HTG\u00A6LS\u00A6PSP\u00A6BD\u00A6MMK\u00A6A\u00cd f.\u00A6CZK\u00A6IMP\u00A6BGX\u00A6M\u00A6GAF\u00A6BGO\u00A6BGN\u00A6BGM\u00A6Can$\u00A6lev\u00A6TL\u00A6KYD\u00A6\u00a3C\u00A6ILS\u00A6G$\u00A6dram\u00A6ILP\u00A6MLF\u00A6ILL\u00A6Be\u00A6ALX\u00A6LRD\u00A6ALV\u00A6HRK\u00A6REF\u00A6HRD\u00A6lek\u00A6JEP\u00A6ALK\u00A6MKN\u00A6VDP\u00A6VDN\u00A6MDen\u00A6VDD\u00A6TPP\u00A6CFPF\u00A6BEL\u00A6GWP\u00A6KD\u00A6GWM\u00A6BF\u00A6TPE\u00A6BEC\u00A6GWE\u00A6SVC\u00A6CWG\u00A6Tk\u00A6TOS\u00A6T$\u00A6XOF\u00A6SUR\u00A6SUN\u00A6NCF\u00A6CVEsc\u00A6XNF\u00A6R\u00A6RD$\u00A6CUX\u00A6ZAP\u00A6ZAL\u00A6TND\u00A6CUP\u00A6GUF\u00A6U Sh\u00A6LNR\u00A6AIF\u00A6VAL\u00A6STE\u00A6UGS\u00A6Db\u00A6MHD\u00A6NZP\u00A6WST\u00A6WSP\u00A6L\u00A6XMF\u00A6TMM\u00A6Q\u00A6$NZ\u00A6SSP\u00A6BDS$\u00A6N$\u00A6MGF\u00A6MGA\u00A6EGP\u00A6BZH\u00A6PLZ\u00A6BAN\u00A6PLX\u00A6KM\u00A6BZ$\u00A6BAD\u00A6Zl\u00A6YRl\u00A6Sf\u00A6CSK\u00A6KRW\u00A6Rbl\u00A6YEI\u00A6BYL\u00A6CSC\u00A6KRO\u00A6KRH\u00A6BYB\u00A6GRN\u00A6Pra\u00A6Af\u00A6Z$\u00A6SL Re\u00A6GRD\u00A6IR\u00a3\u00A6AFA\u00A6YDD\u00A6RWF\u00A6C\u00A6TJS\u00A6TJR\u00A6EEK\u00A6GQP\u00A6MDR\u00A6HK$\u00A6DKr\u00A6MDL\u00A6GQF\u00A6GQE\u00A6Rp\u00A6AED\u00A6KPW\u00A6IDN\u00A6BWP\u00A6MDC\u00A6IDJ\u00A6KPP\u00A6IDG\u00A6VT\u00A6XID\u00A6So. Sh.\u00A6ADP\u00A6RUR\u00A6GPF\u00A6DF\u00A6ADD\u00A6MCG\u00A6MCF\u00A6ECV\u00A6ECS\u00A6LIF\u00A6RUB\u00A6PHP\u00A6UZS\u00A6Col$\u00A6THB\u00A6IBP\u00A6BUR\u00A6COF\u00A6BUK\u00A6COB\u00A6UZC\u00A6UAK\u00A6QR\u00A6UAH\u00A6GNS\u00A6Y\u00A6Mt\u00A6CNX\u00A6Ur$\u00A6GNI\u00A6SML\u00A6MZE\u00A6CNP\u00A6PGK\u00A6OMS\u00A6GF\u00A6RO\u00A6UYP\u00A6XFU\u00A6BTR\u00A6ZRZ\u00A6MAF\u00A6MAD\u00A6Nu\u00A6XFO\u00A6UYF\u00A6RM\u00A6ZRN\u00A6AZM\u00A6GMP\u00A6CF\u00A6SLL\u00A6GMD\u00A6XEU\u00A6BSP\u00A6CMF\u00A6MXV\u00A6XEF\u00A6BSD\u00A6MXP\u00A6MEX$\u00A6PES\u00A6GLK\u00A6BRZ\u00A6PEN\u00A6Ch$\u00A6Sk\u00A6PEI\u00A6BRR\u00A6XDR\u00A6FRG\u00A6FRF\u00A6BRN\u00A6CLF\u00A6CLE\u00A6R$\u00A6CLC\u00A6BRE\u00A6DES\u00A6MWP\u00A6BRC\u00A6BRB\u00A6MK\u00A6PDR\u00A6DEM\u00A6TDF\u00A6PDN\u00A6PDK\u00A6Nrs\u00A6CKD\u00A6MVR\u00A6XCF\u00A6MVP\u00A6EC$\u00A6SIT\u00A6YUR\u00A6AWG\u00A6YUO\u00A6DDM\u00A6YUN\u00A6YUM\u00A6YUG\u00A6YUF\u00A6RON\u00A6YUD\u00A6leu\u00A6SIB\u00A6NKr\u00A6MUR\u00A6XBD\u00A6GIP\u00A6VNS\u00A6XBC\u00A6VNR\u00A6XBB\u00A6XBA\u00A6KID\u00A6SHP\u00A6VNN";

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
    "Ean",
    "Feabh",
    "M\u00e1rta",
    "Aib",
    "Beal",
    "Meith",
    "I\u00fail",
    "L\u00fan",
    "MF\u00f3mh",
    "DF\u00f3mh",
    "Samh",
    "Noll",
    null,
  };

  private static final String[] months = {
    "Ean\u00e1ir",
    "Feabhra",
    "M\u00e1rta",
    "Aibre\u00e1n",
    "Bealtaine",
    "Meitheamh",
    "I\u00fail",
    "L\u00fanasa",
    "Me\u00e1n F\u00f3mhair",
    "Deireadh F\u00f3mhair",
    "Samhain",
    "Nollaig",
    null,
  };

  private static final String[] shortWeekdays = {
    null,
    "Domh",
    "Luan",
    "M\u00e1irt",
    "C\u00e9ad",
    "D\u00e9ar",
    "Aoine",
    "Sath",
  };

  private static final String[] weekdays = {
    null,
    "D\u00e9 Domhnaigh",
    "D\u00e9 Luain",
    "D\u00e9 M\u00e1irt",
    "D\u00e9 C\u00e9adaoin",
    "D\u00e9ardaoin",
    "D\u00e9 hAoine",
    "D\u00e9 Sathairn",
  };

  private static final String[] eras = {
    "RC",
    "AD",
  };

  private static final String[] ampms = {
    "a.m.",
    "p.m.",
  };

  private static final String[][] zoneStrings =
  {
    {  "Etc/GMT", "MAG", "Me\u00e1n-Am Greenwich", "MAG", "Me\u00e1n-Am Greenwich"},
    {  "Europe/Dublin", "MAG", "Me\u00e1n-Am Greenwich", "AS\u00c9", "Am Samhraidh na h\u00c9ireann"},
    {  "Europe/Belfast", "MAG", "Me\u00e1n-Am Greenwich", "ASB", "Am Samhraidh na Breataine"},
    {  "Europe/London", "MAG", "Me\u00e1n-Am Greenwich", "ASB", "Am Samhraidh na Breataine"},
  };

  private static final String territoriesKeys = "TL\u00A6TK\u00A6TJ\u00A6TH\u00A6TG\u00A6TF\u00A6GY\u00A6TD\u00A6TC\u00A6GW\u00A6GU\u00A6GT\u00A6GS\u00A6GR\u00A6GQ\u00A6GP\u00A6SZ\u00A6SY\u00A6GN\u00A6GM\u00A6GL\u00A6SV\u00A6ST\u00A6GI\u00A6GH\u00A6SR\u00A6GF\u00A6GE\u00A6SO\u00A6GD\u00A6SN\u00A6SM\u00A6GB\u00A6SL\u00A6GA\u00A6SK\u00A6SJ\u00A6SI\u00A6SH\u00A6SG\u00A6SE\u00A6SD\u00A6SC\u00A6SB\u00A6SA\u00A6FR\u00A6FO\u00A6FM\u00A6RW\u00A6FK\u00A6RU\u00A6FJ\u00A6FI\u00A6RO\u00A6RE\u00A6ET\u00A6ES\u00A6ER\u00A6EH\u00A6EG\u00A6EE\u00A6EC\u00A6DZ\u00A6QA\u00A6DO\u00A6PY\u00A6DM\u00A6PW\u00A6DK\u00A6DJ\u00A6PT\u00A6PS\u00A6PR\u00A6DE\u00A6PN\u00A6PM\u00A6PL\u00A6PK\u00A6PH\u00A6PG\u00A6PF\u00A6CZ\u00A6PE\u00A6CY\u00A6CX\u00A6CV\u00A6PA\u00A6CU\u00A6CR\u00A6CO\u00A6CN\u00A6CM\u00A6CL\u00A6CK\u00A6CI\u00A6CH\u00A6CG\u00A6CF\u00A6CD\u00A6CC\u00A6OM\u00A6CA\u00A6BZ\u00A6BY\u00A6BW\u00A6BV\u00A6BT\u00A6BS\u00A6BR\u00A6NZ\u00A6BO\u00A6BN\u00A6BM\u00A6NU\u00A6BJ\u00A6BI\u00A6BH\u00A6NR\u00A6BG\u00A6BF\u00A6NP\u00A6BE\u00A6NO\u00A6BD\u00A6BB\u00A6ZW\u00A6NL\u00A6BA\u00A6NI\u00A6NG\u00A6NF\u00A6AZ\u00A6NE\u00A6NC\u00A6AW\u00A6ZM\u00A6NA\u00A6AU\u00A6AT\u00A6AS\u00A6AR\u00A6AQ\u00A6MZ\u00A6AO\u00A6MY\u00A6AN\u00A6MX\u00A6AM\u00A6MW\u00A6AL\u00A6MV\u00A6ZA\u00A6MU\u00A6MT\u00A6AI\u00A6MS\u00A6MR\u00A6AG\u00A6MQ\u00A6AF\u00A6MP\u00A6AE\u00A6MO\u00A6AD\u00A6MN\u00A6MM\u00A6ML\u00A6MK\u00A6YU\u00A6YT\u00A6MH\u00A6MG\u00A6MD\u00A6MC\u00A6MA\u00A6YE\u00A6LY\u00A6LV\u00A6LU\u00A6LT\u00A6LS\u00A6LR\u00A6LK\u00A6LI\u00A6LC\u00A6LB\u00A6LA\u00A6KZ\u00A6KY\u00A6KW\u00A6KR\u00A6KP\u00A6KN\u00A6KM\u00A6KI\u00A6WS\u00A6KH\u00A6KG\u00A6KE\u00A6WF\u00A6JP\u00A6JO\u00A6JM\u00A6VU\u00A6VN\u00A6VI\u00A6VG\u00A6VE\u00A6VC\u00A6VA\u00A6IT\u00A6IS\u00A6IR\u00A6IQ\u00A6UZ\u00A6IO\u00A6UY\u00A6IN\u00A6IL\u00A6US\u00A6IE\u00A6ID\u00A6UM\u00A6UG\u00A6UA\u00A6HU\u00A6HT\u00A6HR\u00A6TZ\u00A6HN\u00A6HM\u00A6TW\u00A6TV\u00A6HK\u00A6TT\u00A6TR\u00A6TO\u00A6TN\u00A6TM";

  private static final String territoriesValues = "T\u00edom\u00f3r-Leste\u00A6T\u00f3cal\u00e1\u00A6An T\u00e1ids\u00edceast\u00e1in\u00A6An T\u00e9alainn\u00A6T\u00f3ga\u00A6Cr\u00edocha Francacha Theas\u00A6An Ghu\u00e1in\u00A6Sead\u00A6Oile\u00e1in Turks agus Caicos\u00A6An Ghuine-Bhissau\u00A6Guam\u00A6Guatamala\u00A6An tSeoirsia Theas agus Oile\u00e1in Sandwich Theas\u00A6An Ghr\u00e9ig\u00A6An Ghuine Mhe\u00e1nchriosach\u00A6Guadal\u00faip\u00A6An tSuasalainn\u00A6An tSiria\u00A6An Ghuine\u00A6An Ghaimbia\u00A6An Ghraonlainn\u00A6An tSalvad\u00f3ir\u00A6Sao Tome agus Principe\u00A6Giobr\u00e1ltar\u00A6G\u00e1na\u00A6Suranam\u00A6An Ghu\u00e1in Fhrancach\u00A6An tSeoirsia\u00A6An tSom\u00e1il\u00A6Grenada\u00A6An tSeineag\u00e1il\u00A6San Mair\u00edne\u00A6An R\u00edocht Aontaithe\u00A6Siarra Leon\u00A6An Ghab\u00fain\u00A6An tSl\u00f3vaic\u00A6Svalbard agus Jan Mayen\u00A6An tSl\u00f3v\u00e9in\u00A6San H\u00e9ilin\u00A6Singeap\u00f3r\u00A6An tSualainn\u00A6An tS\u00fad\u00e1in\u00A6Na S\u00e9is\u00e9il\u00A6Oile\u00e1in Solomon\u00A6An Araib Sh\u00e1dach\u00A6An Fhrainc\u00A6Oile\u00e1in Fhar\u00f3\u00A6An Mhicrin\u00e9is\u00A6Ruanda\u00A6Oile\u00e1in Fh\u00e1clainne\u00A6C\u00f3naidhm na R\u00faise\u00A6Fids\u00ed\u00A6An Fhionlainn\u00A6An R\u00f3m\u00e1in\u00A6R\u00e9union\u00A6An Aet\u00f3ip\u00A6An Sp\u00e1inn\u00A6Eritrea\u00A6An Sah\u00e1ra Thiar\u00A6An \u00c9igipt\u00A6An East\u00f3in\u00A6Eacuad\u00f3r\u00A6An Ailg\u00e9ir\u00A6Catar\u00A6An Phoblacht Dhoiminiceach\u00A6Paragua\u00A6Doiminice\u00A6Palau\u00A6An Danmhairg\u00A6Djibouti\u00A6An Phortaing\u00e9il\u00A6Na Cr\u00edocha Pailist\u00edneacha\u00A6Port\u00f3 R\u00edce\u00A6An Ghearm\u00e1in\u00A6Pitcairn\u00A6Saint Pierre agus Miquelon\u00A6An Pholainn\u00A6An Phacast\u00e1in\u00A6Na hOile\u00e1in Fhilip\u00edneacha\u00A6Nua-Ghuine Phapua\u00A6An Pholain\u00e9is Fhrancach\u00A6Poblacht na Seice\u00A6Peiri\u00fa\u00A6An Chipir\u00A6Oile\u00e1n na Nollag\u00A6Rinn Verde\u00A6Panama\u00A6C\u00faba\u00A6C\u00f3sta R\u00edce\u00A6An Chol\u00f3im\u00A6An tS\u00edn\u00A6Camar\u00fan\u00A6An tSile\u00A6Oile\u00e1in Cook\u00A6An C\u00f3sta Eabhair\u00A6An Eilv\u00e9is\u00A6An Cong\u00f3\u00A6Poblacht na hAfraice L\u00e1ir\u00A6Poblacht Dhaonlathach an Chong\u00f3\u00A6Oile\u00e1in Cocos (Keeling)\u00A6Oman\u00A6Ceanada\u00A6An Bheil\u00eds\u00A6An Bhealar\u00fais\u00A6An Bhotsu\u00e1in\u00A6Oile\u00e1in Bouvet\u00A6An Bh\u00fat\u00e1in\u00A6Na Bah\u00e1ma\u00ed\u00A6An Bhrasa\u00edl\u00A6An Nua-Sh\u00e9alainn\u00A6An Bholaiv\u00A6Br\u00fain\u00e9\u00A6Beirmi\u00fada\u00A6Niue\u00A6Beinin\u00A6An Bhur\u00fain\u00A6Bair\u00e9in\u00A6N\u00e1r\u00fa\u00A6An Bhulg\u00e1ir\u00A6Buirc\u00edne Fas\u00f3\u00A6Neipeal\u00A6An Bheilg\u00A6An Iorua\u00A6An Bhanglaid\u00e9is\u00A6Barbad\u00f3s\u00A6An tSiomb\u00e1ib\u00A6An \u00cdsilt\u00edr\u00A6An Bhoisnia-Heirseagaiv\u00e9in\u00A6Nicearagua\u00A6An Nig\u00e9ir\u00A6Oile\u00e1n Norfolk\u00A6An Asarbaise\u00e1in\u00A6An N\u00edgir\u00A6An Nua-Chalad\u00f3in\u00A6Aruba\u00A6An tSaimbia\u00A6An Namaib\u00A6An Astr\u00e1il\u00A6An Ostair\u00A6Sam\u00f3 Meirice\u00e1nach\u00A6An Airgint\u00edn\u00A6An Antartaice\u00A6M\u00f3saimb\u00edc\u00A6Ang\u00f3la\u00A6An Mhalaeisia\u00A6Antill\u00ed na h\u00cdsilt\u00edre\u00A6Meicsiceo\u00A6An Airm\u00e9in\u00A6An Mhal\u00e1iv\u00A6An Alb\u00e1in\u00A6Mhaildiv\u00ed\u00A6An Afraic Theas\u00A6Oile\u00e1n Mhuir\u00eds\u00A6M\u00e1lta\u00A6Anguilla\u00A6Montsarat\u00A6An Mharat\u00e1in\u00A6Antigua agus Barbuda\u00A6Martinique\u00A6An Afganast\u00e1in\u00A6Oile\u00e1in Mariana Thuaidh\u00A6Aontas na n\u00c9im\u00edr\u00edochta\u00ed Arabacha\u00A6Mac\u00e1\u00f3 (R.R.S. na S\u00edne)\u00A6And\u00f3ra\u00A6An Mhong\u00f3il\u00A6Maenmar\u00A6Mail\u00ed\u00A6An Mhacad\u00f3in\u00A6An I\u00fagslaiv\u00A6Mayotte\u00A6Oile\u00e1in Marshall\u00A6Madagascar\u00A6An Mhold\u00f3iv\u00A6Monac\u00f3\u00A6Marac\u00f3\u00A6\u00c9imin\u00A6An Libia\u00A6An Laitvia\u00A6Lucsamburg\u00A6An Liotu\u00e1in\u00A6Leos\u00f3ta\u00A6An Lib\u00e9ir\u00A6Sr\u00ed Lanca\u00A6Lichtinst\u00e9in\u00A6Saint Lucia\u00A6An Liob\u00e1in\u00A6Laos\u00A6An Chasacst\u00e1in\u00A6Oile\u00e1in Cayman\u00A6Cu\u00e1it\u00A6An Ch\u00f3ir\u00e9 Theas\u00A6An Ch\u00f3ir\u00e9 Thuaidh\u00A6Saint Kitts agus Nevis\u00A6Oile\u00e1in Chom\u00f3ra\u00A6Cireabait\u00ed\u00A6Sam\u00f3\u00A6An Chamb\u00f3id\u00A6An Chirgeast\u00e1in\u00A6An Ch\u00e9inia\u00A6Oile\u00e1in Vail\u00eds agus Fut\u00fana\u00A6An tSeap\u00e1in\u00A6An Iord\u00e1in\u00A6Iam\u00e1ice\u00A6Vanuat\u00fa\u00A6V\u00edtneam\u00A6Oile\u00e1in na Maighdean S.A.M.\u00A6Oile\u00e1in Bhriotanacha na Maighdean\u00A6Veinis\u00e9ala\u00A6Saint Vincent agus na Grenadines\u00A6An Chathaoir Naofa (St\u00e1t Chathair na Vatac\u00e1ine)\u00A6An Iod\u00e1il\u00A6An \u00cdoslainn\u00A6An Iar\u00e1in\u00A6An Iar\u00e1ic\u00A6\u00daisb\u00e9iceast\u00e1in\u00A6Cr\u00edocha Briotanacha an Aig\u00e9in Indiagh\u00A6Urugua\u00A6An India\u00A6Iosrael\u00A6St\u00e1it Aontaithe Mheirice\u00e1\u00A6\u00c9ire\u00A6An Indin\u00e9is\u00A6Mion-Oile\u00e1in Imeallacha S.A.M.\u00A6Uganda\u00A6An \u00dacr\u00e1in\u00A6An Ung\u00e1ir\u00A6H\u00e1it\u00ed\u00A6An Chr\u00f3it\u00A6An Tans\u00e1in\u00A6Hond\u00faras\u00A6Oile\u00e1n Heard agus Oile\u00e1in McDonald\u00A6An T\u00e9av\u00e1in\u00A6Tuval\u00fa\u00A6Hong Cong (R.R.S. na S\u00edne)\u00A6Oile\u00e1in na Tr\u00edon\u00f3ide agus Tob\u00e1ga\u00A6An Tuirc\u00A6Tonga\u00A6An T\u00fain\u00e9is\u00A6An Tuircm\u00e9anast\u00e1in";

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

  private static final String languagesKeys = "es\u00A6kw\u00A6eo\u00A6ks\u00A6en\u00A6el\u00A6qu\u00A6ko\u00A6kn\u00A6kk\u00A6ka\u00A6wa\u00A6jv\u00A6pt\u00A6ps\u00A6de\u00A6pl\u00A6da\u00A6ja\u00A6vi\u00A6cy\u00A6pa\u00A6cv\u00A6cu\u00A6cs\u00A6cr\u00A6iu\u00A6it\u00A6co\u00A6is\u00A6haw\u00A6uz\u00A6io\u00A6os\u00A6ik\u00A6ce\u00A6ur\u00A6ca\u00A6ie\u00A6id\u00A6uk\u00A6ia\u00A6oc\u00A6hy\u00A6bs\u00A6br\u00A6hu\u00A6bo\u00A6bn\u00A6hr\u00A6nv\u00A6ty\u00A6bg\u00A6tt\u00A6no\u00A6be\u00A6nn\u00A6hi\u00A6tr\u00A6nl\u00A6zu\u00A6ba\u00A6he\u00A6tl\u00A6ne\u00A6az\u00A6th\u00A6nb\u00A6na\u00A6zh\u00A6as\u00A6ar\u00A6ta\u00A6gv\u00A6gu\u00A6my\u00A6mt\u00A6sw\u00A6mr\u00A6sv\u00A6af\u00A6mo\u00A6ae\u00A6mn\u00A6sr\u00A6sq\u00A6ml\u00A6ab\u00A6mk\u00A6aa\u00A6so\u00A6mi\u00A6gd\u00A6sm\u00A6sl\u00A6mg\u00A6sk\u00A6ga\u00A6sh\u00A6se\u00A6yi\u00A6sd\u00A6fy\u00A6sc\u00A6sa\u00A6fr\u00A6lv\u00A6lt\u00A6fo\u00A6ru\u00A6lo\u00A6fj\u00A6fi\u00A6ro\u00A6fa\u00A6lb\u00A6la\u00A6eu\u00A6ky\u00A6et";

  private static final String languagesValues = "Sp\u00e1innis\u00A6Cornais\u00A6Esperanto\u00A6Caism\u00edris\u00A6B\u00e9arla\u00A6Gr\u00e9igis\u00A6Ceatsuais\u00A6C\u00f3ir\u00e9is\u00A6Cannadais\u00A6Casachais\u00A6Seoirsis\u00A6Vall\u00fanais\u00A6I\u00e1vais\u00A6Portaing\u00e9ilis\u00A6Paisteo\u00A6Gearm\u00e1inis\u00A6Polainnis\u00A6Danmhairgis\u00A6Seap\u00e1inis\u00A6V\u00edtneamais\u00A6Breatnais\u00A6Puinseaibis\u00A6Suvaisis\u00A6Slavais na hEaglaise\u00A6Seicis\u00A6Cra\u00edais\u00A6Ion\u00faitis\u00A6Iod\u00e1ilis\u00A6Corsaicis\u00A6\u00cdoslainnais\u00A6Hav\u00e1\u00edais\u00A6\u00daisb\u00e9icis\u00A6Ido\u00A6\u00d3is\u00e9itis\u00A6Inupiaq\u00A6Sisinis\u00A6Urdais\u00A6Catal\u00f3inis\u00A6Interlingue\u00A6Indin\u00e9isis\u00A6\u00dacr\u00e1inis\u00A6Interlingua\u00A6Ocat\u00e1inis (tar \u00e9is 1500); Proven\u00e7al\u00A6Airm\u00e9inis\u00A6Boisnis\u00A6Briot\u00e1inis\u00A6Ung\u00e1iris\u00A6Tib\u00e9adais\u00A6Beang\u00e1lais\u00A6Cr\u00f3itis\u00A6Navach\u00f3is\u00A6Taih\u00edtis\u00A6Bulg\u00e1iris\u00A6Tatarais\u00A6Ioruais\u00A6Bealar\u00faisis\u00A6Ioruais Nynorsk\u00A6Hiond\u00fais\u00A6Tuircis\u00A6Ollainnais\u00A6S\u00fal\u00fais\u00A6Baisc\u00edris\u00A6Eabhrais\u00A6Tag\u00e1laigis\u00A6Neipealais\u00A6Asarbaise\u00e1inis\u00A6T\u00e9alainnis\u00A6Ioruais Bokm\u00e5l\u00A6N\u00e1r\u00fais\u00A6S\u00ednis\u00A6Asaimis\u00A6Araibis\u00A6Tamailis\u00A6Mannainis\u00A6G\u00faisear\u00e1itis\u00A6Burmais\u00A6Maltais\u00A6Svaha\u00edlis\u00A6Maraitis\u00A6Sualainnis\u00A6Afrac\u00e1inis\u00A6Mold\u00e1ivis\u00A6Aiv\u00e9istis\u00A6Mong\u00f3ilis\u00A6Seirbis\u00A6Alb\u00e1inis\u00A6Mail\u00e9alaimis\u00A6Abc\u00e1isis\u00A6Macad\u00f3inis\u00A6Afar\u00A6Som\u00e1lais\u00A6Maorais\u00A6Gaeilge na hAlban\u00A6Sam\u00f3is\u00A6Sl\u00f3v\u00e9inis\u00A6Malag\u00e1sais\u00A6Sl\u00f3vacais\u00A6Gaeilge\u00A6Seirbea-Chr\u00f3itis\u00A6S\u00e1imis Thuaidh\u00A6Gi\u00fadais\u00A6Sindis\u00A6Freaslainnais\u00A6Saird\u00ednis\u00A6Sanscrait\u00A6Fraincis\u00A6Laitvis\u00A6Liotu\u00e1inis\u00A6Far\u00f3is\u00A6R\u00faisis\u00A6Laosais\u00A6Fidsis\u00A6Fionnlainnis\u00A6Rom\u00e1inis\u00A6Peirsis\u00A6Leitseabuirgis\u00A6Laidin\u00A6Bascais\u00A6Cirgeasais\u00A6East\u00f3inis";

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
    { "localPatternChars", "RbMLkUnsSElFtTauKcBeyrAC" },
    { "currenciesDisplayName", currenciesDisplayName },
    { "currenciesSymbol", currenciesSymbol },
    { "shortMonths", shortMonths },
    { "months", months },
    { "shortWeekdays", shortWeekdays },
    { "weekdays", weekdays },
    { "eras", eras },
    { "ampms", ampms },
    { "zoneStrings", zoneStrings },
    { "territories", territories },
    { "languages", languages },
  };

  public Object[][] getContents() { return contents; }
}
