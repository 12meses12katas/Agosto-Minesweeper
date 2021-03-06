Feature: Inputs
  In order to parse correctly the input
  As a parser
  I want to fulfill with the requirements in the README file
    
  Scenario: Parse Input 
    Given the parser
    When I pass n parameters to it
    Then the first line contains the number of rows
    And the second line contains the number of columns

  Scenario: Get Input
    Given the parser
    And the controller
    When the parser parses the input
    Then the controller must save the number of rows and columns
    And the controller must save the grid in a two dimensional array

  Scenario: Boundaries
    Given the parser
    When the parser parses the input
    Then the number of rows and columns must be in between 0 and 100

  Scenario: Grid 
    Given the parser
    And the controller
    When the controller recieves the grid
    Then the parser has to convert it to an Array format 

