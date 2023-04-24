package cl.uchile.dcc
package gwent.cards.weathercards
import gwent.cards.ICard
import weathertype.IWeatherType

/** A class that represents an weather type of card in the Gwent game.
 *
 *  weather cards have a name, a cardType, and a weather type.
 *
 */
abstract class AbstractWeatherCard() extends IWeatherCard {
    
    /**
     * The name of the card.
     */
    val name:String
    
    /**
     * The weather type of the card.
     */
    val weatherType: IWeatherType
    
    /**
     * The type of the card. For unit cards, this will always be "Weather Card".
     */
    val cardType: String = "Weather Card"

    /** Returns the weather type of the weather card.
     *
     * This method returns the weather type of the weather card. It will always return
     * an IWeatherType object
     *
     * @return The weather type of the weather card.
     */
    override def getWeatherType(): IWeatherType = {
        this.weatherType
    }
}
