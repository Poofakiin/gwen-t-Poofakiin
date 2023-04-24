package cl.uchile.dcc
package gwent.cards.weathercards.weathertype

import munit.FunSuite

class FogTest extends FunSuite{
  var fog1: IWeatherType = _
  var fog2: IWeatherType = _
  
  override def beforeEach(context: BeforeEach): Unit = {
    fog1 = Fog()
    fog2 = Fog()
  }

  test("A Fog should have a name and it should be Fog") {
    assertEquals(fog1.name, "Fog")
  }

  test("Any Fog should be equal to another and it should have the same hashcode"){
    assertEquals(fog1, fog2)
    assertEquals(fog2, fog1)
    assertEquals(fog1.hashCode(),fog2.hashCode())
  }
}
