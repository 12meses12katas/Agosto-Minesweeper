# require 'rspec'
require './minesweeper.rb'

describe Minesweeper do
  let(:input) { "4 4\n*...\n....\n.*..\n....\n3 5\n**...\n.....\n.*...\n0 0" }
  let(:output) { "Field #1:\n*100\n2210\n1*10\n1110\n\nField #2:\n**100\n33200\n1*100\n" }
  let(:minesweeper){ Minesweeper.new(input) }
  it "should return fields with number of mines around each position" do
    #   ## INPUT ##
    # 4 4
    # * . . .
    # . . . .
    # . * . .
    # . . . .
    #
    # 3 5
    # * * . . .
    # . . . . .
    # . * . . .
    #
    # 0 0
    #

    #  ## OUTPUT ##
    # Field #1:
    # * 1 0 0
    # 2 2 1 0
    # 1 * 1 0
    # 1 1 1 0
    #
    # Field #2:
    # * * 1 0 0
    # 3 3 2 0 0
    # 1 * 1 0 0
    #


    minesweeper.numbers.should eql(output)
  end

end