package cl.uchile.dcc
package gwent.board


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
    
}
