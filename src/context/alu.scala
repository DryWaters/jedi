package context

import expression._
import value._

/*
 * Notes:
 * alu implements all low-level arithmetic, logic, and I/O functions
 * alu does lots of type checking
 * alu is a singleton
 */
object alu {
  // dispatcher
  def execute(opcode: Identifier, args: List[Value]): Value = {
    opcode.name match {
      case "add"      => add(args)
      case "mul"      => mul(args)
      case "sub"      => sub(args)
      case "div"      => div(args)
      case "less"     => less(args) //binary
      case "more"     => more(args) // binary
      case "equals"   => equals(args) // note: equals(7, true) = false, not error
      case "unequals" => unequals(args) // binary, = not(equals(args))?
      case "not"      => not(args) // unary
      // primitive I/O ops:
      case "write"    => write(args)
      case "prompt"   => prompt(args)
      case "read"     => read(args)
      case _          => throw new UndefinedException(opcode)
    }
  }

  private def toInt(arg: Value): Option[Integer] =
    if (arg.isInstanceOf[Integer]) Some(arg.asInstanceOf[Integer]) else None

  private def toReal(arg: Value): Option[Real] =
    if (arg.isInstanceOf[Real]) Some(arg.asInstanceOf[Real])
    else if (arg.isInstanceOf[Integer]) Some(Integer.intToReal(arg.asInstanceOf[Integer]))
    else None

  private def toChars(arg: Value): Option[Chars] =
    if (arg.isInstanceOf[Chars]) Some(arg.asInstanceOf[Chars]) else None

  private def toBool(arg: Value): Option[Boole] =
    if (arg.isInstanceOf[Boole]) Some(arg.asInstanceOf[Boole]) else None

  def add(args: List[Value]) = {
    val args2 = args.map(toInt).filter(_ != None)
    if (args2.size == args.size) args2.flatten.reduce(_ + _)
    else {
      val args3 = args.map(toReal).filter(_ != None)
      if (args3.size == args.size) args3.flatten.reduce(_ + _)
      else {
        val args4 = args.map(toChars).filter(_ != None)
        if (args4.size == args.size) args4.flatten.reduce(_ + _)
        else {
          throw new TypeException("Inputs to + must be numbers or texts")
        }
      }
    }
  }

  def mul(args: List[Value]) = {
    val args2 = args.map(toInt).filter(_ != None)
    if (args2.size == args.size) args2.flatten.reduce(_ * _)
    else {
      val args3 = args.map(toReal).filter(_ != None)
      if (args3.size == args.size) args3.flatten.reduce(_ * _)
      else {
        throw new TypeException("Inputs to * must be numbers")
      }
    }
  }

  def sub(args: List[Value]) = {
    val args2 = args.map(toInt).filter(_ != None)
    if (args2.size == args.size) args2.flatten.reduce(_ - _)
    else {
      val args3 = args.map(toReal).filter(_ != None)
      if (args3.size == args.size) args3.flatten.reduce(_ - _)
      else {
        throw new TypeException("Inputs to - must be numbers")
      }
    }
  }

  def div(args: List[Value]) = {
    val args2 = args.map(toInt).filter(_ != None)
    if (args2.size == args.size) args2.flatten.reduce(_ / _)
    else {
      val args3 = args.map(toReal).filter(_ != None)
      if (args3.size == args.size) args3.flatten.reduce(_ / _)
      else {
        throw new TypeException("Inputs to / must be numbers")
      }
    }
  }

  def less(args: List[Value]): Value = {
    if (args.length != 2) throw new TypeException("less expects two inputs")
    val args2 = args.map(toInt).filter(_ != None)
    if (args2.size == args.size) Boole(args2(0).get.value < args2(1).get.value)
    else {
      val args3 = args.map(toReal).filter(_ != None)
      if (args3.size == args.size) Boole(args3(0).get.value < args3(1).get.value)
      else {
        val args4 = args.map(toChars).filter(_ != None)
        if (args4.size == args.size) Boole(args4(0).get.value < args4(1).get.value)
        else throw new TypeException("Inputs to < must be numbers or texts")
      }
    }
  }

  def more(args: List[Value]): Value = {
    if (args.length != 2) throw new TypeException("more expects two inputs")
    val args2 = args.map(toInt).filter(_ != None)
    if (args2.size == args.size) Boole(args2(0).get.value > args2(1).get.value)
    else {
      val args3 = args.map(toReal).filter(_ != None)
      if (args3.size == args.size) Boole(args3(0).get.value > args3(1).get.value)
      else {
        val args4 = args.map(toChars).filter(_ != None)
        if (args4.size == args.size) Boole(args4(0).get.value > args4(1).get.value)
        else throw new TypeException("Inputs to > must be numbers or texts")
      }
    }
  }

  private def equals(args: List[Value]): Value = {
    val args2 = args.map(toBool).filter(_ != None)
    if (args2.size == args.size) Boole(args2(0).get.value == args2(1).get.value)
    else {
      Boole(false)
    }
  }

  private def unequals(args: List[Value]): Value = {
    val args2 = args.map(toBool).filter(_ != None)
    if (args2.size == args.size) Boole(args2(0).get.value != args2(1).get.value)
    else {
      Boole(false)
    }
  }

  private def not(args: List[Value]): Value = {
    if (args.length == 1 && toBool(args(0)) != None) {
      !toBool(args(0)).get
    } else {
      throw new TypeException("Input must be Boole")
    }
  }

  def write(vals: List[Value]): Value = { println(vals(0)); Notification.DONE }
  def read(vals: List[Value]): Value = { val result = io.StdIn.readDouble(); Real(result) }
  def prompt(vals: List[Value]): Value = { print("=> "); Notification.DONE }

  // etc.
}