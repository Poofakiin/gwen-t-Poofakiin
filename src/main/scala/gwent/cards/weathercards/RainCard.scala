package cl.uchile.dcc
package gwent.cards.weathercards

import weathertype._

/** A class that represent a Rain card in the game Gwent
 *
 * Rain cards have a name, a cardType and a weather type.
 * 
 */
class RainCard() extends AbstractWeatherCard() {
    /**
     * The type name of the card. For rain cards, this will always be "Rain Card".
     */
    val _name = "Rain Card"
    /**
     * The weather type of the card. For rain cards, this will always be an IWeathertype, Rain.
     */
    protected val _weatherType = new Rain()
    
    /** Checks if this RainCard is equal to another object.
     *
     * @param obj The object to compare to.
     * @return true if the object is a RainCard and has the same name
     * card type and weather Type, false otherwise.
     */
    override def equals(obj: Any): Boolean = {
        if (obj.isInstanceOf[RainCard]) {
            val other = obj.asInstanceOf[RainCard]
            (this eq other) ||
                (other._name == this._name &&
                    other._cardType == this._cardType &&
                    other._weatherType == this._weatherType)
        }
        else {
            false
        }
    }

    /** Returns the hash code of this RainCard.
     *
     * @return The hash code of this RainCard.
     */
    override def hashCode():Int = {
        val prime = 31
        var result= 1
        result = prime * result + classOf[RainCard].##
        result = prime * result + _name.##
        result = prime * result + _cardType.##
        result = prime * result + _weatherType.##
        result
    }
}
