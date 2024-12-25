# scala-tutorial-2

## getting started:

Make sure you have the latest version of scala and sbt installed:

https://docs.scala-lang.org/getting-started/index.html#using-the-scala-installer-recommended-way

https://get-coursier.io/docs/cli-installation#windows

## changing folders:

```sh
cd /mnt/cd/Users/Marks-Desktop/Coding/scala-tutorial-2
```

## create a new sbt project

```sh
sbt
```

## create a build file

```sh
vim build.sbt
```

## create new directories:

```sh
mkdir -p src/main/scala
mkdir -p src/test/scala
```

## check your build properties:

Jump in your project/ folder then:

```sh
cat build.properties
```

## build your main scala file

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

## start the sbt server and compile

Go back to the root folder then run:

```sh
sbt
```

then after sbt:scala-tutorial-2>

```sh
compile
```

## run the application

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
