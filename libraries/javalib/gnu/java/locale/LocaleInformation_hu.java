/* LocaleInformation_hu.java --
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

public class LocaleInformation_hu extends ListResourceBundle
{
  private static final String currenciesDisplayNameKeys = "JOD\u00A6BOV\u00A6XAU\u00A6FOK\u00A6LBP\u00A6EUR\u00A6VND\u00A6TZS\u00A6BOP\u00A6KHR\u00A6XAM\u00A6BOL\u00A6KHO\u00A6ZMP\u00A6AUP\u00A6XAF\u00A6MTP\u00A6GHR\u00A6ZMK\u00A6XAD\u00A6GHP\u00A6BOB\u00A6GHO\u00A6MTL\u00A6AUD\u00A6USS\u00A6ITL\u00A6USN\u00A6GHC\u00A6SGD\u00A6PAB\u00A6LAK\u00A6KGS\u00A6CHF\u00A6ATS\u00A6USD\u00A6ETD\u00A6BND\u00A6JMP\u00A6ETB\u00A6DZG\u00A6DZF\u00A6DZD\u00A6PYG\u00A6LYP\u00A6JMD\u00A6ISK\u00A6ESP\u00A6BMP\u00A6LYD\u00A6LYB\u00A6BMD\u00A6NLG\u00A6MRO\u00A6IRR\u00A6SEK\u00A6ERN\u00A6KES\u00A6CFF\u00A6ARS\u00A6ARP\u00A6ARM\u00A6TWD\u00A6SDP\u00A6GEL\u00A6GEK\u00A6MQF\u00A6FKP\u00A6ARA\u00A6SDD\u00A6IQD\u00A6TVD\u00A6SCR\u00A6LVR\u00A6FJP\u00A6LVL\u00A6CDL\u00A6CDG\u00A6CDF\u00A6FJD\u00A6NIO\u00A6MOP\u00A6NIG\u00A6NIC\u00A6XTR\u00A6FIN\u00A6FIM\u00A6SBD\u00A6LUF\u00A6TTO\u00A6AOS\u00A6AOR\u00A6MNT\u00A6HUF\u00A6BIF\u00A6AON\u00A6AOK\u00A6TTD\u00A6SZL\u00A6NHF\u00A6GBP\u00A6SAS\u00A6SAR\u00A6LTT\u00A6PTE\u00A6AOA\u00A6PTC\u00A6LTL\u00A6KZT\u00A6KZR\u00A6VGD\u00A6NGP\u00A6MMX\u00A6NGN\u00A6HTG\u00A6SYP\u00A6PSP\u00A6BHD\u00A6MMK\u00A6ANG\u00A6CZK\u00A6IMP\u00A6BGX\u00A6LSL\u00A6GAF\u00A6BGO\u00A6BGN\u00A6BGM\u00A6CAD\u00A6BGL\u00A6TRL\u00A6KYD\u00A6CYP\u00A6ILS\u00A6GYD\u00A6AMD\u00A6ILP\u00A6MLF\u00A6ILL\u00A6VEB\u00A6ALX\u00A6LRD\u00A6ALV\u00A6HRK\u00A6REF\u00A6HRD\u00A6ALL\u00A6JEP\u00A6ALK\u00A6MKN\u00A6VDP\u00A6VDN\u00A6MKD\u00A6VDD\u00A6TPP\u00A6XPF\u00A6BEL\u00A6GWP\u00A6KWD\u00A6GWM\u00A6BEF\u00A6TPE\u00A6BEC\u00A6GWE\u00A6SVC\u00A6CWG\u00A6BDT\u00A6TOS\u00A6XOF\u00A6SUR\u00A6SUN\u00A6NCF\u00A6CVE\u00A6XNF\u00A6ZAR\u00A6DOP\u00A6CUX\u00A6ZAP\u00A6ZAL\u00A6TND\u00A6CUP\u00A6GUF\u00A6UGX\u00A6LNR\u00A6AIF\u00A6VAL\u00A6STE\u00A6UGS\u00A6STD\u00A6MHD\u00A6NZP\u00A6WST\u00A6WSP\u00A6HNL\u00A6XMF\u00A6TMM\u00A6GTQ\u00A6NZD\u00A6SSP\u00A6BBD\u00A6NAD\u00A6MGF\u00A6MGA\u00A6EGP\u00A6BZH\u00A6PLZ\u00A6BAN\u00A6PLX\u00A6BAM\u00A6BZD\u00A6BAD\u00A6PLN\u00A6YER\u00A6SRG\u00A6CSK\u00A6KRW\u00A6BYR\u00A6YEI\u00A6BYL\u00A6CSC\u00A6KRO\u00A6KRH\u00A6BYB\u00A6SQS\u00A6GRN\u00A6PKR\u00A6AFN\u00A6ZWD\u00A6LKR\u00A6GRD\u00A6IEP\u00A6AFA\u00A6YDD\u00A6RWF\u00A6CRC\u00A6TJS\u00A6TJR\u00A6EEK\u00A6GQP\u00A6MDR\u00A6HKD\u00A6DKK\u00A6MDL\u00A6GQF\u00A6GQE\u00A6IDR\u00A6AED\u00A6KPW\u00A6IDN\u00A6BWP\u00A6MDC\u00A6IDJ\u00A6KPP\u00A6IDG\u00A6VUV\u00A6XID\u00A6SOS\u00A6ADP\u00A6RUR\u00A6GPF\u00A6DJF\u00A6ADD\u00A6MCG\u00A6MCF\u00A6ECV\u00A6ECS\u00A6LIF\u00A6RUB\u00A6PHP\u00A6UZS\u00A6COP\u00A6THB\u00A6IBP\u00A6BUR\u00A6COF\u00A6BUK\u00A6COB\u00A6UZC\u00A6UAK\u00A6QAR\u00A6UAH\u00A6GNS\u00A6CNY\u00A6MZM\u00A6CNX\u00A6UYU\u00A6GNI\u00A6SML\u00A6CNP\u00A6MZE\u00A6GNF\u00A6OMS\u00A6PGK\u00A6OMR\u00A6UYP\u00A6XFU\u00A6BTR\u00A6ZRZ\u00A6MAF\u00A6MAD\u00A6BTN\u00A6XFO\u00A6UYF\u00A6MYR\u00A6ZRN\u00A6AZM\u00A6GMP\u00A6KMF\u00A6SLL\u00A6GMD\u00A6XEU\u00A6BSP\u00A6CMF\u00A6MXV\u00A6XEF\u00A6BSD\u00A6MXP\u00A6MXN\u00A6PES\u00A6GLK\u00A6BRZ\u00A6PEN\u00A6CLP\u00A6SKK\u00A6PEI\u00A6BRR\u00A6XDR\u00A6FRG\u00A6FRF\u00A6BRN\u00A6CLF\u00A6CLE\u00A6BRL\u00A6CLC\u00A6BRE\u00A6DES\u00A6MWP\u00A6BRC\u00A6BRB\u00A6MWK\u00A6PDR\u00A6DEM\u00A6TDF\u00A6PDN\u00A6PDK\u00A6NPR\u00A6CKD\u00A6JPY\u00A6MVR\u00A6XCF\u00A6MVP\u00A6XCD\u00A6SIT\u00A6YUR\u00A6AWG\u00A6YUO\u00A6DDM\u00A6YUN\u00A6YUM\u00A6TCC\u00A6YUG\u00A6YUF\u00A6RON\u00A6YUD\u00A6ROL\u00A6SIB\u00A6NOK\u00A6MUR\u00A6XBD\u00A6GIP\u00A6VNS\u00A6XBC\u00A6VNR\u00A6XBB\u00A6XBA\u00A6KID\u00A6SHP\u00A6VNN";

  private static final String currenciesDisplayNameValues = "Jord\u00e1niai d\u00edn\u00e1r\u00A6Bol\u00edviai mvdol\u00A6Arany\u00A6Fer\u00f6er-szigeteki korona\u00A6Libanoni font\u00A6Euro\u00A6Vietn\u00e1mi dong\u00A6Tanz\u00e1niai shilling\u00A6Bol\u00edviai peso\u00A6Kambodzsai riel\u00A6Asian Monetary Unit\u00A6Boliviano (1863-1962)\u00A6Kambodzsai r\u00e9gi riel\u00A6Zambiai font\u00A6Ausztr\u00e1l font\u00A6CFA frank BEAC\u00A6M\u00e1ltai font\u00A6Gh\u00e1nai \u00fajra\u00e9rt\u00e9kelt cedi\u00A6Zambiai kwacha\u00A6Asian Dinar Unit of Account\u00A6Gh\u00e1nai font\u00A6Boliviano\u00A6Gh\u00e1nai r\u00e9gi cedi\u00A6M\u00e1ltai l\u00edra\u00A6Ausztr\u00e1l doll\u00e1r\u00A6USA doll\u00e1r (aznapi)\u00A6Olasz l\u00edra\u00A6USA doll\u00e1r (k\u00f6vetkez\u0151 napi)\u00A6Gh\u00e1nai cedi\u00A6Szingap\u00fari doll\u00e1r\u00A6Panamai balboa\u00A6Laoszi kip\u00A6Kirgiziszt\u00e1ni szom\u00A6Sv\u00e1jci frank\u00A6Osztr\u00e1k schilling\u00A6USA doll\u00e1r\u00A6Eti\u00f3piai doll\u00e1r\u00A6Brunei doll\u00e1r\u00A6Jamaikai font\u00A6Eti\u00f3piai birr\u00A6Alg\u00e9riai kezdeti frank\u00A6Alg\u00e9riai \u00faj frank\u00A6Alg\u00e9riai d\u00edn\u00e1r\u00A6Paraguayi guarani\u00A6L\u00edbiai font\u00A6Jamaikai doll\u00e1r\u00A6Izlandi korona\u00A6Spanyol peseta\u00A6Bermudai font\u00A6L\u00edbiai d\u00edn\u00e1r\u00A6L\u00edbiai brit katonai fennhat\u00f3s\u00e1gi l\u00edra\u00A6Bermudai doll\u00e1r\u00A6Holland forint\u00A6Maurit\u00e1niai ouguiya\u00A6Ir\u00e1ni rial\u00A6Sv\u00e9d korona\u00A6Eritreai nakfa\u00A6Kenyai shilling\u00A6K\u00f6z\u00e9p-afrikai CFA frank\u00A6Peso\u00A6Argent\u00edn peso (1983-1985)\u00A6Argent\u00edn peso moneda nacional\u00A6Tajvani \u00faj doll\u00e1r\u00A6Szud\u00e1ni font\u00A6Gr\u00faz lari\u00A6Gr\u00faz kupon larit\u00A6Martiniquei frank\u00A6Falkland-szigeteki font\u00A6Argent\u00edn austral\u00A6Szud\u00e1ni d\u00edn\u00e1r\u00A6Iraki d\u00edn\u00e1r\u00A6Tuvalui doll\u00e1r\u00A6Seychelle-szigeteki r\u00fapia\u00A6Lett rubel\u00A6Fidzsi font\u00A6Lett lats\u00A6Kong\u00f3i zaire\u00A6Kong\u00f3i k\u00f6zt\u00e1rsas\u00e1gi frank\u00A6Kong\u00f3i frank\u00A6Fidzsi doll\u00e1r\u00A6Nikaraguai cordoba oro\u00A6Macaoi pataca\u00A6Nikaraguai arany cordoba\u00A6Nikaraguai cordoba\u00A6COMECON Transferable Ruble\u00A6Finn markka (1860-1962)\u00A6Finn markka\u00A6Salamon-szigeteki doll\u00e1r\u00A6Luxemburgi frank\u00A6Trinidad \u00e9s tobagoi r\u00e9gi doll\u00e1r\u00A6Angolai escudo\u00A6Angolai kwanza reajustado (1995-1999)\u00A6Mong\u00f3liai tugrik\u00A6Magyar forint\u00A6Burundi frank\u00A6Angolai \u00faj kwanza (1990-2000)\u00A6Angolai kwanza (1977-1990)\u00A6Trinidad \u00e9s tobagoi doll\u00e1r\u00A6Szv\u00e1zif\u00f6ldi lilangeni\u00A6\u00daj-hebrid\u00e1ki CFP frank\u00A6Brit font sterling\u00A6Sza\u00fadi szuver\u00e9n riyal\u00A6Sza\u00fadi riyal\u00A6Litv\u00e1niai talonas\u00A6Portug\u00e1l escudo\u00A6Angolai kwanza\u00A6Portug\u00e1l conto\u00A6Litv\u00e1niai litas\u00A6Kazahszt\u00e1ni tenge\u00A6Kazahszt\u00e1ni rubel\u00A6Brit virgin-szigeteki doll\u00e1r\u00A6Nig\u00e9riai font\u00A6Mianmari doll\u00e1r konvertibilis valuta\u00A6Nig\u00e9riai naira\u00A6Haiti gourde\u00A6Sz\u00edriai font\u00A6Palesztin font\u00A6Bahreini din\u00e1r\u00A6Mianmari kyat\u00A6Holland-antilla forint\u00A6Cseh korona\u00A6Man-szigeti font sterling\u00A6Bolg\u00e1r leva konvertibilis valuta\u00A6Lesothoi loti\u00A6Gaboni CFA frank\u00A6Bolg\u00e1r leva (1879-1952)\u00A6Bolg\u00e1r \u00faj leva\u00A6Bolg\u00e1r szocialista leva\u00A6Kanadai doll\u00e1r\u00A6Bolg\u00e1r kem\u00e9ny leva\u00A6T\u00f6r\u00f6k l\u00edra\u00A6Kajm\u00e1n-szigeteki doll\u00e1r\u00A6Ciprusi font\u00A6Izraeli \u00faj s\u00e9kel\u00A6Guyanai doll\u00e1r\u00A6Dram\u00A6Izraeli font\u00A6Mali frank\u00A6Izraeli s\u00e9kel\u00A6Venezuelai bol\u00edvar\u00A6Alb\u00e1n doll\u00e1r konvertibilis valuta\u00A6Lib\u00e9riai doll\u00e1r\u00A6Alb\u00e1n lek valuta\u00A6Horv\u00e1t kuna\u00A6R\u00e9unioni frank\u00A6Horv\u00e1t d\u00edn\u00e1r\u00A6Alb\u00e1n lek\u00A6Jersey font sterling\u00A6Alb\u00e1n lek (1946-1961)\u00A6Macedon d\u00edn\u00e1r (1992-1993)\u00A6\u00c9szak-vietn\u00e1mi viet minh piastre dong viet\u00A6\u00c9szak-vietn\u00e1mi \u00faj dong\u00A6Macedon d\u00edn\u00e1r\u00A6\u00c9szak-vietn\u00e1mi piastre dong viet\u00A6Timori pataca\u00A6CFP frank\u00A6Belga frank (p\u00e9nz\u00fcgyi)\u00A6Guinea-Bissaui peso\u00A6Kuvaiti d\u00edn\u00e1r\u00A6Portug\u00e1l guinea mil reis\u00A6Belga frank\u00A6Timori escudo\u00A6Belga frank (konvertibilis)\u00A6Portug\u00e1l guinea escudo\u00A6Salvadori col\u00f3n\u00A6Curacaoi forint\u00A6Bangladesi taka\u00A6Tongai font sterling\u00A6CFA frank BCEAO\u00A6Szovjet rubel\u00A6Szovjet \u00faj rubel\u00A6\u00daj-kaled\u00f3niai frank kezdeti\u00A6Cape Verdei escudo\u00A6French Antilles CFA Franc\u00A6D\u00e9l-afrikai rand\u00A6Dominikai peso\u00A6Kubai konvertibilis valuta\u00A6D\u00e9l-afrikai font\u00A6D\u00e9l-afrikai rand (p\u00e9nz\u00fcgyi)\u00A6Tun\u00e9ziai d\u00edn\u00e1r\u00A6Kubai peso\u00A6Francia Guyanai frank guiana\u00A6Ugandai shilling\u00A6Ceyloni r\u00fapia\u00A6Affars and Issas Franc\u00A6Vatik\u00e1ni l\u00edra\u00A6Sao tome-i \u00e9s principe-i escudo\u00A6Ugandai shilling (1966-1987)\u00A6Sao tome-i \u00e9s principe-i dobra\u00A6Marshall-szigeteki doll\u00e1r\u00A6\u00daj-z\u00e9landi font\u00A6Nyugat-szamoai tala\u00A6Nyugat-szamoai font\u00A6Hodurasi lempira\u00A6French Metropolitan Nouveau Franc\u00A6T\u00fcrkmeniszt\u00e1ni manat\u00A6Guatemalai quetzal\u00A6\u00daj-z\u00e9landi doll\u00e1r\u00A6Sk\u00f3t font\u00A6Barbadosi doll\u00e1r\u00A6Nam\u00edbiai doll\u00e1r\u00A6Madagaszk\u00e1ri frank\u00A6Madagaszk\u00e1ri ariary\u00A6Egyiptomi font\u00A6Brit-hondurasi doll\u00e1r\u00A6Lengyel zloty (1950-1995)\u00A6Bosznia-hercegovinai \u00faj d\u00edn\u00e1r\u00A6Lengyel USA doll\u00e1r konvertibilis valuta\u00A6Bozsnia-hercegovinai konvertibilis m\u00e1rka\u00A6Belizei doll\u00e1r\u00A6Bosznia-hercegovinai d\u00edn\u00e1r\u00A6Lengyel zloty\u00A6Jemeni rial\u00A6Suriname-i gulden\u00A6Csehszlov\u00e1k kem\u00e9ny korona\u00A6D\u00e9l-koreai won\u00A6Feh\u00e9rorosz rubel\u00A6Jemeni imadi riyal\u00A6Feh\u00e9rorosz rubel (1992-1994)\u00A6Csehszlov\u00e1k korona\u00A6D\u00e9l-koreai r\u00e9gi won\u00A6D\u00e9l-koreai hwan\u00A6Feh\u00e9rorosz \u00faj rubel (1994-1999)\u00A6Szom\u00e1lf\u00f6ldi shilling\u00A6G\u00f6r\u00f6g \u00faj drachma\u00A6Pakiszt\u00e1ni r\u00fapia\u00A6Afghani\u00A6Zimbabwei doll\u00e1r\u00A6Sri Lankai r\u00fapia\u00A6G\u00f6r\u00f6g drachma\u00A6\u00cdr font\u00A6Afghani (1927-2002)\u00A6Jemeni d\u00edn\u00e1r\u00A6Ruandai frank\u00A6Costa Ricai colon\u00A6T\u00e1dzsikiszt\u00e1ni somoni\u00A6T\u00e1dzsikiszt\u00e1ni rubel\u00A6\u00c9szt korona\u00A6Egyenl\u00edt\u0151i-guineai peseta guineana\u00A6Moldov\u00e1n rubel kupon\u00A6Hongkongi doll\u00e1r\u00A6D\u00e1n korona\u00A6Moldov\u00e1n lei\u00A6Egyenl\u00edt\u0151i-guineai franco\u00A6Egyenl\u00edt\u0151i-guineai ekwele guineana\u00A6Indon\u00e9z r\u00fapia\u00A6EAE dirham\u00A6\u00c9szak-koreai won\u00A6Indon\u00e9z \u00faj r\u00fapia\u00A6Botswanai pula\u00A6Moldov\u00e1n lei kupon\u00A6Indon\u00e9z j\u00e1va r\u00fapia\u00A6\u00c9szak-koreai n\u00e9pi won\u00A6Indon\u00e9z nica guilder\u00A6Vanuatui vatu\u00A6Iszl\u00e1m d\u00edn\u00e1r\u00A6Szom\u00e1li shilling\u00A6Andorrai peseta\u00A6Orosz rubel (1991-1998)\u00A6Guadeloupei frank\u00A6Dzsibuti frank\u00A6Andorrai d\u00edn\u00e1r\u00A6Monacoi frank kezdeti\u00A6Monacoi frank \u00faj\u00A6Ecuadori Unidad de Valor Constante (UVC)\u00A6Ecuadori sucre\u00A6Liechtensteini frank\u00A6Orosz rubel\u00A6F\u00fcl\u00f6p-szigeteki peso\u00A6\u00dczbegiszt\u00e1ni szum\u00A6Kolumbiai peso\u00A6Thai baht\u00A6\u00c9szak\u00edr font\u00A6Burmai r\u00fapia\u00A6Kong\u00f3i CFA frank\u00A6Burmai kyat\u00A6Kolumbiai pap\u00edr peso\u00A6\u00dczbegiszt\u00e1ni kupon som\u00A6Ukr\u00e1n karbovanec\u00A6Katari rial\u00A6Ukr\u00e1n hrivnya\u00A6Guineai syli\u00A6K\u00ednai j\u00fcan renminbi\u00A6Mozambik metical\u00A6K\u00ednai USA doll\u00e1r konvertibilis valuta\u00A6Uruguay-i peso uruguayo\u00A6Guineai frank (1960-1972)\u00A6San Marinoi l\u00edra\u00A6K\u00ednai jen min piao j\u00fcan\u00A6Mozambik escudo\u00A6Guineai frank\u00A6Om\u00e1ni rial saidi\u00A6P\u00e1pua \u00faj-guineai kina\u00A6Om\u00e1ni rial\u00A6Uruguay-i peso (1975-1993)\u00A6Francia UIC-frank\u00A6Bhut\u00e1ni r\u00fapia\u00A6Zairei zaire\u00A6Marokk\u00f3i frank\u00A6Marokk\u00f3i dirham\u00A6Bhut\u00e1ni ngultrum\u00A6Francia arany frank\u00A6Uruguay-i peso fuerte\u00A6Malajziai ringgit\u00A6Zairei \u00faj zaire\u00A6Azerbajdzs\u00e1ni manat\u00A6Gambiai font\u00A6Comorei frank\u00A6Sierra Leonei leone\u00A6Gambiai dalasi\u00A6European Currency Unit\u00A6Bahamai font\u00A6Cameruni CFA frank\u00A6Mexik\u00f3i Unidad de Inversion (UDI)\u00A6CFA frank BCEAEC\u00A6Bahamai doll\u00e1r\u00A6Mexik\u00f3i ez\u00fcst peso (1861-1992)\u00A6Mexik\u00f3i peso\u00A6Perui sol\u00A6Gr\u00f6nlandi korona\u00A6Brazil cruzeiro (1942-1967)\u00A6Perui sol nuevo\u00A6Chilei peso\u00A6Szlov\u00e1k korona\u00A6Perui inti\u00A6Brazil cruzeiro\u00A6Special Drawing Rights\u00A6Francia frank kezdeti/Frank poincare\u00A6Francia frank\u00A6Brazil cruzado novo\u00A6Chilei unidades de fomento\u00A6Chilei escudo\u00A6Brazil real\u00A6Chilei condor\u00A6Brazil cruzeiro (1990-1993)\u00A6German Sperrmark\u00A6Malawi font\u00A6Brazi cruzado\u00A6Brazi cruzeiro novo (1967-1986)\u00A6Malawi kwacha\u00A6Transzdnyeszteri rubel\u00A6N\u00e9met m\u00e1rka\u00A6Cs\u00e1di CFA frank\u00A6Transzdnyeszteri \u00faj rubel\u00A6Transzdnyeszteri rubel kupon\u00A6Nep\u00e1li r\u00fapia\u00A6Cook-szigeteki doll\u00e1r\u00A6Jap\u00e1n jen\u00A6Mald\u00edv-szigeteki rufiyaa\u00A6CFA \u00faj frank\u00A6Mald\u00edv-szigeteki r\u00fapia\u00A6Kelet-karibi doll\u00e1r\u00A6Szlov\u00e9n tolar\u00A6Jugoszl\u00e1v reform d\u00edn\u00e1r\u00A6Arubai forint\u00A6Jugoszl\u00e1v okt\u00f3beri d\u00edn\u00e1r\u00A6Kelet-N\u00e9met m\u00e1rka\u00A6Jugoszl\u00e1v konvertibilis d\u00edn\u00e1r\u00A6Jugoszl\u00e1v \u00faj d\u00edn\u00e1r\u00A6Turks \u00e9s caicosi korona\u00A6Jugoszl\u00e1v 1994-es d\u00edn\u00e1r\u00A6Jugoszl\u00e1v sz\u00f6vets\u00e9gi d\u00edn\u00e1r\u00A6Rom\u00e1n \u00faj lej\u00A6Jugoszl\u00e1v kem\u00e9ny d\u00edn\u00e1r\u00A6Rom\u00e1n lej\u00A6Szlov\u00e9n tolar bons\u00A6Norv\u00e9g korona\u00A6Mauritiusi r\u00fapia\u00A6European Unit of Account (XBD)\u00A6Gibralt\u00e1ri font\u00A6Vietn\u00e1mi nemzeti dong\u00A6European Unit of Account (XBC)\u00A6Vietn\u00e1mi k\u00f6zt\u00e1rsas\u00e1gi dong\u00A6European Monetary Unit\u00A6European Composite Unit\u00A6Kiribati doll\u00e1r\u00A6Saint Helena font\u00A6Vietn\u00e1mi \u00faj dong";

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

  private static final String currenciesSymbolKeys = "JOD\u00A6BOV\u00A6XAU\u00A6FOK\u00A6LBP\u00A6VND\u00A6TZS\u00A6BOP\u00A6KHR\u00A6XAM\u00A6BOL\u00A6KHO\u00A6ZMP\u00A6AUP\u00A6XAF\u00A6MTP\u00A6GHR\u00A6ZMK\u00A6XAD\u00A6GHP\u00A6BOB\u00A6GHO\u00A6MTL\u00A6AUD\u00A6USS\u00A6USN\u00A6GHC\u00A6SGD\u00A6PAB\u00A6LAK\u00A6KGS\u00A6CHF\u00A6ATS\u00A6USD\u00A6ETD\u00A6BND\u00A6JMP\u00A6ETB\u00A6DZG\u00A6DZF\u00A6DZD\u00A6PYG\u00A6LYP\u00A6JMD\u00A6ISK\u00A6ESP\u00A6BMP\u00A6LYD\u00A6LYB\u00A6BMD\u00A6NLG\u00A6MRO\u00A6IRR\u00A6SEK\u00A6ERN\u00A6KES\u00A6CFF\u00A6ARS\u00A6ARP\u00A6ARM\u00A6TWD\u00A6SDP\u00A6GEL\u00A6GEK\u00A6MQF\u00A6FKP\u00A6ARA\u00A6SDD\u00A6IQD\u00A6TVD\u00A6SCR\u00A6LVR\u00A6FJP\u00A6LVL\u00A6CDL\u00A6CDG\u00A6CDF\u00A6FJD\u00A6NIO\u00A6MOP\u00A6NIG\u00A6NIC\u00A6XTR\u00A6FIN\u00A6FIM\u00A6SBD\u00A6LUF\u00A6TTO\u00A6AOS\u00A6AOR\u00A6MNT\u00A6HUF\u00A6BIF\u00A6AON\u00A6AOK\u00A6TTD\u00A6SZL\u00A6NHF\u00A6SAS\u00A6SAR\u00A6LTT\u00A6PTE\u00A6AOA\u00A6PTC\u00A6LTL\u00A6KZT\u00A6KZR\u00A6VGD\u00A6NGP\u00A6MMX\u00A6NGN\u00A6HTG\u00A6SYP\u00A6PSP\u00A6BHD\u00A6MMK\u00A6ANG\u00A6CZK\u00A6IMP\u00A6BGX\u00A6LSL\u00A6GAF\u00A6BGO\u00A6BGN\u00A6BGM\u00A6CAD\u00A6BGL\u00A6TRL\u00A6KYD\u00A6CYP\u00A6ILS\u00A6GYD\u00A6AMD\u00A6ILP\u00A6MLF\u00A6ILL\u00A6VEB\u00A6ALX\u00A6LRD\u00A6ALV\u00A6HRK\u00A6REF\u00A6HRD\u00A6ALL\u00A6JEP\u00A6ALK\u00A6MKN\u00A6VDP\u00A6VDN\u00A6MKD\u00A6VDD\u00A6TPP\u00A6XPF\u00A6BEL\u00A6GWP\u00A6KWD\u00A6GWM\u00A6BEF\u00A6TPE\u00A6BEC\u00A6GWE\u00A6SVC\u00A6CWG\u00A6BDT\u00A6TOS\u00A6XOF\u00A6SUR\u00A6SUN\u00A6NCF\u00A6CVE\u00A6XNF\u00A6ZAR\u00A6DOP\u00A6CUX\u00A6ZAP\u00A6ZAL\u00A6TND\u00A6CUP\u00A6GUF\u00A6UGX\u00A6LNR\u00A6AIF\u00A6VAL\u00A6STE\u00A6UGS\u00A6STD\u00A6MHD\u00A6NZP\u00A6WST\u00A6WSP\u00A6HNL\u00A6XMF\u00A6TMM\u00A6GTQ\u00A6NZD\u00A6SSP\u00A6BBD\u00A6NAD\u00A6MGF\u00A6MGA\u00A6EGP\u00A6BZH\u00A6PLZ\u00A6BAN\u00A6PLX\u00A6BAM\u00A6BZD\u00A6BAD\u00A6PLN\u00A6YER\u00A6SRG\u00A6CSK\u00A6KRW\u00A6BYR\u00A6YEI\u00A6BYL\u00A6CSC\u00A6KRO\u00A6KRH\u00A6BYB\u00A6SQS\u00A6GRN\u00A6PKR\u00A6AFN\u00A6ZWD\u00A6LKR\u00A6GRD\u00A6IEP\u00A6AFA\u00A6YDD\u00A6RWF\u00A6CRC\u00A6TJS\u00A6TJR\u00A6EEK\u00A6GQP\u00A6MDR\u00A6HKD\u00A6DKK\u00A6MDL\u00A6GQF\u00A6GQE\u00A6IDR\u00A6AED\u00A6KPW\u00A6IDN\u00A6BWP\u00A6MDC\u00A6IDJ\u00A6KPP\u00A6IDG\u00A6VUV\u00A6XID\u00A6SOS\u00A6ADP\u00A6RUR\u00A6GPF\u00A6DJF\u00A6ADD\u00A6MCG\u00A6MCF\u00A6ECV\u00A6ECS\u00A6LIF\u00A6RUB\u00A6PHP\u00A6UZS\u00A6COP\u00A6THB\u00A6IBP\u00A6BUR\u00A6COF\u00A6BUK\u00A6COB\u00A6UZC\u00A6UAK\u00A6QAR\u00A6UAH\u00A6GNS\u00A6CNY\u00A6MZM\u00A6CNX\u00A6UYU\u00A6GNI\u00A6SML\u00A6MZE\u00A6CNP\u00A6GNF\u00A6OMS\u00A6PGK\u00A6OMR\u00A6UYP\u00A6XFU\u00A6BTR\u00A6ZRZ\u00A6MAF\u00A6MAD\u00A6BTN\u00A6XFO\u00A6UYF\u00A6MYR\u00A6ZRN\u00A6AZM\u00A6GMP\u00A6KMF\u00A6SLL\u00A6GMD\u00A6XEU\u00A6BSP\u00A6CMF\u00A6MXV\u00A6XEF\u00A6BSD\u00A6MXP\u00A6MXN\u00A6PES\u00A6GLK\u00A6BRZ\u00A6PEN\u00A6CLP\u00A6SKK\u00A6PEI\u00A6BRR\u00A6XDR\u00A6FRG\u00A6FRF\u00A6BRN\u00A6CLF\u00A6CLE\u00A6BRL\u00A6CLC\u00A6BRE\u00A6DES\u00A6MWP\u00A6BRC\u00A6BRB\u00A6MWK\u00A6PDR\u00A6DEM\u00A6TDF\u00A6PDN\u00A6PDK\u00A6NPR\u00A6CKD\u00A6MVR\u00A6XCF\u00A6MVP\u00A6XCD\u00A6SIT\u00A6YUR\u00A6AWG\u00A6YUO\u00A6DDM\u00A6YUN\u00A6YUM\u00A6TCC\u00A6YUG\u00A6YUF\u00A6RON\u00A6YUD\u00A6ROL\u00A6SIB\u00A6NOK\u00A6MUR\u00A6XBD\u00A6GIP\u00A6VNS\u00A6XBC\u00A6VNR\u00A6XBB\u00A6XBA\u00A6KID\u00A6SHP\u00A6VNN";

  private static final String currenciesSymbolValues = "JD\u00A6BOV\u00A6XAU\u00A6FOK\u00A6LL\u00A6VND\u00A6T Sh\u00A6BOP\u00A6CR\u00A6XAM\u00A6BOL\u00A6KHO\u00A6ZMP\u00A6AUP\u00A6XAF\u00A6MTP\u00A6GHR\u00A6ZMK\u00A6XAD\u00A6GHP\u00A6Bs\u00A6GHO\u00A6Lm\u00A6$A\u00A6USS\u00A6USN\u00A6GHC\u00A6S$\u00A6PAB\u00A6LAK\u00A6som\u00A6SwF\u00A6ATS\u00A6US$\u00A6ETD\u00A6BND\u00A6JMP\u00A6Br\u00A6DZG\u00A6DZF\u00A6DA\u00A6PYG\u00A6LYP\u00A6J$\u00A6ISK\u00A6ESP\u00A6BMP\u00A6LD\u00A6LYB\u00A6Ber$\u00A6NLG\u00A6UM\u00A6RI\u00A6SKr\u00A6ERN\u00A6K Sh\u00A6CFF\u00A6Arg$\u00A6ARP\u00A6ARM\u00A6NT$\u00A6SDP\u00A6lari\u00A6GEK\u00A6MQF\u00A6FKP\u00A6ARA\u00A6SDD\u00A6ID\u00A6TVD\u00A6SR\u00A6LVR\u00A6FJP\u00A6LVL\u00A6CDL\u00A6CDG\u00A6CDF\u00A6F$\u00A6NIO\u00A6MOP\u00A6NIG\u00A6NIC\u00A6XTR\u00A6FIN\u00A6FIM\u00A6SI$\u00A6LUF\u00A6TTO\u00A6AOS\u00A6AOR\u00A6Tug\u00A6Ft\u00A6Fbu\u00A6AON\u00A6AOK\u00A6TT$\u00A6E\u00A6NHF\u00A6SAS\u00A6SRl\u00A6LTT\u00A6PTE\u00A6AOA\u00A6PTC\u00A6LTL\u00A6T\u00A6KZR\u00A6VGD\u00A6NGP\u00A6MMX\u00A6NGN\u00A6HTG\u00A6LS\u00A6PSP\u00A6BD\u00A6MMK\u00A6NA f.\u00A6CZK\u00A6IMP\u00A6BGX\u00A6M\u00A6GAF\u00A6BGO\u00A6BGN\u00A6BGM\u00A6Can$\u00A6lev\u00A6TL\u00A6KYD\u00A6\u00a3C\u00A6ILS\u00A6G$\u00A6dram\u00A6ILP\u00A6MLF\u00A6ILL\u00A6Be\u00A6ALX\u00A6LRD\u00A6ALV\u00A6HRK\u00A6REF\u00A6HRD\u00A6lek\u00A6JEP\u00A6ALK\u00A6MKN\u00A6VDP\u00A6VDN\u00A6MDen\u00A6VDD\u00A6TPP\u00A6CFPF\u00A6BEL\u00A6GWP\u00A6KD\u00A6GWM\u00A6BF\u00A6TPE\u00A6BEC\u00A6GWE\u00A6SVC\u00A6CWG\u00A6Tk\u00A6TOS\u00A6XOF\u00A6SUR\u00A6SUN\u00A6NCF\u00A6CVEsc\u00A6XNF\u00A6R\u00A6RD$\u00A6CUX\u00A6ZAP\u00A6ZAL\u00A6TND\u00A6CUP\u00A6GUF\u00A6U Sh\u00A6LNR\u00A6AIF\u00A6VAL\u00A6STE\u00A6UGS\u00A6Db\u00A6MHD\u00A6NZP\u00A6WST\u00A6WSP\u00A6L\u00A6XMF\u00A6TMM\u00A6Q\u00A6$NZ\u00A6SSP\u00A6BDS$\u00A6N$\u00A6MGF\u00A6MGA\u00A6EGP\u00A6BZH\u00A6PLZ\u00A6BAN\u00A6PLX\u00A6KM\u00A6BZ$\u00A6BAD\u00A6Zl\u00A6YRl\u00A6Sf\u00A6CSK\u00A6KRW\u00A6Rbl\u00A6YEI\u00A6BYL\u00A6CSC\u00A6KRO\u00A6KRH\u00A6BYB\u00A6SQS\u00A6GRN\u00A6Pra\u00A6Af\u00A6Z$\u00A6SL Re\u00A6GRD\u00A6IR\u00a3\u00A6AFA\u00A6YDD\u00A6RWF\u00A6C\u00A6TJS\u00A6TJR\u00A6EEK\u00A6GQP\u00A6MDR\u00A6HK$\u00A6DKr\u00A6MDL\u00A6GQF\u00A6GQE\u00A6Rp\u00A6AED\u00A6KPW\u00A6IDN\u00A6BWP\u00A6MDC\u00A6IDJ\u00A6KPP\u00A6IDG\u00A6VT\u00A6XID\u00A6So. Sh.\u00A6ADP\u00A6RUR\u00A6GPF\u00A6DF\u00A6ADD\u00A6MCG\u00A6MCF\u00A6ECV\u00A6ECS\u00A6LIF\u00A6RUB\u00A6PHP\u00A6UZS\u00A6Col$\u00A6THB\u00A6IBP\u00A6BUR\u00A6COF\u00A6BUK\u00A6COB\u00A6UZC\u00A6UAK\u00A6QR\u00A6UAH\u00A6GNS\u00A6Y\u00A6Mt\u00A6CNX\u00A6Ur$\u00A6GNI\u00A6SML\u00A6MZE\u00A6CNP\u00A6GF\u00A6OMS\u00A6PGK\u00A6RO\u00A6UYP\u00A6XFU\u00A6BTR\u00A6ZRZ\u00A6MAF\u00A6MAD\u00A6Nu\u00A6XFO\u00A6UYF\u00A6RM\u00A6ZRN\u00A6AZM\u00A6GMP\u00A6CF\u00A6SLL\u00A6GMD\u00A6XEU\u00A6BSP\u00A6CMF\u00A6MXV\u00A6XEF\u00A6BSD\u00A6MXP\u00A6MEX$\u00A6PES\u00A6GLK\u00A6BRZ\u00A6PEN\u00A6Ch$\u00A6Sk\u00A6PEI\u00A6BRR\u00A6XDR\u00A6FRG\u00A6FRF\u00A6BRN\u00A6CLF\u00A6CLE\u00A6R$\u00A6CLC\u00A6BRE\u00A6DES\u00A6MWP\u00A6BRC\u00A6BRB\u00A6MK\u00A6PDR\u00A6DEM\u00A6TDF\u00A6PDN\u00A6PDK\u00A6Nrs\u00A6CKD\u00A6MVR\u00A6XCF\u00A6MVP\u00A6EC$\u00A6SIT\u00A6YUR\u00A6AWG\u00A6YUO\u00A6DDM\u00A6YUN\u00A6YUM\u00A6TCC\u00A6YUG\u00A6YUF\u00A6RON\u00A6YUD\u00A6leu\u00A6SIB\u00A6NKr\u00A6MUR\u00A6XBD\u00A6GIP\u00A6VNS\u00A6XBC\u00A6VNR\u00A6XBB\u00A6XBA\u00A6KID\u00A6SHP\u00A6VNN";

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
    "jan.",
    "febr.",
    "m\u00e1rc.",
    "\u00e1pr.",
    "m\u00e1j.",
    "j\u00fan.",
    "j\u00fal.",
    "aug.",
    "szept.",
    "okt.",
    "nov.",
    "dec.",
    null,
  };

  private static final String[] months = {
    "janu\u00e1r",
    "febru\u00e1r",
    "m\u00e1rcius",
    "\u00e1prilis",
    "m\u00e1jus",
    "j\u00fanius",
    "j\u00falius",
    "augusztus",
    "szeptember",
    "okt\u00f3ber",
    "november",
    "december",
    null,
  };

  private static final String[] shortWeekdays = {
    null,
    "V",
    "H",
    "K",
    "Sze",
    "Cs",
    "P",
    "Szo",
  };

  private static final String[] weekdays = {
    null,
    "vas\u00e1rnap",
    "h\u00e9tf\u0151",
    "kedd",
    "szerda",
    "cs\u00fct\u00f6rt\u00f6k",
    "p\u00e9ntek",
    "szombat",
  };

  private static final String[] eras = {
    "i.e.",
    "i.u.",
  };

  private static final String[] ampms = {
    "DE",
    "DU",
  };


  private static final String territoriesKeys = "TL\u00A6TK\u00A6TJ\u00A6TH\u00A6TG\u00A6TF\u00A6GY\u00A6TD\u00A6TC\u00A6GW\u00A6GU\u00A6GT\u00A6GS\u00A6GR\u00A6GQ\u00A6GP\u00A6SZ\u00A6SY\u00A6GN\u00A6GM\u00A6GL\u00A6SV\u00A6ST\u00A6GI\u00A6GH\u00A6SR\u00A6GF\u00A6GE\u00A6SO\u00A6GD\u00A6SN\u00A6SM\u00A6GB\u00A6SL\u00A6GA\u00A6SK\u00A6SJ\u00A6SI\u00A6SH\u00A6SG\u00A6SE\u00A6SD\u00A6SC\u00A6SB\u00A6SA\u00A6FR\u00A6FO\u00A6FM\u00A6RW\u00A6FK\u00A6RU\u00A6FJ\u00A6FI\u00A6RO\u00A6RE\u00A6ET\u00A6ES\u00A6ER\u00A6EH\u00A6EG\u00A6EE\u00A6EC\u00A6DZ\u00A6QA\u00A6DO\u00A6PY\u00A6DM\u00A6PW\u00A6DK\u00A6DJ\u00A6PT\u00A6PS\u00A6PR\u00A6DE\u00A6PN\u00A6PM\u00A6PL\u00A6PK\u00A6PH\u00A6PG\u00A6PF\u00A6CZ\u00A6PE\u00A6CY\u00A6CX\u00A6CV\u00A6PA\u00A6CU\u00A6CR\u00A6CO\u00A6CN\u00A6CM\u00A6CL\u00A6CK\u00A6CI\u00A6CH\u00A6CG\u00A6CF\u00A6CD\u00A6CC\u00A6OM\u00A6CA\u00A6BZ\u00A6BY\u00A6BW\u00A6BV\u00A6BT\u00A6BS\u00A6BR\u00A6NZ\u00A6BO\u00A6BN\u00A6BM\u00A6NU\u00A6BJ\u00A6BI\u00A6BH\u00A6NR\u00A6BG\u00A6BF\u00A6NP\u00A6BE\u00A6NO\u00A6BD\u00A6BB\u00A6ZW\u00A6NL\u00A6BA\u00A6NI\u00A6NG\u00A6NF\u00A6AZ\u00A6NE\u00A6NC\u00A6AW\u00A6ZM\u00A6NA\u00A6AU\u00A6AT\u00A6AS\u00A6AR\u00A6AQ\u00A6MZ\u00A6AO\u00A6MY\u00A6AN\u00A6MX\u00A6AM\u00A6MW\u00A6AL\u00A6MV\u00A6ZA\u00A6MU\u00A6MT\u00A6AI\u00A6MS\u00A6MR\u00A6AG\u00A6MQ\u00A6AF\u00A6MP\u00A6AE\u00A6MO\u00A6AD\u00A6MN\u00A6MM\u00A6ML\u00A6MK\u00A6YU\u00A6YT\u00A6MH\u00A6MG\u00A6MD\u00A6MC\u00A6MA\u00A6YE\u00A6LY\u00A6LV\u00A6LU\u00A6LT\u00A6LS\u00A6LR\u00A6LK\u00A6LI\u00A6LC\u00A6LB\u00A6LA\u00A6KZ\u00A6KY\u00A6KW\u00A6KR\u00A6KP\u00A6KN\u00A6KM\u00A6KI\u00A6WS\u00A6KH\u00A6KG\u00A6KE\u00A6WF\u00A6JP\u00A6JO\u00A6JM\u00A6VU\u00A6VN\u00A6VI\u00A6VG\u00A6VE\u00A6VC\u00A6VA\u00A6IT\u00A6IS\u00A6IR\u00A6IQ\u00A6UZ\u00A6IO\u00A6UY\u00A6IN\u00A6IL\u00A6US\u00A6IE\u00A6ID\u00A6UM\u00A6UG\u00A6UA\u00A6HU\u00A6HT\u00A6HR\u00A6TZ\u00A6HN\u00A6HM\u00A6TW\u00A6TV\u00A6HK\u00A6TT\u00A6TR\u00A6TO\u00A6TN\u00A6TM";

  private static final String territoriesValues = "Kelet-Timor\u00A6Tokelau\u00A6Tadzsikiszt\u00e1n\u00A6Thaif\u00f6ld\u00A6Togo\u00A6Francia D\u00e9li Ter\u00fcletek\u00A6Guyana\u00A6Cs\u00e1d\u00A6T\u00f6r\u00f6k \u00e9s Caicos Szigetek\u00A6Guinea-Bissau\u00A6Guam\u00A6Guatemala\u00A6D\u00e9l-Georgia \u00e9s D\u00e9l-Sandwich Szigetek\u00A6G\u00f6r\u00f6gorsz\u00e1g\u00A6Egyenl\u00edt\u010fi Guinea\u00A6Guadeloupe\u00A6Szv\u00e1zif\u00f6ld\u00A6Sz\u00edriai Arab K\u00f6zt\u00e1rsas\u00e1g\u00A6Guinea\u00A6Gambia\u00A6Gr\u00f6nland\u00A6El Salvador\u00A6Saint Tome \u00e9s Principe\u00A6Gibralt\u00e1r\u00A6Ghana\u00A6Suriname\u00A6Francia Guyana\u00A6Gr\u00fazia\u00A6Szom\u00e1lia\u00A6Grenada\u00A6Szeneg\u00e1l\u00A6San Marino\u00A6Egyes\u00fclt Kir\u00e1lys\u00e1g\u00A6Sierra Leone\u00A6Gabon\u00A6Szlov\u00e1kia\u00A6Svalbard \u00e9s Jan Mayen\u00A6Szlov\u00e9nia\u00A6Saint Helena\u00A6Szingap\u00far\u00A6Sv\u00e9dorsz\u00e1g\u00A6Szud\u00e1n\u00A6Seychelles\u00A6Salamon-szigetek\u00A6Szaud-Ar\u00e1bia\u00A6Franciaorsz\u00e1g\u00A6Fer\u00f6er-szigetek\u00A6Mikron\u00e9zia, Sz\u00f6vets\u00e9gi \u00c1llamok\u00A6Ruanda\u00A6Falkland-szigetek\u00A6Orosz K\u00f6zt\u00e1rsas\u00e1g\u00A6Fidzsi\u00A6Finnorsz\u00e1g\u00A6Rom\u00e1nia\u00A6Reunion (francia)\u00A6Eti\u00f3pia\u00A6Spanyolorsz\u00e1g\u00A6Eritrea\u00A6Nyugat Szahara\u00A6Egyiptom\u00A6\u00c9sztorsz\u00e1g\u00A6Ecuador\u00A6Alg\u00e9ria\u00A6Katar\u00A6Dominikai K\u00f6zt\u00e1rsas\u00e1g\u00A6Paraguay\u00A6Dominika\u00A6Palau\u00A6D\u00e1nia\u00A6Dzsibuti\u00A6Portug\u00e1lia\u00A6Paleszt\u00edn Ter\u00fclet\u00A6Puerto Rico\u00A6N\u00e9metorsz\u00e1g\u00A6Pitcairn-sziget\u00A6Saint Pierre \u00e9s Miquelon\u00A6Lengyelorsz\u00e1g\u00A6Pakiszt\u00e1n\u00A6F\u00fcl\u00f6p-szigetek\u00A6P\u00e1pua \u00daj-Guinea\u00A6Polin\u00e9zia (francia)\u00A6Cseh K\u00f6zt\u00e1rsas\u00e1g\u00A6Peru\u00A6Ciprus\u00A6Kar\u00e1csony-szigetek\u00A6Z\u00f6ld-foki K\u00f6zt\u00e1rsas\u00e1g\u00A6Panama\u00A6Kuba\u00A6Costa Rica\u00A6Kolumbia\u00A6K\u00edna\u00A6Kamerun\u00A6Chile\u00A6Cook-szigetek\u00A6Elef\u00e1ntcsontpart\u00A6Sv\u00e1jc\u00A6Kong\u00f3\u00A6K\u00f6z\u00e9p-afrikai K\u00f6zt\u00e1rsas\u00e1g\u00A6Kong\u00f3, Demokratikus k\u00f6zt\u00e1rsas\u00e1g\u00A6K\u00f3kusz (Keeling)-szigetek\u00A6Om\u00e1n\u00A6Kanada\u00A6Beliz\u00A6Feh\u00e9roroszorsz\u00e1g\u00A6Botswana\u00A6Bouvet-sziget\u00A6Bhut\u00e1n\u00A6Baham\u00e1k\u00A6Braz\u00edlia\u00A6\u00daj-Z\u00e9land\u00A6Bol\u00edvia\u00A6Brunei Darussalam\u00A6Bermuda\u00A6Niue\u00A6Benin\u00A6Burundi\u00A6Bahrain\u00A6Nauru\u00A6Bulg\u00e1ria\u00A6Burkina Faso\u00A6Nep\u00e1l\u00A6Belgium\u00A6Norv\u00e9gia\u00A6Banglades\u00A6Barbados\u00A6Zimbabwe\u00A6Hollandia\u00A6Bosznia-Hercegovina\u00A6Nicaragua\u00A6Nig\u00e9ria\u00A6Norfolk-sziget\u00A6Azerbajdzs\u00e1n\u00A6Niger\u00A6\u00daj Kaled\u00f3nia (francia)\u00A6Aruba\u00A6Zambia\u00A6Nam\u00edbia\u00A6Ausztr\u00e1lia\u00A6Ausztria\u00A6Amerikai Szamoa\u00A6Argent\u00edna\u00A6Antarktisz\u00A6Mozambik\u00A6Angola\u00A6Malajzia\u00A6Holland Antill\u00e1k\u00A6Mexik\u00f3\u00A6\u00d6rm\u00e9nyorsz\u00e1g\u00A6Malawi\u00A6Alb\u00e1nia\u00A6Mald\u00edv-szigetek\u00A6D\u00e9l-Afrika\u00A6Mauritius\u00A6M\u00e1lta\u00A6Anguilla\u00A6Montserrat\u00A6Maurit\u00e1nia\u00A6Antigua \u00e9s Barbuda\u00A6Martinique (francia)\u00A6Afganiszt\u00e1n\u00A6\u00c9szaki Mariana-szigetek\u00A6Egyes\u00fclt Arab Emir\u00e1tus\u00A6Macao S.A.R., China\u00A6Andorra\u00A6Mong\u00f3lia\u00A6Mianmar\u00A6Mali\u00A6Maced\u00f3nia, K\u00f6zt\u00e1rsas\u00e1g\u00A6Jugoszl\u00e1via\u00A6Mayotte\u00A6Marshall-szigetek\u00A6Madagaszk\u00e1r\u00A6Mold\u00e1v K\u00f6zt\u00e1rsas\u00e1g\u00A6Monaco\u00A6Marokk\u00f3\u00A6Jemen\u00A6L\u00edbiai Arab Jamahiriya\u00A6Lettorsz\u00e1g\u00A6Luxemburg\u00A6Litv\u00e1nia\u00A6Lesotho\u00A6Lib\u00e9ria\u00A6Sri Lanka\u00A6Liechtenstein\u00A6Saint Lucia\u00A6Libanon\u00A6Laoszi N\u00e9pi Demokratikus K\u00f6zt\u00e1rsas\u00e1g\u00A6Kazahszt\u00e1n\u00A6Kajm\u00e1n-szigetek\u00A6Kuwait\u00A6Korea, D\u00e9l\u00A6Korea, \u00c9szak\u00A6Saint Kitts \u00e9s Nevis\u00A6Comore-szigetek\u00A6Kiribati\u00A6Szamoa\u00A6Kambodzsa\u00A6Kirgiziszt\u00e1n\u00A6Kenya\u00A6Wallis \u00e9s Futuna Szigetek\u00A6Jap\u00e1n\u00A6Jord\u00e1nia\u00A6Jamaica\u00A6Vanuatu\u00A6Vietn\u00e1m\u00A6U.S. Virgin-szigetek\u00A6Brit Virgin-szigetek\u00A6Venezuela\u00A6Saint Vincent \u00e9s Grenadines\u00A6Vatik\u00e1n\u00A6Olaszorsz\u00e1g\u00A6Izland\u00A6Ir\u00e1n\u00A6Irak\u00A6\u00dczbegiszt\u00e1n\u00A6Brit Indiai Oce\u00e1n\u00A6Uruguay\u00A6India\u00A6Izrael\u00A6Egyes\u00fclt \u00c1llamok\u00A6\u00cdrorsz\u00e1g\u00A6Indon\u00e9zia\u00A6United States Minor Outlying Islands\u00A6Uganda\u00A6Ukrajna\u00A6Magyarorsz\u00e1g\u00A6Haiti\u00A6Horv\u00e1torsz\u00e1g\u00A6Tanz\u00e1nia\u00A6Honduras\u00A6Heard \u00e9s McDonald Szigetek\u00A6Taiwan\u00A6Tuvalu\u00A6Hong Kong S.A.R., China\u00A6Trinidad \u00e9s Tobago\u00A6T\u00f6r\u00f6korsz\u00e1g\u00A6Tonga\u00A6Tun\u00e9zia\u00A6T\u00fcrkmeniszt\u00e1n";

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

  private static final String languagesValues = "spanyol\u00A6kurd\u00A6eszperant\u00f3\u00A6kasm\u00edri\u00A6angol\u00A6g\u00f6r\u00f6g\u00A6kecsua\u00A6koreai\u00A6kannada\u00A6kambodzsai\u00A6gr\u00f6nlandi\u00A6kazah\u00A6volof\u00A6gr\u00faz\u00A6but\u00e1ni\u00A6j\u00e1vai\u00A6portug\u00e1l\u00A6pastu (afg\u00e1n)\u00A6n\u00e9met\u00A6lengyel\u00A6d\u00e1n\u00A6volap\u00fck\u00A6jap\u00e1n\u00A6vietn\u00e1mi\u00A6walesi\u00A6pandzs\u00e1bi\u00A6cseh\u00A6inuktitut\u00A6olasz\u00A6korzikai\u00A6izlandi\u00A6\u00fczb\u00e9g\u00A6orija\u00A6inupiak\u00A6urdu\u00A6orom\u00f3i\u00A6katal\u00e1n\u00A6interlingue\u00A6indon\u00e9z\u00A6ukr\u00e1n\u00A6interlingua\u00A6okszit\u00e1n\u00A6ujgur\u00A6\u00f6rm\u00e9ny\u00A6breton\u00A6magyar\u00A6tibeti\u00A6beng\u00e1li\u00A6horv\u00e1t\u00A6bislama\u00A6tui\u00A6bihari\u00A6bolg\u00e1r\u00A6tat\u00e1r\u00A6norv\u00e9g\u00A6belorusz\u00A6conga\u00A6hindi\u00A6t\u00f6r\u00f6k\u00A6holland\u00A6zulu\u00A6bask\u00edr\u00A6tonga\u00A6h\u00e9ber\u00A6szecsu\u00e1ni\u00A6tagalog\u00A6t\u00fcrkm\u00e9n\u00A6hausza\u00A6nep\u00e1li\u00A6azerbajdzs\u00e1ni\u00A6tigrinya\u00A6ajmara\u00A6thai\u00A6tadzsik\u00A6naurui\u00A6telugu\u00A6k\u00ednai\u00A6assz\u00e1mi\u00A6arab\u00A6tamil\u00A6gudzsar\u00e1ti\u00A6burmai\u00A6amhara\u00A6zsuang\u00A6m\u00e1ltai\u00A6mal\u00e1j\u00A6guarani\u00A6szuah\u00e9li\u00A6marati\u00A6sv\u00e9d\u00A6gal\u00edciai\u00A6szundan\u00e9z\u00A6afrikai\u00A6szeszot\u00f3\u00A6moldvai\u00A6sziszuati\u00A6mongol\u00A6szerb\u00A6alb\u00e1n\u00A6malajalam\u00A6abh\u00e1z\u00A6maced\u00f3n\u00A6afar\u00A6szom\u00e1li\u00A6sona\u00A6maori\u00A6sk\u00f3t (gael)\u00A6szamoai\u00A6szlov\u00e9n\u00A6madagaszk\u00e1ri\u00A6szlov\u00e1k\u00A6\u00edr\u00A6joruba\u00A6szingal\u00e9z\u00A6szerb-horv\u00e1t\u00A6sango\u00A6zsid\u00f3\u00A6szindi\u00A6fr\u00edz\u00A6szanszkrit\u00A6francia\u00A6lett\u00A6litv\u00e1n\u00A6fer\u00f6eri\u00A6kiruanda\u00A6orosz\u00A6laoszi\u00A6fidzsi\u00A6lingala\u00A6finn\u00A6rom\u00e1n\u00A6kirundi\u00A6r\u00e9torom\u00e1n\u00A6perzsa\u00A6latin\u00A6hosza\u00A6baszk\u00A6kirgiz\u00A6\u00e9szt";

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
    { "groupingSeparator", "\u00a0" },
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
    { "shortDateFormat", "yyyy.MM.dd." },
    { "mediumDateFormat", "yyyy.MM.dd." },
    { "longDateFormat", "yyyy. MMMM d." },
    { "fullDateFormat", "yyyy. MMMM d." },
    { "shortTimeFormat", "H:mm" },
    { "mediumTimeFormat", "H:mm:ss" },
    { "longTimeFormat", "H:mm:ss z" },
    { "fullTimeFormat", "H:mm:ss z" },
    { "territories", territories },
    { "languages", languages },
  };

  public Object[][] getContents() { return contents; }
}
