package cl.uchile.dcc
package gwent.cards.weathercards

class RainCard(name: String, cardType = "Weather Card") extends WeatherCard(name,cardType) {
  override def equals(obj: Any): Boolean = {
    if(obj.isInstanceOf[RainCard]){
      val other = obj.asInstanceOf[RainCard]
      (this eq other) ||
        (other.name == this.name &&
          other.cardType == this.cardType)
    }
    else{
      false
    }

    override hashCode():Int = {
      Object.hash(classOf[RainCard],name, cardType)
    }
}
