package cl.uchile.dcc
package gwent.cards.weathercards


/** A class that represent a Clear Weather card in the game Gwent
 *
 * Clear Weather cards have a name, a cardType and a weather type.
 *
 */
class ClearWeatherCard extends AbstractWeatherCard() {
    /**
     * The type name of the card. For Clear Weather cards, this will always be "Clear Weather".
     */
    val name = "Clear Weather"
    /**
     * The weather type of the card. For Clear Weather cards, this will always be an IWeathertype, ClearWeather.
     */
    val weatherType = new ClearWeather()

    /** Checks if this Clear Weather Card is equal to another object.
     *
     * @param obj The object to compare to.
     * @return true if the object is a ClearWeatherCard and has the same name
     * card type and weather Type, false otherwise.
     */
    override def equals(obj: Any): Boolean = {
        if (obj.isInstanceOf[ClearWeatherCard]) {
            val other = obj.asInstanceOf[ClearWeatherCard]
            (this eq other) ||
                (other.name == this.name &&
                    other.cardType == this.cardType &&
                    other.weatherType == this.weatherType)
        }
        else {
            false
        }
    }

    /** Returns the hash code of this ClearWeatherCard.
     *
     * @return The hash code of this ClearWeatherCard.
     */
    override def hashCode():Int = {
        val prime = 31
        var result= 1
        result = prime * result + classOf[ClearWeatherCard].##
        result = prime * result + name.##
        result = prime * result + cardType.##
        result = prime * result + weatherType.##
        result
    }
}