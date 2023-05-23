package cl.uchile.dcc
package gwent.board.sections

import gwent.cards.unitcards.{IUnitCard, RangedCard, SiegeCard}
import gwent.cards.unitcards.effects.{CloseBond, ISpecialAbility, MoralBoost}

import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

class SiegeSectionTest extends FunSuite{
    var array: ArrayBuffer[IUnitCard] = new ArrayBuffer[IUnitCard]()
    var atckpwr: Int = 0

    val firstCardName: String = "Geralt of Rivia"
    val firstCardAttkPwr: Int = 6

    val secondCardName: String = "Dandelion"
    val secondCardAttkPwr: Int = 2


    val moralboost: ISpecialAbility = new MoralBoost()
    val closeBond: ISpecialAbility = new CloseBond()

    var card1: SiegeCard = _
    var card2: SiegeCard = _
    var card3: SiegeCard = _
    var arraywithcard: ArrayBuffer[IUnitCard] = _

    var firstSiegeSection: SiegeSection = _
    var secondSiegeSection: SiegeSection = _

    override def beforeEach(context: BeforeEach): Unit = {
        card1 = new SiegeCard(firstCardName,firstCardAttkPwr, closeBond)
        card2 = new SiegeCard(secondCardName,secondCardAttkPwr, moralboost)
        card3 = new SiegeCard(firstCardName,firstCardAttkPwr)
        arraywithcard= ArrayBuffer(card1)
        firstSiegeSection = new SiegeSection()
        secondSiegeSection = new SiegeSection()

    }
    test("A SiegeSection must be created with a sectionCardGroup"){
        assertEquals(array, firstSiegeSection.sectionCardGroup)
    }
    test("A SiegeSection must be created with a totalAttackPower"){
        assertEquals(atckpwr, firstSiegeSection.totalAttackPower)
    }
    test("A Siege card can be added to the sectionCardGroup of a SiegeSection"){
        assertEquals(firstSiegeSection.sectionCardGroup,array)
        assertNotEquals(firstSiegeSection.sectionCardGroup, arraywithcard)

        firstSiegeSection.AddUnitCard(card1)

        assertNotEquals(firstSiegeSection.sectionCardGroup,array)
        assertEquals(firstSiegeSection.sectionCardGroup, arraywithcard)
    }

    test("A Siege card can be removed from the sectionCardGroup of a SiegeSection"){
        firstSiegeSection.AddUnitCard(card1)
        assertEquals(firstSiegeSection.sectionCardGroup,arraywithcard)

        firstSiegeSection.RemoveUnitCard(card1)

        assertNotEquals(firstSiegeSection.sectionCardGroup,arraywithcard)
        assertEquals(array, firstSiegeSection.sectionCardGroup)
    }
    test("A SiegeSection should be equal to another" +
        " of the same class with the same attributes and it should have the same hashcode"){
        var notEqualtoFirst: SiegeSection = new SiegeSection()
        notEqualtoFirst.AddUnitCard(card1)
        assertEquals(firstSiegeSection, secondSiegeSection)
        assertEquals(secondSiegeSection, firstSiegeSection)
        assertEquals(firstSiegeSection.hashCode(), secondSiegeSection.hashCode())
        assertNotEquals(firstSiegeSection, notEqualtoFirst)
        assertNotEquals(notEqualtoFirst, firstSiegeSection)
        assertNotEquals(firstSiegeSection.hashCode(), notEqualtoFirst.hashCode())
    }
}
