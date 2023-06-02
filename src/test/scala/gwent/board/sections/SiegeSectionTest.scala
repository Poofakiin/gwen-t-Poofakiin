package cl.uchile.dcc
package gwent.board.sections

import gwent.cards.unitcards.{CloseCombatCard, IUnitCard, RangedCard, SiegeCard}
import gwent.cards.unitcards.effects.{CloseBond, ISpecialAbility, MoralBoost}

import cl.uchile.dcc.gwent.cards.ICard
import cl.uchile.dcc.gwent.cards.weathercards.FogCard
import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

class SiegeSectionTest extends FunSuite{

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

    var array: ArrayBuffer[SiegeCard] = new ArrayBuffer[SiegeCard]()
    var arraywithcard: ArrayBuffer[SiegeCard] = _
    var firstSiegeSection: SiegeSection = _
    var secondSiegeSection: SiegeSection = _
    override def beforeEach(context: BeforeEach): Unit = {
        closeCombatCard = new CloseCombatCard(firstCardName,firstCardAttkPwr, closeBond)
        rangedCard = new RangedCard(secondCardName,secondCardAttkPwr, moralboost)
        siegeCard = new SiegeCard(firstCardName,firstCardAttkPwr)
        weatherCard = new FogCard

        arraywithcard = ArrayBuffer(siegeCard)
        firstSiegeSection = new SiegeSection()
        secondSiegeSection = new SiegeSection()

    }
    test("A SiegeSection must be created with a sectionCardGroup"){
        assertEquals(array, firstSiegeSection.getSectionCardGroup)
    }
    test("A SiegeSection must be created with a totalAttackPower"){
        assertEquals(atckpwr, firstSiegeSection.getTotalAttackPower)
    }
    test("A Siegecard can be added to the sectionCardGroup of a SiegeSection"){
        assertEquals(firstSiegeSection.getSectionCardGroup,array)
        assertNotEquals(firstSiegeSection.getSectionCardGroup, arraywithcard)

        firstSiegeSection.AddCard(siegeCard)

        assertNotEquals(firstSiegeSection.getSectionCardGroup,array)
        assertEquals(firstSiegeSection.getSectionCardGroup, arraywithcard)
    }
    
    test("A Siege Section can be cleared, removing all cards from its card section"){
        firstSiegeSection.AddCard(siegeCard)
        assertEquals(firstSiegeSection.getSectionCardGroup,arraywithcard)

        firstSiegeSection.ClearSection()

        assertNotEquals(firstSiegeSection.getSectionCardGroup,arraywithcard)
        assertEquals(array, firstSiegeSection.getSectionCardGroup)
    }
    test("A SiegeSection should be equal to another" +
        " of the same class with the same attributes and it should have the same hashcode"){
        var notEqualtoFirst: SiegeSection = new SiegeSection()
        notEqualtoFirst.AddCard(siegeCard)
        assertEquals(firstSiegeSection, secondSiegeSection)
        assertEquals(secondSiegeSection, firstSiegeSection)
        assertEquals(firstSiegeSection.hashCode(), secondSiegeSection.hashCode())
        assertNotEquals(firstSiegeSection, notEqualtoFirst)
        assertNotEquals(notEqualtoFirst, firstSiegeSection)
        assertNotEquals(firstSiegeSection.hashCode(), notEqualtoFirst.hashCode())
    }
}
