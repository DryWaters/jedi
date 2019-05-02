package expression

import expression._
import context._
import value._

case class Assignment(val vbl: Identifier, val update: Expression) extends SpecialForm {
  def execute(env: Environment) = {
    
    val newValue = update.execute(env)
    // if value exists somewhere in an environment, need to update it
    if(env.contains(vbl)) {
      env(vbl).asInstanceOf[Variable].change(newValue)
    } else {
      env(vbl) = newValue
    }
    Notification.DONE
  }
}