require_relative 'Parser'

class Minesweeper
  attr_accessor :rows, :columns, :grid, :parser 
  @rows
  @columns
  @grid
  @parser

  def main
    getParserResults
    callParserToConstructGrid
  end

  def getParserResults
    @parser = Parser.new
    @parser.readFileToString("src/input.txt")
    @rows = parser.getRowsFromRawInput
    @columns = parser.getColumnsFromRawInput
    @grid = parser.getGrid
  end

  def callParserToConstructGrid
    @parser = Parser.new 
    @grid = @parser.gridToTwoDimensionalArray(@rows, @columns, @grid)
  end
end


