package cl.uchile.dcc
package gwent.players
import gwent.cards.ICard

import scala.collection.mutable.ArrayBuffer

/** A trait that describes the methods of Players
 *
 *
 */
trait GamePlayer {
  val name: String
  var gemsCounter: Int
  var deck: ArrayBuffer[ICard]
  var hand: ArrayBuffer[ICard]
  /** Pick a certain card of a hand of cards and remove it from the hand.
   *
   * @param card the Card that´s going to be played.
   * @param hand the hand of cards.
   */
  def playCard(card: ICard): Unit

  /** Pick a certain card of a deck of cards and adds it to a hand of cards.
   *
   * @param card the Card that´s going to be added to the hand.
   * @param hand the hand of cards.
   * @param deck the deck of cards.
   */
  def drawCard(): Unit
  
  def shuffleDeck(): Unit
  
  def  canDrawCard(): Boolean

  def canPlayCard(card: ICard): Boolean
}
