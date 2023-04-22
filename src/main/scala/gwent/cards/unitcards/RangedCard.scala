package cl.uchile.dcc
package gwent.cards.unitcards

class RangedCard (name: String, cardType: String = "Unit Card", attackPower: Int, specialAbility: SpecialAbility) extends UnitCard(name,cardType, attackPower, specialAbility){
  
  
  override def equals(obj: Any): Boolean = {
    if(obj.isInstanceOf[RangedCard]){
      val other = obj.asInstanceOf[RangedCard]
      (this eq other) ||
        (other.name == this.name &&
          other.cardType == this.cardType &&
          other.attackPower == this.attackPower &&
          other.specialAbility == this.specialAbility)
    }
    else{
      false
    }

    override hashCode():Int = {
      Object.hash(classOf[RangedCard],name, cardType, attackPower, specialAbility)
    }
}
