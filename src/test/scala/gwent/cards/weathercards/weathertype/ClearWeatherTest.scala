package cl.uchile.dcc
package gwent.cards.weathercards.weathertype

import munit.FunSuite

class ClearWeatherTest extends FunSuite{
    var clearWeather: IWeatherType = _
    var clearWeather2: IWeatherType = _

    override def beforeEach(context: BeforeEach): Unit = {
        clearWeather = ClearWeather()
        clearWeather2 = ClearWeather()
    }

    test("A ClearWeather should have a name and it should be Clear Weather") {
        assertEquals(clearWeather.name, "Clear Weather")
    }

    test("Any Clear Weather should be equal to another and it should have the same hashcode"){
        assertEquals(clearWeather, clearWeather2)
        assertEquals(clearWeather2, clearWeather)
        assertEquals(clearWeather.hashCode(),clearWeather2.hashCode())
    }
}
