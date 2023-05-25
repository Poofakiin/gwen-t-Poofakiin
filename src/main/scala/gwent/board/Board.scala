package cl.uchile.dcc
package gwent.board

import gwent.cards.weathercards.IWeatherCard
import gwent.board.HalfBoard
import gwent.board.sections.{IBoardSection, WeatherSection}
import gwent.cards.unitcards.IUnitCard


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

    /**
     * the weather card of the game, any of both players can change it
     */
    var weatherSection: WeatherSection = new WeatherSection
    
    /** Tries to play a certain weather card
     *
     * @param card the weather card that wants to be played
     */
    def PlayerPlayWeatherCard(card: IWeatherCard): Unit = {
        playerBoard.player.playCard(card,weatherSection)
    }

    /** Tries to play a certain weather card
     *
     * @param card the card that wants to be played
     */
    def EnemyPlayWeatherCard(card: IWeatherCard): Unit = {
        playerBoard.player.playCard(card, weatherSection)
    }

    /** Tries to play a unit card
     *
     * @param card the unit card that wants to be played
     */
    def PlayerPlayUnitCard(card: IUnitCard, section: IBoardSection): Unit = {
        playerBoard.playUnitCard(card, section)
    }
    

    /** Tries to play a unit card
     *
     * @param card the unit card that wants to be played
     */
    def EnemyPlayUnitCard(card: IUnitCard, section: IBoardSection): Unit = {
        enemyBoard.playUnitCard(card,section)
    }

    /** Checks if this Board is equal to another object.
     *
     * @param obj The object to compare to.
     * @return true if the object is a Board and has the same playerBoard and
     * enemyBoard, false otherwise.
     */
    override def equals(obj: Any): Boolean = {
        if(obj.isInstanceOf[Board]){
            val other = obj.asInstanceOf[Board]
            (this eq other) ||
                (other.playerBoard == this.playerBoard &&
                    other.enemyBoard == this.enemyBoard &&
                    other.weatherCard == this.weatherCard)
        }
        else{
            false
        }
    }

    /** Returns the hash code of this Board.
     *
     * @return The hash code of this Board.
     */
    override def hashCode():Int = {
        val prime = 31
        var result= 1
        result = prime * result + classOf[Board].##
        result = prime * result + playerBoard.##
        result = prime * result + weatherCard.##
        result = prime * result + enemyBoard.##
        result
    }

}
