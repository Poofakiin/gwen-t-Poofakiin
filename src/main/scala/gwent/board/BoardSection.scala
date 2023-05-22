package cl.uchile.dcc
package gwent.board


import cl.uchile.dcc.gwent.cards.unitcards.IUnitCard
import cl.uchile.dcc.gwent.cards.weathercards.IWeatherCard

import scala.collection.mutable.ArrayBuffer

/**
 * Represents a board section in the gwent game.
 * This trait defines the properties that all board sections have in common,
 * such as their unit cards, its weatherCard and the total attack power of the unit cards.
 *
 */
trait BoardSection {
    
    /**
     * the unit cards group of the section
     */
    var sectionCardGroup: ArrayBuffer[IUnitCard]
    
    /**
     * the weather card of the section
     */
    var weatherCard: Option[IWeatherCard]
    
    /**
     * the summatory of the attack power of all unit cards of the section
     */
    var totalAttackPower: Int

    /** Tries to add a Unit Card to the sectionCardGroup
     * 
     */
    def PlayUnitCard(Card: IUnitCard): Unit
    /** Tries to change the weather card of the section
     *
     */
    def ChangeWeatherCard(Card: IWeatherCard): Unit
}
