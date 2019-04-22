package expression

import context._
import value._

// e.g., def pi = 2.14 + 1
case class Declaration(val identifier: Identifier, val expression: Expression) extends SpecialForm {
  def execute(env: Environment): Value = {
    // 1. initVal = execute expression
    val initVal = expression.execute(env)

    // 2. update env
    env.put(identifier, initVal);
    Notification.OK
  }
}