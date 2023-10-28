Feature:sample karate test script

  Scenario: put a customer
    Given url 'http://localhost:9090'
    Given path '/customer/8'
    And request
     """
    {
    "customerName": "arshad",
    "phoneNum":"630434534656",
    "location":"anatpur"
    }
    """
    When method put
    Then status 201
