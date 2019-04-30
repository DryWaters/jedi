package value

import context._
import expression._

case class Closure(val defEnv: Environment, val body: Expression, val parameters: List[Identifier]) extends Value {
  def apply(args: List[Value]) = {
    val tempEnv = new Environment(defEnv)
    tempEnv.bulkPut(parameters, args)
    body.execute(tempEnv)
  }
}