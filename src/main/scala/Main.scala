package org.jadevirek

object Main {
  def main(args: Array[String]): Unit = {
    println("Hello world!")

  }
  def newFunction(x: Int, y:String ): String = {
    return x.toString + y;
  }

    println(newFunction(15, "test"))

}

