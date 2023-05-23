package cl.uchile.dcc
package gwent.cards.unitcards
import cl.uchile.dcc.gwent.board.HalfBoard
import effects.*

/** A class that represent a Close Combat card in the game Gwent
 *
 * Close Combat cards have a name, a cardType, an attack power, and may have a special ability.
 *
 * @constructor Creates a new CloseCombatCard with a name and an attack power.
 * @param name the name of the unit card.
 * @param attackPower the attack power of the unit card.
 */
class CloseCombatCard(name: String, attackPower: Int) extends AbstractUnitCard(name, attackPower) {

    /** Creates a new CloseCombatCard with a name, an attack power, and a special ability.
     *
     * @param name
     * @param attackPower
     * @param specialAbility
     */
    def this(name:String, attackPower: Int, specialAbility: ISpecialAbility)={
        this(name,attackPower)
        _specialAbility = Some(specialAbility)
    }

    /** Adds a Close Combat card to a Close Combat Section in a Board
     * 
     * @param board te board where the card its going to be added
     */
    override def getPlayed(board: HalfBoard): Unit = {
        board.closeCombatSection.AddUnitCard(this)
    }

    /** Checks if this CloseCombatCard is equal to another object.
     *
     * @param obj The object to compare to.
     * @return true if the object is a CloseCombatCard and has the same name
     * card type, attack power, and special ability (if any), false otherwise.
     */
    override def equals(obj: Any): Boolean = {
        if(obj.isInstanceOf[CloseCombatCard]){
            val other = obj.asInstanceOf[CloseCombatCard]
            (this eq other) ||
                (other.name == this.name &&
                    other.cardType == this.cardType &&
                    other.attackPower == this.attackPower &&
                    other._specialAbility == this._specialAbility)
        }
        else{
            false
        }
    }

    /** Returns the hash code of this CloseCombatCard.
     *
     * @return The hash code of this CloseCombatCard.
     */
    override def hashCode():Int = {
        val prime = 31
        var result= 1
        result = prime * result + classOf[CloseCombatCard].##
        result = prime * result + name.##
        result = prime * result + cardType.##
        result = prime * result + attackPower.##
        result = prime * result + _specialAbility.##
        result
    }
}
