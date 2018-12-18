package arrays

object TryAnArray {
  // math: "apply" a function to its arguments...
  def apply(i: Int): String = s"This is the value: $i"

  def update(i: Int, s: String): Unit =
    println(s"You just tried to write $s to me, at position $i")

  def main(args: Array[String]): Unit = {
    val arr = Array("Hello", "Goodbye")
//    val arr = Array.apply[String]("Hello", "Goodbye")
//    val arr = Array.apply("Hello", "Goodbye")

    val arr2 = new Array[String](4) // create array of four elements

//    val nameOne = arr(0)
    val nameOne = arr.apply(0)
//    arr(1) = "another name"
    arr.update(1, "another name")
    println(s"nameOne is $nameOne")
    println(s"arr(1) is ${arr.apply(1)}")

    println(s"calling apply(4) gets ${TryAnArray.apply(4)}")
    println(s"calling apply(4) gets ${TryAnArray(4)}")
    TryAnArray(3) = "Banana!"
  }
}
