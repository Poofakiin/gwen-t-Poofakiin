package cl.uchile.dcc
package gwent.cards.unitcards
import gwent.cards.unitcards.effects._
import gwent.cards.unitcards.AbstractUnitCard


class SiegeCard (name: String, attackPower: Int) extends AbstractUnitCard(name, attackPower){
  def this(name:String, attackPower: Int, specialAbility: ISpecialAbility)={
    this(name,attackPower)
    _specialAbility = Some(specialAbility)
  }

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[SiegeCard]) {
      val other = obj.asInstanceOf[SiegeCard]
      (this eq other) ||
        (other.name == this.name &&
          other.cardType == this.cardType &&
          other.attackPower == this.attackPower &&
          other._specialAbility == this._specialAbility)
    }
    else {
      false
    }
  }
  override def hashCode():Int = {
    val prime = 31
    var result= 1
    result = prime * result + classOf[SiegeCard].##
    result = prime * result + name.##
    result = prime * result + cardType.##
    result = prime * result + attackPower.##
    result = prime * result + _specialAbility.##
    result
  }
}
