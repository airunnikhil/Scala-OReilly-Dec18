package matching

object TryMathes {
  def main(args: Array[String]): Unit = {
    val seven = 1 | 2 | 3 | 4
    println(s"seven is $seven")
    val x:Any = "Hello"
    val res = x match {
      // pattern.. NOT expression
        // typed capture variable... No need ever to cast!
//      case y => println(s"That was $y"); 7 // capture EVERYTHING!
//      case y:Int => println(s"That was $y"); 7 // captures any Int
      case y:Int if y > 5 => println(s"That was $y"); y * 2 // guard clause...
      case 1 | 2 | 3 | 4 => println("That's four!") // does not "fall through", no "break"
      case 5 => println("That's 5"); "Banana"
      case s:String if s != "Hello" => println(s"That was any string: $s")
      case "Hello" => println("That was EXACTLY Hello...")
    }

    println(s"res is ${res}")
    val s:Any = "Hello"
    // casting and typechecking ... UGH!!!
    val isString:Boolean = s.isInstanceOf[String]
    val s1:String = s.asInstanceOf[String]
  }

}
