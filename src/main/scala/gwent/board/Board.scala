package cl.uchile.dcc
package gwent.board

import cl.uchile.dcc.gwent.board.sections.{CloseCombatSection, RangedSection, SiegeSection}
import cl.uchile.dcc.gwent.cards.unitcards.IUnitCard
import cl.uchile.dcc.gwent.cards.weathercards.IWeatherCard
import cl.uchile.dcc.gwent.players.GamePlayer

/** A class that represents one siede of the board in the gwent game
 *
 * a Board must have three sections, one for each type of unit card, and a Player who´s the one controlling the section.
 *
 * @param siegeSection
 * @param closeCombatSection
 * @param rangedSection
 * @param player
 */
class Board(var siegeSection: SiegeSection, var closeCombatSection: CloseCombatSection, var rangedSection: RangedSection, player: GamePlayer) {

    /** Plays a unit card in its corresponding section, dependeing of the unit card type
     *
     *
     * @param card the card thats going to be played
     */
    def playUnitCard(card:IUnitCard): Unit = {
        ???
    }

    /**
     * 
     * @param card
     */
    def playWeatherCard(card: IWeatherCard): Unit = {
        ???
    }
}
