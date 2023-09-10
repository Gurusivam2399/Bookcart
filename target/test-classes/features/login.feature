Feature: user authentication


Background: 
   And user click on the login link

  @login
  Scenario: login should be success
    And user enter the name as guru
    And user enter the password as pass123
    When user click the login button
    Then login should be success

  @loginfailed
  Scenario: login shouls be fail
    And user enter the name as guruss
    And user enter the password as fail123
    When user click the login button
    Then login should be fail
