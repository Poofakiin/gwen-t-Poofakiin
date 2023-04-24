package cl.uchile.dcc
package gwent.cards.weathercards.weathertype

class Fog extends IWeatherType{
    val name: String = "Fog"

    override def affectWeather(): Unit = {
        ()
    }

    override def equals(obj: Any): Boolean = {
        if (obj.isInstanceOf[Fog]) {
            val other = obj.asInstanceOf[Fog]
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
        result = prime * result + classOf[Fog].##
        result = prime * result + name.##
        result
    }

}
