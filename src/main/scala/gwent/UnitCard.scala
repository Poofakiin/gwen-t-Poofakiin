package cl.uchile.dcc
package gwent

/** A class that represents a unit type of card in the Gwent game.
 *
 *  Unit cards have a name, a type, and an attack power.
 *
 * @param name the name of the unit card.
 * @param cardType the type of the unit card.
 *
 * @param attackPower the attack power of the unit card.
 */
abstract class UnitCard(name: String,cardType: String, var attackPower: Int) extends Card(name,cardType) {
}
