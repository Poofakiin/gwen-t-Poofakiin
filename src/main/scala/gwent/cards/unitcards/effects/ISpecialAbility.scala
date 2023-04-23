package cl.uchile.dcc
package gwent.cards.unitcards.effects

trait ISpecialAbility {
  val name: String
  def useAbility(): Unit
}
