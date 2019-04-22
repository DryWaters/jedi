package expression
import context._

case class Conjuction(val operands: List[Expression]) extends SpecialForm {
  def execute(env: Environment) {
    
  }
  
}