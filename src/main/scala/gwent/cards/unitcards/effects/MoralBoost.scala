package cl.uchile.dcc
package gwent.cards.unitcards.effects

class MoralBoost(name:String ="Moral Boost") extends SpecialAbility(name){
  override def useAbility(): Unit = {
    ()
  }

  override def equals(obj: Any): Boolean = {
    if(obj.isInstanceOf[MoralBoost]){
      val other = obj.asInstanceOf[MoralBoost]
      (this eq other) || 
        (other.name == this.name)
    }
    else{
      false
    }

    override hashCode():Int = {
      Object.hash(classOf[MoralBoost],name)
    }
}
