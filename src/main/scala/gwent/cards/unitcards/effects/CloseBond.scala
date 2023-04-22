package cl.uchile.dcc
package gwent.cards.unitcards.effects

class CloseBond(name:String ="Moral Boost") extends SpecialAbility(name){
  override def useAbility(): Unit = {
    ()
  }

  override def equals(obj: Any): Boolean = {
    if(obj.isInstanceOf[CloseBond]){
      val other = obj.asInstanceOf[CloseBond]
      (this eq other) ||
        (other.name == this.name)
    }
    else{
      false
    }

    override hashCode():Int = {
      Object.hash(classOf[CloseBond],name)
    }
}

