/**
 * Course    : Programming for Data Science Lab (MACSE502)
 * Student   : Aryan Kishor Sao
 * Reg. No.  : 26MML0046
 * Faculty   : Dr. Rajasekhara Babu M, Professor, School of CSE, VIT Vellore
 * Week No.  : 12
 * Date      : 08-10-2026
 * Sl. No.   : 21
 * Title     : Exploring advanced functional combinators beyond the basic set
 *
 * Repository: https://github.com/AryanSao/Programming-for-Data-Science-SCALA
 */

// Programming for Data Science Lab - Week 12
// Sl. No. 21: Exploring advanced functional combinators beyond the basic set

object FunctionalCombinatorsDemo {

  def main(args: Array[String]): Unit = {
    println("==========================================================")
    println("  WEEK 12: ADVANCED FUNCTIONAL COMBINATORS IN SCALA")
    println("==========================================================")

    // 1. Create a list of integers from 1 to 10
    val numbers: List[Int] = (1 to 10).toList
    println(s"Original Integer List (1 to 10): $numbers")

    // 2. Use filter to create a new list with only even numbers
    val evenNumbers: List[Int] = numbers.filter(_ % 2 == 0)
    println(s"\n1. Filtered Even Numbers        : $evenNumbers")

    // 3. Use map to create a new list where each element is multiplied by 3
    val tripledNumbers: List[Int] = numbers.map(_ * 3)
    println(s"2. Tripled Numbers (map * 3)    : $tripledNumbers")

    // 4. Use flatMap to create a list of tuples where each integer is paired with its square
    val pairedWithSquares: List[(Int, Int)] = numbers.flatMap(x => List((x, x * x)))
    println(s"3. Tuples of (x, x^2) (flatMap) : $pairedWithSquares")

    // 5. Use foldLeft to calculate the product of all elements in the list (10!)
    val totalProduct: Long = numbers.foldLeft(1L)((accumulator, element) => accumulator * element)
    println(s"\n4. Cumulative Product (foldLeft): $totalProduct")
    println(s"   Verification: 1 * 2 * 3 * ... * 10 = 10! = $totalProduct")
    println("==========================================================")
  }
}
