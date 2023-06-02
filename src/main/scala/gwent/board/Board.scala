package cl.uchile.dcc
package gwent.board

import gwent.cards.weathercards.IWeatherCard
import gwent.board.HalfBoard
import gwent.board.sections.{IBoardSection, WeatherSection}
import gwent.cards.ICard

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
    
    /** Tries to play a certain card
     *
     * @param card the card that wants to be played
     */
    def PlayerPlayCard(card: ICard): Unit = {
        if(playerBoard.player.playCard(card)){
            card.getPlayed(this,playerBoard)
        }
        else{
            ()
        }
    }

    /** Tries to play a certain weather card
     *
     * @param card the card that wants to be played
     */
    def EnemyPlayCard(card: ICard): Unit = {
        if(enemyBoard.player.playCard(card)){
            card.getPlayed(this,enemyBoard)
        }
        else{
            ()
        }
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
                    other.weatherSection == this.weatherSection)
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
        result = prime * result + weatherSection.##
        result = prime * result + enemyBoard.##
        result
    }

}
