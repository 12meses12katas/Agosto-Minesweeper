require 'test/unit/assertions'
include Test::Unit::Assertions
require './src/Minesweeper.rb'
require './src/Parser.rb'
require './src/Transformer.rb'
 
Given /^the transformer$/ do
  assert File.exist?("src/Transformer.rb")
end

When /^I pass the grid to it$/ do
  assert_equal true,true
end

Then /^the transformer must get the number of mines$/ do
  transformer = Transformer.new
  grid = [["*",".","."],[".",".","*"]]
  assert_equal 2, transformer.getNumberOfMines(grid)
  grid = [["*","*","*"],["*","*","*"]]
  assert_equal 6, transformer.getNumberOfMines(grid)
end

Then /^where the mines are located$/ do
  transformer = Transformer.new
  grid = [["*",".","."],[".",".","*"]]
  numberOfMines = 2
  positionOfMines = { 0 => [0,0], 1 => [1,2]}
  assert_equal positionOfMines, transformer.getPositionOfMines(grid, numberOfMines)
end

Then /^the transformer must increment by (\d+) the number on each of the positions looking in the above row, below row, and in its row$/ do |arg1|
  transformer = Transformer.new
  grid = [["*",".","."],[".",".","*"]]
  positionOfMines = { 0 => [0,0], 1 => [1,2]}
  gridWithMineHints = transformer.setMineHints(grid,positionOfMines)
  grid = [["*","2","1"],["1","2","*"]]
  assert_equal grid, gridWithMineHints
end

Then /^this procedure has to be repeated for all the mines$/ do
  transformer = Transformer.new
  grid = [["*",".","."],[".",".","*"]]
  positionOfMines = { 0 => [0,0], 1 => [1,2]}
  gridWithMineHints = transformer.setMineHints(grid,positionOfMines)
  grid = [["*","2","1"],["1","2","*"]]
  assert_equal grid, gridWithMineHints
end

 
