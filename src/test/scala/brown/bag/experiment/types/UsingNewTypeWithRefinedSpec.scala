package brown.bag.experiment.types

import brown.bag.experiment.types.model.companyNumber.CompanyNumber
import brown.bag.experiment.types.model.withNewType.{AClosingCompanyNumber, AnOpeningCompanyNumber}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers._

class UsingNewTypeWithRefinedSpec extends AnyFlatSpec {

  "the newtype annotation" should "be similar to tagging (...also with no runtime overhead) ... guess what ... an idea coming from Haskell" in {

    def doSomething(aClosingCompanyNumber: AClosingCompanyNumber, anOpeningCompanyNumber: AnOpeningCompanyNumber): String = {
      aClosingCompanyNumber.companyNumber.value + anOpeningCompanyNumber.companyNumber.value
    }

    doSomething(
      aClosingCompanyNumber = AClosingCompanyNumber(CompanyNumber("11111113")),
      anOpeningCompanyNumber = AnOpeningCompanyNumber(CompanyNumber("11111112"))
    ) should be("11111113" + "11111112")

  }


}
