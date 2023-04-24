package cl.uchile.dcc
package gwent.players


import scala.math.Ordering.ordered
import scala.util.Random
import scala.collection.mutable.ArrayBuffer
import gwent.cards.ICard

/** A class that describes a Player in the game.
 *
 * The player is defined by his name, gems counter, deck of cards & hand of cards.
 *
 * @param name the name of the player.
 * @param gemsCounter the gems of the player.
 * @param deck the deck of card of the player.
 * @param hand the hand of cards of the player.
 */
class Player(val name: String, var gemsCounter: Int, var deck: ArrayBuffer[ICard],
             var hand: ArrayBuffer[ICard]) extends GamePlayer {

    /** Verifies if the player's hand meet the requirements to play a given card.
     *
     * @param card The card to be played
     * @return true if the player's hand contains the specified card, false otherwise.
     */
    def canPlayCard(card: ICard): Boolean ={
        this.hand.exists(c => {c == card})
    }

    /**
     * Plays a given card from the player's hand and removes it from the hand.
     * If the player's hand contains the specified card, it will be removed from the hand.
     * If the player's hand does not contain the specified card, this method has no effect.
     * @param card The card to be played.
     * @see canPlayCard
     */
    def playCard(card: ICard): Unit = {
        if(canPlayCard(card)) {
            this.hand -= card
        }
        else{
            ()
        }
    }

    /** Verifies if the player's hand and deck meet the requirements to draw a card.
     *
     * The player's hand must contain less than 10 cards and their deck must not be empty
     * in order to be able to draw a card.
     * @return true if the player is able to draw a card, false otherwise.
     */
    def canDrawCard(): Boolean = {
        this.deck.nonEmpty && this.hand.size < 10
    }

    /** Draws the first card from the deck of cards and adds it to the player's hand.
     *
     * If the player's hand is not already at the maximum size of 10 cards and the deck is not empty.
     * this method will add the first card from the deck to the player's hand and remove it from the deck.
     *
     * If the deck is empty or the player's hand already has 10 cards, no card will be drawn.
     *
     * If the player's hand already has 10 cards but the deck is not empty, a card will get
     * removed from the deck but it will not be added to the hand
     *
     */
    def drawCard(): Unit = {
        if(canDrawCard()){
            this.hand += this.deck.head
            this.deck -= this.deck.head
        }
        else if(this.deck.nonEmpty){
            this.deck -= this.deck.head
        }
    }

    /** Randomly shuffles the cards in the deck to change their order.
     * This method uses the Random.shuffle method to shuffle the cards in the deck
     * in a random order.
     */
    def shuffleDeck(): Unit = {
        this.deck = Random.shuffle(this.deck)
    }

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
