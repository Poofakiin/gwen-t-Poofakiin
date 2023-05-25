package cl.uchile.dcc
package gwent.cards

import gwent.board.sections.IBoardSection

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

    /**
     *
     */
    def PlayinSectionCloseCombat(section: IBoardSection): Unit

    /**
     *
     */
    def PlayinSectionRanged(section: IBoardSection): Unit

    /**
     *
     */
    def PlayinSectionSiege(section: IBoardSection): Unit

    /**
     *
     */
    def PlayinSectionWeather(section: IBoardSection): Unit
}
