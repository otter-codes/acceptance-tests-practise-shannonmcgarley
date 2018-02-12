import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.{Matchers, WordSpec}

class Ex1_PositiveOrNegativeDecimal extends WordSpec with Matchers {

  // A decimal number which will always have a '.' part, which may optionally have a '-' sign to indicate a negative value
  val expression = """""".r

  val matching = Table("matching",
    "0.0",
    "-0.0",
    "1.0",
    "-1.0",
    "10000.0",
    "-10000.0",
    "12345678901234567890.0",
    "-12345678901234567890.0",
    "0.000000001234567890",
    "-0.000000001234567890"
  )

  val nonMatching = Table("nonMatching",
    "a0.0",
    "-a.a",
    "-",
    "--0.0",
    "a0.0",
    "a12345",
    " 0",
    " 12345",
    "0a0"
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
