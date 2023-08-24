package cl.uchile.dcc
package gwent.cards.weathercards.weathertype

/** A class that represent a Fog weather type in the game Gwent
 *
 * Fog weather type have a name.
 *
 */
class Fog extends IWeatherType{
    
    /**
     * The name of the the weather type. For a Fog, this will always
     * be "Fog".
     */
    val name: String = "Fog"

    /** Affects the weather in order to make a change in the game
     *
     * this method hasnt been added yet
     */
    override def affectWeather(): Unit = {
        ()
    }

    /** Checks if this Fog is equal to another object.
     *
     * @param obj The object to compare to.
     * @return true if the object is a Fog and has the same name, false otherwise.
     */
    override def equals(obj: Any): Boolean = {
        if (obj.isInstanceOf[Fog]) {
            val other = obj.asInstanceOf[Fog]
            (this eq other) ||
                (other.name == this.name)
        }
        else {
            false
        }
    }

    /** Returns the hash code of this Fog.
     *
     * @return The hash code of this Fog.
     */
    override def hashCode():Int = {
        val prime = 31
        var result= 1
        result = prime * result + classOf[Fog].##
        result = prime * result + name.##
        result
    }

}
