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
    val name:String
    
    /**
     * The weather type of the card.
     */
    val weatherType: IWeatherType
    
    /**
     * The type of the card. For unit cards, this will always be "Weather Card".
     */
    val cardType: String = "Weather Card"

    /** Returns the weather type of the weather card.
     *
     * This method returns the weather type of the weather card. It will always return
     * an IWeatherType object
     *
     * @return The weather type of the weather card.
     */
    override def getWeatherType(): IWeatherType = {
        this.weatherType
    }

    /** Aplies the weather ability to the board in the game
     *
     * @param board the board where´s going to be aplied the ability
     */
    override def useWeatherAbility(board: Board): Unit = {
        ???
    }

    /** Try to play a card in to a Weather Section in a Board
     *
     * @param section te board where the card its going to be added
     */
    override def PlayinSectionWeather(section: IBoardSection): Unit ={
        section.AddCard(this)
    }

    /** Try to play a card in to a Close Combat Section in a Board
     *
     * @param section te board where the card its going to be added
     */
    override def PlayinSectionCloseCombat(section: IBoardSection): Unit = {
        ()
    }

    /** Try to play a card in to a Ranged Section in a Board
     *
     * @param section te board where the card its going to be added
     */
    override def PlayinSectionRanged(section: IBoardSection): Unit = {
        ()
    }

    /** Try to play a card in to a Siege Section in a Board
     *
     * @param section te board where the card its going to be added
     */
    override def PlayinSectionSiege(section: IBoardSection): Unit = {
        ()
    }
}
