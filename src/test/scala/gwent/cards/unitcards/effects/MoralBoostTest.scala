package cl.uchile.dcc
package gwent.cards.unitcards.effects

import munit.FunSuite

class MoralBoostTest  extends FunSuite {

  var effect1: MoralBoost = _
  var effect2: MoralBoost = _

  override def beforeEach(context: BeforeEach): Unit = {
    effect1 = MoralBoost()
    effect2 = MoralBoost()
  }

  test("A MoralBoost should have a name and it should be Close Bond") {
    assertEquals(effect1.name, "Moral Boost")
  }

  test("Any MoralBoost should be equal to another and it should have the same hashcode") {
    assertEquals(effect1, effect2)
    assertEquals(effect2, effect1)
    assertEquals(effect1.hashCode(), effect2.hashCode())
  }

}