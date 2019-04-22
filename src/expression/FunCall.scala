package expression

import context._

case class FunCall(val operator: Identifier, val operands: List[Expression]) extends Expression {
  def execute(env: Environment) = {
    // 1. val args = result of executing operands (eager execution)
    val args = operands.map(op => op.execute(env))
    // 2. alu.execute(operator, args)
    alu.execute(operator, args)
  } 
}