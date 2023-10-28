Feature: trying Scenario Outline

  Scenario Outline: used to pass data sets
    Given url '<url>'
    Given path '/customers'
    When method get
    Then status 200
  Examples:
      |url|
      |http://localhost:9090|
      |http://localhost:9090|

  # passing path with url :

    #Given url '<url>'
    #Given path '<path>'
    #When method get
    #Then status 200
    #Examples:
     # |url| path |
     # |http://localhost:9090|/customers|
     # |http://localhost:9090|/customers|
