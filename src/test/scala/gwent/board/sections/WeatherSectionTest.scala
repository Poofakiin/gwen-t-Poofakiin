package cl.uchile.dcc
package gwent.board.sections

import gwent.cards.ICard
import gwent.cards.unitcards.{CloseCombatCard, RangedCard, SiegeCard}
import gwent.cards.unitcards.effects.{CloseBond, ISpecialAbility, MoralBoost}
import gwent.cards.weathercards.{ClearWeatherCard, FogCard, IWeatherCard}

import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

class WeatherSectionTest extends FunSuite{

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

    var fog: IWeatherCard = new FogCard
    var clearWeatherCard: IWeatherCard = _
    var firstWeatherSection: WeatherSection = _
    var secondWeatherSection: WeatherSection = _
    override def beforeEach(context: BeforeEach): Unit = {
        closeCombatCard = new CloseCombatCard(firstCardName,firstCardAttkPwr, closeBond)
        rangedCard = new RangedCard(secondCardName,secondCardAttkPwr, moralboost)
        siegeCard = new SiegeCard(firstCardName,firstCardAttkPwr)
        weatherCard = new FogCard

        firstWeatherSection = new WeatherSection()
        secondWeatherSection = new WeatherSection()

        clearWeatherCard = new ClearWeatherCard()

    }
    test("A WeatherSection must be created with a weatherCard, and it should start as a Clear Weather Card"){
        assertEquals(firstWeatherSection.getWeatherCard, clearWeatherCard)
    }

    test("A Weather Card can change the weather card of a WeatherSection"){
        assertEquals(firstWeatherSection.getWeatherCard,clearWeatherCard)
        assertNotEquals(firstWeatherSection.getWeatherCard, fog)

        firstWeatherSection.AddCard(weatherCard)

        assertNotEquals(firstWeatherSection.getWeatherCard,clearWeatherCard)
        assertEquals(firstWeatherSection.getWeatherCard, fog)
    }

    test("A Weather Section can be cleared, changing it weather card to a Clear Weather card"){
        assertEquals(firstWeatherSection.getWeatherCard,clearWeatherCard)
        firstWeatherSection.AddCard(fog)
        assertNotEquals(firstWeatherSection.getWeatherCard,clearWeatherCard)
        assertEquals(firstWeatherSection.getWeatherCard,fog)
        firstWeatherSection.ClearSection()
        assertNotEquals(firstWeatherSection.getWeatherCard,fog)
        assertEquals(firstWeatherSection.getWeatherCard,clearWeatherCard)
    }

    test("A weather card can be setted as the weather card of the section"){
        assertEquals(firstWeatherSection.getWeatherCard, clearWeatherCard)
        firstWeatherSection.setWeatherCard(weatherCard)
        assertNotEquals(firstWeatherSection.getWeatherCard, clearWeatherCard)
        assertEquals(firstWeatherSection.getWeatherCard, weatherCard)
    }
    
    test("A WeatherSection should be equal to another" +
        " of the same class with the same attributes and it should have the same hashcode"){
        var notEqualtoFirst: WeatherSection = new WeatherSection()
        notEqualtoFirst.AddCard(fog)
        assertEquals(firstWeatherSection, secondWeatherSection)
        assertEquals(secondWeatherSection, firstWeatherSection)
        assertEquals(firstWeatherSection.hashCode(), secondWeatherSection.hashCode())
        assertNotEquals(firstWeatherSection, notEqualtoFirst)
        assertNotEquals(notEqualtoFirst, firstWeatherSection)
        assertNotEquals(firstWeatherSection.hashCode(), notEqualtoFirst.hashCode())
    }

}
