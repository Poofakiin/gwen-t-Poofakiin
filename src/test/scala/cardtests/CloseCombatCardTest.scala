package cl.uchile.dcc
package cardtests

import cl.uchile.dcc.gwent.cards.unitcards.CloseCombatCard
import munit.FunSuite

class CloseCombatCardTest extends FunSuite {



  val firstName = "Vernon Roche"
  val secondName = "Geralt of Rivia"
  val cardType = "Hero"

  var vernonRoche = new
  var geraltOfRivia = new CloseCombatCard(secondName)
  test("Una carta debe tener su nombre propio"){
    assertEquals(vernonRoche.name, firstName)
    assertEquals(geraltOfRivia.name, secondName)
  }
  test("Una Carta debe tener una clasificacion que la identifica"){
    assertEquals(vernonRoche.cardType, cardType)
    assertEquals(geraltOfRivia.cardType, cardType)
  }
}
