package cl.uchile.dcc
package gwent.cards.weathercards.weathertype

/** A class that represent a Rain weather type in the game Gwent
 *
 * Rain weather type have a name.
 *
 */
class Rain extends IWeatherType{

    /**
     * The name of the the weather type. For a Rain, this will always
     * be "Rain".
     */
    val name:String = "Rain"

    /** Affects the weather in order to make a change in the game
     *
     * this method hasnt been added yet
     */
    override def affectWeather(): Unit = {
        ()
    }

    /** Checks if this Rain is equal to another object.
     *
     * @param obj The object to compare to.
     * @return true if the object is a Rain and has the same name, false otherwise.
     */
    override def equals(obj: Any): Boolean = {
        if (obj.isInstanceOf[Rain]) {
            val other = obj.asInstanceOf[Rain]
            (this eq other) ||
                (other.name == this.name)
        }
        else {
            false
        }
    }

    /** Returns the hash code of this Rain.
     *
     * @return The hash code of this Rain.
     */
    override def hashCode():Int = {
        val prime = 31
        var result= 1
        result = prime * result + classOf[Rain].##
        result = prime * result + name.##
        result
    }


}
