package cl.uchile.dcc

package gwent.board.sections
import gwent.cards.ICard
import gwent.cards.unitcards.IUnitCard


import scala.collection.mutable.ArrayBuffer

abstract class AbstractUnitBoardSection extends IBoardSection{

    /**
     * the unit cards group of the section
     */
    var sectionCardGroup: ArrayBuffer[ICard] = new ArrayBuffer[ICard]()

    /**
     * the summatory of the attack power of all unit cards of the section
     */
    var totalAttackPower: Int = 0

    /** Add a Card to the card section group
     *
     * @param card the unit card thats going to be added
     */
    override def AddCard(card: ICard): Unit = {
        this.sectionCardGroup+=card
    }

    /** Removes a currently Played Card
     *
     * @param card the card that´s going to be removed
     */
    override def RemoveCard(card: ICard): Unit = {
        this.sectionCardGroup-=card
    }

    /** Play a card in a certain section
     *
     * @param ICard the card that´s going to be played
     */
    override def PlayinSection(card: ICard): Boolean = {
        ???
    }
}
