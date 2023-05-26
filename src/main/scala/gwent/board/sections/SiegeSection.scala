package cl.uchile.dcc
package gwent.board.sections

import gwent.board.sections.IBoardSection
import gwent.cards.unitcards.IUnitCard
import gwent.cards.weathercards.IWeatherCard
import gwent.cards.ICard

import scala.collection.mutable.ArrayBuffer

/**
 * A class that represent a section where only siege cards can be played
 */
class SiegeSection extends AbstractUnitBoardSection {

    /** Play a card in a siege section
     *
     * @param ICard the card that´s going to be played
     * @return True if the card was played, false otherwise
     */
    override def PlayinSection(card: ICard): Boolean = {
        card.PlayinSectionSiege(this)
    }
    
    
    
    /** Checks if this SiegeSection is equal to another object.
     *
     * @param obj The object to compare to.
     * @return true if the object is a SiegeSection and has the same totalAttackPower and
     * sectionCardGroup, false otherwise.
     */
    override def equals(obj: Any): Boolean = {
        if(obj.isInstanceOf[SiegeSection]){
            val other = obj.asInstanceOf[SiegeSection]
            (this eq other) ||
                (other.sectionCardGroup.sameElements(this.sectionCardGroup) &&
                    other.totalAttackPower == this.totalAttackPower)
        }
        else{
            false
        }
    }

    /** Returns the hash code of this SiegeSection.
     *
     * @return The hash code of this SiegeSection.
     */
    override def hashCode():Int = {
        val prime = 31
        var result= 1
        result = prime * result + classOf[SiegeSection].##
        result = prime * result + sectionCardGroup.##
        result = prime * result + totalAttackPower.##
        result
    }
}
