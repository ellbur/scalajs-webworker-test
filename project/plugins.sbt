
addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.5")

libraryDependencies ++= Seq(
  "org.apache.commons" % "commons-io" % "1.3.2"
)

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.11.2")

addSbtPlugin("com.pulsetor" % "sbt-pulsetor-cpp" % "1.0-SNAPSHOT")

resolvers += "Local Maven Repository" at file(Path.userHome.absolutePath + "/.m2/repository").toURL.toString
