package cl.uchile.dcc
package gwent.players.cardgroups
import gwent.cards.unitcards.effects._
import gwent.cards.unitcards._
import gwent.cards.weathercards.weathertype._
import gwent.cards.weathercards._
import gwent.cards.ICard
import munit.FunSuite
import scala.collection.mutable.ArrayBuffer


class HandTest extends FunSuite{

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

    var hand1: Hand = _
    var hand2: Hand = _
    var hand3: Hand = _
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
        hand1 = Hand(array1)
        hand2 = Hand(array2)
        hand3 = Hand(array3)
    }
    test("A Hand should be created with a card collection array"){
        assertEquals(hand1.cardCollection(), array1)
    }
    test("A Hand should have a limit card, and it should be 10"){
        assertEquals(hand1.limitCards(), 10)
    }

    test("If a Hand is Empty, then its card collection size should be 0"){
        var emptyHand: Hand = new Hand(emptyArray)
        assert(emptyHand.cardCollection().isEmpty)
        assertEquals(emptyHand.cardCollection().size,0)
    }
    test("If a Hand is full, the its card collection shouls be the same as its limit card"){
        hand1.addCard(geraltOfRivia)
        assert(hand1.itsFull())
        assertEquals(hand1.cardCollection().size,hand1.limitCards())
    }
    test("A Card can be added to a hand that isn´t full"){
        assert(!hand1.itsFull())
        assert(!hand1.hasCard(geraltOfRivia))
        hand1.addCard(geraltOfRivia)
        assert(hand1.hasCard(geraltOfRivia))
    }

    test("A card wont be added if the card collection size its equal to the limit card"){
        var arrayFull: ArrayBuffer[ICard] = ArrayBuffer(forktail, fiend, ghoul, albrich,
            cockatrice, ballista, catapult, raincard, thaler, geraltOfRivia)
        hand1.addCard(geraltOfRivia)
        assertEquals(hand1.cardCollection(), arrayFull)
        assert(hand1.cardCollection().size == 10)
        hand1.addCard(icegiant)
        assertEquals(hand1.cardCollection(), arrayFull)
        assert(hand1.cardCollection().size == 10)
    }

    test("A Hand should have a card if it is in its card collection"){
        assertEquals(hand2.cardCollection()(0),griffin)
        assert(hand2.hasCard(griffin))
    }

    test("A Hand should not have a card if it isn´t in its card collection"){
        assert(!hand1.cardCollection()(0).equals(griffin))
        assert(!hand1.hasCard(griffin))
    }
    test("A Hand can take a card out of it if it isn´t empty"){
        assert(!hand1.cardCollection().isEmpty)
        assertEquals(hand1.cardCollection().size,9)
        hand1.takeCard(forktail)
        assertNotEquals(hand1.cardCollection().size,9)
    }

    test("A Deck card collection size wont change if its empty and tries to take out a card"){
        var emptyHand: Hand = new Hand(emptyArray)
        assertEquals(emptyHand.cardCollection().size,0)
        assert(emptyHand.cardCollection().isEmpty)
        emptyHand.takeCard(geraltOfRivia)
        assertEquals(emptyHand.cardCollection().size,0)
        assert(emptyHand.cardCollection().isEmpty)
    }

    test("A Hand with the same card collection size as its limit cards should be Full"){
        hand1.addCard(geraltOfRivia)
        assertEquals(hand1.cardCollection().size,hand1.limitCards())
        assert(hand1.itsFull())
    }

    test("A Hand should be equal to another Hand with the"+
        "same attributes and it should have the same hashcode"){
        val sameAsHand1: Hand = new Hand(array1)
        assertEquals(hand1, sameAsHand1)
        assertEquals(sameAsHand1, hand1)
        assertEquals(hand1.hashCode(),sameAsHand1.hashCode())
        assertNotEquals(hand1, hand2)
        assertNotEquals(hand2, hand1)
        assertNotEquals(hand1.hashCode(),hand2.hashCode())
    }

}
