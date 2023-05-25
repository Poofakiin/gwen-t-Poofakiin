package cl.uchile.dcc
package gwent.cards

import cl.uchile.dcc.gwent.board.sections.IBoardSection

/**
 * Represents a card in the gwent game.
 * This trait defines the properties that all cards have in common,
 * such as their name and cardtype.
 *
 */
trait ICard {
    /**
     * The name of the card.
     */
    val name: String
    /**
     * The type of the card.
     */
    val cardType: String

    /** Try to play a card in to a Close Combat Section in a Board
     *
     * @param section te board where the card its going to be added
     */
    def PlayinSectionCloseCombat(section: IBoardSection): Unit

    /** Try to play a card in to a Ranged Section in a Board
     *
     * @param section te board where the card its going to be added
     */
    def PlayinSectionRanged(section: IBoardSection): Unit

    /** Try to play a card in to a Siege Section in a Board
     *
     * @param section te board where the card its going to be added
     */
    def PlayinSectionSiege(section: IBoardSection): Unit

    /** Try to play a card in to a Weather Section in a Board
     *
     * @param section te board where the card its going to be added
     */
    def PlayinSectionWeather(section: IBoardSection): Unit
}
