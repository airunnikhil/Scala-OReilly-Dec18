package hello
// underscore is wildcard for import (and other things)
//import java.time._
import java.time.{LocalDate, ZonedDateTime}
// import is not restricted to "types" and static import,
// import almost anything!

/* public is not a keyword! public is default :) */
object Hello {
  def &^% (v: Int): Int = v + 2

  // Unit ~ void, but is a value
  // literal value is ()
//  def noArgs(a:Unit): Int = {
  def noArgs: Int = {
    println("Hello, with no args")
    //() // return keyword is normally NOT used
    99
  }

  def moreInfix(a: Int, b: Int): Int = a + b

  def main(args: Array[String]): Unit = {
    println("Hello, Scala world!")
    // val declares a assign-once variable
    var x/*:Int*/ = noArgs// () only allowed if on the declaration
    println("value of x is " + x)
    x = x + 1
    println(s"the new value of x is $x")
    println(s"the new value of x is ${x + 100}")
    println(s"the length of Hello is ${"Hello".length}")
    println(f"Pi is ${math.Pi}%7.5f")
//    x = "Hello"
    println(raw"this is a backslash \ $x ")
    println(
      """
        |hello, this is a very long
        |string with multiple lines
      """/*.stripMargin*/)

    val any:Any = 3
    // "operator overloading" is allowed...
    // identifiers can include weird symbols
    // and keywords -- use backquote format
    // precedence is "largely as expected" based on characters
    // beginning with * / high
    // & ^ | low...
    // applies to home made operators too.
    // associativity: Colon ":" can create right-associative methods
    println(s"funky function of 4 is ${&^%(4)}")
//    Thread.`yield`()
    // Console "auto-imported" from Predef...
    Console.println("Hello")
    // "infix" format... is this function or an operator...
    Console println "Hello"
    println(s"funky of 9 is ${Hello &^% 9}")

    println(s"two plus two is ${2.+(2)}")

    println(s"moreInfix(3, 4) is ${Hello moreInfix (3, 4)}")

    val newNum = &^% {10}
    println(s"newNum is $newNum")

    val exprVal = if (math.random() > 0.5) {
      "Big"
    } else {
      println("this will be small")
      "Small"
    }
    println(exprVal)
    // (math.random()) ? "Big" : "Small"
  }
}
