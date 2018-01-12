Feature: Visiting the Gov.UK main category pages

  As a visitor to the Gov.UK home page I should be able to visit the main category pages

  Scenario: Describe the specific scenario
    Given I am on the Gov.UK homepage
    When I click on the "Benefits" linkText link
    Then I should be on the "Benefits" page
