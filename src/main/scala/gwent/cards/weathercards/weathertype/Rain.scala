package cl.uchile.dcc
package gwent.cards.weathercards.weathertype

class Rain extends IWeatherType{
  val name:String = "Rain"

  override def affectWeather(): Unit = {
    ()
  }

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[Rain]) {
      val other = obj.asInstanceOf[Rain]
      (this eq other) ||
        (other.name == this.name)
    }
    else {
      false
    }
  }
  override def hashCode():Int = {
    val prime = 31
    var result= 1
    result = prime * result + classOf[Rain].##
    result = prime * result + name.##
    result
  }
  

}
