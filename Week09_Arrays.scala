/**
 * Course    : Programming for Data Science Lab (MACSE502)
 * Student   : Aryan Kishor Sao
 * Reg. No.  : 26MML0046
 * Faculty   : Dr. Rajasekhara Babu M, Professor, School of CSE, VIT Vellore
 * Week No.  : 09
 * Date      : 10-09-2026
 * Sl. No.   : 18
 * Title     : arrays in Scala
 *
 * Repository: https://github.com/AryanSao/Programming-for-Data-Science-SCALA
 */

// Programming for Data Science Lab - Week 9
// Sl. No. 18: arrays in Scala

object ScalaArrayOperations {

  // Function to calculate the sum of elements in an integer array
  def sumArray(arr: Array[Int]): Int = {
    var total = 0
    for (num <- arr) {
      total += num
    }
    total
  }

  // Function to concatenate string elements separated by commas
  def concatenateFruits(fruits: Array[String]): String = {
    fruits.mkString(", ")
  }

  def main(args: Array[String]): Unit = {
    println("==========================================================")
    println("     WEEK 9: ARRAYS IN SCALA DEMONSTRATION")
    println("==========================================================")

    // 1. Create an array of integers with values: 2, 5, 9, 14, 20
    val intArray: Array[Int] = Array(2, 5, 9, 14, 20)
    println(s"Created Integer Array  : [${intArray.mkString(", ")}]")
    println(s"Array Length           : ${intArray.length}")

    // 2. Calculate the sum of its elements using the custom function
    val totalSum = sumArray(intArray)
    println(s"Calculated Sum of Array : $totalSum")

    // 3. Create an array of strings with names of five different fruits
    val fruitArray: Array[String] = Array("Apple", "Banana", "Cherry", "Date", "Elderberry")
    println(s"\nCreated Fruit Array    : [${fruitArray.mkString(", ")}]")

    // 4. Concatenate all elements separated by commas
    val concatenatedFruits = concatenateFruits(fruitArray)
    println(s"Concatenated Fruits    : $concatenatedFruits")

    // 5. Iterate over the integer array and print each element to the console
    println("\nIterating over the integer array elements:")
    for (i <- intArray.indices) {
      println(s"  Index $i -> Element: ${intArray(i)}")
    }
    println("==========================================================")
  }
}
