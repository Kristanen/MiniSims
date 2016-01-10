#Käyttoohje
MiniPool on pienimuotoinen biljardipeli, jossa tarkoituksena on pussittaa värillisiä palloja valkoisen pallon avulla mahdollisimman vähillä lyönneillä. Jokainen lyönti kasvattaa pistelaskuria ja mitä pienempi pistelaskurin arvo on pelin lopussa, sitä paremmin peli pelattiin. Valkoista palloa ei kuitenkaan saa pussittaa. Mikäli valkoisen pallon pussittaa, rangaistuksena on kaksi lisäpistettä. Peli päättyy, kun kaikki värilliset pallot on pussitettu. Uuden pelin voi aloittaa “New game” -nappulasta.

Valkoista palloa lyödään antamalla haluttu kulma asteina ja nopeus prosentteina maksiminopeudesta. Kulman suuruus kasvaa vastapäivään ja nollakulma on positiivisen x-akselin suuntainen. Kulma annetaan kentässä “Power in angles” ja nopeus kentässä “Power in %”. Valittujen arvojen syöttämisen jälkeen painetaan “Hit”-nappulaa pallon lyömiseksi.

##Huomioita
Huomasin yliopiston koneella, että ohjelmassa esiintyy vilkkumista. Ilmeisesti tätä esiintyy toisilla koneilla enemmän kuin toisilla. Kotikoneellani vilkkumista esiintyy erittäin harvoin.

Joitakin luokista oli erittäin vaikea testata, sillä monet niistä olivat suoraan sidoksissa piirtämiseen. Yksikkötestien lisäksi kirjoitin graafiselle käyttöliittymälle omat testit, jotka simuloivat käyttäjän toimintaa, käyttäen AssertJ Swing JUnit -kirjastoa. Yrittäessäni generoida Pit-raporttia tämän jälkeen testit olivat liian hitaita, joten Pit-raportissa ei ole näitä testejä.
