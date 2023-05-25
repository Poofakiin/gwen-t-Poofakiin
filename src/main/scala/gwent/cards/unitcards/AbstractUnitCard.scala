package cl.uchile.dcc
package gwent.cards.unitcards
import cl.uchile.dcc.gwent.board.HalfBoard
import cl.uchile.dcc.gwent.board.sections.IBoardSection
import effects.*

/** A class that represents an unit type of card in the Gwent game.
 *
 *  Unit cards have a name, a cardType, an attack power, and may have a special ability.
 *
 * @param name the name of the unit card.
 * @param attackPower the attack power of the unit card.
 */
abstract class AbstractUnitCard(val name: String, var attackPower: Int) extends IUnitCard{

    /**
     * The type of the card. For unit cards, this will always be "Unit Card".
     */
    val cardType: String = "Unit Card"

    /**
     * The special ability of the unit card, if any.
     */
    protected var _specialAbility: Option[ISpecialAbility] = None

    /**
     * Returns the special ability of the unit card.
     *
     * This method returns the special ability of a unit card. If the card has a special ability,
     * this method will return the Some(ISpecialAbility) instance that represents it. If the card
     * doesn't have a special ability, it will return None.
     *
     * @return The special ability of the unit card, if any.
     */
    override def getSpecialAbility(): Option[ISpecialAbility] = {
        _specialAbility
    }

    /** Try to play a card in to a Ranged Section in a Board
     *
     * @param section te board where the card its going to be added
     */
    override def PlayinSectionRanged(section: IBoardSection): Boolean = {
        false
    }

    /** Try to play a card in to a Siege Section in a Board
     *
     * @param section te board where the card its going to be added
     */
    override def PlayinSectionSiege(section: IBoardSection): Boolean = {
        false
    }

    /** Try to play a card in to a Weather Section in a Board
     *
     * @param section te board where the card its going to be added
     */
    override def PlayinSectionWeather(section: IBoardSection): Boolean = {
        false
    }

    /** Try to play a card in to a Close Combat Section in a Board
     *
     * @param section te board where the card its going to be added
     */
    override def PlayinSectionCloseCombat(section: IBoardSection): Boolean = {
        false
    }
}

