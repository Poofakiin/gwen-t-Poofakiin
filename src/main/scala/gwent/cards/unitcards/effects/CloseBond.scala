package cl.uchile.dcc
package gwent.cards.unitcards.effects


/** A class that represent a Close Bond special ability in the game Gwent
 *
 * Close Bond ability have a name.
 *
 */
class CloseBond() extends ISpecialAbility{
    /**
     * The name of the special ability. For a Close Bond, this will always be "Close Bond".
     */
    val name:String = "Close Bond"

    /** Uses the special ability in order to make a change in the game
     *
     * this method hasnt been added yet
     */
    override def useAbility(): Unit = {

    }
    
    /** Checks if this CloseBond is equal to another object.
     *
     * @param obj The object to compare to.
     * @return true if the object is a CloseBond and has the same name, false otherwise.
     */
    override def equals(obj: Any): Boolean = {
        if (obj.isInstanceOf[CloseBond]) {
            val other = obj.asInstanceOf[CloseBond]
            (this eq other) ||
                (other.name == this.name)
        }
        else {
            false
        }
    }

    /** Returns the hash code of this ClosBond.
     *
     * @return The hash code of this CloseBond.
     */
    override def hashCode():Int = {
        val prime = 31
        var result= 1
        result = prime * result + classOf[CloseBond].##
        result = prime * result + name.##
        result
    }
}

