package cl.uchile.dcc
package gwent.players.cardgroups

import gwent.cards.ICard
import gwent.players.cardgroups.AbstractCardGroup

import scala.collection.mutable.ArrayBuffer

class Hand (var cardCollection: ArrayBuffer[ICard]) extends AbstractCardGroup{
    
    override val limitCards: Int = 10

    /** Checks if this Player is equal to another object.
     *
     * @param obj The object to compare to.
     * @return true if the object is a Player and has the same name, gemscounter
     * deck and hand.
     */
    override def equals(obj: Any): Boolean = {
        if(obj.isInstanceOf[Player]){
            val other = obj.asInstanceOf[Player]
            (this eq other) ||
                (other.name == this.name &&
                    other.gemsCounter == this.gemsCounter &&
                    other.hand.sameElements(this.hand) &&
                    other.deck.sameElements(this.deck))
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
        result = prime * result + classOf[Player].##
        result = prime * result + name.##
        result = prime * result + gemsCounter.##
        result = prime * result + hand.##
        result = prime * result + deck.##
        result
    }
}
