#Testaus

Joitakin luokista oli erittäin vaikea testata, sillä monet niistä olivat suoraan sidoksissa piirtämiseen. Yksikkötestien lisäksi kirjoitin graafiselle käyttöliittymälle omat testit, jotka simuloivat käyttäjän toimintaa, käyttäen AssertJ Swing JUnit -kirjastoa. Yrittäessäni generoida Pit-raporttia tämän jälkeen testit olivat liian hitaita, joten Pit-raportissa ei ole näitä testejä. Testejä ei kuitenkaan ole jätetty huomiotta. Jos halutaan generoida Pit-raportti, tulee näihin testeihin lisäty ignore poistaa ennen sitä.

Graafisten testien tekoa vaikeutti game loop, joka pyörii, kunnes peli päättyy. Swingin testauskirjasto jäi jumiin,
kunnes laitoin sen omaan säikeeseensä pyörimään. Tämän takia Pit:istä tuli niiden kohdalla erittäin hidas.

Testien apuluokat ovat test.utils paketissa.

Itse peliä on testattu myös runsaasti käsin. Esimerkiksi lyöty palloja pussiin, testattu kontrollien toimivuus ja että peli voidaan
aloittaa alusta oikein.
