
def game

end

Given /^I want to play MineSweeper$/ do
  @game ||= MineSweeper::Game.new
end

When /^I give the board$/ do |input_board|
  @output_board = @game.play input_board
end

Then /^I should get the board$/ do |expected_output_board|
  @output_board.should == expected_output_board
end

