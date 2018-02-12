import org.scalatest.{Matchers, WordSpec}
import org.scalatest.prop.TableDrivenPropertyChecks._

class Ex1_Username extends WordSpec with Matchers {

  // A username that consists of a first name (all lowercase letters) and last name (all lowercase letters), separated
  // by a period, follow by an optional number between 0 and 99999.
  val expression = """""".r

  val matching = Table("matching",
    "a.b",
    "a.b0",
    "a.b99999",
    "abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz",
    "abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz0",
    "abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz99999",
    "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz",
    "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz0",
    "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz99999"
  )

  val nonMatching = Table("nonMatching",
    "",
    "a",
    "a.",
    "a.0",
    "a.99999",
    "a.b.",
    "a.b.0",
    "a.b.99999",
    "ab0",
    "ab99999",
    "a.b100000",
    "abcdefghijklmnopqrstuvwxyz0",
    "abcdefghijklmnopqrstuvwxyz99999",
    "abcdefghijklmnopqrstuvwxyz",
    "abcdefghijklmnopqrstuvwxyz.",
    "abcdefghijklmnopqrstuvwxyz.0",
    "abcdefghijklmnopqrstuvwxyz.99999",
    ".a",
    ".abcdefghijklmnopqrstuvwxyz",
    "..",
    "...",
    "..a",
    "..abcdefghijklmnopqrstuvwxyz"
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
