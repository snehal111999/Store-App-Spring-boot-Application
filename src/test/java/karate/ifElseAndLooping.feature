Feature:sample karate test script
  Background:
    * url 'http://localhost:9090'

  Scenario: getting customers data by using if-else
    Given path '/customers'
    When method get
    Then status 200
    * def locations = []
    * def phoneNums = []
    And eval for(var i=0; i< response.length; i++) if(response[i].customerName.includes("arshad")) locations.push(response[i].location); else phoneNums.push(response[i].phoneNum);
    And if (locations.length == 0) karate.log(phoneNums); else karate.log(locations);


