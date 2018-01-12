import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.scalatest._
import org.scalatest.selenium.WebBrowser

class HelloSelenium extends FlatSpec with Matchers with WebBrowser {

  implicit val webDriver: WebDriver = new ChromeDriver()
  sys.addShutdownHook(webDriver.close())

  "The home page" should "have the correct title and content" in {
    go to "https://www.gov.uk"

    pageTitle shouldBe "Welcome to GOV.UK"
    find(cssSelector("h1")).get.text shouldBe "Welcome to GOV.UK"

    click on linkText("Benefits")
    pageTitle shouldBe "Benefits - GOV.UK"

    goBack()
    pageTitle shouldBe "Welcome to GOV.UK"
  }
}
