package context

import scala.util.parsing.combinator._
import expression._
import value._

class Jedi2Parsers extends Jedi1Parsers {
  
  // params parser
  // a parameter list is zero or more comma-separated identifiers bracketed by parentheses:
  // params ::= "(" ~ (identifier ~ ("," ~ identifier)*)? ~ ")"
    def params: Parser[List[Identifier]] = "(" ~> opt(identifier) ~ opt(rep("," ~> identifier)) <~ ")" ^^ {
      case Some(identifier) ~ None          => identifier :: Nil
      case Some(identifier) ~ Some(moreIdentifiers) => identifier :: moreIdentifiers
      case _ => Nil
  }
  
  // lambda parser
  // lambda ::= "lambda" ~ params ~ expression
    def lambda: Parser[Lambda] = "lambda" ~ params ~ expression ^^ {
      case "lambda" ~ params ~ expression => Lambda(params, expression)
    }
  
  
  // block parser
  // a block is one or more semi-colon separated expressions bracketed by curly braces:
  // block ::= "{" ~ expression ~ (";" ~ expression)* ~ "}"
    def block: Parser[Block] = "{" ~ expression ~ opt(rep(";" ~> expression)) ~ "}" ^^ {
    case "{" ~ expression ~ None ~ "}" => Block(expression :: Nil) 
    case "{" ~ expression ~ Some(moreExp) ~ "}" => Block(expression :: moreExp)
  }
  
  
  // override of term parser
  override def term: Parser[Expression]  = lambda | funCall | block | literal | "("~>expression<~")"
}
