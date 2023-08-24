package cl.uchile.dcc
package gwent.cards.weathercards.weathertype


/**
 * Represents a weather type in the gwent game.
 * This trait defines the properties that all weather types have in common
 * such as their name and the method affectWeather.
 *
 */
trait IWeatherType {

    /**
     * The name of a weather type
     */
    val name: String

    /** Affects the weather in order to make a change in the game
     *
     * this method hasnt been added yet
     */
    def affectWeather(): Unit
}
