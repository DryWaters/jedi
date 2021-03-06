package value

import expression.Literal

case class Integer(val value: Int) extends Literal with Ordered[Integer] with Equals {
  def +(other: Integer) = Integer(this.value + other.value)
  def *(other: Integer) = Integer(this.value * other.value)
  def -(other: Integer) = Integer(this.value - other.value)
  def /(other: Integer) = if(other.value == 0) throw new IllegalArgumentException("Unable to divide by zero") else Integer(this.value / other.value)
  def unary_- = Integer(-this.value)
  override def toString = value.toString
  def compare(other: Integer) = if (this.value < other.value) -1 else if (other.value < this.value) 1 else 0
  override def canEqual(other: Any) = other.isInstanceOf[Integer]
  override def equals(other: Any) = 
    other match {
    case other: Integer => this.canEqual(other) && (other.value == this.value)
    case _ => false
  }
  override def hashCode = this.toString.##
}

object Integer {
  implicit def intToReal(n: Integer) = Real(n.value.toDouble)
}