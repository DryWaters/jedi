package expression

import context._
import value._

// e.g., def pi = 2.14 + 1
case class Declaration(val identifier: Identifier, val expression: Expression) extends SpecialForm {
  def execute(env: Environment): Value = {
    // 1. initVal = execute expression
    // 2. update env
    Notification.DONE
    null
  }
}