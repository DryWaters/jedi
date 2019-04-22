package expression

import context._
import value._

case class Disjunction(val operands: List[Expression]) extends SpecialForm {
  def execute(env: Environment) = {
    def helper(value: Boole, unseen: List[Expression]): Boole = {
      if (unseen == Nil || value.value == true) value
      else helper(value || checkValue(unseen.head, env), unseen.tail)
    }
    helper(checkValue(operands(0), env), operands.tail)
  }

  def checkValue(operand: Expression, env: Environment) = {
    val val1 = operand.execute(env)
    if (!val1.isInstanceOf[Boole]) throw new TypeException("disjunction must be Boole-valued")
    val1.asInstanceOf[Boole]
  }
  
}
