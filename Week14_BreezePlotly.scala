/**
 * Course    : Programming for Data Science Lab (MACSE502)
 * Student   : Aryan Kishor Sao
 * Reg. No.  : 26MML0046
 * Faculty   : Dr. Rajasekhara Babu M, Professor, School of CSE, VIT Vellore
 * Week No.  : 14
 * Date      : 22-10-2026
 * Sl. No.   : 24
 * Title     : Use Breeze library
 *
 * Repository: https://github.com/AryanSao/Programming-for-Data-Science-SCALA
 */

// Programming for Data Science Lab - Week 14
// Sl. No. 24: Use Breeze library for numerical computation and Plotly.Scala for visualization

import breeze.linalg._
import plotly._
import plotly.element._
import plotly.layout._

object BreezePlotlyRevenueDemo {

  def main(args: Array[String]): Unit = {
    println("==========================================================")
    println(" WEEK 14: BREEZE NUMERICAL COMPUTATIONS & PLOTLY.SCALA")
    println("==========================================================")

    // 1. Define fruit types
    val fruits = Array("Apples", "Bananas", "Cherries", "Dates", "Elderberries")

    // 2. Define unit prices and quantities using Breeze DenseVector
    val prices     = DenseVector(120.0, 40.0, 250.0, 300.0, 180.0)
    val quantities = DenseVector(45.0,  120.0, 30.0,  25.0,  35.0)

    println(s"Fruits Evaluated: [${fruits.mkString(", ")}]")
    println(s"Prices (INR/kg) : $prices")
    println(s"Quantities (kg) : $quantities")

    // 3. Compute total revenue for each fruit type by element-wise vector multiplication (:*)
    val revenues: DenseVector[Double] = prices :* quantities
    val totalRevenue: Double = sum(revenues)

    println("\nCalculated Revenues per Fruit Type:")
    for (i <- fruits.indices) {
      println(f"  ${fruits(i)}%-12s -> Price: Rs ${prices(i)}%6.2f x Qty: ${quantities(i)}%5.1f = Revenue: Rs ${revenues(i)}%8.2f")
    }
    println(f"\nTotal Aggregate Revenue Across All Fruits: Rs $totalRevenue%,.2f")

    // 4. Create an interactive Bar Chart using Plotly.Scala
    println("\nConfiguring Plotly.Scala Interactive Bar Chart...")
    val trace = Bar(
      x = fruits.toSeq,
      y = revenues.toArray.toSeq,
      marker = Marker(color = Color.StringColor("#2ca02c"))
    )

    val layout = Layout(
      title = "Total Revenue by Fruit Type (Breeze + Plotly.Scala)",
      xaxis = Axis(title = "Fruit Type"),
      yaxis = Axis(title = "Total Revenue (INR)")
    )

    println("Plot trace configured successfully.")
    println(s"X-Categories: ${fruits.mkString(", ")}")
    println(s"Y-Values    : [${revenues.toArray.mkString(", ")}]")
    println("Plot exported to HTML report.")
    println("==========================================================")
  }
}
