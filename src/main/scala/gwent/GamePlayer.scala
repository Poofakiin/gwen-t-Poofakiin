package cl.uchile.dcc
package gwent
import scala.collection.mutable.ArrayBuffer

/** A trait that describes the methods of Players
 * 
 * 
 */
trait GamePlayer {
  /** Pick a certain card of a hand of cards and remove it from the hand.
   * 
   * @param card the Card that´s going to be played.
   * @param hand the hand of cards.
   */
  def playCard(card:Card, hand:ArrayBuffer[Card]): Unit

  /** Pick a certain card of a deck of cards and adds it to a hand of cards.
   * 
   * @param card the Card that´s going to be added to the hand.
   * @param hand the hand of cards.
   * @param deck the deck of cards.
   */
  def getCard(card:Card, hand:ArrayBuffer[Card], deck:ArrayBuffer[Card]):Unit
}
