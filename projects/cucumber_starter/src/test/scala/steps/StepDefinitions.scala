package steps

import cucumber.api.scala.{EN, ScalaDsl}

class StepDefinitions extends ScalaDsl with EN {

  Given("""^I meet some precondition$"""){
    println("Precondition met")
  }

  When("""^I take some action$"""){
    println("Action taken")
  }

  Then("""^Some result should occur$"""){
    println("Result occurred")
  }

}
