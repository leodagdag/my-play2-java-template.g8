import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "my_play2_app"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      // Add your project dependencies here,
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA)
    .settings(
      lessEntryPoints <<= baseDirectory(customLessEntryPoints)    
    )
  // Only compile the bootstrap bootstrap.less file and any other *.less file in the stylesheets directory
  def customLessEntryPoints(base: File): PathFinder = (
    (base / "app" / "assets" / "stylesheets" / "bootstrap" ** "bootstrap.less") +++
    (base / "app" / "assets" / "stylesheets" / "bootstrap" ** "responsive.less") +++
    (base / "app" / "assets" / "stylesheets" ** "main.less")
  )

}
