package expression

import context._

case class Lambda(val parameters: List[Identifier], val body: Expression) extends SpecialForm {
  def execute(env: Environment) {
    
  }
  
}