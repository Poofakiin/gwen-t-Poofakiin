package cl.uchile.dcc
package gwent.board.sections

import gwent.board.sections.IBoardSection
import gwent.cards.unitcards.{IUnitCard, SiegeCard}
import gwent.cards.weathercards.IWeatherCard
import gwent.cards.ICard

import scala.collection.mutable.ArrayBuffer

/**
 * A class that represent a section where only siege cards can be played
 */
class SiegeSection extends IBoardSection[SiegeCard] {
    /**
     * the close combat group of the section
     */
    var sectionCardGroup: ArrayBuffer[SiegeCard] = new ArrayBuffer[SiegeCard]()

    /**
     * the summatory of the attack power of all unit cards of the section
     */
    var totalAttackPower: Int = 0


    /** Add a Siege Card to the card section group
     *
     * @param card the siege card thats going to be added
     */
    override def AddCard(card: SiegeCard): Unit = {
        this.sectionCardGroup += card
    }

    /** Removes all currently played cards from card section
     *
     */
    override def ClearSection(): Unit = {
        this.sectionCardGroup.clear()
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
