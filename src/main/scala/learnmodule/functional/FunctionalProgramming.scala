package org.jadevirek
package learnmodule.functional

object FunctionalProgramming extends App {

  // Scala is OO
  class Person(name: String) {
    def apply(age: Int) = println(s"I have aged $age years")
  }

  val bob = new Person("Bob")
  bob.apply(43)
  bob(43) // INVOKING bob as a function === bob.apply(43)

  /*
    Scala runs on the JVM
    Functional programming:
    - compose functions
    - pass functions as args
    - return functions as results
    Conclusion: FunctionX = Function1, Function2, ... Function22
   */

  val simpleIncrementer = new Function1[Int, Int] {
    override def apply(arg: Int): Int = arg + 1
  }

  simpleIncrementer.apply(23) // 24
  simpleIncrementer(23) // simpleIncrementer.apply(23)
  // defined a function!

  // ALL SCALA FUNCTIONS ARE INSTANCES OF THESE FUNCTION_X TYPES

  // function with 2 arguments and a String return type
  val stringConcatenator = new Function2[String, String, String] {
    override def apply(arg1: String, arg2: String): String = arg1 + arg2
  }

  stringConcatenator("I love", " Scala") // "I love Scala"

  // syntax sugars
  // defining a lambda expression similar like in Java
  val doubler: Int => Int = (x: Int) => 2 * x
  val doublerTwoArgs: (Int, String) => Int = (x: Int, y: String) => 2 * x + y.getBytes().length
  doubler(4) // 8
  doublerTwoArgs(11, "Hello")
  val curriedMultiplication: Int => Int => Int = x => y => x * y

  curriedMultiplication(5)(5) // 25
  /*
    equivalent to the much longer:
    val doubler: Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(x: Int) = 2 * x
    }
   */
  def curriedAddition(x: Int)(y: Int): Unit = print(x+y)
  curriedAddition(11)(3) // 14

  // higher-order functions: take functions as args/return functions as results
  val aMappedList: List[Int] = List(1, 2, 3).map(x => x + 1) // HOF
  val aFlatMappedList = List(1, 2, 3).map { x =>
    List(x, 2 * x)
  } // alternative syntax, same as .flatMap(x => List(x, 2 * x))
  println(aFlatMappedList)
  val aFilteredList = List(1, 2, 3, 4, 5).filter(_ <= 3) // equivalent to x => x <= 3


  // all pairs between the numbers 1, 2, 3 and the letters 'a', 'b', 'c'
  val allPairs = List(1, 2, 3).flatMap(number => List('a', 'b', 'c').map(letter => s"$number-$letter"))
  val allPairs2 = List(1, 2, 3).flatMap(number => List('a', 'b', 'c'))

  /**
   * In java:
   * val numbers: Nothing = List.of(1, 2, 3)
   *  val letters: Nothing = List.of('a', 'b', 'c')
   *
   *  val allPairs: Nothing = numbers.stream.
   *  flatMap((number) => letters.stream.map((letter) => number + "-" + letter)).toList
   */
//
  print(allPairs2)
  print(allPairs)
  // for comprehensions
  val alternativePairs = for {
    number <- List(1, 2, 3)
    letter <- List('a', 'b', 'c')
  } yield s"$number-$letter"
  // equivalent to the map/flatMap chain above

  /**
   * Collections
   */

  // lists
  val aList = List(1, 2, 3, 4, 5)
  val firstElement = aList.head
  val rest = aList.tail
  val aPrependedList = 0 :: aList // List(0,1,2,3,4,5)
  val aPostpendedList =  aList :+ 3 // List(0,1,2,3,4,3)
  val anExtendedList = 0 +: aList :+ 6 // List(0,1,2,3,4,5,6)

  // insert to specified index
  // def insert(list: List[Any], i: Int, value: Any) = {
  //  list.take(i) ++ List(value) ++ list.drop(i)
  //}
  //

  // sequences
  val aSequence: Seq[Int] = Seq(1, 2, 3) // Seq.apply(1,2,3)
  val accessedElement = aSequence(1) // the element at index 1: 2

  // vectors: fast Seq implementation
  val aVector = Vector(1, 2, 3, 4, 5)

  // sets = no duplicates
  val aSet = Set(1, 2, 3, 4, 1, 2, 3) // Set(1,2,3,4)
  val setHas5 = aSet.contains(5) // false
  val anAddedSet = aSet + 5 // Set(1,2,3,4,5)
  val aRemovedSet = aSet - 3 // Set(1,2,4)

  // ranges
  val aRange = 1 to 1000
  val twoByTwo = aRange.map(x => 2 * x).toList // List(2,4,6,8..., 2000)

  // tuples = groups of values under the same value
  val aTuple = ("Bon Jovi", "Rock", 1982)

  // maps
  val aPhonebook: Map[String, Int] = Map(
    ("Daniel", 6437812),
    "Jane" -> 327285 // ("Jane", 327285)
  )


}
