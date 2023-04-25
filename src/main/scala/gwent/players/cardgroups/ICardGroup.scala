package cl.uchile.dcc
package gwent.players.cardgroups

import gwent.cards.ICard

import scala.collection.mutable.ArrayBuffer

/** Represents a collecion of cards in the game gwent.
 *
 * This trait defines the properties that all cards collection have in common,
 * such as their list of cards and limit cards. Also it defines
 * the methods that a rcard collection must have such as itsFull, hasCard, takeCard and
 *  addCard
 *
 */

trait ICardGroup {

    /**
     * limit of cards in the collection
     */
    val limitCards: Int

    /**
     * the array of the cards in the collection
     */
    var cardCollection: ArrayBuffer[ICard]
    
    /** Verify if the card collection list size its less than the limit card collection
     *
     */
    def itsFull(): Boolean

    /** Verify if a given card is in the card collection array
     *
     * @param card the Card that´s going to checked.
     */
    def hasCard(card: ICard): Boolean

    /** Removes a given card from the card collection array.
     *
     * @param card the Card that´s going to be removed.
     */
    def takeCard(card: ICard): Unit

    /** Add a given card to the card collection array.
     *
     * @param card the Card that´s going to be added.
     */
    def addCard(card: ICard): Unit
}
