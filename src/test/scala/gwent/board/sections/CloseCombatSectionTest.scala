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
        assertEquals(array, firstCloseCombatSection.sectionCardGroup)
    }
    test("A CloseCombatSection must be created with a totalAttackPower"){
        assertEquals(atckpwr, firstCloseCombatSection.totalAttackPower)
    }
    test("A Close combat card can be added to the sectionCardGroup of a CloseCombatSection"){
        assertEquals(firstCloseCombatSection.sectionCardGroup,array)
        assertNotEquals(firstCloseCombatSection.sectionCardGroup, arraywithcard)

        firstCloseCombatSection.AddCard(closeCombatCard)

        assertNotEquals(firstCloseCombatSection.sectionCardGroup,array)
        assertEquals(firstCloseCombatSection.sectionCardGroup, arraywithcard)
    }
    
    
    test("A Close combat section can be cleared, removing all cards from its card section"){
        firstCloseCombatSection.AddCard(closeCombatCard)
        assertEquals(firstCloseCombatSection.sectionCardGroup,arraywithcard)

        firstCloseCombatSection.ClearSection()

        assertNotEquals(firstCloseCombatSection.sectionCardGroup,arraywithcard)
        assertEquals(array, firstCloseCombatSection.sectionCardGroup)
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
