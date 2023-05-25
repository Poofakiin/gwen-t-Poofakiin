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
trait IBoardSection {

    /** Play a card in a certain section
     * 
     * @param ICard the card that´s going to be played
     */
    def PlayinSection(card: ICard): Unit
    

    /** Add a card to the card section group
     *
     * @param card the unit card thats going to be added
     */
    def AddCard(card: ICard): Unit

    /** Removes a currently Played Card
     *
     * @param card the card that´s going to be removed
     */
    def RemoveCard(card: ICard): Unit

}
