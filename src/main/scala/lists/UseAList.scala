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

  def showAList[T](list:List[T]):Unit = list match {
    case Nil => ()
    case h :: t => println("--" + h) ; showAList(t)
  }

//  def forEvery[T](list:List[T], operation: T => Unit):Unit = list match {
//    case Nil => ()
//    case h :: t => operation(h) ; forEvery(t, operation)
//  }

  def forEvery[T](list:List[T])(implicit operation: T => Unit):Unit = list match {
    case Nil => ()
    case h :: t => operation(h) ; forEvery(t)
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

//    infinite(1)

    showAList(List(1, 2, 3, 9, 8, 7, 6))
    forEvery(List(1, 2, 3, 9, 8, 7, 6))(v => println("++" + v))
    implicit def f[T]: T => Unit
      = v => println("This is the implicit version" + v)
    forEvery(List(1, 2, 3, 9, 8, 7, 6))

    List(1, 2, 3, 4, 5).map(x => x + 2).foreach(x => println(x))
    println("----------------")
//    List(1, 2, 3, 4, 5).map(_ + 2).foreach(println(_))
//    List(1, 2, 3, 4, 5).map(_ + 2).foreach(println)
    List(1, 2, 3, 4, 5).map(_ + 2) foreach println
  }
}
