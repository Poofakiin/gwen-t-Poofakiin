package cl.uchile.dcc
package gwent.board

import gwent.cards.weathercards.IWeatherCard


/** A class that represents one siede of the board in the gwent game
 *
 * each side of a Board must have three sections, one for each type of unit card
 * , and a Player who´s the one controlling the half.
 *
 * @param siegeSection
 * @param closeCombatSection
 * @param rangedSection
 * @param player
 *
 */

/** A class that represents a whole board in the gwent game
 * 
 * A Gwent´s Board must have two sides, each one controlled by a Player
 * 
 * @param playerBoard
 * @param enemyBoard
 * @param siegeWeather
 * @param closeCombatWeather
 * @param rangedWeather
 */
class Board(var playerBoard: HalfBoard, var enemyBoard: HalfBoard) {
    /**
     * the weather card of the section
     */
    var siegeWeather: IWeatherCard

    /**
     * the weather card of the section
     */
    var closeCombatWeather: IWeatherCard

    /**
     * the weather card of the section
     */
    var rangedWeather: IWeatherCard


    /** Tries to change the weather card of the section
     *
     */
    def PlayerPlayWeatherCard(card: IWeatherCard): Unit = {
        ???
    }


    /** Tries to change the weather card of the section
     *
     */
    def EnemyPlayWeatherCard(card: IWeatherCard): Unit = {
        ???
    }
        

}
