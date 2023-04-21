package cl.uchile.dcc
package gwent.cards.weathercards

/** A class that represents a weather type card in the Gwent game
 *
 *  Weather cards have a name and a type.
 *
 * @param name the name of the weather card.
 * @param cardType the type of the weather card.
 *
 */
abstract class WeatherCard(name:String,cardType = "Weather Card") extends Card(name,cardType) {
}
