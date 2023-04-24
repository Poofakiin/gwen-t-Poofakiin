package cl.uchile.dcc
package gwent.cards.weathercards
import munit.FunSuite
import weathertype._

class FogCardTest extends FunSuite{
  val fog: IWeatherType = new Fog()

  var card1: FogCard = _
  var card2: FogCard = _

  override def beforeEach(context: BeforeEach): Unit = {
    card1 = new FogCard()
    card2 = new FogCard()
  }

  test("A FogCard should have a name and it should be Fog Card") {
    assertEquals(card1.name, "Fog Card")
  }

  test("A FogCard should have a card type and it should be Weather Card") {
    assertEquals(card1.cardType, "Weather Card")
  }

  test("A FogCard should have a weather type and it should be Fog") {
    assertEquals(card1.getWeatherType(), fog)
  }

  test("Any FogCard should be equal to another and it should have the same hashcode"){
    assertEquals(card1, card2)
    assertEquals(card2, card1)
    assertEquals(card1.hashCode(),card2.hashCode())
  }
}
