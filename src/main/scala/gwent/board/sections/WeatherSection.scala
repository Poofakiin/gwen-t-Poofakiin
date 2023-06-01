package cl.uchile.dcc
package gwent.board.sections

import gwent.cards.weathercards.{ClearWeatherCard, IWeatherCard}

import gwent.cards.ICard

class WeatherSection extends IBoardSection[IWeatherCard] {
    var weatherCard: IWeatherCard = ClearWeatherCard()

    /** Add a Card to the card section group
     *
     * @param card the unit card thats going to be added
     */
    override def AddCard(card: IWeatherCard): Unit = {
        weatherCard = card
    }

    /** Removes a currently Played Card
     *
     * @param card the card that´s going to be removed
     */
    override def ClearSection(): Unit = {
        this.weatherCard = new ClearWeatherCard()
    }

    /** Checks if this WeatherSection is equal to another object.
     *
     * @param obj The object to compare to.
     * @return true if the object is a WeatherSection and has the same weathercard, false otherwise.
     */
    override def equals(obj: Any): Boolean = {
        if(obj.isInstanceOf[WeatherSection]){
            val other = obj.asInstanceOf[WeatherSection]
            (this eq other) ||
                (other.weatherCard == this.weatherCard)
        }
        else{
            false
        }
    }

    /** Returns the hash code of this WeatherSection.
     *
     * @return The hash code of this WeatherSection.
     */
    override def hashCode():Int = {
        val prime = 31
        var result= 1
        result = prime * result + classOf[WeatherSection].##
        result = prime * result + weatherCard.##
        result
    }
}
