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
  /** Picks a certain card and removes it from the player's hand.
   *
   * @param card the Card that´s going to be played.
   * @param hand the hand of cards.
   */
  def canPlayCard(card: ICard): Boolean ={
    this.hand.exists(y => {y == card})
  }

  def playCard(card: ICard): Unit = {
    if(canPlayCard(card)) {
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
      this.deck -= this.deck.head
    }
    else if(this.deck.nonEmpty){
      this.deck -= this.deck.head
    }
  }

  def shuffleDeck(): Unit = {
    this.deck = Random.shuffle(this.deck)
  }

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
