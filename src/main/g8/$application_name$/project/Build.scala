import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "$application_name$"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      "org.jongo" % "jongo" % "0.1"
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
