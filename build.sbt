name := "java2018"

version := "0.1"

scalaVersion := "2.12.6"

mainClass in (Compile,run) := Some("Runner")

libraryDependencies ++= Seq(
  //  "commons-io" % "commons-io" % "2.6",
   "com.google.guava" % "guava" % "23.5-jre",
  //  "org.apache.commons" % "commons-math3" % "3.6.1"
  )
