package expression

import value.Value
import context.Environment

trait Literal extends Expression with Value {
  override def execute(env: Environment):Value  = this
}