package cl.uchile.dcc
package gwent.players

import cardgroups._
import gwent.cards.unitcards.effects._
import gwent.cards.unitcards._
import gwent.cards.weathercards.weathertype._
import gwent.cards.weathercards._
import gwent.cards.ICard
import gwent.board.HalfBoard
import munit.FunSuite
import scala.collection.mutable.ArrayBuffer


class PlayerTest extends FunSuite {
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

    var firstPlayerBoard: HalfBoard = _
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

        firstPlayerBoard = new HalfBoard(firstPlayer)
    }

    test("A Player should be created with a name") {
        assertEquals(firstPlayer.name, firstname)
    }

    test("A Player should be created with a gems counter") {
        assertEquals(firstPlayer.gemsCounter, gems)
    }

    test("A Player should be created with a deck") {
        assertEquals(firstPlayer.deck, deck1)
    }

    test("A Player should be created with a hand") {
        assertEquals(firstPlayer.hand, hand1)
    }

    test("A Player can draw a card if its hand is non full and its deck its non empty"){
        assert(!firstPlayer.hand.itsFull())
        assert(firstPlayer.deck.cardCollection.nonEmpty)
        assert(firstPlayer.canDrawCard())
    }

    test("A Player cant draw a card if its hand is full"){
        firstPlayer.drawCard()
        assert(firstPlayer.hand.itsFull())
        assert(!firstPlayer.canDrawCard())
    }

    test("A Player cant draw a card if its deck its empty"){
        firstPlayer.deck.cardCollection = emptyArray
        assert(!firstPlayer.deck.cardCollection.nonEmpty)
        assert(!firstPlayer.canDrawCard())
    }

    test("A Player can play a card if it is on his hand"){
        assert(firstPlayer.hand.hasCard(forktail))
        assertEquals(firstPlayer.hand.cardCollection.size, 9)
        firstPlayer.playCard(forktail,firstPlayerBoard)
        assert(!firstPlayer.hand.hasCard(forktail))
        assertEquals(firstPlayer.hand.cardCollection.size, 8)
    }
    test("A Player wont play a card if it cant be played"){
        assert(!firstPlayer.hand.hasCard(griffin))
        assertEquals(firstPlayer.hand.cardCollection.size, 9)
        firstPlayer.playCard(griffin,firstPlayerBoard)
        assert(!firstPlayer.hand.hasCard(griffin))
        assertEquals(firstPlayer.hand.cardCollection.size, 9)
    }

    test("A Player wont be able to play a card if his hand its empty"){
        firstPlayer.hand.cardCollection = emptyArray
        assertEquals(firstPlayer.hand.cardCollection, emptyArray)
        firstPlayer.playCard(forktail,firstPlayerBoard)
        assertEquals(firstPlayer.hand.cardCollection, emptyArray)
    }

    test("if a player can draw a card, when it draw it, his hand"+
        "will gain a card and his deck will lose one"){
        assert(secondPlayer.canDrawCard())
        assertEquals(secondPlayer.hand.cardCollection.size, 9)
        assertEquals(secondPlayer.deck.cardCollection.size, 9)
        secondPlayer.drawCard()
        assertEquals(secondPlayer.hand.cardCollection.size, 10)
        assertEquals(secondPlayer.deck.cardCollection.size, 8)
    }

    test("if a player cant draw a card but his deck isnt empty,"+
        "the deck will lose a card but its hand will remain the same size"){
        secondPlayer.drawCard()
        assert(!secondPlayer.canDrawCard())
        assert(!secondPlayer.deck.cardCollection.isEmpty)
        assertEquals(secondPlayer.hand.cardCollection.size, 10)
        assertEquals(secondPlayer.deck.cardCollection.size, 8)
        secondPlayer.drawCard()
        assertEquals(secondPlayer.hand.cardCollection.size, 10)
        assertEquals(secondPlayer.deck.cardCollection.size, 7)
    }

    test("if a player cant draw a card and has an empty deck"+
        "the deck and the hand will remain the same size"){
        secondPlayer.deck.cardCollection = emptyArray
        assert(!secondPlayer.canDrawCard())
        assert(secondPlayer.deck.cardCollection.isEmpty)
        assertEquals(secondPlayer.hand.cardCollection.size, 9)
        assertEquals(secondPlayer.deck.cardCollection.size, 0)
        secondPlayer.drawCard()
        assertEquals(secondPlayer.hand.cardCollection.size, 9)
        assertEquals(secondPlayer.deck.cardCollection.size, 0)
    }


    test("A Player should be equal to another Player with the"+
        "same attributes and it should have the same hashcode"){
        val sameAsPlayer1: Player = new Player(firstname,gems,deck1,hand1)
        assertEquals(firstPlayer, sameAsPlayer1)
        assertEquals(sameAsPlayer1, firstPlayer)
        assertEquals(firstPlayer.hashCode(),sameAsPlayer1.hashCode())
        assertNotEquals(firstPlayer, secondPlayer)
        assertNotEquals(secondPlayer, firstPlayer)
        assertNotEquals(firstPlayer.hashCode(),secondPlayer.hashCode())
    }
}
