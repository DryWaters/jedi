package expression

import context._

case class FunCall(val operator: Identifier, val operands: List[Expression]) extends Expression {
  def execute(env: Environment) = {
    val args = operands.map(op => op.execute(env))
    alu.execute(operator, args)
  } 
}