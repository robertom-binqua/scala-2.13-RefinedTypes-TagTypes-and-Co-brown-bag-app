version := "0.1"

scalaVersion := "2.13.16"

lazy val root = (project in file("."))
  .settings(
    name := "scala-2.13-RefinedTypes-TagTypes-and-Co-brown-bag-app",
    scalacOptions ++= Seq("-feature","-Xprint:all","-Yshow-syms","-Ymacro-annotations"),
    libraryDependencies ++= Dependencies.test ++ Dependencies.prod
  )


