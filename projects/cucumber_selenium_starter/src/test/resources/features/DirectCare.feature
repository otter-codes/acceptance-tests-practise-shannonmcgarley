Feature: Users who pay for their own care can register

  As a user who pays for their own care I should be able to provide my details and register for the scheme

Scenario: User with a UK address can register for the scheme
    Given I am on the social care compliance homepage
    When I choose the "Someone who pays for the care directly" option
    And I enter my name as "name"
    And I choose the "Yes" option
    And I enter my address
       | Field          | Value          |
       | addressLine1 |123 Fake Street |
       | addressLine2 | Fake town      |
       | postcode       |NE98 1ZZ        |
    And I enter my phone number as "12345"
    And I choose the "No" option for email
    And I choose the "No" option for UTR
    And I choose the "No" option for PAYE
    And I click confirm and send