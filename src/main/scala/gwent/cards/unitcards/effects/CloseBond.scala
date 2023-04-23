package cl.uchile.dcc
package gwent.cards.unitcards.effects

class CloseBond() extends ISpecialAbility{
  val name:String = "Close Bond"
  override def useAbility(): Unit = {
    
  }

  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[CloseBond]) {
      val other = obj.asInstanceOf[CloseBond]
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
    result = prime * result + classOf[CloseBond].##
    result = prime * result + name.##
    result
  }
}

