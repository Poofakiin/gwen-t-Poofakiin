package cl.uchile.dcc
package gwent.cards.unitcards
import gwent.cards.unitcards.effects._
import gwent.cards.ICard

/** A class that represents a unit type of card in the Gwent game.
 *
 *  Unit cards have a name, a type, and an attack power.
 *
 * @param name the name of the unit card.
 * @param cardType the type of the unit card.
 * @param attackPower the attack power of the unit card.
 */
abstract class UnitCard(val name: String, var attackPower: Int) extends ICard{
  protected var _specialAbility: Option[SpecialAbility] = None
  var cardType: String = "Unit Card"
  def this(name: String, attackPower: Int, specialAbility: SpecialAbility)={
    this(name,attackPower)
    _specialAbility = Some(specialAbility)
  }
}

