
import sbt._

object build {
  lazy val jsFiles = taskKey[Seq[File]]("The generated JS files")
  lazy val siteMappings = taskKey[Seq[(String, File)]]("HTML/JS/CSS etc")
}

