package cl.uchile.dcc
package gwent.cards.weathercards
import gwent.cards.ICard
import weathertype.IWeatherType

/**
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
