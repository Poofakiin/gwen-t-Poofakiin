package cl.uchile.dcc
package gwent.players


import scala.util.Random
import scala.collection.mutable.ArrayBuffer
import gwent.cards.ICard

import cardgroups.*
import gwent.board.sections.IBoardSection

import cl.uchile.dcc.gwent.board.{Board, HalfBoard}

/** A class that describes a Player in the game.
 *
 * The player is defined by his name, gems counter, deck of cards & hand of cards.
 *
 * @param name the name of the player.
 * @param gemsCounter the gems of the player.
 * @param deck the deck of card of the player.
 * @param hand the hand of cards of the player.
 */
class Player(val name: String, var gemsCounter: Int, var deck: Deck,
             var hand: Hand) extends GamePlayer {

    /** Verifies if the player's hand and deck meet the requirements to draw a card.
     *
     * The player's hand must contain less than 10 cards and their deck must not be empty
     * in order to be able to draw a card.
     * @return true if the player is able to draw a card, false otherwise.
     */
    def canDrawCard(): Boolean = {
        this.deck.cardCollection.nonEmpty && !this.hand.itsFull()
    }


    /** Pick a given card of Players hand of cards and removes it from the hand, it returns true if
     * it get removed, false otherwise
     *
     * @param card the Card that´s going to be played
     * @return true if the card was removed, false otherwise
     * @see hasCard
     */
    def playCard(card: ICard):Boolean = {
        if(this.hand.hasCard(card)) {
            this.hand.takeCard(card)
            return true
        }
        else{
            return false
        }
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
            this.hand.addCard(this.deck.cardCollection.head)
            this.deck.takeCard(this.deck.cardCollection.head)
        }
        else if(this.deck.cardCollection.nonEmpty){
            this.deck.takeCard(this.deck.cardCollection.head)
        }
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
                    other.hand.equals(this.hand) &&
                    other.deck.equals(this.deck))
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
