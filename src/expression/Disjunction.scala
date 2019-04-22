package expression

import context._
import value._

case class Disjunction(val operands: List[Expression]) extends SpecialForm {
  def execute(env: Environment) = {
    def helper(value: Boole, unseen: List[Expression]): Boole = {
      if (unseen == Nil || value.value == true) value
      else helper(value || unseen.head.execute(env).asInstanceOf[Boole], unseen.tail)
    }
    helper(operands(0).asInstanceOf[Boole], operands.tail)
  }
  
}