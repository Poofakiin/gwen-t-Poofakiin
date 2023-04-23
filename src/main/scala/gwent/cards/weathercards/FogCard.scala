package cl.uchile.dcc
package gwent.cards.weathercards

import weathertype.Fog
import weathertype.IWeatherType

class FogCard extends AbstractWeatherCard() {
  val name = "Rain Card"
  val weatherType: IWeatherType = new Fog()

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[FogCard]) {
      val other = obj.asInstanceOf[FogCard]
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
    result = prime * result + classOf[FogCard].##
    result = prime * result + name.##
    result = prime * result + cardType.##
    result = prime * result + weatherType.##
    result
  }
}
