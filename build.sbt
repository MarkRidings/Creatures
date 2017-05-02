import scala.sys.SystemProperties

name := "Creatures"

version := "1.0"

scalaVersion := "2.12.1"

scalacOptions += "-deprecation"

libraryDependencies ++= Seq(
  "org.scalafx" %% "scalafx" % "8.0.102-R11",
  "org.scala-lang" % "scala-reflect" % "2.12.1"
)


unmanagedJars in Compile += {
  val ps = new SystemProperties
  val jh = ps("java.home")
  Attributed.blank(file(jh) / "lib/ext/jfxrt.jar")
}

publishTo := Some(Resolver.file("Creatures", new File("/home/mark/Development/Creatures/Release")))
