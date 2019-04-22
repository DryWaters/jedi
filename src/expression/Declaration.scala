package expression

import context._
import value._

case class Declaration(val identifier: Identifier, val expression: Expression) extends SpecialForm {
  def execute(env: Environment): Value = {
    val initVal = expression.execute(env)
    env.put(identifier, initVal);
    Notification.OK
  }
}