package value

import expression.Literal

case class Boole(val value: Boolean) extends Literal with Equals {
  def &&(other: Boole) = if (this.value == false || other.value == false) Boole(false) else Boole(true)
  def ||(other: Boole) = if (this.value == true || other.value == true) Boole(true) else Boole(false)
  def unary_! = Boole(!value)
  override def toString = value.toString
  override def canEqual(other: Any) = other.isInstanceOf[Boole]
  override def equals(other: Any) =
    other match {
      case other: Boole => this.canEqual(other) && (other.value == this.value)
      case _            => false
    }
  override def hashCode = this.toString.##
}