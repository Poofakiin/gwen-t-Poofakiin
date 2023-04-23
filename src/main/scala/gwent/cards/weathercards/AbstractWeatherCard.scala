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

  override def useWeatherType(): Unit = {
    this.weatherType.affectWeather()
  }


  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[AbstractWeatherCard]) {
      val other = obj.asInstanceOf[AbstractWeatherCard]
      (this eq other) ||
        (other.name == this.name &&
          other.cardType == this.cardType &&
          other.weatherType == this.weatherType)
    }
    else {
      false
    }
  }
  override def hashCode():Int = {
    val prime = 31
    var result= 1
    result = prime * result + classOf[AbstractWeatherCard].##
    result = prime * result + name.##
    result = prime * result + cardType.##
    result = prime * result + weatherType.##
    result
  }
}
