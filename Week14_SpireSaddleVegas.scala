/**
 * Course    : Programming for Data Science Lab (MACSE502)
 * Student   : Aryan Kishor Sao
 * Reg. No.  : 26MML0046
 * Faculty   : Dr. Rajasekhara Babu M, Professor, School of CSE, VIT Vellore
 * Week No.  : 14
 * Date      : 22-10-2026
 * Sl. No.   : 25
 * Title     : Saddle for data manipulation
 *
 * Repository: https://github.com/AryanSao/Programming-for-Data-Science-SCALA
 */

// Programming for Data Science Lab - Week 14
// Sl. No. 25: Saddle for data manipulation, Spire for precise statistics, Vegas for visualization

import org.saddle._
import spire.math.Rational
import spire.implicits._
import vegas._

case class MarketRecord(date: String, fruit: String, price: Double)

object SpireSaddleVegasAnalysis {

  // Function to compute exact mean using Spire Rational arithmetic
  def computeSpireMean(prices: List[Double]): Rational = {
    val rationals = prices.map(Rational(_))
    val sum = rationals.foldLeft(Rational.zero)(_ + _)
    sum / Rational(prices.length)
  }

  // Function to compute sample variance using Spire Rational arithmetic
  def computeSpireVariance(prices: List[Double]): Rational = {
    if (prices.length <= 1) Rational.zero
    else {
      val mean = computeSpireMean(prices)
      val rationals = prices.map(Rational(_))
      val squaredDiffSum = rationals.map(p => (p - mean) * (p - mean)).foldLeft(Rational.zero)(_ + _)
      squaredDiffSum / Rational(prices.length - 1)
    }
  }

  def main(args: Array[String]): Unit = {
    println("==========================================================")
    println(" WEEK 14: SPIRE PRECISION, SADDLE MANIPULATION & VEGAS")
    println("==========================================================")

    // 1. Multi-temporal fruit price observations
    val marketData = List(
      MarketRecord("2026-10-01", "Apples",  120.5),
      MarketRecord("2026-10-02", "Apples",  122.0),
      MarketRecord("2026-10-03", "Apples",  121.0),
      MarketRecord("2026-10-04", "Apples",  125.0),
      MarketRecord("2026-10-05", "Apples",  123.5),

      MarketRecord("2026-10-01", "Bananas",  42.0),
      MarketRecord("2026-10-02", "Bananas",  44.5),
      MarketRecord("2026-10-03", "Bananas",  43.0),
      MarketRecord("2026-10-04", "Bananas",  45.0),
      MarketRecord("2026-10-05", "Bananas",  42.5),

      MarketRecord("2026-10-01", "Oranges",  82.0),
      MarketRecord("2026-10-02", "Oranges",  79.5),
      MarketRecord("2026-10-03", "Oranges",  81.0),
      MarketRecord("2026-10-04", "Oranges",  85.0),
      MarketRecord("2026-10-05", "Oranges",  84.0)
    )

    println(s"Total Ingested Price Observations: ${marketData.size}")

    // 2. Group by Fruit and compute Spire precision statistics
    val groupedByFruit = marketData.groupBy(_.fruit)

    println("\nPrecision Statistics Computed Using Spire (Exact Rational & Decimal):")
    groupedByFruit.toList.sortBy(_._1).foreach { case (fruit, records) =>
      val prices = records.map(_.price)
      val meanRat = computeSpireMean(prices)
      val varRat  = computeSpireVariance(prices)
      val stdDev  = math.sqrt(varRat.toDouble)

      println(s"\n--- Fruit: $fruit (N = ${prices.length}) ---")
      println(s"  Exact Rational Mean     : $meanRat")
      println(f"  Decimal Mean            : Rs ${meanRat.toDouble}%7.3f")
      println(s"  Exact Rational Variance : $varRat")
      println(f"  Decimal Sample Variance : ${varRat.toDouble}%7.4f")
      println(f"  Standard Deviation      : ${stdDev}%7.4f")
    }

    // 3. Visualize Multi-Series Trends Over Time Using Vegas
    println("\nConfiguring Vegas Multi-Series Time Series Visualization...")
    val vegasData = marketData.map { r =>
      Map("Date" -> r.date, "Fruit" -> r.fruit, "Price" -> r.price)
    }

    val plot = Vegas("Multi-Fruit Price Trends Over Time")
      .withData(vegasData)
      .mark(Line)
      .encodeX("Date", Nom, title = "Observation Date")
      .encodeY("Price", Quant, title = "Price (INR)")
      .encodeColor("Fruit", Nom, title = "Fruit Category")

    println("Vega-Lite Multi-Series Specification Constructed Successfully.")
    println(plot.toJson.take(280) + " ... [JSON Complete]")
    println("==========================================================")
  }
}
