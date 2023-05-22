package cl.uchile.dcc
package gwent.board.sections

import gwent.board.sections.IBoardSection
import gwent.cards.unitcards.IUnitCard
import gwent.cards.weathercards.IWeatherCard

import scala.collection.mutable.ArrayBuffer

/**
 * A class that represent a section where only close combat cards can be played
 */
class CloseCombatSection extends IBoardSection{
    /**
     * the close combat cards group of the section
     */
    var sectionCardGroup: ArrayBuffer[IUnitCard] = new ArrayBuffer[IUnitCard]()

    /**
     * the weather card of the section
     */
    var weatherCard: Option[IWeatherCard] = None
    
    /**
     * the summatory of the attack power of all unit cards of the section
     */
    var totalAttackPower: Int = 0

    /** Tries to add a Unit Card to the sectionCardGroup
     *
     */
    override def PlayUnitCard(Card: IUnitCard): Unit = {
        ???
    }
    
    
}
