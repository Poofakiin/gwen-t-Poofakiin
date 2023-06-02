package cl.uchile.dcc
package gwent.cards.weathercards

import gwent.cards.weathercards.weathertype.{ClearWeather, IWeatherType}

import munit.FunSuite

class ClearWeatherCardTest extends FunSuite{
    val clearWeather: IWeatherType = new ClearWeather()

    var card1: ClearWeatherCard = _
    var card2: ClearWeatherCard = _

    override def beforeEach(context: BeforeEach): Unit = {
        card1 = new ClearWeatherCard()
        card2 = new ClearWeatherCard()
    }

    test("A ClearWeatherCard should have a name and it should be Clear Weather Card") {
        assertEquals(card1.name, "Clear Weather Card")
    }

    test("A ClearWeatherCard should have a card type and it should be Weather Card") {
        assertEquals(card1.cardType, "Weather Card")
    }

    test("A ClearWeatherCard should have a weather type and it should be ClearWeather") {
        assertEquals(card1.getWeatherType(), clearWeather)
    }

    test("Any ClearWeatherCard should be equal to another and it should have the same hashcode"){
        assertEquals(card1, card2)
        assertEquals(card2, card1)
        assertEquals(card1.hashCode(),card2.hashCode())
    }
}
