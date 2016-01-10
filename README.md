#Ohjelman kuvaus
####Aihe: MiniPool
MiniPool on yksinkertainen versio biljardista. MiniPoolissa pelaaja yrittää pussittaa palloja säätämällä lyönnin voimakkuutta ja suuntaa eli toisin sanoen valkoisen pallon lähtönopeutta ja -suuntaa. Valkoista palloa ei saa pussittaa, vaan sen avulla on tarkoitus pussittaa muita palloja. Peli päättyy, kun kaikki pallot valkoista lukuunottamatta on saatu pussitettua.

Pelialusta on suorakulmion muotoinen, jonka vaakasuorat sivut ovat pystysuoria pidemmät. Pussit sijaitsevat suorakulmion kaikissa kulmissa sekä pitkien sivujen keskikohdissa.

####Käyttäjä:
Pelaaja

####Käyttäjän toiminnot:
- lyönnin voimakkuuden säätäminen
- lyönnin suunnan säätäminen
- pallon lyöminen

##Huomioita
Huomasin yliopiston koneella, että ohjelmassa esiintyy vilkkumista. Ilmeisesti tätä esiintyy toisilla koneilla enemmän kuin toisilla. Kotikoneellani vilkkumista esiintyy erittäin harvoin.

Joitakin luokista oli erittäin vaikea testata, sillä monet niistä olivat suoraan sidoksissa piirtämiseen. Yksikkötestien lisäksi kirjoitin graafiselle käyttöliittymälle omat testit, jotka simuloivat käyttäjän toimintaa, käyttäen AssertJ Swing JUnit -kirjastoa. Yrittäessäni generoida Pit-raporttia tämän jälkeen testit olivat liian hitaita, joten Pit-raportissa ei ole näitä testejä.
