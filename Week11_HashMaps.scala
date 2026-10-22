/**
 * Course    : Programming for Data Science Lab (MACSE502)
 * Student   : Aryan Kishor Sao
 * Reg. No.  : 26MML0046
 * Faculty   : Dr. Rajasekhara Babu M, Professor, School of CSE, VIT Vellore
 * Week No.  : 11
 * Date      : 24-09-2026
 * Sl. No.   : 20
 * Title     : Handling collisions and resolving conflicts in HashMap’s
 *
 * Repository: https://github.com/AryanSao/Programming-for-Data-Science-SCALA
 */

// Programming for Data Science Lab - Week 11
// Sl. No. 20: Handling collisions and resolving conflicts in HashMap's

import scala.collection.mutable

object ScalaHashMapDemo {

  // Function to merge two HashMaps, resolving conflicts by taking the higher grade
  def mergeWithHigherGrade(
    mapA: mutable.HashMap[String, Double],
    mapB: mutable.HashMap[String, Double]
  ): mutable.HashMap[String, Double] = {
    val mergedMap = new mutable.HashMap[String, Double]()
    val allKeys = mapA.keySet ++ mapB.keySet

    for (key <- allKeys) {
      (mapA.get(key), mapB.get(key)) match {
        case (Some(gradeA), Some(gradeB)) =>
          mergedMap(key) = math.max(gradeA, gradeB)
        case (Some(gradeA), None) =>
          mergedMap(key) = gradeA
        case (None, Some(gradeB)) =>
          mergedMap(key) = gradeB
        case (None, None) =>
      }
    }
    mergedMap
  }

  // Function to handle collisions by chaining using lists to store multiple grades
  def insertWithChaining(
    chainedMap: mutable.HashMap[String, List[Double]],
    student: String,
    grade: Double
  ): Unit = {
    val existingGrades = chainedMap.getOrElse(student, List.empty[Double])
    chainedMap(student) = existingGrades :+ grade
  }

  def main(args: Array[String]): Unit = {
    println("==========================================================")
    println(" WEEK 11: HASHMAP CONFLICT RESOLUTION & CHAINING IN SCALA")
    println("==========================================================")

    // 1. Create a HashMap with student names and grades
    val studentGrades = new mutable.HashMap[String, Double]()
    studentGrades("Aryan") = 84.5
    studentGrades("Bhavna") = 91.0
    studentGrades("Chetan") = 76.0
    println(s"Initial HashMap: $studentGrades")

    // Insert a duplicate key with a different grade (Overwrite behavior)
    println("\nInserting duplicate key 'Aryan' with new grade 92.0...")
    studentGrades("Aryan") = 92.0
    println(s"HashMap after duplicate insertion (Overwritten): $studentGrades")

    // 2. Conflict resolution: Merge two HashMaps taking the higher grade
    val midTermGrades = mutable.HashMap("Aryan" -> 85.0, "Divya" -> 88.0, "Eshan" -> 74.0)
    val finalGrades   = mutable.HashMap("Aryan" -> 93.5, "Divya" -> 82.0, "Farhan" -> 90.0)

    println(s"\nMidterm Grades: $midTermGrades")
    println(s"Final Grades  : $finalGrades")

    val resolvedMap = mergeWithHigherGrade(midTermGrades, finalGrades)
    println(s"Merged Map (Taking Higher Grade): $resolvedMap")

    // 3. Collision handling by Chaining (storing list of values for each key)
    println("\n--- Separate Chaining Collision Resolution ---")
    val chainedMap = new mutable.HashMap[String, List[Double]]()
    val gradeEntries = List(
      ("Aryan", 84.5),
      ("Bhavna", 91.0),
      ("Aryan", 92.0),
      ("Aryan", 95.0),
      ("Bhavna", 94.5),
      ("Chetan", 78.0)
    )

    for ((student, grade) <- gradeEntries) {
      insertWithChaining(chainedMap, student, grade)
    }

    println("Chained HashMap (all grades preserved per student):")
    chainedMap.foreach { case (student, grades) =>
      println(f"  $student%-8s -> Grades: [${grades.mkString(", ")}] (Count: ${grades.length})")
    }
    println("==========================================================")
  }
}
