package cl.uchile.dcc
package cardtests

import gwent.cards.unitcards._
import gwent.cards.unitcards.effects._
import munit.FunSuite
import munit.Clue.generate

class CloseCombatCardTest extends FunSuite {



  val firstName = "Vernon Roche"
  val secondName = "Geralt of Rivia"
  val cardType = "Hero"
  val closeBond: Option[CloseBond] = Some(new CloseBond())

  var geraltOfRivia = new CloseCombatCard(secondName,2, closeBond)

  test("Una carta debe tener su nombre propio"){
    assertEquals(geraltOfRivia.name, firstName)
    assertEquals(geraltOfRivia.name, secondName)
  }
  test("Una Carta debe tener una clasificacion que la identifica"){
    assertEquals(geraltOfRivia.cardType, cardType)
    assertEquals(geraltOfRivia.cardType, cardType)
  }
}
