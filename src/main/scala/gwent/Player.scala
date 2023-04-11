package cl.uchile.dcc
package gwent
import scala.collection.mutable.ArrayBuffer


class Player(val name: String, var gemsCounter: Int, var deck: ArrayBuffer[Card],
             var hand: ArrayBuffer[Card]) extends GamePlayer {
  override def playCard(card: Card): Unit = {
    hand -= card
  }

  override def getCard(card: Card): Unit = {
    deck -= card
    hand.append(card)
  }
}
