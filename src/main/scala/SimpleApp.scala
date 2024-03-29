/* SimpleApp.scala */
import org.apache.spark.sql.SparkSession

object SimpleApp {
  def main(args: Array[String]) {
    val logFile = "/usr/local/Cellar/apache-spark/2.4.4/README.md" // Should be some file on your system
    val spark = SparkSession.builder.appName("Simple Application").getOrCreate()
    val logData = spark.read.textFile(logFile).cache()
    val numAs = logData.filter(line => line.contains("spark")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println(s"Lines with spark: $numAs, Lines with b: $numBs")
    spark.stop()
  }
}

