import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.{Matchers, WordSpec}

class Ex1_abc extends WordSpec with Matchers {

  // A string with 'a' repeated three or four times, followed by 'b' exactly twice.
  val expression = """""".r

  val matching = Table("matching",
    "aaabb",
    "aaaabb"
  )

  val nonMatching = Table("nonMatching",
    "aaab",
    "aaabbb",
    "aaaabbb",
    "aabb",
    "abb",
    "aaaa11",
    "aaa11",
    "111bb",
    "1111bb",
    "bbbbb",
    "bbbbbb",
    "cccbb",
    "ccccbb",
    "aaacc",
    "aaaacc"
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
