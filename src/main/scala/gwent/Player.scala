package cl.uchile.dcc
package gwent
import scala.collection.mutable.ArrayBuffer


class Player(val name: String, var gemsCounter: Int, var deck: ArrayBuffer[Card], var hand: ArrayBuffer[Card]){
  def playCard(card:Card): Unit ={
    hand-= card
  }
  def getCard(card:Card):Unit ={
    hand+=card
    deck-=card
  }
}
