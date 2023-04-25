package cl.uchile.dcc
package gwent.players.cardgroups

import gwent.cards.ICard
import gwent.players.cardgroups.AbstractCardGroup

import scala.collection.mutable.ArrayBuffer


/** A class that represent a Deck in the game Gwent
 *
 * Deck have a card array and a car limit
 *
 * @param cardCollection its the card array
 */
class Hand (cardCollection: ArrayBuffer[ICard]) extends AbstractCardGroup(cardCollection){
    
    /**
     * the limit card of the array, for a deck it will always be 10
     */
    val limitCards: Int = 10

    /** Checks if this Hand is equal to another object.
     *
     * @param obj The object to compare to.
     * @return true if the object is a Player and has the same cardCollection and limitCards.
     */
    override def equals(obj: Any): Boolean = {
        if(obj.isInstanceOf[Deck]){
            val other = obj.asInstanceOf[Deck]
            (this eq other) ||
                (other.cardCollection.sameElements(this.cardCollection) &&
                    other.limitCards == this.limitCards)
        }
        else{
            false
        }

    }

    /** Returns the hash code of this Deck.
     *
     * @return The hash code of this Deck.
     */
    override def hashCode():Int = {
        val prime = 31
        var result= 1
        result = prime * result + classOf[Deck].##
        result = prime * result + cardCollection.##
        result = prime * result + limitCards.##
        result
    }
}
