Feature: Cart Funtionality


	@cleanup
  Scenario Outline: add product to the cart
    And user should login "<username>" and "<password>"
    And user search the "<book>"
    When user add the book to the cart
    Then the cart badge should be update

    @data1
    Examples: 
      | username    | password    | book                 |
      | gurusivam23 | Gurusivam23 | All of Us with Wings |
      | aravindkk   | Aravind15   | The Simple Wild      |

    @data2
    Examples: 
      | username   | password   | book |
      | prasanth22 | Pras1234   | HP2  |
      | Kiruba25   | Kirukk2326 | HP3  |
