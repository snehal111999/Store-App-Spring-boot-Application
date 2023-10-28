Feature: read data from java class

  Scenario: read data from a java class
    Then def readData = Java.type('com.shop.storeApp.classForKarate')
    Then def output = readData.DisplayMessage()
    Then print output

    #writing output in text file
    And karate.write(output , "sampleOutput.txt");
    #this output will be stored in target folder

    #karate.write(response ,"apiResponse.txt"); this can be written to store the response of an api

   #reading data from json file
   * def readJson = read('classpath:payload/request.json')
    Then print readJson
