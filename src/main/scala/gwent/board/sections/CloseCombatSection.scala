package cl.uchile.dcc
package gwent.board.sections

import gwent.board.sections.AbstractBoardSection
import gwent.cards.unitcards.IUnitCard
import gwent.cards.weathercards.IWeatherCard

import scala.collection.mutable.ArrayBuffer

/**
 * A class that represent a section where only close combat cards can be played
 */
class CloseCombatSection extends AbstractBoardSection{

    /** Checks if this CloseCombatSection is equal to another object.
     *
     * @param obj The object to compare to.
     * @return true if the object is a CloseCombatSection and has the same totalAttackPower and
     * sectionCardGroup, false otherwise.
     */
    override def equals(obj: Any): Boolean = {
        if(obj.isInstanceOf[CloseCombatSection]){
            val other = obj.asInstanceOf[CloseCombatSection]
            (this eq other) ||
                (other.sectionCardGroup.sameElements(this.sectionCardGroup) &&
                    other.totalAttackPower == this.totalAttackPower)
        }
        else{
            false
        }
    }

    /** Returns the hash code of this CloseCombatSection.
     *
     * @return The hash code of this CloseCombatSection.
     */
    override def hashCode():Int = {
        val prime = 31
        var result= 1
        result = prime * result + classOf[CloseCombatSection].##
        result = prime * result + sectionCardGroup.##
        result = prime * result + totalAttackPower.##
        result
    }

}
