package expression

import expression._
import context._
import value._

case class Assignment(val vbl: Identifier, val update: Expression) extends SpecialForm {
  def execute(env: Environment) = {
    val newValue = update.execute(env)

    if (!env.contains(vbl)) throw new UndefinedException(vbl)
    if (!env(vbl).isInstanceOf[Variable]) throw new TypeException("Only able to update variables")

    env(vbl).asInstanceOf[Variable].change(newValue)

    Notification.DONE
  }
}