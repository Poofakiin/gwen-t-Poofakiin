package cl.uchile.dcc
package gwent.board.sections

import gwent.board.sections.IBoardSection
import gwent.cards.unitcards.IUnitCard
import gwent.cards.weathercards.IWeatherCard

import scala.collection.mutable.ArrayBuffer

/**
 * A class that represent a section where only ranged cards can be played
 */
class RangedSection extends AbstractBoardSection {

    /** Tries to add a Unit Card to the sectionCardGroup
     *
     */
    override def PlayUnitCard(Card: IUnitCard): Unit = {
        ???
    }
}
