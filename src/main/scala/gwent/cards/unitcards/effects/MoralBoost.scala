package cl.uchile.dcc
package gwent.cards.unitcards.effects

class MoralBoost(name:String ="Moral Boost") extends SpecialAbility(name){
  override def useAbility(): Unit = {
    ()
  }

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[MoralBoost]) {
      val other = obj.asInstanceOf[MoralBoost]
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
    result = prime * result + classOf[MoralBoost].##
    result = prime * result + name.##
    result
  }
}
