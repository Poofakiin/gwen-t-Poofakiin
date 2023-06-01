package cl.uchile.dcc
package gwent.board

import gwent.board.sections.{CloseCombatSection, RangedSection, SiegeSection, WeatherSection}
import gwent.cards.ICard
import gwent.cards.unitcards.{CloseCombatCard, RangedCard, SiegeCard}
import gwent.cards.unitcards.effects.{CloseBond, MoralBoost}
import gwent.cards.weathercards.{FogCard, RainCard}
import gwent.players.Player
import gwent.players.cardgroups.{Deck, Hand}
import gwent.board.HalfBoard

import munit.FunSuite
import scala.collection.mutable.ArrayBuffer

class HalfBoardTest extends FunSuite{
    /**
     * Let´s define 18 cards, 9 of them will be in the player´s hand
     * and the rest in player´s deck
     */
    val closebond: CloseBond = new CloseBond
    val moralboost: MoralBoost = new MoralBoost

    val forktail: CloseCombatCard = new CloseCombatCard("Fork Tail",5,closebond)
    val fiend: CloseCombatCard = new CloseCombatCard("Fiend",6)
    val ghoul: CloseCombatCard = new CloseCombatCard("Ghoul",1,moralboost)
    val griffin: CloseCombatCard = new CloseCombatCard("Griffin",5)
    val geraltOfRivia: CloseCombatCard = new CloseCombatCard("Geralt of Rivia",10,moralboost)

    val albrich: RangedCard = new RangedCard("Albrich",2,closebond)
    val cockatrice: RangedCard = new RangedCard("Cockatrice",2)
    val cynthia: RangedCard = new RangedCard("Cynthia",4,closebond)
    val milva: RangedCard = new RangedCard("Milva",10,moralboost)
    val olaf: RangedCard = new RangedCard("Olaf",12)

    val ballista: SiegeCard = new SiegeCard("Ballista",6,moralboost)
    val catapult: SiegeCard = new SiegeCard("Catapult",8,closebond)
    val icegiant: SiegeCard = new SiegeCard("Ice Giant", 5)
    val thaler: SiegeCard = new SiegeCard("Thaler",1)
    val trebuchet: SiegeCard = new SiegeCard("Trebuchet",6,closebond)

    val raincard: RainCard = new RainCard
    val fogcard: FogCard = new FogCard
    val fogcard2: FogCard = new FogCard

    var handArray1: ArrayBuffer[ICard] = _
    var handArray2: ArrayBuffer[ICard] = _

    var deckArray1: ArrayBuffer[ICard] = _
    var deckArray2:  ArrayBuffer[ICard] = _
    var emptyArray: ArrayBuffer[ICard]= ArrayBuffer()

    /**
     * Inicializamos las variables del constructor de Player
     */
    var firstname: String = "Eridin"
    var secondname: String = "Wild Hunt"
    var gems = 2

    var deck1: Deck = _
    var deck2: Deck = _
    var hand1: Hand = _
    var hand2: Hand = _

    var firstPlayer : Player = _
    var secondPlayer : Player = _
    var thirdPlayer : Player = _
    var halfBoardOne: HalfBoard = _
    var halfBoardTwo: HalfBoard = _

    var closeCombatSection: CloseCombatSection = _
    var rangedSection: RangedSection = _
    var siegeSection: SiegeSection = _
    var weatherSection: WeatherSection = _


    override def beforeEach(context: BeforeEach): Unit = {
        handArray1 = ArrayBuffer(forktail, fiend, ghoul, albrich,
            cockatrice, ballista, catapult, raincard, thaler)
        hand1 = new Hand(handArray1)

        handArray2 = ArrayBuffer(griffin,geraltOfRivia,cynthia,
            milva,olaf,icegiant,trebuchet,fogcard,fogcard2)
        hand2 = new Hand(handArray2)

        deckArray1 = ArrayBuffer(griffin,geraltOfRivia,cynthia,
            milva,olaf,icegiant,trebuchet,fogcard,fogcard2)
        deck1 = new Deck(deckArray1)

        deckArray2 = ArrayBuffer(forktail, fiend, ghoul, albrich,
            cockatrice, ballista, catapult, raincard, thaler)
        deck2 = new Deck(deckArray2)

        firstPlayer = new Player(firstname, gems, deck1, hand1)
        secondPlayer = new Player(secondname, gems, deck2, hand2)
        thirdPlayer = new Player(firstname, gems, deck1,hand1)

        halfBoardOne = HalfBoard(firstPlayer)
        halfBoardTwo =  HalfBoard(secondPlayer)

        closeCombatSection = new CloseCombatSection
        siegeSection = new SiegeSection
        rangedSection =  new RangedSection
        weatherSection = new WeatherSection
    }

    test("A Half board must be created with a Player"){
        assertEquals(halfBoardOne.player, firstPlayer)
    }
    test("A Half board must have a Close Combat Section"){
        assertEquals(halfBoardOne.closeCombatSection, closeCombatSection)
    }
    test("A Half board must have a Siege Section"){
        assertEquals(halfBoardOne.siegeSection, siegeSection)
    }
    test("A Half board must have a Ranged Section"){
        assertEquals(halfBoardOne.rangedSection, rangedSection)
    }

    test("A Half board must be capable of only playing a close combat card in its section if the player has it"){
        var fillcloseCombat: CloseCombatSection = new CloseCombatSection
        fillcloseCombat.PlayinSection(forktail)
        assertEquals(halfBoardOne.closeCombatSection, closeCombatSection)
        assertNotEquals(halfBoardOne.closeCombatSection, fillcloseCombat)

        halfBoardOne.playUnitCard(albrich, this.closeCombatSection)
        assertEquals(halfBoardOne.closeCombatSection, closeCombatSection)

        halfBoardOne.playUnitCard(ballista,this.closeCombatSection)
        assertEquals(halfBoardOne.closeCombatSection, closeCombatSection)

        halfBoardOne.playUnitCard(forktail,this.closeCombatSection)
        assertNotEquals(halfBoardOne.closeCombatSection, closeCombatSection)

    }

    test("A Half board must be capable of only playing a ranged card in its section if the player has it"){
        var fillranged: RangedSection = new RangedSection
        fillranged.PlayinSection(albrich)
        assertEquals(halfBoardOne.rangedSection,rangedSection)
        assertNotEquals(halfBoardOne.rangedSection,fillranged)

        halfBoardOne.playUnitCard(forktail, this.rangedSection)
        assertEquals(halfBoardOne.rangedSection,rangedSection)

        halfBoardOne.playUnitCard(ballista, this.rangedSection)
        assertEquals(halfBoardOne.rangedSection,rangedSection)

        halfBoardOne.playUnitCard(albrich,this.rangedSection)
        assertNotEquals(halfBoardOne.rangedSection,rangedSection)
    }
    test("A Half board must be capable of only playing a siege card in its section if the player has it"){
        var fillranged: SiegeSection = new SiegeSection
        fillranged.PlayinSection(ballista)
        assertEquals(halfBoardOne.siegeSection,siegeSection)
        assertNotEquals(halfBoardOne.siegeSection,fillranged)

        halfBoardOne.playUnitCard(forktail, this.siegeSection)
        assertEquals(halfBoardOne.siegeSection,siegeSection)

        halfBoardOne.playUnitCard(albrich, this.siegeSection)
        assertEquals(halfBoardOne.siegeSection,siegeSection)

        halfBoardOne.playUnitCard(ballista,this.siegeSection)
        assertNotEquals(halfBoardOne.siegeSection,siegeSection)
    }

    test(""){
        var fillranged: SiegeSection = new SiegeSection
        var fillcombat: SiegeSection = new SiegeSection
        var emptySiege: SiegeSection =  new SiegeSection

        halfBoardOne.playUnitCard(ballista, fillranged)
        fillcombat.PlayinSection(ballista)
        assertEquals(fillcombat, fillranged)
        assertNotEquals(emptySiege, fillcombat)
    }

    test("A HalfBoard should be equal to another Board with the"+
        "same attributes and it should have the same hashcode"){
        val sameAsHalfBoard1: HalfBoard = new HalfBoard(firstPlayer)
        assertEquals(halfBoardOne, sameAsHalfBoard1)
        assertEquals(sameAsHalfBoard1, halfBoardOne)
        assertEquals(halfBoardOne.hashCode(),sameAsHalfBoard1.hashCode())
        assertNotEquals(halfBoardOne, halfBoardTwo)
        assertNotEquals(halfBoardTwo, halfBoardOne)
        assertNotEquals(halfBoardOne.hashCode(),halfBoardTwo.hashCode())
    }

}
