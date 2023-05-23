package cl.uchile.dcc
package gwent.board.sections

import gwent.cards.unitcards.{CloseCombatCard, IUnitCard}
import gwent.cards.unitcards.effects._

import scala.collection.mutable.ArrayBuffer
import munit.FunSuite

class CloseCombatSectionTest extends FunSuite{

    var atckpwr: Int = 0

    val firstCardName: String = "Geralt of Rivia"
    val firstCardAttkPwr: Int = 6

    val secondCardName: String = "Dandelion"
    val secondCardAttkPwr: Int = 2


    val moralboost: ISpecialAbility = new MoralBoost()
    val closeBond: ISpecialAbility = new CloseBond()

    var card1: CloseCombatCard = _
    var card2: CloseCombatCard = _
    var card3: CloseCombatCard = _

    var array: ArrayBuffer[IUnitCard] = new ArrayBuffer[IUnitCard]()
    var arraywithcard: ArrayBuffer[IUnitCard] = _
    var firstCloseCombatSection: CloseCombatSection = _
    var secondCloseCombatSection: CloseCombatSection = _
    override def beforeEach(context: BeforeEach): Unit = {
        card1 = new CloseCombatCard(firstCardName,firstCardAttkPwr, closeBond)
        card2 = new CloseCombatCard(secondCardName,secondCardAttkPwr, moralboost)
        card3 = new CloseCombatCard(firstCardName,firstCardAttkPwr)
        arraywithcard = ArrayBuffer(card1)
        firstCloseCombatSection = new CloseCombatSection()
        secondCloseCombatSection = new CloseCombatSection()

    }
    test("A CloseCombatSection must be created with a sectionCardGroup"){
        assertEquals(array, firstCloseCombatSection.sectionCardGroup)
    }
    test("A CloseCombatSection must be created with a totalAttackPower"){
        assertEquals(atckpwr, firstCloseCombatSection.totalAttackPower)
    }
    test("A Close combat card can be added to the sectionCardGroup of a CloseCombatSection"){
        assertEquals(firstCloseCombatSection.sectionCardGroup,array)
        assertNotEquals(firstCloseCombatSection.sectionCardGroup, arraywithcard)

        firstCloseCombatSection.AddUnitCard(card1)

        assertNotEquals(firstCloseCombatSection.sectionCardGroup,array)
        assertEquals(firstCloseCombatSection.sectionCardGroup, arraywithcard)
    }

    test("A Close combat card can be removed from the sectionCardGroup of a CloseCombatSection"){
        firstCloseCombatSection.AddUnitCard(card1)
        assertEquals(firstCloseCombatSection.sectionCardGroup,arraywithcard)

        firstCloseCombatSection.RemoveUnitCard(card1)

        assertNotEquals(firstCloseCombatSection.sectionCardGroup,arraywithcard)
        assertEquals(array, firstCloseCombatSection.sectionCardGroup)
    }
    test("A CloseCombatSection should be equal to another" +
        " of the same class with the same attributes and it should have the same hashcode"){
        var notEqualtoFirst: CloseCombatSection = new CloseCombatSection()
        notEqualtoFirst.AddUnitCard(card1)
        assertEquals(firstCloseCombatSection, secondCloseCombatSection)
        assertEquals(secondCloseCombatSection, firstCloseCombatSection)
        assertEquals(firstCloseCombatSection.hashCode(), secondCloseCombatSection.hashCode())
        assertNotEquals(firstCloseCombatSection, notEqualtoFirst)
        assertNotEquals(notEqualtoFirst, firstCloseCombatSection)
        assertNotEquals(firstCloseCombatSection.hashCode(), notEqualtoFirst.hashCode())
    }
}
