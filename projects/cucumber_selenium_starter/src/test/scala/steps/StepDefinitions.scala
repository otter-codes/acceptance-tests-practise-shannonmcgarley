package steps

import cucumber.api.scala.{EN, ScalaDsl}
import org.scalatest._
import support.Browser

class StepDefinitions extends ScalaDsl with EN with Matchers with Browser {

  Given("""^I am on the Gov.UK homepage$"""){() =>
    go to "https://www.gov.uk"
    pageTitle shouldBe "Welcome to GOV.UK"
    find(cssSelector("h1")).get.text shouldBe "Welcome to GOV.UK"
  }

  When("""^I click on the "Benefits" linkText link$"""){() =>
    click on linkText("Benefits")
  }

  Then("""^I should be on the "Benefits" page$"""){() =>
    pageTitle shouldBe "Benefits - GOV.UK"
  }

}
