package cl.uchile.dcc
package gwent.board.sections

import gwent.cards.weathercards.{ClearWeatherCard, IWeatherCard}

import gwent.cards.ICard


/**
 * A class that represent a section where only weather cards can be played
 * 
 * A weather section has a weatherCard
 */
class WeatherSection extends IBoardSection[IWeatherCard] {

    /**
     * the weather card of the section
     */
    private var _weatherCard: IWeatherCard = ClearWeatherCard()

    /** Delivers the weather card of the section
     *
     * @return The weather card of the section
     */
    def getWeatherCard: IWeatherCard ={
        val clonedCard: IWeatherCard = _weatherCard
        clonedCard
    }


    /** Add a weather card to the section, when a weather card its added it replaces the previous one
     *
     * @param card the weather card thats going to be added
     */
    override def AddCard(card: IWeatherCard): Unit = {
        _weatherCard = card
    }

    /** Removes all currently played cards from card section
     *
     */
    override def ClearSection(): Unit = {
        this._weatherCard = new ClearWeatherCard()
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
                (other._weatherCard == this._weatherCard)
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
        result = prime * result + _weatherCard.##
        result
    }
}
