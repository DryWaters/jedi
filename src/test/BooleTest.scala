package test

import value._

object BooleTest extends App {
  val t = Boole(true)
  val f = Boole(false)
  
  println("!t = " + (!t))
  println("!f = " + (!f))
    
  println("t && t = " + (t && t))
  println("f && f = " + (f && f))
  println("t && f = " + (t && f))
  println("f && t = " + (f && t))
  
  println("t || t = " + (t || t))
  println("f || f = " + (f || f))
  println("t || f = " + (t || f))
  println("f || t = " + (f || t))
  
}