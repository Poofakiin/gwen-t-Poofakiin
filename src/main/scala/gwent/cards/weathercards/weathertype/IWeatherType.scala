package cl.uchile.dcc
package gwent.cards.weathercards.weathertype

trait IWeatherType {
    val name: String
    def affectWeather(): Unit
}
