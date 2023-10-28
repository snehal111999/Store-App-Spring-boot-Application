Feature:sample karate test script

  Scenario: delete a customer
    Given url 'http://localhost:9090'
    Given path '/customer/6'
    When method delete
    Then status 200

    #calling test.feature file in test4.feature file
    And def allData = call read ('classpath: karate/test2.feature')
    Then print allData
