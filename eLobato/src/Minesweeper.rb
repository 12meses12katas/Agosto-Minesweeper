require_relative 'Parser'

class Minesweeper
  attr_accessor :rows, :columns, :grid 
  @rows
  @columns
  @grid

  def main
    getParserResults
  end

  def getParserResults
    parser = Parser.new
    parser.readFileToString("src/input.txt")
    @rows = parser.getRowsFromRawInput
    @columns = parser.getColumnsFromRawInput
    @grid = parser.getGrid
  end
end


