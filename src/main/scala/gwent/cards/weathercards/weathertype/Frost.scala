package cl.uchile.dcc
package gwent.cards.weathercards.weathertype


/** A class that represent a Frost weather type in the game Gwent
 *
 * Frost weather type have a name.
 *
 */
class Frost extends IWeatherType{

    /**
     * The name of the the weather type. For a Frost, this will always
     * be "Frost".
     */
    val name:String = "Frost"

    /** Affects the weather in order to make a change in the game
     *
     * this method hasnt been added yet
     */
    override def affectWeather(): Unit = {
        ()
    }

    /** Checks if this Frost is equal to another object.
     *
     * @param obj The object to compare to.
     * @return true if the object is a Frost and has the same name, false otherwise.
     */
    override def equals(obj: Any): Boolean = {
        if (obj.isInstanceOf[Frost]) {
            val other = obj.asInstanceOf[Frost]
            (this eq other) ||
                (other.name == this.name)
        }
        else {
            false
        }
    }

    /** Returns the hash code of this Frost.
     *
     * @return The hash code of this Frost.
     */
    override def hashCode():Int = {
        val prime = 31
        var result= 1
        result = prime * result + classOf[Frost].##
        result = prime * result + name.##
        result
    }


}