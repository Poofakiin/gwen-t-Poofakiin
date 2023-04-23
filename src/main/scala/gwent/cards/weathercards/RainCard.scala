package cl.uchile.dcc
package gwent.cards.weathercards

class RainCard(name: String, cardType: String = "Weather Card") extends AbstractWeatherCard(name,cardType) {
  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[RainCard]) {
      val other = obj.asInstanceOf[RainCard]
      (this eq other) ||
        (other.name == this.name &&
          other.cardType == this.cardType)
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
    result
  }
}
