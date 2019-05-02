package expression
import context._
import value._

case class Iteration(val condition: Expression, val body: Expression) extends SpecialForm {
  def execute(env: Environment) = {
    while(condition.execute(env) == Boole(true)) {
      body.execute(env)  
    }
    Notification.DONE
  }
}