package cl.uchile.dcc
import munit.FunSuite
import cl.uchile.dcc.gwent.Card
import cl.uchile.dcc.gwent.Player
import cl.uchile.dcc.gwent.UnitCard
import cl.uchile.dcc.gwent.WeatherCard

import scala.collection.mutable.ArrayBuffer

class PlayerTest extends FunSuite {
  val vernonRoche = new Card("Vernon Roche", "hero")
  val geraltOfRivia = new Card("Geralt of Rivia", "hero")
  val papimicky = new Card("Papi Micky", "thief")
  val kingFoltest = new Card("King Foltest", "king")
  val sunnyday = new Card("Sunny Day", "Sun")

  var handArray = ArrayBuffer(vernonRoche, geraltOfRivia)
  var deckArray = ArrayBuffer(papimicky, kingFoltest, sunnyday)
  var emptyArray = ArrayBuffer()
  var playerName = "Eridin"
  var gems = 2

  var firstPlayer : Player = _

  override def beforeEach(context: BeforeEach): Unit = {
    firstPlayer = new Player("Eridin", 2, ArrayBuffer(papimicky, kingFoltest, sunnyday), ArrayBuffer(vernonRoche, geraltOfRivia))
  }

  test("Todo jugador debe tener Nombre") {
    assertEquals(firstPlayer.name, playerName)
  }

  test("Todo jugador debe tener un contador de gemas") {
    assertEquals(firstPlayer.gemsCounter, gems)
  }

  test("Todo jugador debe tener una mano de cartas") {
    assertEquals(firstPlayer.hand, handArray)
  }

  test("Todo jugador debe tener un mazo de cartas") {
    assertEquals(firstPlayer.deck, deckArray)
  }

  test("Todo jugador debe ser capaz de jugar una carta"){
    assertEquals(firstPlayer.hand,handArray)
    firstPlayer.playCard(vernonRoche)
    assertEquals(firstPlayer.hand,ArrayBuffer(geraltOfRivia))
  }

  test("Todo jugador debe ser capaz de robar una carta de su mazo"){
    assertEquals(firstPlayer.hand, handArray)
    assertEquals(firstPlayer.deck, deckArray)
    firstPlayer.getCard(papimicky)
    assertEquals(firstPlayer.hand, ArrayBuffer(vernonRoche, geraltOfRivia, papimicky))
    assertEquals(firstPlayer.deck, ArrayBuffer(kingFoltest, sunnyday))
  }

}
