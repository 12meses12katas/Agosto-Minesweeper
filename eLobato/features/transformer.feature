Feature: Transformer
  In order to transform the grid to the solution
  As a transformer object
  I want to fulfill with the requirements in the README 

  Scenario: Mines
    Given the transformer
    When I pass the grid to it
    Then the transformer must get the number of mines
    And where the mines are located

  Scenario: Get score
    Given the transformer
    When I pass the grid to it
    Then the transformer must increment by 1 the number on each of the positions looking in the above row, below row, and in its row 
    And this procedure has to be repeated for all the mines


