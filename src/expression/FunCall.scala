package expression

import context._
import value._

case class FunCall(val operator: Identifier, val operands: List[Expression]) extends Expression {
  def execute(env: Environment) = {

    val args = operands.map(op => op.execute(env))
    println(operator)

    alu.execute(operator, args)

  }
}