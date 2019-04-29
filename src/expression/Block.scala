package expression

import context._

case class Block(val expressions: List[Expression]) extends SpecialForm {
  def execute(env: Environment) = {
    val tempEnv = new Environment(env)
    val execExps = expressions.map(exp => exp.execute(tempEnv))
    execExps.last
  }
}