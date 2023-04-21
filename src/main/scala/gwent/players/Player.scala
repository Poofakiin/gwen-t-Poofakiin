package cl.uchile.dcc
package cl.uchile.dcc.gwent.players

import cl.uchile.dcc.gwent.players.GamePlayer

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
  override def playCard(card: Card): Unit = {
    /* utilizar el metodo indexOf, cambiar el if y utilizar el remove
    */
    if(this.hand.contains(card)) {
      this.hand -= card
    }
  }

  /** Adds a card to the player's hand and removes it from their deck.
   *
   * @param card the Card that´s going to be added to the hand.
   * @param hand the hand of cards.
   * @param deck the deck of cards.
   */
  override def getCard(): Unit = {
    /* agregar un metodo shuffle
    */
    if(this.deck.size>0){
      hand.append(deck[0])

    }
    deck -= card
    hand.append(card)
  }
}
