ThisBuild / scalaVersion := "3.6.2"
ThisBuild / version := "1.0"
ThisBuild / name := "multi_module"
ThisBuild / organization := "com.scala_tutorial_2"

// Core module
lazy val core = (project in file("core")).settings(
	libraryDependencies += Constants.rootPackage %% "config" % "1.4.2"  
)

// Server module
lazy val server = (project in file("server")).dependsOn(core)

// Root project definition
lazy val root = (project in file(".")).aggregate(core, server)
