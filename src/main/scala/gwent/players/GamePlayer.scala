package cl.uchile.dcc
package gwent.players
import gwent.cards.ICard

import scala.collection.mutable.ArrayBuffer

/** Represents a player in the gwent game.
 *
 * This trait defines the properties that all cards have in common,
 * such as their name, gems, deck and hand. Also it defines
 * the methods that a Player must have such as playCard, drawCard, shuffleDeck,
 * canDrawCard and canPlayCard
 *
 */
trait GamePlayer {

    /**
     * The name of the Player.
     */
    val name: String

    /**
     * The gems of the Player
     */
    var gemsCounter: Int

    /**
     * The deck of the PLayer.
     */
    var deck: ArrayBuffer[ICard]

    /**
     * The hand of the Player.
     */
    var hand: ArrayBuffer[ICard]

    /** Pick a given card of Players hand of cards and remove it from the hand.
     *
     * @param card the Card that´s going to be played.
     */
    def playCard(card: ICard): Unit

    /** Draws the first card from the deck of cards and adds it to the player's hand.
     *
     */
    def drawCard(): Unit

    /** Randomly shuffles the cards in the deck to change their order.
     *
     */
    def shuffleDeck(): Unit

    /** Verify if the player's hand and deck meet the requirements to draw a card.
     *
     */
    def  canDrawCard(): Boolean

    /** Verify if the player's hand meet the requirements to play given a card.
     *
     */
    def canPlayCard(card: ICard): Boolean
}
