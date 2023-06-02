package cl.uchile.dcc
package gwent.board.sections

import gwent.cards.ICard
import gwent.board.sections.IBoardSection
import gwent.cards.unitcards.{IUnitCard, RangedCard}
import gwent.cards.weathercards.IWeatherCard

import scala.collection.mutable.ArrayBuffer

/**
 * A class that represent a section where only ranged cards can be played
 * 
 * A RangedSection has a section of cards and the total attackpower of the cards
 */
class RangedSection extends IBoardSection[RangedCard] {

    /**
     * the ranged card group of the section
     */
    private var _sectionCardGroup: ArrayBuffer[RangedCard] = new ArrayBuffer[RangedCard]()

    /**
     * the summatory of the attack power of all unit cards of the section
     */
    private var _totalAttackPower: Int = 0

    /** Delivers the section's ranged card group.
     *
     * @return The section's ranged card group.
     */
    def getSectionCardGroup: ArrayBuffer[RangedCard] = {
        _sectionCardGroup
    }

    /** Sets the section's ranged card group.
     *
     * @param value The new ranged card group.
     */
    def setSectionCardGroup(value: ArrayBuffer[RangedCard]): Unit = {
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


    /** Add a Ranged Card to the card section group
     *
     * @param card the ranged card thats going to be added
     */
    override def AddCard(card: RangedCard): Unit = {
        this._sectionCardGroup += card
    }


    /** Removes all currently played cards from card section
     *
     */
    override def ClearSection(): Unit = {
        this._sectionCardGroup.clear()
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
                (other._sectionCardGroup.sameElements(this._sectionCardGroup) &&
                    other._totalAttackPower == this._totalAttackPower)
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
        result = prime * result + _sectionCardGroup.##
        result = prime * result + _totalAttackPower.##
        result
    }

}
