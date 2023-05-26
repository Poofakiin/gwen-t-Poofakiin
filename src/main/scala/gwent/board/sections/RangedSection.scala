package cl.uchile.dcc
package gwent.board.sections

import gwent.cards.ICard
import gwent.board.sections.IBoardSection
import gwent.cards.unitcards.IUnitCard
import gwent.cards.weathercards.IWeatherCard

import scala.collection.mutable.ArrayBuffer

/**
 * A class that represent a section where only ranged cards can be played
 */
class RangedSection extends AbstractUnitBoardSection {

    /** Play a card in a ranged section
     *
     * @param ICard the card that´s going to be played
     * @return True if the card was played, false otherwise
     */
    override def PlayinSection(card: ICard): Boolean = {
        card.PlayinSectionRanged(this)
    }
    
    
    /** Checks if this RangedSection is equal to another object.
     *
     * @param obj The object to compare to.
     * @return true if the object is a RangedSection and has the same totalAttackPower and
     * sectionCardGroup, false otherwise.
     */
    override def equals(obj: Any): Boolean = {
        if(obj.isInstanceOf[RangedSection]){
            val other = obj.asInstanceOf[RangedSection]
            (this eq other) ||
                (other.sectionCardGroup.sameElements(this.sectionCardGroup) &&
                    other.totalAttackPower == this.totalAttackPower)
        }
        else{
            false
        }
    }

    /** Returns the hash code of this RangedSection.
     *
     * @return The hash code of this RangedSection.
     */
    override def hashCode():Int = {
        val prime = 31
        var result= 1
        result = prime * result + classOf[RangedSection].##
        result = prime * result + sectionCardGroup.##
        result = prime * result + totalAttackPower.##
        result
    }

}
