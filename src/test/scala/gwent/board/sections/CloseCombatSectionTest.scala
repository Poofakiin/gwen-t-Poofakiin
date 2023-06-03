package cl.uchile.dcc
package gwent.board.sections

import gwent.cards.unitcards.{CloseCombatCard, IUnitCard, RangedCard, SiegeCard}
import gwent.cards.unitcards.effects.*

import gwent.cards.ICard
import gwent.cards.weathercards.FogCard

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

    var closeCombatCard: CloseCombatCard = _
    var rangedCard: RangedCard = _
    var siegeCard: SiegeCard = _
    var weatherCard: FogCard = _

    var array: ArrayBuffer[CloseCombatCard] = new ArrayBuffer[CloseCombatCard]()
    var arraywithcard: ArrayBuffer[CloseCombatCard] = _
    var firstCloseCombatSection: CloseCombatSection = _
    var secondCloseCombatSection: CloseCombatSection = _
    override def beforeEach(context: BeforeEach): Unit = {
        closeCombatCard = new CloseCombatCard(firstCardName,firstCardAttkPwr, closeBond)
        rangedCard = new RangedCard(secondCardName,secondCardAttkPwr, moralboost)
        siegeCard = new SiegeCard(firstCardName,firstCardAttkPwr)
        weatherCard = new FogCard

        arraywithcard = ArrayBuffer(closeCombatCard)
        firstCloseCombatSection = new CloseCombatSection()
        secondCloseCombatSection = new CloseCombatSection()

    }
    test("A CloseCombatSection must be created with a sectionCardGroup"){
        assertEquals(array, firstCloseCombatSection.getSectionCardGroup)
    }
    test("A CloseCombatSection must be created with a totalAttackPower"){
        assertEquals(atckpwr, firstCloseCombatSection.getTotalAttackPower)
    }
    test("A Close combat card can be added to the sectionCardGroup of a CloseCombatSection"){
        assertEquals(firstCloseCombatSection.getSectionCardGroup,array)
        assertNotEquals(firstCloseCombatSection.getSectionCardGroup, arraywithcard)

        firstCloseCombatSection.AddCard(closeCombatCard)

        assertNotEquals(firstCloseCombatSection.getSectionCardGroup,array)
        assertEquals(firstCloseCombatSection.getSectionCardGroup, arraywithcard)
    }


    test("An Int number can be setted as the section totalattackpower"){
        var newAttkPwr: Int = 4
        assertEquals(firstCloseCombatSection.getTotalAttackPower,atckpwr)
        firstCloseCombatSection.setTotalAttackPower(newAttkPwr)
        assertNotEquals(firstCloseCombatSection.getTotalAttackPower,atckpwr)
        assertEquals(firstCloseCombatSection.getTotalAttackPower, newAttkPwr)
    }
    
    test("A Close combat section can be cleared, removing all cards from its card section"){
        firstCloseCombatSection.AddCard(closeCombatCard)
        assertEquals(firstCloseCombatSection.getSectionCardGroup,arraywithcard)

        firstCloseCombatSection.ClearSection()

        assertNotEquals(firstCloseCombatSection.getSectionCardGroup,arraywithcard)
        assertEquals(array, firstCloseCombatSection.getSectionCardGroup)
    }
    test("A CloseCombatSection should be equal to another" +
        " of the same class with the same attributes and it should have the same hashcode"){
        var notEqualtoFirst: CloseCombatSection = new CloseCombatSection()
        notEqualtoFirst.AddCard(closeCombatCard)
        assertEquals(firstCloseCombatSection, secondCloseCombatSection)
        assertEquals(secondCloseCombatSection, firstCloseCombatSection)
        assertEquals(firstCloseCombatSection.hashCode(), secondCloseCombatSection.hashCode())
        assertNotEquals(firstCloseCombatSection, notEqualtoFirst)
        assertNotEquals(notEqualtoFirst, firstCloseCombatSection)
        assertNotEquals(firstCloseCombatSection.hashCode(), notEqualtoFirst.hashCode())
    }
}
