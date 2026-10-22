# Programming-for-Data-Science-SCALA

**Course**: Programming for Data Science Lab (MACSE502)  
**Academic Year**: Fall Semester 2026  
**Student Name**: Aryan Kishor Sao  
**Registration Number**: `26MML0046`  
**Faculty / Instructor**: Dr. Rajasekhara Babu M, Professor, School of Computer Science and Engineering (SCOPE), Vellore Institute of Technology (VIT), Vellore  

---

## 📌 Repository Overview

This repository contains clean, modular, and thoroughly documented Scala source code developed for the laboratory components of **MACSE502: Programming for Data Science**. The exercises demonstrate essential functional paradigms, immutable collection transformations, high-performance numerical data structures, tabular data manipulation, and dynamic visualizations in Scala.

---

## 📑 Laboratory Experiments Index (Weeks 09 – 14)

| Sl. No. | Week | Topic | Experiment Title | Source Code Link |
|:---:|:---:|:---|:---|:---:|
| **18** | Week 09 | Arrays in Scala | Arrays in Scala | [`Week09_Arrays.scala`](./Week09_Arrays.scala) |
| **19** | Week 10 | Lists, Sets, and Tuples in Scala | Lists, Sets, and Tuples in Scala | [`Week10_Collections.scala`](./Week10_Collections.scala) |
| **20** | Week 11 | HashMaps in Scala | Handling Collisions and Resolving Conflicts in HashMaps | [`Week11_HashMaps.scala`](./Week11_HashMaps.scala) |
| **21** | Week 12 | Advanced Functional Combinators | Exploring Advanced Functional Combinators Beyond the Basic Set | [`Week12_Combinators.scala`](./Week12_Combinators.scala) |
| **22** | Week 13 | Case Classes | Case Classes in Scala | [`Week13_CaseClasses.scala`](./Week13_CaseClasses.scala) |
| **23** | Week 13 | Saddle & Vegas Visualization | Use Saddle to Load and Manipulate a Dataset | [`Week13_SaddleVegas.scala`](./Week13_SaddleVegas.scala) |
| **24** | Week 14 | Breeze Numerical Computations | Use Breeze Library for Numerical Computations and Plotly Visualizations | [`Week14_BreezePlotly.scala`](./Week14_BreezePlotly.scala) |
| **25** | Week 14 | Spire Precision & Saddle Manipulation | Saddle for Data Manipulation and Precision Statistics with Spire | [`Week14_SpireSaddleVegas.scala`](./Week14_SpireSaddleVegas.scala) |

---

## 🛠 Prerequisites & Dependencies

To compile and execute these programs:
- **Java Virtual Machine**: JDK 11 or JDK 17+ (LTS)
- **Scala**: Version 2.13.x or 3.x
- **CLI Runners**: `scala` or `scala-cli`

### Library Dependencies (Weeks 13 – 14)
- **Saddle**: `org.scala-saddle::saddle-core:1.3.4` (High-performance tabular data frame and series)
- **Vegas**: `org.vegas-viz::vegas:0.3.11` (Declarative statistical data visualization built on Vega-Lite)
- **Breeze**: `org.scalanlp::breeze:2.1.0` (Numerical processing, dense vectors, linear algebra)
- **Plotly.Scala**: `org.plotly-scala::plotly-render:0.8.4` (Interactive browser charting)
- **Spire**: `org.typelevel::spire:0.18.0` (Exact rational arithmetic, arbitrary precision mathematical structures)

---

## 🚀 Execution Instructions

Each `.scala` file can be executed directly using the standard Scala runner or `scala-cli`:

```bash
# Example: Running Week 9 Arrays demonstration
scala Week09_Arrays.scala

# Example: Running Week 10 Collections demonstration
scala Week10_Collections.scala

# Example: Running with scala-cli with automated dependency fetching
scala-cli run Week13_SaddleVegas.scala
```

---

## 📄 License & Attribution
Developed for academic submission and educational study under the curriculum of Vellore Institute of Technology (VIT), Vellore.
