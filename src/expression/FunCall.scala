package expression

import context._
import value._

case class FunCall(val operator: Identifier, val operands: List[Expression]) extends Expression {
  def execute(env: Environment) = {
    val args = operands.map(op => op.execute(env))
    if (env.contains(operator) && env(operator).isInstanceOf[Closure]) {
      val closure = env(operator).asInstanceOf[Closure]
      closure(args)
    } else {
      alu.execute(operator, args)
    }
  }
}