package cl.uchile.dcc
package gwent.cards.unitcards.effects

abstract class SpecialAbility(val name: String){
  def useAbility(): Unit
}
