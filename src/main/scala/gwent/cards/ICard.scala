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

    /** Plays this card on a section of certain board and HalfBoard, depending on its type
     * 
     * @param board the whole board where its going to be played
     * @param halfBoard the half of the board where the card can get played
     */
    def getPlayed(board:Board, halfBoard: HalfBoard): Unit
}
