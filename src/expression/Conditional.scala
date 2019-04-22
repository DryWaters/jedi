package expression

import context._
import value._

case class Conditional(val condition: Expression, consequent: Expression, alternative: Expression = null) extends SpecialForm {
  def execute(env: Environment): Value = {
    if (condition.execute(env).equals(Boole(true))) {
      consequent.execute(env)
    } else if(condition.execute(env).equals(Boole(false)) && alternative != null) {
      println(alternative)
      alternative.execute(env)
    } else {
      Notification.UNSPECIFIED
    }
  }
}