package matching

import scala.annotation.tailrec

// single class inheritance (usually a bad idea!)
// multiple trait inheritance (likely OK)
//abstract class Carrier {
trait Carrier {
  def payload:Int
}

class NonCaseCar/* private */(val seats:Int, f:Int) /*extends Other(f)*/ {
  var fuel = f
  println(s"Making non-case car, seats = $seats, fuel = $f")
}

case class Truck(payload:Int, fuel:Int) extends Carrier
case class Car(seats:Int, fuel: Int) extends Carrier {
  if (seats < 1 || fuel < 1) {
    throw new IllegalArgumentException("bad seats or fuel")
  }
  println("making a car")
  override def payload: Int = (seats - 1) * 170
}

object Fleet {
  def payloadCapability(v:Any):Int = v match {
    case Truck(p, _) => p
    case Car(s, _) => 170 * (s - 1)
  }
//
//  @tailrec
//  def capableOf(vehicles:List[Any], payload:Int):Any = vehicles match {
//    case Nil => null
//    case h :: t if payloadCapability(h) > payload => h
//    case _ :: t => capableOf(t, payload)
//  }
//
  @tailrec
  def capableOf(vehicles:List[Carrier], payload:Int):Any = vehicles match {
    case Nil => null
    case h :: t if h.payload > payload => h
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

    try {
      val sillyCar = Car(-2, 50)
      println(s"Silly Car is $sillyCar")
                             // Might also see in Akka message handlers
    } catch /* ex match */ { // PartialFunction[Throwable]
      case t: IllegalArgumentException => println("That's a bad car!")
      case _ : Throwable => println("Really, wasn't expecting that!")
    }
    println("Still executing...")

    payloadCapability("Bad")
  }
}
