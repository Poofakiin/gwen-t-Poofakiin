package cl.uchile.dcc
package gwent.cards.weathercards.weathertype

import munit.FunSuite

class RainTest extends FunSuite {
  var rain1: IWeatherType = _
  var rain2: IWeatherType = _

  override def beforeEach(context: BeforeEach): Unit = {
    rain1 = Rain()
    rain2 = Rain()
  }

  test("A Rain should have a name and it should be Rain") {
    assertEquals(rain1.name, "Rain")
  }

  test("Any Rain should be equal to another and it should have the same hashcode") {
    assertEquals(rain1, rain2)
    assertEquals(rain1, rain2)
    assertEquals(rain1.hashCode(), rain2.hashCode())
  }
}