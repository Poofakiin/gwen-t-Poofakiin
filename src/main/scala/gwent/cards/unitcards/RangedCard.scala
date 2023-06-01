package cl.uchile.dcc
package gwent.cards.unitcards

import gwent.board.HalfBoard
import gwent.board.Board
import gwent.board.sections.IBoardSection
import effects.*


/** A class that represent a Ranged card in the game Gwent
 *
 * Ranged cards have a name, a cardType, an attack power, and may have a special ability.
 *
 * @constructor Creates a new RangedCard with a name and an attack power.
 * @param name the name of the unit card.
 * @param attackPower the attack power of the unit card.
 */
class RangedCard (name: String, attackPower: Int) extends AbstractUnitCard(name, attackPower){

    /** Creates a new RangedCard with a name, an attack power, and a special ability.
     *
     * @param name
     * @param attackPower
     * @param specialAbility
     */
    def this(name:String, attackPower: Int, specialAbility: ISpecialAbility)={
        this(name,attackPower)
        _specialAbility = Some(specialAbility)
    }

    /** Adds a Ranged card to a Ranged Section in a Board
     *
     * @param section the board section where the card its going to be added
     */
    override def getPlayed(board: Board, halfBoard: HalfBoard): Unit = {
        halfBoard.rangedSection.AddCard(this)
    }

    /** Checks if this RangedCard is equal to another object.
     *
     * @param obj The object to compare to.
     * @return true if the object is a RangedCard and has the same name
     * card type, attack power, and special ability (if any), false otherwise.
     */
    override def equals(obj: Any): Boolean = {
        if (obj.isInstanceOf[RangedCard]) {
            val other = obj.asInstanceOf[RangedCard]
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

    /** Returns the hash code of this RangedCard.
     *
     * @return The hash code of this RangedCard.
     */
    override def hashCode():Int = {
        val prime = 31
        var result= 1
        result = prime * result + classOf[RangedCard].##
        result = prime * result + name.##
        result = prime * result + cardType.##
        result = prime * result + attackPower.##
        result = prime * result + _specialAbility.##
        result
    }
}
