package cl.uchile.dcc
package gwent.cards.unitcards

import effects._
import gwent.cards.ICard

/**
 * Represents a unit card in the gwent game.
 * This trait defines the properties that all unit cards have in common
 * such as their attack power and special Ability.
 *
 */
trait IUnitCard extends ICard{
    /**
     * The attack power of the unit card
     */
    var attackPower: Int
    /**
     * The special ability of the unit card
     */
    protected var _specialAbility: Option[ISpecialAbility]

    /** Returns the special ability of the unit card.
     *
     * This method returns the special ability of a unit card. If the card has a special ability,
     * this method will return the Some(ISpecialAbility) instance that represents it. If the card
     * doesn't have a special ability, it will return None.
     *
     * @return The special ability of the unit card, if any.
     */
    def getSpecialAbility(): Option[ISpecialAbility]
    
}
