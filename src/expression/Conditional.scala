package expression

import context._
import value._

case class Conditional(val condition: Expression, consequent: Expression, alternative: Expression = Boole(true)) extends SpecialForm {
  def execute(env: Environment): Value = {
    if (condition.execute(env).equals(Boole(true))) {
      consequent.execute(env)
    } else {
      alternative.execute(env)
    }
    Notification.OK
  }
}