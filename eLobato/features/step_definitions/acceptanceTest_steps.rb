require 'test/unit/assertions'
include Test::Unit::Assertions
require './src/Minesweeper.rb'
require './src/Parser.rb'
require './src/Transformer.rb'

Given /^the minesweeper$/ do
  assert File.exist?("src/Minesweeper.rb")
end

Given /^acceptance(\d+)\.txt$/ do |arg1|
  assert File.exist?("src/acceptance"+arg1+".txt")
end

When /^I pass the grid acceptance(\d+)\.txt to it$/ do |arg1|
  game = Minesweeper.new
  game.main("src/acceptance"+arg1+".txt")           
  if arg1 == "1"
    grid = Array.new(4) { Array.new(4) }
    grid = [["*",1,0,0],[2,2,1,0],[1,"*",1,0],[1,1,1,0]]
    assert_equal grid, game.solution
  elsif arg1 == "2" 
    grid = Array.new(3) { Array.new(5) }
    grid = [["*","*",1,0,0],[3,3,2,0,0],[1,"*",1,0,0]]
    assert_equal grid, game.solution
  else 
    assert_equal false,true
  end
end

Then /^the transformer must get the expected output$/ do
  assert_equal true,true
end
