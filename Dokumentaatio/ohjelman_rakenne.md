#Rakennekuvaus
Ohjelmassa on managereita ja entityitä. Entityt kuvaavat kaikkia biljardipelissä olevia itsenäisiä kokonaisuuksia, kuten seiniä ja palloja. Entiteillä on update-metodi, jota kutsutaan game loopin jokaisella kierroksella.

Ohjelman managereiden tehtävänä on hallinnoida ohjelmaa omien vastuualueidensa kautta. Entity manager pitää kirjaa kaikista pelin entiteistä, Collision manager päivittää World-olioita dyn4j-kirjastolle, joka huolehtii pelin törmäyksen havainnoinnista, Rendering manager vastaa ikkunasta ja sen eri elementtien päivittämisestä sekä piirtämisestä, vaikka piirto tapahtuukin entiteissä itsessään, ja PoolGame pitää kirjaa pelin tilasta (sisältää PoolTable-olion (pelipöytä) ja pelin pisteet).

Circle ja Rectangle ovat luokkia, joita käytetään monessa yhteydessä, kuten pallojen ja seinien määrittelyn tukena.
