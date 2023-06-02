package cl.uchile.dcc
package gwent.board.sections

import gwent.cards.unitcards.{CloseCombatCard, IUnitCard}

import cl.uchile.dcc.gwent.cards.ICard

import scala.collection.mutable.ArrayBuffer

/**
 * A class that represent a section where only close combat cards can be played
 */
class CloseCombatSection extends IBoardSection[CloseCombatCard] {

    /**
     * the close combat group of the section
     */
    var sectionCardGroup: ArrayBuffer[CloseCombatCard] = new ArrayBuffer[CloseCombatCard]()

    /**
     * the summatory of the attack power of all unit cards of the section
     */
    var totalAttackPower: Int = 0

    /** Add a close combat card to the card section group
     *
     * @param card the close combat card thats going to be added
     */
    override def AddCard(card: CloseCombatCard): Unit = {
        this.sectionCardGroup += card
    }

    /** Removes all currently played cards from card section
     *
     */
    override def ClearSection(): Unit = {
        this.sectionCardGroup.clear()
    }
    
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
