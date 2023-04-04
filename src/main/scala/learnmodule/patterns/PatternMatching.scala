package org.jadevirek
package learnmodule.patterns


  object PatternMatching extends App {

    // switch expression
    var anInteger = 1
    val order = anInteger match {
      case 1 => "first"
      case 2 => "second"
      case 3 => "third"
      case _ => anInteger.*(11)
    }
    // PM is an EXPRESSION
    println(order)
    // Case class decomposition
     class Person(val name: String, val age: Int){
      def apply(name: String, age: Int): Person= new Person(name,age);
    }


    val bob = new Person("Bob", 43) // Person.apply("Bob", 43)

    val personGreeting = bob match {
      // Compare by equality
      case  p: Person => s"Hi, my name is ${p.name} and I am ${p.age} years old."
      case _ => "Something else"
    }
    println(    new Person("Bob", 43).equals(bob))
    println(    personGreeting)
    // deconstructing tuples
    val aTuple = ("Bon Jovi", "Rock")
    val bandDescription = aTuple match {
      case (band, genre) => s"$band belongs to the genre $genre"
      case _ => "I don't know what you're talking about"
    }

    // decomposing lists
    val aList = List(1, 2, 3)
    val listDescription = aList match {
      case List(_, 2, _) => "List containing 2 on its second position"
      case _ => "unknown list"
    }

    // if PM doesn't match anything, it will throw a MatchError
    // PM will try all cases in sequence}
  }

