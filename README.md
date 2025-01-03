# scala-tutorial-2

## getting started:

Make sure you have the latest version of scala and sbt installed:

https://docs.scala-lang.org/getting-started/index.html#using-the-scala-installer-recommended-way

https://get-coursier.io/docs/cli-installation#windows

### changing folders:

```sh
cd /mnt/cd/Users/Marks-Desktop/Coding/scala-tutorial-2
```

## adding a main application

### create a new sbt project

```sh
sbt
```

### create a build file

```sh
vim build.sbt
```

### create new directories:

```sh
mkdir -p src/main/scala
mkdir -p src/test/scala
```

### check your build properties:

Jump in your project/ folder then:

```sh
cat build.properties
```

### build your main scala file

Within your src/main/scala folder, create a new directory:

```sh
mkdir -p com/scala-tutorial-2
```

Then create the file:

```sh
vim main.scala
```

Inside the file start with something like:

```sh
package com.scala-tutorial-2

object Main {
    def main(args: Array[String]): Unit = println("Learning SBT!")
}
```

### start the sbt server and compile

Go back to the root folder then run:

```sh
sbt
```

then after sbt:scala-tutorial-2>

```sh
compile
```

### run the application

In the same location run:

```sh
runMain com.scala_tutorial_2.Main
```

If you want to trigger incremental compilation and hit autocompile while
main.scala is being edited in another directory:

```sh
~compile
```

This will start a watching process for main.scala

### installing and using libraries

Open up your build.sbt file in your root folder and add:

```sh
libraryDependencies += "com.{library owner}" %% "{library name}" % "{version #}"
```

For example,

```sh
libraryDependencies += "com.lihaoyi" %% "fansi" % "0.4.0"
```

%% automatically determines the latest version of the library. If you only have
one % sign you will need to specify the scala version i.e. "fansi_2.13"

To add multiple libraries:

```sh
libraryDependencies ++= Seq(
    "com.lihaoyi" %% "fansi" % "0.4.0"
)
```

Save and close build.sbt then run:

```sh
sbt
```

and:

```sh
runMain com.scala_tutorial_2.Main
```

### setting up a library dependency for tests

Open up build.sbt then add the scalatest library as follows:

```sh
libraryDependencies ++= Seq(
	"com.lihaoyi" %% "fansi" % "0.4.0",
	"org.scalatest" %% "scalatest" % "3.2.13" % Test
)
```

Save and close.

## setting up and running tests

Create a new folder in your src/test/ directory:

```sh
mkdir -p src/test/scala/com/scala-tutorial-2
```

Create a test file:

```sh
vim $_/SimpleTest.scala
```

Edit the file:

```sh
package com.scala_tutorial_2

import org.scalatest.funsuite.AnyFunSuite

class SimpleTest extends AnyFunSuite {
    test("simplest test possible") {
        assert("Scala".toLowerCase == "scala")
    }
}
```

Close and run:

```sh
sbt
```

Then:

```sh
compile
```

To run the test (white sbt server is running)

```sh
test:testOnly com.scala_tutorial_2.SimpleTest
```

To test a variety of files, like regex for example:

```sh
test:testOnly *SimpleTest
```

To test everything that you have under the test directory:

```sh
test
```

To run the test outside of the sbt console, quit the sbt server and then run:

```sh
sbt test
```

## setting up multi-module projects

```sh
mkdir multi-module-project
```

Jump in the new directory:

```sh
cd $_
```

Next build your sbt file:

```sh
vim build sbt
```

Insert:

```sh
ThisBuild / scalaVersion := "3.6.2"
ThisBuild / version := "1.0"
ThisBuild / name := "multi-module"
ThisBuild / organization := "com.scala_tutorial_2"

lazy val core = (project in file("core"))
lazy val server = (project in file("server"))
lazy val root = (project in file(".")).aggregate(core, server)
```

Then run:

```sh
sbt
```

To switch to the core module, run:

```sh
project core
```

You can then compile or ~compile from there.

## modularizing build.sbt and usign constants

Change to the project directory:

```sh
cd project
```

Create a new file:

```sh
vim Constants.scala
```

## using plugins and building an app

Go to the project directory:

```sh
cd project
```

Create a new file:

```sh
vim plugins.sbt
```

Insert:

```sh
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "1.2.0")
```

Run:

```sh
sbt
```

Then:

```sh
project core
```

Then:

```sh
assembly
```

```sh
java -jar core-assembly-1.0 jar
```
