package cl.uchile.dcc
package gwent.cards.unitcards.effects


/** A class that represent a Moral Boost special ability in the game Gwent
 *
 * Moral Boost ability have a name.
 *
 */
class MoralBoost() extends ISpecialAbility{

    /**
     * The name of the special ability. For a Moral Boost, this will always
     * be "Moral Boost".
     */
    val name: String = "Moral Boost"

    /** Uses the special ability in order to make a change in the game
     *
     * this method hasnt been added yet
     */
    override def useAbility(): Unit = {

    }

    /** Checks if this MoralBoost is equal to another object.
     *
     * @param obj The object to compare to.
     * @return true if the object is a MoralBoost and has the same name
     * card type, attack power, and special ability (if any), false otherwise.
     */
    override def equals(obj: Any): Boolean = {
        if (obj.isInstanceOf[MoralBoost]) {
            val other = obj.asInstanceOf[MoralBoost]
            (this eq other) ||
                (other.name == this.name)
        }
        else {
            false
        }
    }

    /** Returns the hash code of this MoralBoost.
     *
     * @return The hash code of this MoralBoost.
     */
    override def hashCode():Int = {
        val prime = 31
        var result= 1
        result = prime * result + classOf[MoralBoost].##
        result = prime * result + name.##
        result
    }
}
