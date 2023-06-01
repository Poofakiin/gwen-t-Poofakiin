package cl.uchile.dcc
package gwent.cards

import gwent.board.HalfBoard
import gwent.board.Board

/**
 * Represents a card in the gwent game.
 * This trait defines the properties that all cards have in common,
 * such as their name and cardtype.
 *
 */
trait ICard{
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
     * @return True if the card was played, false otherwise
     */
    def getPlayed(board:Board, halfBoard: HalfBoard): Unit
}
