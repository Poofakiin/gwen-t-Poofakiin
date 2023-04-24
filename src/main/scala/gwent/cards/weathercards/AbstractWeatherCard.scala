package cl.uchile.dcc
package gwent.cards.weathercards
import gwent.cards.ICard
import weathertype.IWeatherType

/** A class that represents a weather type card in the Gwent game
 *
 *  Weather cards have a name and a type.
 *
 * @param name the name of the weather card.
 * @param cardType the type of the weather card.
 *
 */
abstract class AbstractWeatherCard() extends IWeatherCard {
  val name:String
  val weatherType: IWeatherType
  val cardType: String = "Weather Card"

  override def getWeatherType(): IWeatherType = {
    this.weatherType
  }
}
