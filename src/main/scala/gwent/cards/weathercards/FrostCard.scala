package cl.uchile.dcc
package gwent.cards.weathercards

import weathertype.Frost

/** A class that represent a Frost card in the game Gwent
 *
 * Frost cards have a name, a cardType and a weather type.
 *
 */
class FrostCard extends AbstractWeatherCard() {
    /**
     * The type name of the card. For Frost Cards, this will always be " Frost Card".
     */
    val name = "Frost Card"
    /**
     * The weather type of the card. For Frost Cards, this will always be an IWeathertype, Frost.
     */
    val weatherType = new Frost()

    /** Checks if this Frost Card is equal to another object.
     *
     * @param obj The object to compare to.
     * @return true if the object is a FrostCard and has the same name
     * card type and weather Type, false otherwise.
     */
    override def equals(obj: Any): Boolean = {
        if (obj.isInstanceOf[FrostCard]) {
            val other = obj.asInstanceOf[FrostCard]
            (this eq other) ||
                (other.name == this.name &&
                    other.cardType == this.cardType &&
                    other.weatherType == this.weatherType)
        }
        else {
            false
        }
    }

    /** Returns the hash code of this FrostCard.
     *
     * @return The hash code of this FrostCard.
     */
    override def hashCode():Int = {
        val prime = 31
        var result= 1
        result = prime * result + classOf[FrostCard].##
        result = prime * result + name.##
        result = prime * result + cardType.##
        result = prime * result + weatherType.##
        result
    }
}
