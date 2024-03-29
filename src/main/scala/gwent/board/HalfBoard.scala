package cl.uchile.dcc
package gwent.board

import cl.uchile.dcc.gwent.board.sections.{CloseCombatSection, IBoardSection, RangedSection, SiegeSection}
import cl.uchile.dcc.gwent.cards.unitcards.IUnitCard
import cl.uchile.dcc.gwent.cards.weathercards.IWeatherCard
import cl.uchile.dcc.gwent.players.GamePlayer

/** A class that represents one siede of the board in the gwent game
 *
 * each side of a Board must have three sections, one for each type of unit card
 * , and a Player who´s the one controlling the half.
 *
 * @param player the player who controlls the section
 *
 */
class HalfBoard(var player: GamePlayer) {

    /**
     * siegeSection the section of siege cards
     */
    var siegeSection: SiegeSection = new SiegeSection()
    
    /**
     * closeCombatSection the section of close combat cards
     */
    var closeCombatSection: CloseCombatSection = new CloseCombatSection()

    /**
     * rangedSection the section of ranged cards
     */
    var rangedSection: RangedSection = new RangedSection()

    /** Checks if this HalfBoard is equal to another object.
     *
     * @param obj The object to compare to.
     * @return true if the object is a HalfBoard and has the same player, siegeSection
     * closeCombatSection, rangedSection and weatherCard, false otherwise.
     */
    override def equals(obj: Any): Boolean = {
        if(obj.isInstanceOf[HalfBoard]){
            val other = obj.asInstanceOf[HalfBoard]
            (this eq other) ||
                (other.player == this.player &&
                    other.siegeSection == this.siegeSection &&
                    other.closeCombatSection == this.closeCombatSection &&
                    other.rangedSection == this.rangedSection)
        }
        else{
            false
        }
    }

    /** Returns the hash code of this HalfBoard.
     *
     * @return The hash code of this HalfBoard.
     */
    override def hashCode():Int = {
        val prime = 31
        var result= 1
        result = prime * result + classOf[HalfBoard].##
        result = prime * result + siegeSection.##
        result = prime * result + closeCombatSection.##
        result = prime * result + rangedSection.##
        result = prime * result + player.##
        result
    }
}
