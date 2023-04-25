package cl.uchile.dcc
package gwent.players.cardgroups

import gwent.cards.ICard

import scala.collection.mutable.ArrayBuffer

trait ICardGroup {

    val limitCards: Int
    var cardCollection: ArrayBuffer[ICard]

    def itsEmpty(): Boolean

    def itsFull(): Boolean

    def hasCard(card: ICard): Boolean

    def takeCard(card: ICard): Unit

    def addCard(card: ICard): Unit
}
