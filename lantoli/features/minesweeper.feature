Feature: empty board

  As a minesweeper
  I want to be able to load an empty game
  So that I test it works

  Scenario: empty game
    Given I want to play MineSweeper
    When I get the board
      """
      0 0
      """
    Then I should get the board
      """
      0 0
      """
  
