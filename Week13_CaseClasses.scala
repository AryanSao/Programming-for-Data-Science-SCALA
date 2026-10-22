/**
 * Course    : Programming for Data Science Lab (MACSE502)
 * Student   : Aryan Kishor Sao
 * Reg. No.  : 26MML0046
 * Faculty   : Dr. Rajasekhara Babu M, Professor, School of CSE, VIT Vellore
 * Week No.  : 13
 * Date      : 15-10-2026
 * Sl. No.   : 22
 * Title     : Case Classes
 *
 * Repository: https://github.com/AryanSao/Programming-for-Data-Science-SCALA
 */

// Programming for Data Science Lab - Week 13
// Sl. No. 22: Case Classes in Scala

case class Person(name: String, age: Int, city: String)

object ScalaCaseClassDemo {

  // Function to filter out people older than 30 (keeps age <= 30)
  def filterOutOlderThan30(people: List[Person]): List[Person] = {
    people.filter(_.age <= 30)
  }

  // Function to group people by their city
  def groupByCity(people: List[Person]): Map[String, List[Person]] = {
    people.groupBy(_.city)
  }

  // Function to transform each Person object into the specified format
  def formatPersonStrings(people: List[Person]): List[String] = {
    people.map(p => s"${p.name} is ${p.age} years old and lives in ${p.city}")
  }

  // Function to sort the list of people by age in ascending order
  def sortByAgeAscending(people: List[Person]): List[Person] = {
    people.sortBy(_.age)
  }

  def main(args: Array[String]): Unit = {
    println("==========================================================")
    println("       WEEK 13: SCALA CASE CLASSES DEMONSTRATION")
    println("==========================================================")

    // 1. Create a list of Person objects representing five individuals
    val individuals: List[Person] = List(
      Person("Aarav", 28, "Mumbai"),
      Person("Bhavna", 34, "Bengaluru"),
      Person("Chirag", 24, "Mumbai"),
      Person("Deepika", 38, "Delhi"),
      Person("Eshan", 30, "Bengaluru")
    )

    println("Original List of Persons:")
    individuals.foreach(p => println(s"  $p"))

    // 2. Filter out people older than 30
    val filteredPeople = filterOutOlderThan30(individuals)
    println("\n1. Filtered Persons (Age <= 30, filtered out older than 30):")
    filteredPeople.foreach(p => println(s"  $p"))

    // 3. Group people by their city
    val cityGroups = groupByCity(individuals)
    println("\n2. Grouped by City:")
    cityGroups.foreach { case (city, group) =>
      val names = group.map(_.name).mkString(", ")
      println(s"  City: $city%-10s -> Members: $names (Total: ${group.length})")
    }

    // 4. Transform each Person into formatted string
    val formattedDescriptions = formatPersonStrings(individuals)
    println("\n3. Transformed Person Descriptions:")
    formattedDescriptions.foreach(desc => println(s"  - $desc"))

    // 5. Sort the list of people by age in ascending order
    val sortedByAge = sortByAgeAscending(individuals)
    println("\n4. Sorted by Age (Ascending):")
    sortedByAge.foreach(p => println(f"  ${p.name}%-8s | Age: ${p.age}%2d | City: ${p.city}"))
    println("==========================================================")
  }
}
