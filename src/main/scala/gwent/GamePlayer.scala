package cl.uchile.dcc
package gwent

trait GamePlayer {
  def playCard(card:Card): Unit
  
  def getCard(card:Card):Unit
}
