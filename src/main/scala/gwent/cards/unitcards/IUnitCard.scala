package cl.uchile.dcc
package gwent.cards.unitcards
import gwent.cards.unitcards.effects._
import gwent.cards.ICard

trait IUnitCard extends ICard{
  var attackPower: Int
  protected var _specialAbility: Option[ISpecialAbility]

  def getSpecialAbility(): Option[ISpecialAbility]
}
