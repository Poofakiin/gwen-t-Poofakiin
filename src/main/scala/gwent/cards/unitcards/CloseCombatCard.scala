package cl.uchile.dcc
package gwent.cards.unitcards
import cl.uchile.dcc.gwent.board.{Board, HalfBoard}
import cl.uchile.dcc.gwent.board.sections.IBoardSection
import effects.*

/** A class that represent a Close Combat card in the game Gwent
 *
 * Close Combat cards have a name, a cardType, an attack power, and may have a special ability.
 *
 * @constructor Creates a new CloseCombatCard with a name and an attack power.
 * @param name the name of the unit card.
 * @param attackPower the attack power of the unit card.
 */
class CloseCombatCard(_name: String, _attackPower: Int) extends AbstractUnitCard(_name, _attackPower) {

    /** Creates a new CloseCombatCard with a name, an attack power, and a special ability.
     *
     * @param _name
     * @param _attackPower
     * @param _specialAbility
     */
    def this(name:String, attackPower: Int, specialAbility: ISpecialAbility)={
        this(name,attackPower)
        specialAbility_(specialAbility)
    }

    /** Plays this card on a certain board and HalfBoard close combat section
     *
     * @param board the whole board where its going to be played
     * @param halfBoard the half of the board where the card can get played
     */
    override def getPlayed(board: Board, halfBoard: HalfBoard): Unit = {
        halfBoard.closeCombatSection.AddCard(this)
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
