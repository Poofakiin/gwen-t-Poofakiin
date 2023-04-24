package cl.uchile.dcc
package gwent.cards.weathercards

import weathertype.Fog
import weathertype.IWeatherType

/** A class that represent a Fog card in the game Gwent
 *
 * Fog cards have a name, a cardType and a weather type.
 *
 */
class FogCard extends AbstractWeatherCard() {

    /**
     * The type name of the card. For fog cards, this will always be "Fog Card".
     */
    val name = "Fog Card"

    /**
     * The weather type of the card. For fog cards, this will always be an IWeathertype, Fog.
     */
    val weatherType: IWeatherType = new Fog()

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
                (other.name == this.name &&
                    other.cardType == this.cardType &&
                    other.weatherType == this.weatherType)
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
        result = prime * result + name.##
        result = prime * result + cardType.##
        result = prime * result + weatherType.##
        result
    }
}
