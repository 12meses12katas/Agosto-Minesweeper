Feature: minefields creation

  Scenario: one field with one empty cell
    Given I want to play MineSweeper
    When I give the board
      """
      1 1
      .
      0 0
      """
    Then I should get the board
      """
      Field #1:
      0
      
      """

  Scenario: two fields with one empty cell
    Given I want to play MineSweeper
    When I give the board
      """
      1 1
      .
      1 1
      .
      0 0
      """
    Then I should get the board
      """
      Field #1:
      0

      Field #2:
      0

      """

  Scenario: one mine in the middle
    Given I want to play MineSweeper
    When I give the board
      """
      3 3
      ...
      .*.
      ...
      0 0
      """
    Then I should get the board
      """
      Field #1:
      111
      1*1
      111

      """

    Scenario: kata acceptance test scenario
    Given I want to play MineSweeper
    When I give the board
      """
      4 4
      *...
      ....
      .*..
      ....
      3 5
      **...
      .....
      .*...
      0 0
      """
    Then I should get the board
      """
      Field #1:
      *100
      2210
      1*10
      1110

      Field #2:
      **100
      33200
      1*100
      
      """
