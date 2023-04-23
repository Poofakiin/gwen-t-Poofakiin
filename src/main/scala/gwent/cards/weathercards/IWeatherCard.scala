package cl.uchile.dcc
package gwent.cards.weathercards

import gwent.cards.ICard
import weathertype.IWeatherType

trait IWeatherCard extends ICard{
  val name:String
  val cardType: String
  val weatherType: IWeatherType
  def getWeatherType(): IWeatherType
  def useWeatherType(): Unit
}
