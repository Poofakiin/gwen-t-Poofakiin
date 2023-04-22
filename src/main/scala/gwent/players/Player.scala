package cl.uchile.dcc
package cl.uchile.dcc.gwent.players

import cl.uchile.dcc.gwent.players.GamePlayer
import scala.util.Random
import scala.collection.mutable.ArrayBuffer

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
    /* utilizar el metodo indexOf, cambiar el if y utilizar el remove
    */
    if(this.hand.indexOf(card)>=0) {
      this.hand.remove(this.hand.indexOf(card))
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
  def getCard(): Unit = {
    if(this.deck.size>0){
      this.hand.append(deck[0])
      this.deck.remove(0)
    }
    else{
      ()
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

    override hashCode():Int = {
      Object.hash(classOf[Player],name, gemsCounter, hand, deck)
    }
  }
}
