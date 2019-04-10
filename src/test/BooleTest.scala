package test

import value._

object BooleTest extends App {
  val t = Boole(true)
  val f = Boole(false)
  
  assert(!t == Boole(false))
  assert(!f == Boole(true))
  println("!t = " + (!t))
  println("!f = " + (!f))
  
  assert((t && t) == Boole(true))
  assert((f && f) == Boole(false))
  assert((t && f) == Boole(false))
  assert((f && t) == Boole(false))
  println("t && t = " + (t && t))
  println("f && f = " + (f && f))
  println("t && f = " + (t && f))
  println("f && t = " + (f && t))
  
  assert((t || t) == Boole(true))
  assert((f || f) == Boole(false))
  assert((t || f) == Boole(true))
  assert((f || t) == Boole(true))
  println("t || t = " + (t || t))
  println("f || f = " + (f || f))
  println("t || f = " + (t || f))
  println("f || t = " + (f || t))
  
}