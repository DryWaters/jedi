package expression

import context._

case class FunCall(val operator: Identifier, val operands: List[Expression]) extends Expression {
  def execute(env: Environment) = {
    // 1. val args = result of executing operands (eager execution)
    // 2. alu.execute(operator, args)
    null
  }
  
}