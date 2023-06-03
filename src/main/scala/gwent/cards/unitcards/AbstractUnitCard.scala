package cl.uchile.dcc
package gwent.cards.unitcards
import cl.uchile.dcc.gwent.board.{Board, HalfBoard}
import cl.uchile.dcc.gwent.board.sections.IBoardSection
import effects.*

/** A class that represents an unit type of card in the Gwent game.
 *
 *  Unit cards have a name, a cardType, an attack power, and may have a special ability.
 *
 * @param name the name of the unit card.
 * @param attackPower the attack power of the unit card.
 */
abstract class AbstractUnitCard(protected val _name: String, protected var _attackPower: Int) extends IUnitCard{

    /**
     * The type of the card. For unit cards, this will always be "Unit Card".
     */
    val _cardType: String = "Unit Card"

    /**
     * The special ability of the unit card, if any.
     */
    protected var _specialAbility: Option[ISpecialAbility] = None

    /** Sets a new special Ability for the card
     * 
     * @param specialAbility the new special Ability
     */
    protected def specialAbility_(specialAbility: ISpecialAbility): Unit ={
        _specialAbility = Some(specialAbility)
    }

    /** Gives a copy of the card name
     *
     * @return the copy of the card name
     */
    def name: String={
        var cloneName: String =  _name
        cloneName
    }

    /** Gives a copy of the attackpower of the card
     *
     * @return the copy of the attack power
     */
    def attackPower: Int = {
        var cloneAttackPwr: Int = _attackPower
        cloneAttackPwr
    }

    /** Gives a copy of the card type of the card
     *
     * @return the copy of the card type
     */
    def cardType: String ={
        var cloneCardType: String =  _cardType
        cloneCardType
    }

    /** Gives a copy of the special ability of the card
     *
     * @return the copy of the special ability
     */
    def specialAbility: Option[ISpecialAbility] ={
        var cloneSpecialAbility: Option[ISpecialAbility] = _specialAbility
        cloneSpecialAbility
    }
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
    
}

