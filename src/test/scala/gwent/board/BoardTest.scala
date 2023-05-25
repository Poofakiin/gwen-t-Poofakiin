package cl.uchile.dcc
package gwent.board

import gwent.board.sections.{CloseCombatSection, RangedSection, SiegeSection, WeatherSection}
import gwent.cards.ICard
import gwent.cards.unitcards.{CloseCombatCard, RangedCard, SiegeCard}
import gwent.cards.unitcards.effects.{CloseBond, MoralBoost}
import gwent.cards.weathercards.{FogCard, RainCard}
import gwent.players.Player
import gwent.players.cardgroups.{Deck, Hand}

import munit.FunSuite

import scala.collection.mutable.ArrayBuffer

class BoardTest extends FunSuite{
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

    var firstBoard: Board =_
    var secondBoard: Board =_


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
        firstBoard = new Board(halfBoardOne,halfBoardTwo)
        secondBoard = new Board(halfBoardTwo, halfBoardOne)
    }

    test("A board must be created with weathersection"){
        assertEquals(firstBoard.weatherSection,weatherSection)
    }

    test("A board must be created with a player half board"){
        assertEquals(firstBoard.playerBoard,halfBoardOne)
    }

    test("A board must be created wit a enemy half board"){
        assertEquals(firstBoard.enemyBoard, halfBoardTwo)
    }

    test("A Board should be equal to another Board with the"+
        "same attributes and it should have the same hashcode"){
        val sameAsBoard1: Board = new Board(halfBoardOne,halfBoardTwo)
        assertEquals(firstBoard, sameAsBoard1)
        assertEquals(sameAsBoard1, firstBoard)
        assertEquals(firstBoard.hashCode(),sameAsBoard1.hashCode())
        assertNotEquals(firstBoard, secondBoard)
        assertNotEquals(secondBoard, firstBoard)
        assertNotEquals(secondBoard.hashCode(),firstBoard.hashCode())
    }
}
