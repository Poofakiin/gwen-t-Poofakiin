package cl.uchile.dcc
package gwent.cards

import gwent.board.HalfBoard

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
    def getPlayed(board: Board): Unit
}
