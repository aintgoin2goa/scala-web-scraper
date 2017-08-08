import Dependencies._
import sbt.Keys._
import sbt._

name := "scraper"

resolvers += Resolver.sonatypeRepo("public")
scalaVersion := "2.12.1"
assemblyJarName in assembly := "scraper.jar"

libraryDependencies ++= Seq(
  "com.amazonaws" % "aws-lambda-java-events" % "1.1.0",
  "com.amazonaws" % "aws-lambda-java-core" % "1.1.0",
  "com.github.seratch" %% "awscala" % "0.5.+",
  "org.json4s" %% "json4s-native" % "3.4.2",
  "net.ruippeixotog" %% "scala-scraper" % "2.0.0"
)

libraryDependencies += scalaTest % Test
libraryDependencies += "org.scalamock" %% "scalamock-scalatest-support" % "3.5.0" % Test

scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-feature",
  "-Xfatal-warnings")
