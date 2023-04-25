package cl.uchile.dcc
package gwent.players.cardgroups

import gwent.cards.ICard

import scala.collection.mutable.ArrayBuffer

/** A class that represents an card collection type in the Gwent game.
 *
 * card collections have a card array and a limit card
 *
 * @param cardCollection its the card array
 */
abstract class AbstractCardGroup(var cardCollection: ArrayBuffer[ICard]) extends ICardGroup{
    /**
     * the limit card of the array
     */
    val  limitCards: Int

    /** Verify if the card collection list size its less than the limit card collection
     *
     * @return true if the card collection size its equals to the limit card, false otherwise.
     */
    override def itsFull(): Boolean = {
        this.cardCollection.size > limitCards
    }

    /** Verify if a given card is in the card collection array.
     *
     * @param card the Card that´s going to checked.
     * @return true if the card is in the array, false otherwise.
     */
    override def hasCard(card: ICard): Boolean = {
        this.cardCollection.exists(c => {c == card})
    }

    /** Removes a given card from the card collection array.
     *
     * @param card the Card that´s going to be removed.
     */
    override def takeCard(card: ICard): Unit = {
        this.cardCollection -= card
    }

    /** Add a given card to the card collection array.
     *
     * @param card the Card that´s going to be added.
     */
    override def addCard(card: ICard): Unit = {
        this.cardCollection += card
    }
}
