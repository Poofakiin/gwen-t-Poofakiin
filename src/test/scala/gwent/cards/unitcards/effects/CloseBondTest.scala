package cl.uchile.dcc
package gwent.cards.unitcards.effects

import munit.FunSuite


class CloseBondTest extends FunSuite{

    var effect1: CloseBond = _
    var effect2: CloseBond = _
    override def beforeEach(context: BeforeEach): Unit = {
        effect1 = CloseBond()
        effect2 = CloseBond()
    }

    test("A CloseBond should have a name and it should be Close Bond") {
        assertEquals(effect1.name, "Close Bond")
    }

    test("Any CloseBond should be equal to another and it should have the same hashcode"){
        assertEquals(effect1, effect2)
        assertEquals(effect2, effect1)
        assertEquals(effect1.hashCode(),effect2.hashCode())
    }

}
