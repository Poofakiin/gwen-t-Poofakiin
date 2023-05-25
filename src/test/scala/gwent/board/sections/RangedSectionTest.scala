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

    var array: ArrayBuffer[ICard] = new ArrayBuffer[ICard]()
    var arraywithcard: ArrayBuffer[ICard] = _
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
        assertEquals(array, firstRangedSection.sectionCardGroup)
    }
    test("A RangedSection must be created with a totalAttackPower"){
        assertEquals(atckpwr, firstRangedSection.totalAttackPower)
    }
    test("A Rangedcard can be added to the sectionCardGroup of a RangedSection"){
        assertEquals(firstRangedSection.sectionCardGroup,array)
        assertNotEquals(firstRangedSection.sectionCardGroup, arraywithcard)

        firstRangedSection.PlayinSection(rangedCard)

        assertNotEquals(firstRangedSection.sectionCardGroup,array)
        assertEquals(firstRangedSection.sectionCardGroup, arraywithcard)
    }

    test("A Close combat card wont be played in a RangedSection"){
        assertEquals(firstRangedSection.sectionCardGroup,array)
        firstRangedSection.PlayinSection(closeCombatCard)
        assertEquals(firstRangedSection.sectionCardGroup,array)
    }

    test("A Siege card wont be played in a RangedSection"){
        assertEquals(firstRangedSection.sectionCardGroup,array)
        firstRangedSection.PlayinSection(siegeCard)
        assertEquals(firstRangedSection.sectionCardGroup,array)
    }

    test("A weather type card wont be played in a RangedSection"){
        assertEquals(firstRangedSection.sectionCardGroup,array)
        firstRangedSection.PlayinSection(weatherCard)
        assertEquals(firstRangedSection.sectionCardGroup,array)
    }

    test("A ranged card can be removed from the sectionCardGroup of a RangedSection"){
        firstRangedSection.PlayinSection(rangedCard)
        assertEquals(firstRangedSection.sectionCardGroup,arraywithcard)

        firstRangedSection.RemoveCard(rangedCard)

        assertNotEquals(firstRangedSection.sectionCardGroup,arraywithcard)
        assertEquals(array, firstRangedSection.sectionCardGroup)
    }
    test("A RangedSection should be equal to another" +
        " of the same class with the same attributes and it should have the same hashcode"){
        var notEqualtoFirst: RangedSection = new RangedSection()
        notEqualtoFirst.PlayinSection(rangedCard)
        assertEquals(firstRangedSection, secondRangedSection)
        assertEquals(secondRangedSection, firstRangedSection)
        assertEquals(firstRangedSection.hashCode(), secondRangedSection.hashCode())
        assertNotEquals(firstRangedSection, notEqualtoFirst)
        assertNotEquals(notEqualtoFirst, firstRangedSection)
        assertNotEquals(firstRangedSection.hashCode(), notEqualtoFirst.hashCode())
    }
}
