/**
 * Course    : Programming for Data Science Lab (MACSE502)
 * Student   : Aryan Kishor Sao
 * Reg. No.  : 26MML0046
 * Faculty   : Dr. Rajasekhara Babu M, Professor, School of CSE, VIT Vellore
 * Week No.  : 10
 * Date      : 17-09-2026
 * Sl. No.   : 19
 * Title     : lists, sets, and tuples in Scala
 *
 * Repository: https://github.com/AryanSao/Programming-for-Data-Science-SCALA
 */

// Programming for Data Science Lab - Week 10
// Sl. No. 19: lists, sets, and tuples in Scala

object ScalaCollectionsDemo {

  // Function to square each element of an integer list
  def squareList(primes: List[Int]): List[Int] = {
    primes.map(x => x * x)
  }

  // Function to compute the intersection of two sets of characters
  def intersectSets(setA: Set[Char], setB: Set[Char]): Set[Char] = {
    setA.intersect(setB)
  }

  def main(args: Array[String]): Unit = {
    println("==========================================================")
    println("   WEEK 10: LISTS, SETS, AND TUPLES IN SCALA")
    println("==========================================================")

    // 1. Create a list of the first five prime numbers
    val primeList: List[Int] = List(2, 3, 5, 7, 11)
    println(s"Original List of Primes : $primeList")

    // 2. Return a new list with each element squared
    val squaredPrimes = squareList(primeList)
    println(s"Squared List of Primes  : $squaredPrimes")

    // 3. Create a set of unique characters from the string 'hello world'
    val inputStr = "hello world"
    val charSetA: Set[Char] = inputStr.filterNot(_.isWhitespace).toSet
    println(s"\nUnique characters in '$inputStr' (excluding spaces): $charSetA")

    // Define a second character set to compute intersection
    val comparisonStr = "world wide web"
    val charSetB: Set[Char] = comparisonStr.filterNot(_.isWhitespace).toSet
    println(s"Unique characters in '$comparisonStr': $charSetB")

    // 4. Compute set intersection
    val commonChars = intersectSets(charSetA, charSetB)
    println(s"Intersection of two sets: $commonChars")

    // 5. Create a tuple with three elements: integer, string, boolean
    val recordTuple: (Int, String, Boolean) = (101, "Programming for Data Science", true)
    println("\nTuple Components:")
    println(s"  Element 1 (Integer): ${recordTuple._1}")
    println(s"  Element 2 (String) : ${recordTuple._2}")
    println(s"  Element 3 (Boolean): ${recordTuple._3}")
    println("==========================================================")
  }
}
