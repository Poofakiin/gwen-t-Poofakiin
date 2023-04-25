package cl.uchile.dcc
package gwent.players

import gwent.cards.unitcards.effects._
import gwent.cards.unitcards._
import gwent.cards.weathercards.weathertype._
import gwent.cards.weathercards._
import gwent.cards.ICard
import munit.FunSuite
import scala.collection.mutable.ArrayBuffer

class PlayerTest extends FunSuite {
    /**
     * Let´s define 18 cards, 9 of them will be in the player´s hand
     * and the rest in player´s deck
     */
    /*
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

    var firstPlayer : Player = _
    var secondPlayer : Player = _
    var thirdPlayer : Player = _

    override def beforeEach(context: BeforeEach): Unit = {
        handArray1 = ArrayBuffer(forktail, fiend, ghoul, albrich,
            cockatrice, ballista, catapult, raincard, thaler)
        handArray2 = ArrayBuffer(griffin,geraltOfRivia,cynthia,
            milva,olaf,icegiant,trebuchet,fogcard,fogcard2)

        deckArray1 = ArrayBuffer(griffin,geraltOfRivia,cynthia,
            milva,olaf,icegiant,trebuchet,fogcard,fogcard2)
        deckArray2 = ArrayBuffer(forktail, fiend, ghoul, albrich,
            cockatrice, ballista, catapult, raincard, thaler)

        firstPlayer = new Player(firstname, gems, deckArray1, handArray1)
        secondPlayer = new Player(secondname, gems, deckArray2, handArray2)
        thirdPlayer = new Player(firstname, gems, deckArray1,handArray1)
    }

    test("A Player should be created with a name") {
        assertEquals(firstPlayer.name, firstname)
    }

    test("A Player should be created with a gems counter") {
        assertEquals(firstPlayer.gemsCounter, gems)
    }

    test("A Player should be created with a deck") {
        assertEquals(firstPlayer.deck, deckArray1)
    }

    test("A Player should be created with a hand") {
        assertEquals(firstPlayer.hand, handArray1)
    }
    test("A PLayer can play a card if it is on his hand"){
        assert(firstPlayer.canPlayCard(forktail))
        firstPlayer.playCard(forktail)
        assert(!firstPlayer.canPlayCard(forktail))
    }
    test("A Player cant play a card if it isn´t on his hand"){
        assertEquals(firstPlayer.hand, handArray1)
        assert(!firstPlayer.canPlayCard(griffin))
        firstPlayer.playCard(griffin)
        assertEquals(firstPlayer.hand, handArray1)
    }
    test("A Player wont be able to play a card if his hand its empty"){
        firstPlayer.hand = emptyArray
        assertEquals(firstPlayer.hand, emptyArray)
        firstPlayer.playCard(forktail)
        assertEquals(firstPlayer.hand, emptyArray)
    }

    test("A Player can draw a card if his deck "+
        "isn´t empty and his hand has less than 10 cards"){
        val newArray = ArrayBuffer(griffin,geraltOfRivia,cynthia,
            milva,olaf,icegiant,trebuchet,fogcard,fogcard2)
        assert(firstPlayer.canDrawCard())
        assertEquals(firstPlayer.hand, handArray1)
        assertEquals(firstPlayer.deck, newArray)
        firstPlayer.drawCard()
        assertEquals(firstPlayer.hand, handArray1)
        assertNotEquals(firstPlayer.deck, newArray)
    }
    test("A Player can´t draw a card if its deck its empty"){
        firstPlayer.deck = emptyArray
        assertEquals(firstPlayer.deck, emptyArray)
        assert(!firstPlayer.canDrawCard())
    }
    test("If a Player drew a card with a hand with 10 cards"+
        "and a non empty deck, the deck will lose a card but its hand will remain the same size"){
        firstPlayer.drawCard()
        assertEquals(firstPlayer.hand.size,10)
        assertEquals(firstPlayer.deck.size, 8)
        firstPlayer.drawCard()
        assertEquals(firstPlayer.hand.size,10)
        assertEquals(firstPlayer.deck.size,7)
    }
    test("A Player can shuffle his deck"){
        var newArray: ArrayBuffer[ICard] = ArrayBuffer(griffin,geraltOfRivia,cynthia,
            milva,olaf,icegiant,trebuchet,fogcard,fogcard2)
        assertEquals(firstPlayer.deck,newArray)
        firstPlayer.shuffleDeck()
        assert(!firstPlayer.deck.corresponds(newArray)(_==_))
    }

    test("A Player should be equal to another Player with the"+
        "same attributes and it should have the same hashcode"){
        val sameAsPlayer1: Player = new Player(firstname,gems,deckArray1,handArray1)
        assertEquals(firstPlayer, sameAsPlayer1)
        assertEquals(sameAsPlayer1, firstPlayer)
        assertEquals(firstPlayer.hashCode(),sameAsPlayer1.hashCode())
        assertNotEquals(firstPlayer, secondPlayer)
        assertNotEquals(secondPlayer, firstPlayer)
        assertNotEquals(firstPlayer.hashCode(),secondPlayer.hashCode())
    }*/
}
