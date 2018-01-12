name := "cucumber_starter"

version := "0.1"

scalaVersion := "2.11.11"

libraryDependencies ++= Seq(
  "info.cukes" % "cucumber-junit" % "1.2.4",
  "info.cukes" % "cucumber-picocontainer" % "1.2.4",
  "info.cukes" % "cucumber-scala_2.11" % "1.2.2",
  "junit" % "junit" % "4.12" % "test",
  "com.novocode" % "junit-interface" % "0.11" % "test",
  "org.scalatest" %% "scalatest" % "2.2.4"
)
