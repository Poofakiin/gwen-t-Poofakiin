package cl.uchile.dcc
import munit.FunSuite
import cl.uchile.dcc.gwent.Card

class CardTest extends FunSuite {
  val firstName = "Vernon Roche"
  val secondName = "Geralt of Rivia"
  val cardType = "Hero"

  var vernonRoche = new Card(firstName,cardType)
  var geraltOfRivia = new Card(secondName, cardType)
  test("Una carta debe tener su nombre propio"){
    assertEquals(vernonRoche.name, firstName)
    assertEquals(geraltOfRivia.name, secondName)
  }
  test("Una Carta debe tener una clasificacion que la identifica"){
    assertEquals(vernonRoche.cardType, cardType)
    assertEquals(geraltOfRivia.cardType, cardType)
  }
}
