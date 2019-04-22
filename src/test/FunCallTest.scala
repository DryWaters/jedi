package test

import expression._
import context._
import value._


object FunCallTest extends App {
  val globalEnvironment = new Environment
  val operands = List(Integer(6), Integer(7))
  var exp = FunCall(Identifier("add"), operands)
  println(exp.execute(globalEnvironment))
  exp = FunCall(Identifier("less"), operands)
  println(exp.execute(globalEnvironment))
  exp = FunCall(Identifier("mul"), operands)
  println(exp.execute(globalEnvironment))
  
  val op1 = List(Chars("Hi "), Chars("there"))
  exp = FunCall(Identifier("add"), op1)
  println(exp.execute(globalEnvironment))
  
  val op2 = List(Boole(true), Integer(7))
  exp = FunCall(Identifier("equals"), op2)
  println(exp.execute(globalEnvironment))
  
  val op3 = List(Boole(false))
  exp = FunCall(Identifier("not"), op3)
  println(exp.execute(globalEnvironment))
  
  val op4 = List(Integer(6), Integer(10), Integer(20))
  exp = FunCall(Identifier("add"), op4)
  println(exp.execute(globalEnvironment))
}