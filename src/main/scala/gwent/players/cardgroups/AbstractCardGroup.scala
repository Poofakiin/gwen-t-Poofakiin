package cl.uchile.dcc
package gwent.players.cardgroups

import gwent.cards.ICard

import scala.collection.mutable.ArrayBuffer


abstract class AbstractCardGroup(var cardCollection: ArrayBuffer[ICard]) extends ICardGroup{
    val  limitCards: Int

    override def itsFull(): Boolean = {
        this.cardCollection.size > limitCards
    }

    override def hasCard(card: ICard): Boolean = {
        this.cardCollection.exists(c => {c == card})
    }

    override def takeCard(card: ICard): Unit = {
        this.cardCollection -= card
    }

    override def addCard(card: ICard): Unit = {
        this.cardCollection += card
    }
}
