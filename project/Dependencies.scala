import sbt._

object Dependencies {

  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.2.10"
  lazy val refinedCore = "eu.timepit" %% "refined" % "0.9.28"
  lazy val shapeless = "com.chuusai" %% "shapeless" % "2.4.0-M1"
  lazy val play = "com.typesafe.play" %% "play" % "2.8.7"
  lazy val scalaCheck = "org.scalatestplus" %% "scalacheck-1-14" % "3.2.2.0"
  lazy val refinedScalaCheck = "eu.timepit" %% "refined-scalacheck" % "0.9.27"
  lazy val newType = "io.estatico" %% "newtype" % "0.4.4"

  val test = Seq(
    scalaTest % Test,
    scalaCheck % Test,
    refinedScalaCheck % Test
  )

  val prod = Seq(
    refinedCore,
    shapeless,
    newType,
    play
  )

}
