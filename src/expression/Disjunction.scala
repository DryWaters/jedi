package expression

import context._

case class Disjunction(val operands: List[Expression]) extends SpecialForm {
  def execute(env: Environment) {
    
  }
  
}