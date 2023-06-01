package cl.uchile.dcc
package gwent.board.sections

import gwent.cards.ICard
import gwent.board.sections.IBoardSection
import gwent.cards.unitcards.{IUnitCard, RangedCard}
import gwent.cards.weathercards.IWeatherCard

import scala.collection.mutable.ArrayBuffer

/**
 * A class that represent a section where only ranged cards can be played
 */
class RangedSection extends IBoardSection[RangedCard] {

    /**
     * the close combat group of the section
     */
    var sectionCardGroup: ArrayBuffer[RangedCard] = new ArrayBuffer[RangedCard]()

    /**
     * the summatory of the attack power of all unit cards of the section
     */
    var totalAttackPower: Int = 0


    override def AddCard(card: RangedCard): Unit = {
        this.sectionCardGroup += card
    }

    override def ClearSection(): Unit = {
        this.sectionCardGroup.clear()
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
