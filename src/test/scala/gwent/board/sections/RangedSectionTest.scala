package cl.uchile.dcc
package gwent.board.sections

import gwent.cards.unitcards.{CloseCombatCard, IUnitCard, RangedCard, SiegeCard}
import gwent.cards.unitcards.effects.{CloseBond, ISpecialAbility, MoralBoost}

import cl.uchile.dcc.gwent.cards.ICard
import cl.uchile.dcc.gwent.cards.weathercards.FogCard
import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

class RangedSectionTest extends FunSuite{

    var atckpwr: Int = 0

    val firstCardName: String = "Geralt of Rivia"
    val firstCardAttkPwr: Int = 6

    val secondCardName: String = "Dandelion"
    val secondCardAttkPwr: Int = 2


    val moralboost: ISpecialAbility = new MoralBoost()
    val closeBond: ISpecialAbility = new CloseBond()

    var closeCombatCard: CloseCombatCard = _
    var rangedCard: RangedCard = _
    var siegeCard: SiegeCard = _
    var weatherCard: FogCard = _

    var array: ArrayBuffer[RangedCard] = new ArrayBuffer[RangedCard]()
    var arraywithcard: ArrayBuffer[RangedCard] = _
    var firstRangedSection: RangedSection = _
    var secondRangedSection: RangedSection = _
    override def beforeEach(context: BeforeEach): Unit = {
        closeCombatCard = new CloseCombatCard(firstCardName,firstCardAttkPwr, closeBond)
        rangedCard = new RangedCard(secondCardName,secondCardAttkPwr, moralboost)
        siegeCard = new SiegeCard(firstCardName,firstCardAttkPwr)
        weatherCard = new FogCard

        arraywithcard = ArrayBuffer(rangedCard)
        firstRangedSection = new RangedSection()
        secondRangedSection = new RangedSection()

    }
    test("A RangedSection must be created with a sectionCardGroup"){
        assertEquals(array, firstRangedSection.getSectionCardGroup)
    }
    test("A RangedSection must be created with a totalAttackPower"){
        assertEquals(atckpwr, firstRangedSection.getTotalAttackPower)
    }
    test("A Rangedcard can be added to the sectionCardGroup of a RangedSection"){
        assertEquals(firstRangedSection.getSectionCardGroup,array)
        assertNotEquals(firstRangedSection.getSectionCardGroup, arraywithcard)

        firstRangedSection.AddCard(rangedCard)

        assertNotEquals(firstRangedSection.getSectionCardGroup,array)
        assertEquals(firstRangedSection.getSectionCardGroup, arraywithcard)
    }

    test("An Int can be setted as the section totalattackpower"){
        var newAttkPwr: Int = 4
        assertEquals(firstRangedSection.getTotalAttackPower,atckpwr)
        firstRangedSection.setTotalAttackPower(newAttkPwr)
        assertNotEquals(firstRangedSection.getTotalAttackPower,atckpwr)
        assertEquals(firstRangedSection.getTotalAttackPower, newAttkPwr)
    }
    
    test("A Ranged Section can be cleared, removing all cards from its card section"){
        firstRangedSection.AddCard(rangedCard)
        assertEquals(firstRangedSection.getSectionCardGroup,arraywithcard)

        firstRangedSection.ClearSection()

        assertNotEquals(firstRangedSection.getSectionCardGroup,arraywithcard)
        assertEquals(array, firstRangedSection.getSectionCardGroup)
    }
    test("A RangedSection should be equal to another" +
        " of the same class with the same attributes and it should have the same hashcode"){
        var notEqualtoFirst: RangedSection = new RangedSection()
        notEqualtoFirst.AddCard(rangedCard)
        assertEquals(firstRangedSection, secondRangedSection)
        assertEquals(secondRangedSection, firstRangedSection)
        assertEquals(firstRangedSection.hashCode(), secondRangedSection.hashCode())
        assertNotEquals(firstRangedSection, notEqualtoFirst)
        assertNotEquals(notEqualtoFirst, firstRangedSection)
        assertNotEquals(firstRangedSection.hashCode(), notEqualtoFirst.hashCode())
    }
}
