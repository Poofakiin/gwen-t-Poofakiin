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

    var array: ArrayBuffer[ICard] = new ArrayBuffer[ICard]()
    var arraywithcard: ArrayBuffer[ICard] = _
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

        firstCloseCombatSection.PlayinSection(closeCombatCard)

        assertNotEquals(firstCloseCombatSection.sectionCardGroup,array)
        assertEquals(firstCloseCombatSection.sectionCardGroup, arraywithcard)
    }

    test("A Ranged card wont be played in a close combat section"){
        assertEquals(firstCloseCombatSection.sectionCardGroup,array)
        firstCloseCombatSection.PlayinSection(rangedCard)
        assertEquals(firstCloseCombatSection.sectionCardGroup,array)
    }

    test("A Siege card wont be played in a close combat section"){
        assertEquals(firstCloseCombatSection.sectionCardGroup,array)
        firstCloseCombatSection.PlayinSection(siegeCard)
        assertEquals(firstCloseCombatSection.sectionCardGroup,array)
    }

    test("A weather type card wont be played in a close combat section"){
        assertEquals(firstCloseCombatSection.sectionCardGroup,array)
        firstCloseCombatSection.PlayinSection(weatherCard)
        assertEquals(firstCloseCombatSection.sectionCardGroup,array)
    }

    test("A Close combat card can be removed from the sectionCardGroup of a CloseCombatSection"){
        firstCloseCombatSection.PlayinSection(closeCombatCard)
        assertEquals(firstCloseCombatSection.sectionCardGroup,arraywithcard)

        firstCloseCombatSection.RemoveCard(closeCombatCard)

        assertNotEquals(firstCloseCombatSection.sectionCardGroup,arraywithcard)
        assertEquals(array, firstCloseCombatSection.sectionCardGroup)
    }
    test("A CloseCombatSection should be equal to another" +
        " of the same class with the same attributes and it should have the same hashcode"){
        var notEqualtoFirst: CloseCombatSection = new CloseCombatSection()
        notEqualtoFirst.PlayinSection(closeCombatCard)
        assertEquals(firstCloseCombatSection, secondCloseCombatSection)
        assertEquals(secondCloseCombatSection, firstCloseCombatSection)
        assertEquals(firstCloseCombatSection.hashCode(), secondCloseCombatSection.hashCode())
        assertNotEquals(firstCloseCombatSection, notEqualtoFirst)
        assertNotEquals(notEqualtoFirst, firstCloseCombatSection)
        assertNotEquals(firstCloseCombatSection.hashCode(), notEqualtoFirst.hashCode())
    }
}
