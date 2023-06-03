package cl.uchile.dcc
package gwent.cards.weathercards

import gwent.cards.ICard

import cl.uchile.dcc.gwent.board.sections.IBoardSection
import cl.uchile.dcc.gwent.board.{Board, HalfBoard}
import weathertype.IWeatherType

/** A class that represents an weather type of card in the Gwent game.
 *
 *  weather cards have a name, a cardType, and a weather type.
 *
 */
abstract class AbstractWeatherCard() extends IWeatherCard {
    
    /**
     * The name of the card.
     */
    protected val _name:String
    
    /**
     * The weather type of the card.
     */
    protected val _weatherType: IWeatherType
    
    /**
     * The type of the card. For unit cards, this will always be "Weather Card".
     */
    protected val _cardType: String = "Weather Card"

    /** Gives a copy of the name of the card
     *
     * @return the copy of the name
     */
    def name: String ={
       var cloneName:String = _name
       cloneName
    }

    /** Gives a copy of the card type of the card
     *
     * @return the copy of the card type
     */
    def cardType: String = {
        var cloneCardType: String = _cardType
        cloneCardType
    }

    /** Returns the weather type of the weather card.
     *
     * This method returns the weather type of the weather card. It will always return
     * an IWeatherType object
     *
     * @return The weather type of the weather card.
     */
    override def getWeatherType(): IWeatherType = {
        this._weatherType
    }

    /** Aplies the weather ability to the board in the game
     *
     * @param board the board where´s going to be aplied the ability
     */
    override def useWeatherAbility(board: Board): Unit = {
        ???
    }

    /** Plays this card on a certain board and HalfBoard weater section
     *
     * @param board the whole board where its going to be played
     * @param halfBoard the half of the board where the card can get played
     */
    def getPlayed(board: Board,halfBoard: HalfBoard): Unit = {
        board.weatherSection.AddCard(this)
    }
}
