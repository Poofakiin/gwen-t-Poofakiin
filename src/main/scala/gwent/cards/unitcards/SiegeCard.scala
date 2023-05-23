package cl.uchile.dcc
package gwent.cards.unitcards

import effects.*
import gwent.cards.unitcards.AbstractUnitCard

import cl.uchile.dcc.gwent.board.HalfBoard

/** A class that represent a Siege card in the game Gwent
 *
 * Siege cards have a name, a cardType, an attack power, and may have a special ability.
 *
 * @constructor Creates a new RangedCard with a name and an attack power.
 * @param name the name of the unit card.
 * @param attackPower the attack power of the unit card.
 */
class SiegeCard (name: String, attackPower: Int) extends AbstractUnitCard(name, attackPower){
    /** Creates a new SiegeCard with a name, an attack power, and a special ability.
     *
     * @param name
     * @param attackPower
     * @param specialAbility
     */
    def this(name:String, attackPower: Int, specialAbility: ISpecialAbility)={
        this(name,attackPower)
        _specialAbility = Some(specialAbility)
    }

    /** Adds a Siege card to a Close Combat Section in a Board
     *
     * @param board te board where the card its going to be added
     */
    override def getPlayed(board: HalfBoard): Unit = {
        board.siegeSection.AddUnitCard(this)
    }
    /** Checks if this SiegeCard is equal to another object.
     *
     * @param obj The object to compare to.
     * @return true if the object is a SiegeCard and has the same name
     * card type, attack power, and special ability (if any), false otherwise.
     */
    override def equals(obj: Any): Boolean = {
        if (obj.isInstanceOf[SiegeCard]) {
            val other = obj.asInstanceOf[SiegeCard]
            (this eq other) ||
                (other.name == this.name &&
                    other.cardType == this.cardType &&
                    other.attackPower == this.attackPower &&
                    other._specialAbility == this._specialAbility)
        }
        else {
            false
        }
    }
    /** Returns the hash code of this SiegeCard.
     *
     * @return The hash code of this SiegeCard.
     */
    override def hashCode():Int = {
        val prime = 31
        var result= 1
        result = prime * result + classOf[SiegeCard].##
        result = prime * result + name.##
        result = prime * result + cardType.##
        result = prime * result + attackPower.##
        result = prime * result + _specialAbility.##
        result
    }
}
