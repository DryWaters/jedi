
package test

import value._

object NumberTest1 extends App {
  var i1 = Integer(7)
  var i2 = Integer(6)
  var i3 = Integer(7)

  assert((i1 * i2) == Integer(42))
  assert(!(i1 == i2))
  assert(i1 == i1)
  assert(!(i1 < i2))
  assert(i1 > i2)
  assert(i1.## == i3.##)
  assert(-i1 == Integer(-7))
  println("i1 * i2 = " + (i1 * i2))
  println("i1 == i2 = " + (i1 == i2))
  println("i1 < i2 = " + (i1 < i2))
  println("i1.## = " + i1.##)

  var r1 = Real(3.14)
  var r2 = Real(2.71)
  var r3 = Real(3.14)
  assert(-r1 == Real(-3.14))
  assert(r1 * r2 == Real(8.5094))
  assert(!(r1 < r2))
  assert(r1 > r2)
  assert(r1.## == r3.##)
  println("-r1 = " + -r1)
  println("r1 * r2 = " + (r1 * r2))
  println("r1 == r2 = " + (r1 == r2))
  println("r1 < r2 = " + (r1 < r2))
  println("r1.## = " + r1.##)

  assert((r1 * i2) == Real(18.84))
  assert((i1 * r2) == Real(18.97))
  println("r1 * i2 = " + (r1 * i2))
  println("i1 * r2 = " + (i1 * r2))

  try {
    println(i1 / Integer(0))
  } catch {
    case e: IllegalArgumentException => println("Can't divide by zero!")
    case _: Throwable                => assert(false, "Should not be here")
  }

  try {
    println(r1 / Real(0))
  } catch {
    case e: IllegalArgumentException => println("Can't divide by zero!")
    case _: Throwable                => assert(false, "Should not be here")
  }
}