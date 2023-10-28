Feature:sample karate test script
Background:
* url 'http://localhost:9090'

  @RunThisScenario
  Scenario: get all customers
    Given path '/customers'
    When method get
    Then status 200
    #assertions
    And print response
    #response is in form of array so printing value of array[1]
    And print response

    #Storing it in a variable
    And def des = response[1].customerName
    Then print des

    #checking if the array[1] contains value
    And match response[1].customerName contains 'saloni'
    # !contains can be used
    And match response[1].customerName !contains 'sneha'
    #checking for multiple indexes
    And match response[1 , 2 , 3].customerName contains 'saloni'
    # $ can be used instead of response
    And match $[1 , 2 , 3].customerName contains 'saloni'

    #to check data type :
    And match response[1].customerName == '#string'
    #it should fail because value of customerName is a string
    #And match response[1].customerName == '#number'

     #optional value ##
     #to verify response[0]
    Then match response[0] ==
    """
    {
        "customerName": '#string',
        "phoneNum": '#string',
        "location": '#string',
        "productId": null,
        "customerId": '#number'
    }
    """

    #to verify complete response[0,1,2,3....]
    Then match each response ==
    """
    {
        "customerName": '##string',
        "phoneNum": '#string',
        "location": '#string',
        "productId": null,
        "customerId": '#number'
    }
    """



