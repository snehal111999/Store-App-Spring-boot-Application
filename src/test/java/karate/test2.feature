Feature:sample karate test script for post

 @Test
  Scenario: post a customer
    Given url 'http://localhost:9090'
    Given path '/customer'
    And request
    """
    {
    "customerId": 2,
    "customerName":"saloni",
    "phoneNum":"1234567",
    "location":"anantapur"
    }
    """
    When method post
    Then status 201
   # to check the name is same
   Then match response == "#object"
   Then match response.customerName == "saloni"

   @tag
  Scenario Outline: post a customer
    Given url 'http://localhost:9090'
    Given path '/customer'
    And request {"customerId":'<customerId>', "customerName": '<customerName>',"phoneNum": '<phoneNum>',"location":'<location>'}
    When method post
    Then status 201
     Examples:
       |customerId|customerName|phoneNum|location|
       |8         |arshad      |1234567 |anantapur|
       |9         |ashwini     |238794  |sangli|





