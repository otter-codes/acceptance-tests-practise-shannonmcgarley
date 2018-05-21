package steps

import cucumber.api.DataTable
import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.By
import org.scalatest._
import support.Browser
import scala.collection.JavaConverters._

class StepDefinitionsDirectCare extends ScalaDsl with EN with Matchers with Browser {

  Given("""^I am on the social care compliance homepage$""") { () =>
    go to "http://localhost:8550/apply-for-social-care-compliance-scheme/capacity-registering"
    find(cssSelector("h1")).get.text shouldBe "Which of these options best describes you?"
  }

  When("""^I choose the "Someone who pays for the care directly" option$""") { () =>
    click on id("capacityRegistering.personalBudgetHolderDirect")
    click on id("submit")
  }

  And("""^I enter my name as "(.+)"$""") { name: String =>
    webDriver.findElement(By.id("value")).sendKeys(name)
    webDriver.findElement(By.id("submit")).click()
    // textField("value").value = name
    // click on id("submit")
  }

  And("""^I choose the "Yes" option$""") { () =>
    click on id("value-yes")
    click on id("submit")
  }
  When("""^I enter my address$""") { (table: DataTable) =>
    table.asMaps[String, String](classOf[String], classOf[String]).asScala.foreach(row => {

      println(s"Row: field = ${row.get("Field")} value = ${row.get("Value")}")

      webDriver.findElement(By.name(row.get("Field"))).sendKeys(row.get("Value"))
    })
    click on id("submit")

  }
  And("""^I enter my phone number as "(.+)"$""") { (number: String) =>
    webDriver.findElement(By.id("value"))
      .sendKeys(number)
    webDriver.findElement(By.id("submit")).click()

    //textField("value").value = "name"
    //click on id("submit")
  }
  And("""^I choose the "No" option for email""") { () =>
    click on id("value-no")
    click on id("submit")
  }

  And("""^I choose the "No" option for UTR""") { () =>
    click on id("value-no")
    click on id("submit")
  }

  And("""^I choose the "No" option for PAYE""") { () =>
    click on id("value-no")
    click on id("submit")
  }

  And("""^I click continue$""") { () =>
    click on id("submit")
  }
  And("""^I click confirm and send$""") { () =>
    click on id("submit")

  }

}