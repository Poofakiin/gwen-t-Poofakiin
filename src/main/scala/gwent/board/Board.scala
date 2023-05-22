package cl.uchile.dcc
package gwent.board

import gwent.cards.weathercards.IWeatherCard

import cl.uchile.dcc.gwent.cards.unitcards.IUnitCard


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
 */
class Board(var playerBoard: HalfBoard, var enemyBoard: HalfBoard) {
    
    /** Tries to play a certain weather card
     * 
     * @param card the weather card that wants to be played
     */
    def PlayerPlayWeatherCard(card: IWeatherCard): Unit = {
        playerBoard.player.playCard(card,playerBoard)
        playerBoard.player.playCard(card,enemyBoard)
    }

    /** Tries to play a unit card
     * 
     * @param card the unit card that wants to be played
     */
    def PlayerPlayUnitCard(card: IUnitCard): Unit = {
        playerBoard.playUnitCard(card)
    }
    
    /** Tries to play a certain weather card
     *
     * @param card the card that wants to be played
     */
    def EnemyPlayWeatherCard(card: IWeatherCard): Unit = {
        enemyBoard.player.playCard(card,enemyBoard)
        enemyBoard.player.playCard(card,playerBoard)
    }

    /** Tries to play a unit card
     *
     * @param card the unit card that wants to be played
     */
    def EnemyPlayUnitCard(card: IUnitCard): Unit = {
        enemyBoard.playUnitCard(card,enemyBoard)
    }


}
