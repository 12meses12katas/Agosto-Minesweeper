require_relative 'Parser'
require_relative 'Transformer'

class Minesweeper
  attr_accessor :rows, :columns, :grid, :parser, :solution
  @rows
  @columns
  @grid
  @parser
  @solution

  def main(pathToFile)
    getParserResults(pathToFile)
    callParserToConstructGrid
    setMineHints(grid)
  end

  def getParserResults(pathToFile)
    @parser = Parser.new
    @parser.readFileToString(pathToFile)
    @rows = parser.getRowsFromRawInput
    @columns = parser.getColumnsFromRawInput
    @grid = parser.getGrid
  end

  def callParserToConstructGrid
    @parser = Parser.new 
    @grid = @parser.gridToTwoDimensionalArray(@rows, @columns, @grid)
  end

  def setMineHints(grid)
    transformer = Transformer.new
    numberOfMines = transformer.getNumberOfMines(grid)
    positionOfMines = transformer.getPositionOfMines(grid, numberOfMines)
    @solution = transformer.setMineHints(grid, positionOfMines)
  end
end


