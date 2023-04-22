package cl.uchile.dcc
package cl.uchile.dcc.gwent.players


import cl.uchile.dcc.gwent.players.GamePlayer

import scala.util.Random
import scala.collection.mutable.ArrayBuffer
import gwent.cards.Card

/** A class that describes a Player in the game.
 *
 * The player is defined by his name, gems counter, deck of cards & hand of cards.
 *
 * @param name the name of the player.
 * @param gemsCounter the gems of the player.
 * @param deck the deck of card of the player.
 * @param hand the hand of cards of the player.
 */
class Player(val name: String, var gemsCounter: Int, var deck: ArrayBuffer[Card],
             var hand: ArrayBuffer[Card]) extends GamePlayer {
  /** Picks a certain card and removes it from the player's hand.
   *
   * @param card the Card that´s going to be played.
   * @param hand the hand of cards.
   */
  def playCard(card: Card): Unit = {
    if(this.hand.exists(y => {y == card})) {
      this.hand -= card
    }
    else{
      ()
    }
  }

  /** Adds a card to the player's hand and removes it from their deck.
   *
   * @param card the Card that´s going to be added to the hand.
   * @param hand the hand of cards.
   * @param deck the deck of cards.
   */

  def canDrawCard(): Boolean = {
    this.deck.nonEmpty && this.hand.size < 10
  }
  def drawCard(): Unit = {
    if(canDrawCard()){
      this.hand += this.deck.head
      this.deck.tails
    }
    else if(this.deck.nonEmpty){
      this.deck.tails
    }
  }

  def shuffleDeck(): Unit = {
    Random.shuffle(this.deck)
  }

  override def equals(obj: Any): Boolean = {
    if(obj.isInstanceOf[Player]){
      val other = obj.asInstanceOf[Player]
      (this eq other) ||
        (other.name == this.name &&
          other.gemsCounter == this.gemsCounter &&
          other.hand == this.hand &&
          other.deck == this.deck)
    }
    else{
      false
    }

  }
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
