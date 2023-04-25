package cl.uchile.dcc
package gwent.players.cardgroups
import gwent.cards.unitcards.effects._
import gwent.cards.unitcards._
import gwent.cards.weathercards.weathertype._
import gwent.cards.weathercards._
import gwent.cards.ICard
import munit.FunSuite
import scala.collection.mutable.ArrayBuffer


class HandTest {

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

    var emptyArray: ArrayBuffer[ICard]= ArrayBuffer()

}
