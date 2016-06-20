
import build._

organization := "com.github.ellbur"

name := "scalajs-webworker-test-site-view"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.7"

scalaSource in Compile <<= baseDirectory(_ / "src")

scalaSource in Test <<= baseDirectory(_ / "test")

resourceDirectory in Compile <<= baseDirectory(_ / "resources")

resourceDirectory in Test <<= baseDirectory(_ / "test-resources")

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.8.0",
  "be.doeraene" %%% "scalajs-jquery" % "0.8.0",
  "com.github.ellbur" %%% "redo-signals-core" % "0.8-SNAPSHOT",
  "com.lihaoyi" %%% "scalatags" % "0.5.2.2-SNAPSHOT"
)

// Test-only dependencies
libraryDependencies ++= Seq(
)

resolvers += "Local Maven Repository" at file(Path.userHome.absolutePath + "/.m2/repository").toURL.toString

enablePlugins(ScalaJSPlugin)

publishTo := Some(Resolver.file("file", new File(Path.userHome.absolutePath + "/.m2/repository")))

resolvers += "jitpack" at "https://jitpack.io"

siteMappings := {
  val root = baseDirectory.value / "site-files"
  root.***.get flatMap { file =>
    file.relativeTo(root) map { path =>
      (path.getPath, file)
    }
  }
}

watchSources ++= siteMappings.value map (_._2)

