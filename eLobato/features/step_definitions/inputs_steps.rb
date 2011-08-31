require 'test/unit/assertions'
include Test::Unit::Assertions
require './src/Minesweeper.rb'
require './src/Parser.rb'

# Scenario 1 - Read STDIN

Given /^the parser$/ do
  assert File.exist?("src/Parser.rb")
end
 
When /^I pass n parameters to it$/ do
  theParser = Parser.new
  theParser.readFileToString("src/input.txt")
  assert_equal true, true
end
 
Then /^the first line contains the number of rows$/ do
  theParser = Parser.new
  theParser.readFileToString("src/input.txt")
  assert_equal theParser.getRowsFromRawInput, 2
end
 
Then /^the second line contains the number of columns$/ do
  theParser = Parser.new
  theParser.readFileToString("src/input.txt")
  assert_equal theParser.getColumnsFromRawInput, 3
end

# Scenario 2 - Get information

Given /^the controller$/ do
  assert File.exist?("src/Minesweeper.rb")
end
 
When /^the parser parses the input$/ do
  theParser = Parser.new
  theParser.readFileToString("src/input.txt")
  theParser.getGrid
  assert_equal true,true 
end
Then /^the controller must save the number of rows and columns$/ do
  game = Minesweeper.new
  game.main("src/input.txt")
  assert_equal 2, game.rows
  assert_equal 3, game.columns
end

Then /^the controller must save the grid in a two dimensional array$/ do
  theParser = Parser.new
  theParser.readFileToString("src/input.txt")
  assert_equal "*..\n..*\n", theParser.getGrid
end
  
Then /^the number of rows and columns must be in between (\d+) and (\d+)$/ do |arg1, arg2|
  theParser = Parser.new
  theParser.readFileToString("src/inputError.txt")
  assert_equal "error", theParser.getColumnsFromRawInput 
  assert_equal "error", theParser.getRowsFromRawInput 
  theParser.readFileToString("src/input.txt")
  assert_equal theParser.getColumnsFromRawInput, 3
  assert_equal theParser.getRowsFromRawInput, 2
end

When /^the controller recieves the grid$/ do
  rows, cols = 2,3  
  grid = [["*",".","."],[".",".","*"]]
  game = Minesweeper.new
  game.main("src/input.txt")
end

Then /^the parser has to convert it to an Array format$/ do
  rows, cols = 2,3  
  grid = [["*",".","."],[".",".","*"]]
  game = Minesweeper.new
  game.main("src/input.txt")
  assert_equal grid, game.grid
end

 
