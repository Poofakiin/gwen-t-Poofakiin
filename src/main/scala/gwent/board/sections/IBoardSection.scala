package cl.uchile.dcc
package gwent.board.sections

import gwent.cards.unitcards.IUnitCard
import gwent.cards.weathercards.IWeatherCard

import scala.collection.mutable.ArrayBuffer

/**
 * Represents a board section in the gwent game.
 * This trait defines the properties that all board sections have in common,
 * such as their unit cards and the total attack power of the unit cards.
 *
 */
trait IBoardSection {

    /**
     * the unit cards group of the section
     */
    var sectionCardGroup: ArrayBuffer[IUnitCard]
    
    /**
     * the summatory of the attack power of all unit cards of the section
     */
    var totalAttackPower: Int

    /** Tries to add a Unit Card to the sectionCardGroup
     *
     */
    def PlayUnitCard(Card: IUnitCard): Unit
}
