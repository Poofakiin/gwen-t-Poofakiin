package cl.uchile.dcc
package gwent.cards.weathercards.weathertype

import munit.FunSuite

class FrostTest extends FunSuite{
    var frost1: IWeatherType = _
    var frost2: IWeatherType = _

    override def beforeEach(context: BeforeEach): Unit = {
        frost1 = Frost()
        frost2 = Frost()
    }

    test("A Frost should have a name and it should be Frost") {
        assertEquals(frost1.name, "Frost")
    }

    test("Any Frost should be equal to another and it should have the same hashcode"){
        assertEquals(frost1, frost2)
        assertEquals(frost2, frost1)
        assertEquals(frost1.hashCode(),frost2.hashCode())
    }
}
