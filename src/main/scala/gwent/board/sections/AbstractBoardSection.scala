package cl.uchile.dcc
package gwent.board.sections
import gwent.cards.unitcards.IUnitCard

import cl.uchile.dcc.gwent.cards.weathercards.IWeatherCard

import scala.collection.mutable.ArrayBuffer

abstract class AbstractBoardSection extends IBoardSection{

    /**
     * the unit cards group of the section
     */
    var sectionCardGroup: ArrayBuffer[IUnitCard] = new ArrayBuffer[IUnitCard]()

    /**
     * the summatory of the attack power of all unit cards of the section
     */
    var totalAttackPower: Int = 0

    /** Add a unit card to the card section group
     *
     * @param card the unit card thats going to be added
     */
    override def AddUnitCard(card: IUnitCard): Unit = {
        this.sectionCardGroup+=card
    }

    /** Removes a currently Played Unit Card
     *
     * @param card the card that´s going to be removed
     */
    override def RemoveUnitCard(card: IUnitCard): Unit = {
        this.sectionCardGroup-=card
    }
}
