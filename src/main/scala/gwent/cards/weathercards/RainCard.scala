package cl.uchile.dcc
package gwent.cards.weathercards

import weathertype.Rain
import weathertype.IWeatherType


class RainCard() extends AbstractWeatherCard() {
    val name = "Rain Card"
    val weatherType = new Rain()

    override def equals(obj: Any): Boolean = {
        if (obj.isInstanceOf[RainCard]) {
            val other = obj.asInstanceOf[RainCard]
            (this eq other) ||
                (other.name == this.name &&
                    other.cardType == this.cardType &&
                    other.weatherType == this.weatherType)
        }
        else {
            false
        }
    }
    override def hashCode():Int = {
        val prime = 31
        var result= 1
        result = prime * result + classOf[RainCard].##
        result = prime * result + name.##
        result = prime * result + cardType.##
        result = prime * result + weatherType.##
        result
    }
}
