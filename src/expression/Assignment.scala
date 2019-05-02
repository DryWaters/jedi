package expression

import expression._
import context._
import value._

case class Assignment(vbl: Identifier, update: Expression) extends SpecialForm {

  def execute(env: Environment) = {
    val newValue = Variable(update.execute(env))
    env.put(vbl, newValue);
    Notification.DONE
  }
}