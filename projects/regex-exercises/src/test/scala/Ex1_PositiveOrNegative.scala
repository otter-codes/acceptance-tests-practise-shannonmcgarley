import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.{Matchers, WordSpec}

class Ex1_PositiveOrNegative extends WordSpec with Matchers {

  // An integer that may optionally have a '-' sign to indicate a negative value
  val expression = """""".r

  val matching = Table("matching",
    "0",
    "-0",
    "1",
    "-1",
    "10000",
    "-10000",
    "12345678901234567890",
    "-12345678901234567890"
  )

  val nonMatching = Table("nonMatching",
    "a",
    "-a",
    "-",
    "--0",
    "a0",
    "a12345",
    " 0",
    " 12345"
  )

  "regular expression" should {
    forAll(matching) {(example) =>
      s"Match the string $example" in {
        example should fullyMatch regex expression
      }
    }
    forAll(nonMatching) {(example) =>
      s"Not match the string $example" in {
        example should not fullyMatch regex(expression)
      }
    }
  }
}
