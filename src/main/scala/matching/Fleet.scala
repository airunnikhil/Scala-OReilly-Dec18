package matching

import scala.annotation.tailrec

case class Truck(payload:Int, fuel:Int)
case class Car(seats:Int, fuel: Int)

object Fleet {
  def payloadCapability(v:Any):Int = v match {
    case Truck(p, _) => p
    case Car(s, _) => 170 * (s - 1)
  }

  @tailrec
  def capableOf(vehicles:List[Any], payload:Int):Any = vehicles match {
    case Nil => null
    case h :: t if payloadCapability(h) > payload => h
    case _ :: t => capableOf(t, payload)
  }

  def main(args: Array[String]): Unit = {
//    val t1 = Truck(50000, 3)
    val t1:Any = Car(5, 3)
    println(t1)
    t1 match {
      case Truck(_, f) if f > 5 => println(s"I found a Truck with $f fuel")
      case Truck(p, _) =>
        println(s"I found a Truck with $p payload, but not much fuel")
      case Car(s, f) => println(s"I found a car with $s seats")
    }

    val fleet = List(Truck(600, 5), Car(5, 7))
    println(capableOf(fleet, 300))
    println(capableOf(fleet, 610))

  }
}
