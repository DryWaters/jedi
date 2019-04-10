package value

import expression.Literal

case class Boole(val value: Boolean) extends Literal {
  def &&(other: Boole) = if (this.value == false || other.value == false) Boole(false) else Boole(true)
  def ||(other: Boole) = if (this.value == true || other.value == true) Boole(true) else Boole(false)
  def unary_! = Boole(!value)
  override def toString = value.toString
}