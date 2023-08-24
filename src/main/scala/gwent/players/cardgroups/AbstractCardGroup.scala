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
abstract class AbstractCardGroup(protected var _cardCollection: ArrayBuffer[ICard]) extends ICardGroup{
    /**
     * the limit card of the array
     */
    protected val  _limitCards: Int

    /** Gives a copy of the cardcollection
     * 
     * @return the copy of the card collection
     */
    def cardCollection(): ArrayBuffer[ICard] = {
        _cardCollection.clone()
    }

    /** Sets a new value for the cardCollection
     * 
     * @param value the new cardCollection
     */
    protected def cardCollection_(value: ArrayBuffer[ICard]) = {
        _cardCollection = value
    }

    /** Gives a copy of the limitCards
     * 
     * @return the copy of the limitCards
     */
    def limitCards(): Int ={
        var cloneLimitCards: Int = _limitCards
        cloneLimitCards
    }
    /** Verify if the card collection list size its less than the limit card collection
     *
     * @return true if the card collection size its equals to the limit card, false otherwise.
     */
    override def itsFull(): Boolean = {
        this._cardCollection.size >= _limitCards
    }

    /** Verify if a given card is in the card collection array.
     *
     * @param card the Card that´s going to checked.
     * @return true if the card is in the array, false otherwise.
     */
    override def hasCard(card: ICard): Boolean = {
        this._cardCollection.exists(c => {c == card})
    }

    /** Removes a given card from the card collection array.
     *
     * @param card the Card that´s going to be removed.
     */
    override def takeCard(card: ICard): Unit = {
        this._cardCollection -= card
    }

    /** Add a given card to the card collection array.
     *
     * If the card collection its full, it can´t add a new card
     *
     * @param card the Card that´s going to be added.
     */
    override def addCard(card: ICard): Unit = {
        if(!this.itsFull()) {
            this._cardCollection += card
        }
    }
}
