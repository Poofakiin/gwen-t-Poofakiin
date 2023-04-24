package cl.uchile.dcc
package gwent.cards.unitcards.effects


/**
 * Represents a special ability in the gwent game.
 * This trait defines the properties that all special abilities have in common
 * such as their name, and methods such as useAbility.
 *
 */
trait ISpecialAbility {
    /**
     * The name of the special ability
     */
    val name: String

    /** Uses the special ability in order to make a change in the game
     *
     * this method hasnt been added yet
     */
    def useAbility(): Unit
}
