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
abstract class UnitCard(val name: String, var attackPower: Int, val specialAbility: Option[Some[CloseBond]] = None) extends ICard{
  var cardType: String = "Unit Card"
}

