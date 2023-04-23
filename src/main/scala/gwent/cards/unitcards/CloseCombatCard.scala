package cl.uchile.dcc
package gwent.cards.unitcards
import gwent.cards.unitcards.effects._


class CloseCombatCard(name: String, attackPower: Int) extends UnitCard(name, attackPower) {
  def this(name:String, attackPower: Int, specialAbility: SpecialAbility)={
    this(name,attackPower)
    _specialAbility = Some(specialAbility)
  }
  
  override def equals(obj: Any): Boolean = {
    if(obj.isInstanceOf[CloseCombatCard]){
      val other = obj.asInstanceOf[CloseCombatCard]
      (this eq other) ||
        (other.name == this.name &&
          other.cardType == this.cardType &&
          other.attackPower == this.attackPower &&
          other._specialAbility == this._specialAbility)
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
      result = prime * result + _specialAbility.##
      result
    }
}
