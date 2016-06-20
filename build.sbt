
import build._

lazy val `site-view` = project

lazy val `fake-site` = project settings (
  siteMappings <<= siteMappings in `site-view`,
  jsFiles := {
    val f = (fastOptJS in (`site-view`, Compile)).value
    val p = f.data.getPath
    Seq(f.data, file(p + ".map"), (packageJSDependencies in(`site-view`, Compile)).value)
  }
)
