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
  assert_equal theParser.getRowsFromRawInput(), "2"
end
 
Then /^the second line contains the number of columns$/ do
  theParser = Parser.new
  theParser.readFileToString("src/input.txt")
  assert_equal theParser.getColumnsFromRawInput(), "3"
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
  game.main
  assert_equal "2", game.rows
  assert_equal "3", game.columns
end

Then /^the controller must save the grid in a two dimensional array$/ do
  game = Minesweeper.new
  game.main
  assert_equal "\n*..\n..*\n", game.grid
end
  
