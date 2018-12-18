package hello
// underscore is wildcard for import (and other things)
//import java.time._
import java.time.{LocalDate, ZonedDateTime}
// import is not restricted to "types" and static import,
// import almost anything!

/* public is not a keyword! public is default :) */
object Hello {
  // Unit ~ void, but is a value
  // literal value is ()
//  def noArgs(a:Unit): Int = {
  def noArgs: Int = {
    println("Hello, with no args")
    //() // return keyword is normally NOT used
    99
  }

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
  }
}
