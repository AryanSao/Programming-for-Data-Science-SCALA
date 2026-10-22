/**
 * Course    : Programming for Data Science Lab (MACSE502)
 * Student   : Aryan Kishor Sao
 * Reg. No.  : 26MML0046
 * Faculty   : Dr. Rajasekhara Babu M, Professor, School of CSE, VIT Vellore
 * Week No.  : 13
 * Date      : 15-10-2026
 * Sl. No.   : 23
 * Title     : Use Saddle to load and manipulate a dataset
 *
 * Repository: https://github.com/AryanSao/Programming-for-Data-Science-SCALA
 */

// Programming for Data Science Lab - Week 13
// Sl. No. 23: Use Saddle to load and manipulate a dataset, and Vegas for visualization

import org.saddle._
import vegas._

case class FruitRecord(date: String, fruit: String, price: Double, quantity: Int)

object SaddleVegasFruitAnalysis {

  def main(args: Array[String]): Unit = {
    println("==========================================================")
    println(" WEEK 13: SADDLE DATA MANIPULATION & VEGAS VISUALIZATION")
    println("==========================================================")

    // 1. Define fruit pricing and quantity dataset over time
    val rawData = List(
      FruitRecord("2026-09-01", "Apples",  120.0, 50),
      FruitRecord("2026-09-02", "Apples",  125.5, 45),
      FruitRecord("2026-09-03", "Apples",  122.0, 60),
      FruitRecord("2026-09-04", "Apples",  130.0, 40),
      FruitRecord("2026-09-05", "Apples",  128.0, 55),
      FruitRecord("2026-09-01", "Bananas",  40.0, 100),
      FruitRecord("2026-09-02", "Bananas",  42.0, 95),
      FruitRecord("2026-09-03", "Bananas",  41.5, 110),
      FruitRecord("2026-09-01", "Oranges",  80.0, 70),
      FruitRecord("2026-09-02", "Oranges",  85.0, 65)
    )

    println("Raw Fruit Market Records Ingested: " + rawData.size + " rows.")

    // 2. Load into Saddle Frame / Vector structures
    val datesVec = Vec(rawData.map(_.date): _*)
    val fruitVec = Vec(rawData.map(_.fruit): _*)
    val priceVec = Vec(rawData.map(_.price): _*)
    val qtyVec   = Vec(rawData.map(_.quantity): _*)

    val colIndex = Index(Array("Date", "Fruit", "Price", "Quantity"))
    println(s"\nInitialized Saddle Series across columns: ${colIndex.toSeq.mkString(", ")}")

    // 3. Filter for 'Apples'
    val appleRecords = rawData.filter(_.fruit.equalsIgnoreCase("Apples"))
    println(s"\nFiltered Records for 'Apples' (${appleRecords.length} records):")
    appleRecords.foreach { r =>
      println(f"  Date: ${r.date} | Price: Rs ${r.price}%6.2f | Quantity: ${r.quantity}%3d")
    }

    // 4. Calculate average price of Apples using Saddle Vec
    val applePriceVec = Vec(appleRecords.map(_.price): _*)
    val avgApplePrice = applePriceVec.mean
    println(f"\nAverage Price of Apples: Rs $avgApplePrice%.2f")

    // 5. Visualize price trend over time using Vegas
    println("\nConstructing Vegas Vega-Lite Interactive Line Plot Specification...")
    val vegasData = appleRecords.map { r =>
      Map("Date" -> r.date, "Price" -> r.price)
    }

    val plot = Vegas("Apple Price Trend Over Time")
      .withData(vegasData)
      .mark(Line)
      .encodeX("Date", Nom, title = "Date of Observation")
      .encodeY("Price", Quant, title = "Price per Unit (INR)")

    println("Generated Vega-Lite JSON Specification for Browser Rendering:")
    println(plot.toJson.take(280) + " ... [JSON Complete]")
    println("==========================================================")
  }
}
