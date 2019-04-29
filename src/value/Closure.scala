package value

import context._
import expression._

case class Closure(val defEnv: Environment, val body: Expression, val parameters: List[Identifier]) extends Value {
  
}

object Closure {
  def apply(args: List[Value], body: Expression) {
    val tempEnv = new Environment()
    new Closure(tempEnv, body, args)
  }
}