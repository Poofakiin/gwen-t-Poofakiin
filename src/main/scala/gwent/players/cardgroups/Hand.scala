package cl.uchile.dcc
package gwent.players.cardgroups

import gwent.cards.ICard
import gwent.players.cardgroups.AbstractCardGroup

import scala.collection.mutable.ArrayBuffer

class Hand (cardCollection: ArrayBuffer[ICard]) extends AbstractCardGroup(cardCollection){

    val limitCards: Int = 10

    /** Checks if this Player is equal to another object.
     *
     * @param obj The object to compare to.
     * @return true if the object is a Player and has the same name, gemscounter
     * deck and hand.
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

    /** Returns the hash code of this Player.
     *
     * @return The hash code of this Player.
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
