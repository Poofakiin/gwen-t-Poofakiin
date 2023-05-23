package cl.uchile.dcc
package gwent.board.sections

import gwent.cards.unitcards.{IUnitCard, RangedCard}
import gwent.cards.unitcards.effects.{CloseBond, ISpecialAbility, MoralBoost}

import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

class RangedSectionTest extends FunSuite{
    var array: ArrayBuffer[IUnitCard] = new ArrayBuffer[IUnitCard]()
    var atckpwr: Int = 0

    val firstCardName: String = "Geralt of Rivia"
    val firstCardAttkPwr: Int = 6

    val secondCardName: String = "Dandelion"
    val secondCardAttkPwr: Int = 2


    val moralboost: ISpecialAbility = new MoralBoost()
    val closeBond: ISpecialAbility = new CloseBond()

    var card1: RangedCard = _
    var card2: RangedCard = _
    var card3: RangedCard = _
    var arraywithcard: ArrayBuffer[IUnitCard] = _

    var firstRangedSection: RangedSection = _
    var secondRangedSection: RangedSection = _

    override def beforeEach(context: BeforeEach): Unit = {
        card1 = new RangedCard(firstCardName,firstCardAttkPwr, closeBond)
        card2 = new RangedCard(secondCardName,secondCardAttkPwr, moralboost)
        card3 = new RangedCard(firstCardName,firstCardAttkPwr)
        arraywithcard= ArrayBuffer(card1)
        firstRangedSection = new RangedSection()
        secondRangedSection = new RangedSection()

    }
    test("A RangedSection must be created with a sectionCardGroup"){
        assertEquals(array, firstRangedSection.sectionCardGroup)
    }
    test("A RangedSection must be created with a totalAttackPower"){
        assertEquals(atckpwr, firstRangedSection.totalAttackPower)
    }
    test("A Ranged card can be added to the sectionCardGroup of a RangedSection"){
        assertEquals(firstRangedSection.sectionCardGroup,array)
        assertNotEquals(firstRangedSection.sectionCardGroup, arraywithcard)

        firstRangedSection.AddUnitCard(card1)

        assertNotEquals(firstRangedSection.sectionCardGroup,array)
        assertEquals(firstRangedSection.sectionCardGroup, arraywithcard)
    }

    test("A Ranged card can be removed from the sectionCardGroup of a RangedSection"){
        firstRangedSection.AddUnitCard(card1)
        assertEquals(firstRangedSection.sectionCardGroup,arraywithcard)

        firstRangedSection.RemoveUnitCard(card1)

        assertNotEquals(firstRangedSection.sectionCardGroup,arraywithcard)
        assertEquals(array, firstRangedSection.sectionCardGroup)
    }
    test("A RangedSection should be equal to another" +
        " of the same class with the same attributes and it should have the same hashcode"){
        var notEqualtoFirst: RangedSection = new RangedSection()
        notEqualtoFirst.AddUnitCard(card1)
        assertEquals(firstRangedSection, secondRangedSection)
        assertEquals(secondRangedSection, firstRangedSection)
        assertEquals(firstRangedSection.hashCode(), secondRangedSection.hashCode())
        assertNotEquals(firstRangedSection, notEqualtoFirst)
        assertNotEquals(notEqualtoFirst, firstRangedSection)
        assertNotEquals(firstRangedSection.hashCode(), notEqualtoFirst.hashCode())
    }
}
