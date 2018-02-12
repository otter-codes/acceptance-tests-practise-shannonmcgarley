import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.{Matchers, WordSpec}

class Ex1_CardNumber extends WordSpec with Matchers {

  // A 16 digit bank card number which may contain a single space after every fourth digit
  val expression = """""".r

  val matching = Table("matching",
    "1234 5678 9012 3456",
    "1234567890123456"
  )

  val nonMatching = Table("nonMatching",
    "123456789012345",
    "12345678901234567",
    "1234  5678  9012  3456",
    "123 5678 9012 3456",
    "1234 567 9012 3456",
    "1234 5678 901 3456",
    "1234 5678 9012 456",
    "aaaabbbbccccdddd",
    "aaaa bbbb cccc dddd"
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
