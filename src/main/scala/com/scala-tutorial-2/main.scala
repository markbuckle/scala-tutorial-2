package com.scala_tutorial_2

object Main {

	val fansiStr: fansi.Str = fansi.Color.Red("This should be a red string")
	def main(args: Array[String]): Unit = println(fansiStr)
}
