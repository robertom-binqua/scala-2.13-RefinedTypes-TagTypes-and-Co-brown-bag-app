package brown.bag.experiment.types

import eu.timepit.refined.api.Refined
import eu.timepit.refined.numeric.Greater
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers._

class WitnessExampleSpec extends AnyFlatSpec {

  "TheSpecialId" should "be created from a simple Int via refined.auto.autoRefineV" in {

    import eu.timepit.refined.auto.autoRefineV

    // mmmm ..... strange 5 in a type position .... this is the concept of literal Singleton Type
    val x : Int Refined Greater[5] = 6

    val y: 5 = 5

    val s: "test" = "test"

    // this is to make the compilation to fail during one of the compilation phases
//    val z : Int Refined Greater[5] = 4

//    val z: 6 = 5

  }

  "shapeless.Witness.Aux[5] apply method" should "build an instance on the fly" in {

    //see how the apply method is invoked but the implicit mechanism

    val x = shapeless.Witness.apply[5]

    implicitly[shapeless.Witness.Aux[5]].value should be(5)

    implicitly[shapeless.Witness.Aux[5]] should not(be(theSameInstanceAs(implicitly[shapeless.Witness.Aux[5]])))

  }

  "trying to create an invalid refined type via Witness at compile time" should "not work" in {
    assertTypeError("" +
      "import shapeless.Witness\n" +
      "import eu.timepit.refined.numeric.Greater\n" +
      "import eu.timepit.refined.api.Refined\n" +
      "\n" +
      "val witness5 = Witness(5)\n" +
      "val a: Int Refined Greater[witness5.T] = 4"
    )
  }

}
