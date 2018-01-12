name := "cucumber_selenium_starter"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  "org.seleniumhq.selenium" % "selenium-java" % "3.7.1" % "test",
  "org.seleniumhq.selenium" % "selenium-chrome-driver" % "3.7.1" % "test",
  "org.scalatest" % "scalatest_2.12" % "3.0.4" % "test",
  "io.cucumber" % "cucumber-junit" % "2.0.1" % "test",
  "io.cucumber" % "cucumber-picocontainer" % "2.0.1" % "test",
  "io.cucumber" % "cucumber-scala_2.12" % "2.0.1" % "test",
  "junit" % "junit" % "4.12" % "test",
  "com.novocode" % "junit-interface" % "0.11" % "test"
)
