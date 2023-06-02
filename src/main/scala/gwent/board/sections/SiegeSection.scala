package cl.uchile.dcc
package gwent.board.sections

import gwent.board.sections.IBoardSection
import gwent.cards.unitcards.{IUnitCard, SiegeCard}
import gwent.cards.weathercards.IWeatherCard
import gwent.cards.ICard

import scala.collection.mutable.ArrayBuffer

/**
 * A class that represent a section where only siege cards can be played
 * 
 * A SiegeSection has a section of cards and the total attackpower of the cards
 */
class SiegeSection extends IBoardSection[SiegeCard] {
    /**
     * the siege card group of the section
     */
    private var _sectionCardGroup: ArrayBuffer[SiegeCard] = new ArrayBuffer[SiegeCard]()

    /**
     * the summatory of the attack power of all unit cards of the section
     */
    private var _totalAttackPower: Int = 0

    /** Delivers the section's siege card group.
     *
     * @return The section's siege card group.
     */
    def getSectionCardGroup: ArrayBuffer[SiegeCard] = {
        _sectionCardGroup
    }

    /** Sets the section's siege card group.
     *
     * @param value The new siege card group.
     */
    def setSectionCardGroup(value: ArrayBuffer[SiegeCard]): Unit = {
        _sectionCardGroup = value
    }

    /** Delivers the total attack power of all unit cards in the section.
     *
     * @return The total attack power.
     */
    def getTotalAttackPower: Int = {
        _totalAttackPower
    }

    /** Sets the total attack power of all unit cards in the section.
     *
     * @param value The new total attack power.
     */
    def setTotalAttackPower(value: Int): Unit ={
        _totalAttackPower = value
    }


    /** Add a Siege Card to the card section group
     *
     * @param card the siege card thats going to be added
     */
    override def AddCard(card: SiegeCard): Unit = {
        this._sectionCardGroup += card
    }

    /** Removes all currently played cards from card section
     *
     */
    override def ClearSection(): Unit = {
        this._sectionCardGroup.clear()
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
                (other._sectionCardGroup.sameElements(this._sectionCardGroup) &&
                    other._totalAttackPower == this._totalAttackPower)
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
        result = prime * result + _sectionCardGroup.##
        result = prime * result + _totalAttackPower.##
        result
    }
}
