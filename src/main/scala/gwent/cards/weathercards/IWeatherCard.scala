package cl.uchile.dcc
package gwent.cards.weathercards

import gwent.cards.ICard

import cl.uchile.dcc.gwent.board.Board
import weathertype.IWeatherType


/**
 * Represents a weather card in the gwent game.
 * This trait defines the properties that all weather cards have in common
 * such as their weatherType.
 *
 */
trait IWeatherCard extends ICard{
    
    /**
     * The weather type of the Weather Card
     */
    val weatherType: IWeatherType
    
    /** Returns the weather type of the weather card.
     *
     * This method returns the weather type of the weather card. It will always return
     * an IWeatherType object
     *
     * @return The weather type of the weather card.
     */
    def getWeatherType(): IWeatherType

    def getPlayed(board: Board): Unit
}
