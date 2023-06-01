package cl.uchile.dcc
package gwent.board.sections

import gwent.cards.ICard

import scala.collection.mutable.ArrayBuffer

/**
 * Represents a board section in the gwent game.
 * This trait defines the properties that all board sections have in common,
 * such as their unit cards, its weatherCard and the total attack power of the unit cards.
 *
 */
trait IBoardSection[ T <: ICard] {

    /** Add a card to the card section group
     *
     * @param card the unit card thats going to be added
     */
    def AddCard(card: T): Unit

    /** Removes a currently Played Card
     *
     * @param card the card that´s going to be removed
     */
    def ClearSection(): Unit

}
