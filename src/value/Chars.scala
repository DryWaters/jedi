package value

import expression.Literal

case class Chars(val value: String) extends Literal with Ordered[Chars] with Equals {
  def length = Integer(value.length)
  def +(other: Chars) = Chars(this.value + other.value)
  override def toString = value.toString
  def compare(other: Chars) = this.value.compare(other.value)
  override def canEqual(other: Any) = other.isInstanceOf[Chars]
  override def equals(other: Any) =
    other match {
      case other: Chars => this.canEqual(other) && (other.value == this.value)
      case _            => false
    }
  override def hashCode = this.toString.##
  def substring(start: Integer, end: Integer) = Chars(this.value.substring(start.value, end.value))
}