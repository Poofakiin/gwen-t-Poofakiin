package cl.uchile.dcc
package gwent.cards.weathercards

import gwent.cards.weathercards.weathertype.{Frost, IWeatherType}

import munit.FunSuite

class FrostCardTest extends FunSuite{
    val frost: IWeatherType = new Frost()

    var card1: FrostCard = _
    var card2: FrostCard = _

    override def beforeEach(context: BeforeEach): Unit = {
        card1 = new FrostCard()
        card2 = new FrostCard()
    }

    test("A FrostCard should have a name and it should be Frost Card") {
        assertEquals(card1.name, "Frost Card")
    }

    test("A FrostCard should have a card type and it should be Frost Card") {
        assertEquals(card1.cardType, "Weather Card")
    }

    test("A FrostCard should have a weather type and it should be Frost") {
        assertEquals(card1.getWeatherType(), frost)
    }

    test("Any FrostCard should be equal to another and it should have the same hashcode"){
        assertEquals(card1, card2)
        assertEquals(card2, card1)
        assertEquals(card1.hashCode(),card2.hashCode())
    }
}
