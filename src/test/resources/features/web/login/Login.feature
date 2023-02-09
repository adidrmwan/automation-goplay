@Web @Amazon @Login
Feature: As User, I have be able to Success Login

  Background:
    Given user open amazon homepage
    And user on login page

  @Negative @InvalidLoginUsingEmail
  Scenario Outline: User be able to see error message when input invalid data email
    When user input "<email_type>" email
    And user click next button on login page
    Then user see error message "<message>" on login page

    Examples:
    |email_type           |message                                                    |
    |invalid              |We cannot find an account with that email address          |
    |not_registered       |We cannot find an account with that email address          |
    |none                 |Enter your email or mobile phone number                    |

  @Negative @InvalidLoginUsingPhoneNumber
  Scenario Outline: User be able to see error message when input invalid data email
    When user input "<number_type>" phone number
    And user click next button on login page
    Then user see error message "<message>" on login page

    Examples:
      |number_type          |message                                                    |
      |invalid              |We cannot find an account with that mobile number          |
      |not_registered       |We cannot find an account with that mobile number          |
      |none                 |Enter your email or mobile phone number                    |

