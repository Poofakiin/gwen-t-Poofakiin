package cl.uchile.dcc
package cardtests

import gwent.cards.unitcards._
import gwent.cards.unitcards.effects._
import munit.FunSuite

class CloseCombatCardTest extends FunSuite {

  val firstCardName: String = "Geralt of Rivia"
  val firstCardAttkPwr: Int = 6

  val secondCardName: String = "Dandelion"
  val secondCardAttkPwr: Int = 2


  val moralboost: ISpecialAbility = new MoralBoost()
  val closeBond: ISpecialAbility = new CloseBond()

  var card1: CloseCombatCard = _
  var card2: CloseCombatCard = _
  var card3: CloseCombatCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    card1 = new CloseCombatCard(firstCardName,firstCardAttkPwr, closeBond)
    card2 = new CloseCombatCard(secondCardName,secondCardAttkPwr, moralboost)
    card3 = new CloseCombatCard(firstCardName,firstCardAttkPwr)
  }
  test("A CloseCombatCard with special ability should be created with a name") {
    assertEquals(card1.name, firstCardName)
  }

  test("A CloseCombatCard without special ability should be created with a name") {
    assertEquals(card3.name, firstCardName)
  }
  
  test("A CloseCombatCard with special ability should hace a card type and it should be Unit Card") {
    assertEquals(card1.cardType, "Unit Card")
  }

  test("A CloseCombatCard without special ability should hace a card type and it should be Unit Card") {
    assertEquals(card3.cardType, "Unit Card")
  }

  test("A CloseCombatCard with special ability should be created with an attack power value") {
    assertEquals(card1.attackPower, firstCardAttkPwr)
  }

  test("A CloseCombatCard without special ability should be created with an attack power value") {
    assertEquals(card3.attackPower, firstCardAttkPwr)
  }

  test("If the CloseCombatCard constructor is used with the third variable SpecialAbility,"+
    "then the card should have a special ability") {
    assert(card1.getSpecialAbility().contains(closeBond))
  }

  test("If the constructor is used without the SpecialAbility parameter, "+
  "the CloseCombatCard should not have a special ability"){
    assertEquals(card3.getSpecialAbility(),None)
  }

  test("A CloseCombatCard with a special ability should be equal to another "+
    "card of the same class with the same attributes and it should have the same hashcode"){

    var sameAsCard1: CloseCombatCard = new CloseCombatCard(firstCardName,firstCardAttkPwr,closeBond)
    assertEquals(card1, sameAsCard1)
    assertEquals(sameAsCard1, card1)
    assertEquals(card1.hashCode(),sameAsCard1.hashCode())
    assertNotEquals(card1, card2)
    assertNotEquals(card2, card1)
    assertNotEquals(card1.hashCode(),card2.hashCode())
  }

  test("A CloseCombatCard without a special ability should be equal to another "+
    "card of the same class with the same attributes and it should have the same hashcode"){
    var sameAsCard3: CloseCombatCard = new CloseCombatCard(firstCardName,firstCardAttkPwr)
    assertEquals(card3, sameAsCard3)
    assertEquals(sameAsCard3,card3)
    assertEquals(card3.hashCode(),sameAsCard3.hashCode())
    assertNotEquals(card3, card2)
    assertNotEquals(card2,card3)
    assertNotEquals(card3.hashCode(),card2.hashCode())
  }


   test("A CloseCombatCard without a special ability should not be equal to "+
     "another card of the same attributes but with a special ability"){
     assertNotEquals(card3,card1)
   }

  test("A CloseCombatCard with a special ability should not be equal to "+
    "another card of the same attributes but without a special ability"){
    assertNotEquals(card1, card3)
  }
}
