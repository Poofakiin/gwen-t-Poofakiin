package cl.uchile.dcc
package gwent.cards.weathercards.weathertype


/** A class that represent a Clear weather type in the game Gwent
 *
 * Clear weather type have a name.
 *
 */
class ClearWeather extends IWeatherType{

    /**
     * The name of the the weather type. For a ClearWeather, this will always
     * be "Clear Weather".
     */
    val name:String = "Clear Weather"

    /** Affects the weather in order to make a change in the game
     *
     * this method hasnt been added yet
     */
    override def affectWeather(): Unit = {
        ()
    }

    /** Checks if this ClearWeather is equal to another object.
     *
     * @param obj The object to compare to.
     * @return true if the object is a ClearWeather and has the same name, false otherwise.
     */
    override def equals(obj: Any): Boolean = {
        if (obj.isInstanceOf[ClearWeather]) {
            val other = obj.asInstanceOf[ClearWeather]
            (this eq other) ||
                (other.name == this.name)
        }
        else {
            false
        }
    }

    /** Returns the hash code of this ClearWeather.
     *
     * @return The hash code of this ClearWeather.
     */
    override def hashCode():Int = {
        val prime = 31
        var result= 1
        result = prime * result + classOf[ClearWeather].##
        result = prime * result + name.##
        result
    }
    
}
