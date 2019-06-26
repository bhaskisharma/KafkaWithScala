
name := "KafkaUsingScala"

version := "0.1"

scalaVersion := "2.11.8"

//https://mvnrepository.com/artifact/org.scala-lang/scala-library
libraryDependencies ++= {
  Seq(
    "org.scala-lang" % "scala-library" % "2.11.8",
    "org.apache.kafka" %% "kafka" % "2.3.0"
  )
}
