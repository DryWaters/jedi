package context

import scala.util.parsing.combinator._
import expression._
import value._

class Jedi2Parsers extends Jedi1Parsers {
  
  // params parser
  // a parameter list is zero or more comma-separated identifiers bracketed by parentheses:
  // params ::= "(" ~ (identifier ~ ("," ~ identifier)*)? ~ ")"
  
  // lambda parser
  // lambda ::= "lambda" ~ params ~ expression
  
  // block parser
  // a block is one or more semi-colon separated expressions bracketed by curly braces:
  // block ::= "{" ~ expression ~ (";" ~ expression)* ~ "}"
    def block: Parser[Block] = "{" ~ expression ~ opt(rep(";" ~> expression)) ~ "}" ^^ {
    case "{" ~ expression ~ None ~ "}" => Block(expression :: Nil) 
    case "{" ~ expression ~ Some(moreExp) ~ "}" => Block(expression :: moreExp)
  }
  
  
  // override of term parser
//  override def term: Parser[Expression]  = lambda | funCall | block | literal | "("~>expression<~")"
  override def term: Parser[Expression]  = funCall | block | literal | "("~>expression<~")"
}
