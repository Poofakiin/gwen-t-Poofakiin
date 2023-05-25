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
        assertEquals(array, firstSiegeSection.sectionCardGroup)
    }
    test("A SiegeSection must be created with a totalAttackPower"){
        assertEquals(atckpwr, firstSiegeSection.totalAttackPower)
    }
    test("A Siegecard can be added to the sectionCardGroup of a SiegeSection"){
        assertEquals(firstSiegeSection.sectionCardGroup,array)
        assertNotEquals(firstSiegeSection.sectionCardGroup, arraywithcard)

        firstSiegeSection.PlayinSection(siegeCard)

        assertNotEquals(firstSiegeSection.sectionCardGroup,array)
        assertEquals(firstSiegeSection.sectionCardGroup, arraywithcard)
    }

    test("A Close combat card wont be played in a SiegeSection"){
        assertEquals(firstSiegeSection.sectionCardGroup,array)
        firstSiegeSection.PlayinSection(closeCombatCard)
        assertEquals(firstSiegeSection.sectionCardGroup,array)
    }

    test("A Ranged card wont be played in a SiegeSection"){
        assertEquals(firstSiegeSection.sectionCardGroup,array)
        firstSiegeSection.PlayinSection(rangedCard)
        assertEquals(firstSiegeSection.sectionCardGroup,array)
    }

    test("A weather type card wont be played in a SiegeSection"){
        assertEquals(firstSiegeSection.sectionCardGroup,array)
        firstSiegeSection.PlayinSection(weatherCard)
        assertEquals(firstSiegeSection.sectionCardGroup,array)
    }

    test("A siege card can be removed from the sectionCardGroup of a SiegeSection"){
        firstSiegeSection.PlayinSection(siegeCard)
        assertEquals(firstSiegeSection.sectionCardGroup,arraywithcard)

        firstSiegeSection.RemoveCard(siegeCard)

        assertNotEquals(firstSiegeSection.sectionCardGroup,arraywithcard)
        assertEquals(array, firstSiegeSection.sectionCardGroup)
    }
    test("A SiegeSection should be equal to another" +
        " of the same class with the same attributes and it should have the same hashcode"){
        var notEqualtoFirst: SiegeSection = new SiegeSection()
        notEqualtoFirst.PlayinSection(siegeCard)
        assertEquals(firstSiegeSection, secondSiegeSection)
        assertEquals(secondSiegeSection, firstSiegeSection)
        assertEquals(firstSiegeSection.hashCode(), secondSiegeSection.hashCode())
        assertNotEquals(firstSiegeSection, notEqualtoFirst)
        assertNotEquals(notEqualtoFirst, firstSiegeSection)
        assertNotEquals(firstSiegeSection.hashCode(), notEqualtoFirst.hashCode())
    }
}
