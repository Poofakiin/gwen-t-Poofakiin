package cl.uchile.dcc
package gwent.players

import gwent.cards.ICard
import gwent.board.sections.IBoardSection
import gwent.players.cardgroups.*

import gwent.board.HalfBoard
import gwent.board.Board

import javax.net.ssl.SNIHostName
import scala.collection.mutable.ArrayBuffer

/** Represents a player in the gwent game.
 *
 * This trait defines the properties that all cards have in common,
 * such as their name, gems, _deck and _hand. Also it defines
 * the methods that a Player must have such as playCard, drawCard, shuffleDeck,
 * canDrawCard and canPlayCard
 *
 */
trait GamePlayer {

    /**
     * The name of the Player.
     */
    protected val _name: String

    /**
     * The gems of the Player
     */
    protected var _gemsCounter: Int

    /**
     * The deck of the PLayer.
     */
    protected var _deck: Deck

    /**
     * The hand of the Player.
     */
    protected var _hand: Hand
    

    /** Pick a given card of Players hand of cards and remove it from the hand.
     * 
     * @param card the Card that´s going to be played.
     *          
     */

    /** Pick a given card of Players hand of cards and removes it from the hand, it returns true if
     * it get removed, false otherwise
     * 
     * @param card the Card that´s going to be played
     * @return true if the card was removed, false otherwise
     */
    def playCard(card: ICard): Boolean

    /** Draws the first card from the deck of cards and adds it to the player's hand.
     *
     */
    def drawCard(): Unit


    /** Verify if the player's hand meet the requirements to draw a card.
     *
     */
    def canDrawCard(): Boolean
}
