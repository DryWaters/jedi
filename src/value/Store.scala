package value

import collection.mutable._
import context._

class Store(private var elems: ArrayBuffer[Value] = ArrayBuffer[Value]()) extends Value {
  // adds e to the end of store
  def add(e: Value) { elems += e }

  // inserts e at position pos in this
  def put(e: Value, pos: Integer) { elems.insert(pos.value, e) }

  // removes element at position pos from this
  def rem(pos: Integer) { elems.remove(pos.value) }

  // returns element at position pos in this
  def get(pos: Integer): Value = elems(pos.value)

  // returns true ie this contains e
  def contains(e: Value): Boole = Boole(elems.contains(e))

  // returns the size of this
  def size: Integer = Integer(elems.length)

  // returns "{e0 e1 e2 ...}"
  override def toString = "{" + elems.mkString(" ") + "}"

  // returns store containing the elements of this transformed by trans
  def map(trans: Closure): Store = {
    if (elems.length == 0) return this

    new Store(elems.map(elem => trans(elem :: Nil)))
  }

  // returns store containing the elements of this that passed test
  def filter(test: Closure): Store = {

    // if trying to filter an empty Store just return Store
    if (elems.length == 0) return this

    // if trying to filter with a Closure that does not return a Boole, throw error
    if (!test(elems(0) :: Nil).isInstanceOf[Boole])
      throw new TypeException("filter expects a closure that returns Boole")

    new Store(elems.filter(elem => test(elem :: Nil).asInstanceOf[Boole].value))
  }
}