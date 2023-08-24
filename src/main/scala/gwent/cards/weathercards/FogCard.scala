package cl.uchile.dcc
package gwent.cards.weathercards

import weathertype._
/** A class that represent a Fog card in the game Gwent
 *
 * Fog cards have a name, a cardType and a weather type.
 *
 */
class FogCard extends AbstractWeatherCard() {

    /**
     * The type name of the card. For fog cards, this will always be "Fog Card".
     */
    val _name = "Fog Card"

    /**
     * The weather type of the card. For fog cards, this will always be an IWeathertype, Fog.
     */
    protected val _weatherType: IWeatherType = new Fog()

    /** Checks if this FogCard is equal to another object.
     *
     * @param obj The object to compare to.
     * @return true if the object is a FogCard and has the same name
     * card type and weather Type, false otherwise.
     */
    override def equals(obj: Any): Boolean = {
        if (obj.isInstanceOf[FogCard]) {
            val other = obj.asInstanceOf[FogCard]
            (this eq other) ||
                (other._name == this._name &&
                    other._cardType == this._cardType &&
                    other._weatherType == this._weatherType)
        }
        else {
            false
        }
    }

    /** Returns the hash code of this FogCard.
     *
     * @return The hash code of this FogCard.
     */
    override def hashCode():Int = {
        val prime = 31
        var result= 1
        result = prime * result + classOf[FogCard].##
        result = prime * result + _name.##
        result = prime * result + _cardType.##
        result = prime * result + _weatherType.##
        result
    }
}
