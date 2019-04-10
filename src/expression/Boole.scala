package expression

case class Boole(val value: Boolean) extends Literal with Ordered[Boole] with Equals {
  def &&(other: Boole) = if (this.value == false) Boole(false) else Boole(true)
  def ||(other: Boole) = if (this.value == true) Boole(true) else Boole(false)
  def unary_! = if (this.value == true) Boole(false) else Boole(true)

}