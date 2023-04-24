package cl.uchile.dcc
package gwent.cards.weathercards

import weathertype._
import munit.FunSuite

class RainCardTest extends FunSuite {
    val rain: IWeatherType = new Rain()

    var card1: RainCard = _
    var card2: RainCard = _

    override def beforeEach(context: BeforeEach): Unit = {
        card1 = new RainCard()
        card2 = new RainCard()
    }

    test("A RainCard should have a name and it should be Rain Card") {
        assertEquals(card1.name, "Rain Card")
    }

    test("A RainCard should have a card type and it should be Weather Card") {
        assertEquals(card1.cardType, "Weather Card")
    }

    test("A RainCard should have a weather type and it should be Rain") {
        assertEquals(card1.getWeatherType(), rain)
    }

    test("Any RainCard should be equal to another and it should have the same hashcode"){
        assertEquals(card1, card2)
        assertEquals(card2, card1)
        assertEquals(card1.hashCode(),card2.hashCode())
    }
}

