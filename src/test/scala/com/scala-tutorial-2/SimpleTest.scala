package com.scala_tutorial_2

import org.scalatest.funsuite.AnyFunSuite

class SimpleTest extends AnyFunSuite {
    test("simplest test possible") {
        assert("Scala".toLowerCase == "scala")
    }
}
