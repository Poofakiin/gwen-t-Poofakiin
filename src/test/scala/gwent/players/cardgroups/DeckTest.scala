package cl.uchile.dcc
package gwent.players.cardgroups
import gwent.cards.unitcards.effects._
import gwent.cards.unitcards._
import gwent.cards.weathercards.weathertype._
import gwent.cards.weathercards._
import gwent.cards.ICard
import munit.FunSuite
import scala.collection.mutable.ArrayBuffer


class DeckTest extends FunSuite {

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

    var deck1: Deck = _
    var deck2: Deck = _
    var deck3: Deck = _
    var array1: ArrayBuffer[ICard] = _
    var array2: ArrayBuffer[ICard] = _
    var array3: ArrayBuffer[ICard] = _
    var emptyArray: ArrayBuffer[ICard]= ArrayBuffer()

    override def beforeEach(context: BeforeEach): Unit = {
        array1 = ArrayBuffer(forktail, fiend, ghoul, albrich,
            cockatrice, ballista, catapult, raincard, thaler)
        array2 = ArrayBuffer(griffin,geraltOfRivia,cynthia,
            milva,olaf,icegiant,trebuchet,fogcard,fogcard2)
        array3 = ArrayBuffer(griffin,geraltOfRivia,cynthia,
            milva,olaf,icegiant,trebuchet,fogcard,fogcard2, forktail) 
        deck1 = Deck(array1)
        deck2 = Deck(array2)
        deck3 = Deck(array3)
    }
    test("A Deck should be created with a card collection array"){
        assertEquals(deck1.cardCollection(), array1)
    }
    test("A Deck should have a limit card, and it should be 10"){
        assertEquals(deck1.limitCards(), 10)
    }
    
    test("If a Deck is Empty, then its card collection size should be 0"){
        var emptyDeck: Deck = new Deck(emptyArray)
        assert(emptyDeck.cardCollection().isEmpty)
        assertEquals(emptyDeck.cardCollection().size,0)
    }
    test("If a Deck is full, the its card collection shouls be the same as its limit card"){
        deck1.addCard(geraltOfRivia)
        assert(deck1.itsFull())
        assertEquals(deck1.cardCollection().size,deck1.limitCards())
    }
    test("A Card can be added to a deck that isn´t full"){
        assert(!deck1.itsFull())
        assert(!deck1.hasCard(geraltOfRivia))
        deck1.addCard(geraltOfRivia)
        assert(deck1.hasCard(geraltOfRivia))
    }
    
    test("A card wont be added if the card collection size its equal to the limit card"){
        var arrayFull: ArrayBuffer[ICard] = ArrayBuffer(forktail, fiend, ghoul, albrich,
            cockatrice, ballista, catapult, raincard, thaler, geraltOfRivia)
        deck1.addCard(geraltOfRivia)
        assertEquals(deck1.cardCollection(), arrayFull)
        assert(deck1.cardCollection().size == 10)
        deck1.addCard(icegiant)
        assertEquals(deck1.cardCollection(), arrayFull)
        assert(deck1.cardCollection().size == 10)
    }
    
    test("A Deck should have a card if it is in its card collection"){
        assertEquals(deck2.cardCollection()(0),griffin)
        assert(deck2.hasCard(griffin))
    }
    
    test("A Deck should not have a card if it isn´t in its card collection"){
        assert(!deck1.cardCollection()(0).equals(griffin))
        assert(!deck1.hasCard(griffin))
    }
    test("A Deck can take a card out of it if it isn´t empty"){
        assert(!deck1.cardCollection().isEmpty)
        assertEquals(deck1.cardCollection().size,9)
        deck1.takeCard(forktail)
        assertNotEquals(deck1.cardCollection().size,9)
    }
    
    test("A Deck card collection size wont change if its empty and tries to take out a card"){
        var emptyDeck: Deck = new Deck(emptyArray)
        assertEquals(emptyDeck.cardCollection().size,0)
        assert(emptyDeck.cardCollection().isEmpty)
        emptyDeck.takeCard(geraltOfRivia)
        assertEquals(emptyDeck.cardCollection().size,0)
        assert(emptyDeck.cardCollection().isEmpty)
    }
    
    test("A Deck with the same card collection size as its limit cards should be Full"){
        deck1.addCard(geraltOfRivia)
        assertEquals(deck1.cardCollection().size,deck1.limitCards())
        assert(deck1.itsFull())
    }

    test("A Deck can be shuffled"){
        var newArray: ArrayBuffer[ICard] = ArrayBuffer(griffin,geraltOfRivia,cynthia,
            milva,olaf,icegiant,trebuchet,fogcard,fogcard2)
        assertEquals(deck2.cardCollection(),newArray)
        deck2.shuffleDeck()
        assert(!deck2.cardCollection().corresponds(newArray)(_==_))
    }
    test("A Deck should be equal to another Deck with the"+
        "same attributes and it should have the same hashcode"){
        val sameAsDeck1: Deck = new Deck(array1)
        assertEquals(deck1, sameAsDeck1)
        assertEquals(sameAsDeck1, deck1)
        assertEquals(deck1.hashCode(),sameAsDeck1.hashCode())
        assertNotEquals(deck1, deck2)
        assertNotEquals(deck2, deck1)
        assertNotEquals(deck1.hashCode(),deck2.hashCode())
    }

}
