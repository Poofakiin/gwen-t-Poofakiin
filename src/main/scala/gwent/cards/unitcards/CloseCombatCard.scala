package cl.uchile.dcc
package gwent.cards.unitcards
import gwent.cards.unitcards.effects._


class CloseCombatCard(name: String, attackPower: Int, specialAbility: Option[SpecialAbility] = None) extends UnitCard(name, attackPower, specialAbility) {

  def getSpecialAbility(): Unit ={
    this.cardType
  }
  override def equals(obj: Any): Boolean = {
    if(obj.isInstanceOf[CloseCombatCard]){
      val other = obj.asInstanceOf[CloseCombatCard]
      (this eq other) ||
        (other.name == this.name &&
          other.cardType == this.cardType &&
          other.attackPower == this.attackPower &&
          other.specialAbility == this.specialAbility)
    }
    else{
      false
    }
  }

    override def hashCode():Int = {
      val prime = 31
      var result= 1
      result = prime * result + classOf[CloseCombatCard].##
      result = prime * result + name.##
      result = prime * result + cardType.##
      result = prime * result + attackPower.##
      result = prime * result + specialAbility.##
      result
    }
}
