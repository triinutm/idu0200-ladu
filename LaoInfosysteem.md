# Sissejuhatus #

SISSE LOGIMINE

Kasutaja: juhan

Parool: juurikas34metsX


Funktsionaalsused

RÜHM 1
- Toodete haldus (toote otsing, toote lisamine, toote andmete muutmine)

RÜHM 2
- Lao toimingud (arvele võtmine, maha kandmine, ühest laost teise liigutamine)

RÜHM 3
- Hinnakirja tegemine (hinnakirja loomine/muutmine/kustutame, hinnakirja klientide haldus, hinnakirja toodete haldus)


Tegemist on laosüsteemiga, täpsemat infot leiab:

http://maurus.ttu.ee/ained/IDU0200_2013/doc/13/LADU_juhend.pdf

# Nõuded #
Kontroller ei tohi :
nõue 1.1.  sisaldada otse andmebaasiga suhtlevat koodi (JDBC/SQL)

nõue 1.2.  genereerida väljundit (sisaldada  brauserisse saadetatavat HTML-i genereerivat koodi)

nõue 2.3. Esitluskomponent (servlet, JSP) ei tohi sisaldada andmebaasiga suhtlevat koodi.

nõue 2.4. Esitluskomponendid saavad oma andmeid „mudeli“ (siin võib neid nimetada ehk ka andmeid sisaldavateks komponentideks) komponentide poole pöördudes. Sellised pöördumised mudeli poole on võimalik kirjutada  esitluskomponendi koodi.

nõue 3.5 Vähemalt ühe veebilehe või kasutajavormi või alamvormi HTML-i genereerimiseks kasutada XSLT-teisendust.

nõue 4.6. Vähemalt ühe veebilehe (või keerulisema html-vormi või lehel alamosa) genereerimise realiseerimisel tuleks kasutada „Composite View“ mustrit.

nõue 5.7. asutage vähemalt ühes sellises  andmete salvestamise tegevuses „validator“-tüüpi objekti.  Teie ülesanne on vähemalt ühe andmete sisestuse/muudatuse korral teha nii et vigaste andmete salvestamise katsel püütaks vead validatori poolt kinni ja näidataks
IGA andmevälja juures (mille sisu oli ebakorrektne) veateadet (vaata allpool olevat kasutajavormide näidet)

nõue 6.8. Rakenduse andmebaasiühenduse parameetrid (andmebaasi serveri aadress, andmebaasi nimi, andmebaasi port, andmebaasi kasutajanimi ja parool) ei tohiks olla  koodi sisse kirjutatud vaid need peaks olema salvestatud konfiguratsioonifailis. Väga hästi sobib selleks näiteks ava platvormil kasutatavad „properties“-tüüpi failid (vaata selle kohta harjutustundides tulevaid näiteid)

nõue 6.9.
Kasutage rakenduses täiendavalt selliseid disainimustreid mida selles materjalis mainitud ei ole (siin juhendis on mainitud järgmiseid idsianimustreid :  „MVC“, „Composite View“, „Data Access Object“). Selliseid täiendavaid, teie enda poolt valitud mustreid peaks olema vähemalt 3. Proovige oma rakenduses neid vähemalt kolme mustrit kasutada.

nõue 9.10.
•Osade andmebaasiga seotud operatsioonide realiseerimiseksl tuleb andmebaasiga suhtlemiseks kasutada ORM-vahekihi tarkvara. (Object Relational Mapping)

•Osade andmebaasidega seotud operatsioonide realiseerimiseks tuleb kasutada JDBC-d (Java Database Connectivity) ja SQL lauseid. JDBC-d tuleb kasutada Data Access Object mustrit (DAO) realiseeriva klassi sees.(Ehk siis teiste sõnadega – andmebaasiga suhtleb DAO klass mille meetodid sisaldavad andmebaasi poole pöördumisi SQL-lausetega üle JDBC API)

nõue 9.11.
Kasutage ühes andmeuuendus-tegevuses SQL-protseduuri väljakutsumist . Töö andmetega (SQL-laused) teeb siis ära andmebaasi salvestatud SQL-protseduur ja  rakenduses ei sisaldu selle tegevusega seotud SQL-lauseid – rakenduses on ainult SQL-protseduuri väljakutse.

nõue 10.12.
Kasutage XMLHttpRequest objekti (nn. „AJAX-väljakutse“) andmete tõmbamiseks serveril, andmete tagasisaatmiseks serverile ja selle tagasisaatmise tulemuste näitamiseks veebilehel (mitu ajaxi varianti on)

nõue 11.13. Kirjutage üks käsurealt käivitatav test kasutades JUnit testimis-raamistikku.

nõue 12.14. Logifaili olemasolu

nõue 13.15. Kaitsmise ajal peab rakenduse lähtekood peab olema kopeeritud TTÜ serverisse tudengi kodukataloogi  (vabal valikul imbi.ld.ttu.ee või hektor4.ttu.ee) ja peab olema võimalik seda rakendust linuxi käsureal uuesti kompileerida  ja serverile installeerida.

dokumentatsioon:

nõue 15.17.  Vabalt valitud vahendiga (ArgoUML, Rational, MS Visio) kandke klassidiagrammidele kõik teie poolt loodud komponendid – klassid, JSP-lehed, XSL-lehed,SQL-protseduurid. Kuigi vormistuseks on klassidiagramm tuleks nendlee diagrammidel kanda  kõik komponendid – ka selliseid mis ei ole vormistatud kui klassid (JSP-lehed , SQL-protseduurid vms.)

nõue 15.18. Kaks jada- või koostöödiagrammi.

nõue 15.19.  Pange kirja milliseid disainimustreid te kasutasite oma rakenduses (lisaks MVC, DAO ja Composite View mustritele) ja kus teie rakenduses on neid mustreid realsieerivad osad (klassid). Võib olla teksti vormis, mõne lausega iga mustri kohta.

# Sarnased lahendused #
1. https://code.google.com/p/ladu/source/browse/#svn

2. http://subversion.assembla.com/svn/service-mvc/trunk/
> http://imbi.ld.ttu.ee:7500/t104445_t103950_ladu/

3.http://hektor4.ttu.ee:7500/t104493_ladu/s
Kasutaja: olga
Parool: test

# Detailid #

Add your content here.  Format your content with:
  * Text in **bold** or _italic_
  * Headings, paragraphs, and lists
  * Automatic links to other wiki pages