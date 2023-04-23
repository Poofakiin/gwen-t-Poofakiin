package cl.uchile.dcc
package cardtests

import gwent.cards.unitcards._
import gwent.cards.unitcards.effects._
import munit.FunSuite

class SiegeCardTest extends FunSuite {
  val firstCardName: String = "Catapult"
  val firstCardAttkPwr: Int = 8

  val secondCardName: String = "Kaedweni Siege Expert"
  val secondCardAttkPwr: Int = 1


  val moralboost: ISpecialAbility = new MoralBoost()
  val closeBond: ISpecialAbility = new CloseBond()

  var card1: SiegeCard = _
  var card2: SiegeCard = _
  var card3: SiegeCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    card1 = new SiegeCard(firstCardName,firstCardAttkPwr, closeBond)
    card2 = new SiegeCard(secondCardName,secondCardAttkPwr, moralboost)
    card3 = new SiegeCard(firstCardName,firstCardAttkPwr)
  }
  test("A SiegeCard with special ability should be created with a name") {
    assertEquals(card1.name, firstCardName)
  }

  test("A SiegeCard without special ability should be created with a name") {
    assertEquals(card3.name, firstCardName)
  }

  test("A SiegeCard with special ability should hace a card type and it should be Unit Card") {
    assertEquals(card1.cardType, "Unit Card")
  }

  test("A SiegeCard without special ability should hace a card type and it should be Unit Card") {
    assertEquals(card3.cardType, "Unit Card")
  }

  test("A SiegeCard with special ability should be created with an attack power value") {
    assertEquals(card1.attackPower, firstCardAttkPwr)
  }

  test("A SiegeCard without special ability should be created with an attack power value") {
    assertEquals(card3.attackPower, firstCardAttkPwr)
  }


  test("If the SiegeCard constructor is used with the third variable SpecialAbility,"+
    "then the card should have a special ability") {
    assert(card1.getSpecialAbility().contains(closeBond))
  }

  test("If the constructor is used without the SpecialAbility parameter, "+
    "the SiegeCard should not have a special ability"){
    assertEquals(card3.getSpecialAbility(),None)
  }

  test("A SiegeCard with a special ability should be equal to another "+
    "card of the same class with the same attributes"){

    var sameAsCard1: SiegeCard = new SiegeCard(firstCardName,firstCardAttkPwr,closeBond)
    assertEquals(card1, sameAsCard1)
    assertEquals(sameAsCard1, card1)
    assertNotEquals(card1, card2)
    assertNotEquals(card2, card1)
  }

  test("A SiegeCard without a special ability should be equal to another "+
    "card of the same class with the same attributes"){
    var sameAsCard3: SiegeCard = new SiegeCard(firstCardName,firstCardAttkPwr)
    assertEquals(card3, sameAsCard3)
    assertEquals(sameAsCard3,card3)
    assertNotEquals(card3, card2)
    assertNotEquals(card2,card3)
  }

  test("A SiegeCard without a special ability should not be equal to "+
    "another card of the same attributes but with a special ability"){
    assertNotEquals(card3,card1)
  }

  test("A SiegeCard with a special ability should not be equal to "+
    "another card of the same attributes but without a special ability"){
    assertNotEquals(card1, card3)
  }

}
