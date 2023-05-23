package cl.uchile.dcc
package gwent.board.sections

import gwent.cards.unitcards.IUnitCard
import gwent.cards.weathercards.IWeatherCard

import scala.collection.mutable.ArrayBuffer

/**
 * Represents a board section in the gwent game.
 * This trait defines the properties that all board sections have in common,
 * such as their unit cards, its weatherCard and the total attack power of the unit cards.
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

    /** Add a unit card to the card section group
     *
     * @param card the unit card thats going to be added
     */
    def AddUnitCard(card: IUnitCard): Unit

    /** Removes a currently Played Unit Card
     *
     * @param card the card that´s going to be removed
     */
    def RemoveUnitCard(card: IUnitCard): Unit

}
