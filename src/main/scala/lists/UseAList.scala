package lists

import scala.annotation.tailrec

object UseAList {
  @tailrec
  def infinite(x:Int):Unit = {
    println(x);
    infinite(x + 1)
//    println("-")
  }

  def showNames(names:List[String]): Unit = names match {
    case Nil => ()
//    case List(a, b) => println(s"List has two elements $a and $b")
    case h :: t => println(s"> $h") ; showNames(t)
  }

  def main(args: Array[String]): Unit = {
//    val names: List[String] = List("Fred", "Jim", "Sheila")
//    val names: List[String] = "Fred" :: "Jim" :: "Sheila" :: Nil
    val names: List[String] = Nil.::("Sheila").::("Jim").::("Fred")

    println(s"First name in list is ${names(0)}")
    val moreNames = "Alice" :: "Bob" :: names

    println(s"names is $names")
    println(s"moreNames is $moreNames")

    println(s"head of names is ${names.head}")
    println(s"tail of names is ${names.tail}")

    val moreNamesTailTwice = moreNames.tail.tail
    println(s"are they the same? ${moreNamesTailTwice.eq(names)}")
    showNames(moreNames)

    infinite(1)
  }
}
