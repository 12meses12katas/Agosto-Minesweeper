Feature: Transformer
  In order to comply with the acceptance test
  As a coder
  I want to test the two acceptance tests given in the README

  Scenario: Test One
    Given the minesweeper
    And acceptance1.txt
    When I pass the grid acceptance1.txt to it
    Then the transformer must get the expected output 

  Scenario: Test two
    Given the minesweeper
    And acceptance2.txt
    When I pass the grid acceptance2.txt to it
    Then the transformer must get the expected output 


