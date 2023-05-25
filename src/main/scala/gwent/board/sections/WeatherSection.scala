package cl.uchile.dcc
package gwent.board.sections

import gwent.cards.weathercards.{ClearWeatherCard, IWeatherCard}

import cl.uchile.dcc.gwent.cards.ICard

class WeatherSection extends IBoardSection {
    var weatherCard: ICard = new ClearWeatherCard

    /** Play a card in a siege section
     *
     * @param ICard the card that´s going to be played
     */
    override def PlayinSection(card: ICard): Unit = {
        card.PlayCardinSectionWeather(this)
    }

    /** Add a Card to the card section group
     *
     * @param card the unit card thats going to be added
     */
    override def AddCard(card: ICard): Unit = {
        weatherCard = card
    }

    /** Removes a currently Played Card
     *
     * @param card the card that´s going to be removed
     */
    override def RemoveCard(card: ICard): Unit = {
        weatherCard = new ClearWeatherCard
    }
}
