
import org.apache.commons.io.FileUtils
import build._

lazy val site = taskKey[Unit]("Put everything together into the site")

site := {
  val root = target.value / "site"
  if (root.exists)
    FileUtils.deleteDirectory(root)

  siteMappings.value foreach { case (path: String, file: File) =>
    val dest = root / path
    dest.getParentFile.mkdirs()
    IO.copyFile(file, dest)
  }

  jsFiles.value foreach { (file: File) =>
    IO.copyFile(file, root / file.getName)
  }
}
