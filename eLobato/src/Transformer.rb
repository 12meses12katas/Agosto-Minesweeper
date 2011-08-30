class Transformer

  def getNumberOfMines(grid)
    numberOfMines = 0
    grid.each do |row|
      row.each do |cell|
        if cell == "*"
          numberOfMines += 1
        end
      end
    end
    numberOfMines
  end

  def getPositionOfMines(grid, numberOfMines)
    rowIndex = 0
    columnIndex = 0
    mineIndex = 0
    positionOfMines = Hash.new
    grid.each do |row|
      row.each do |column|
        if column == "*"
          positionOfMines[mineIndex] = [rowIndex,columnIndex]
          mineIndex += 1
        end
        columnIndex += 1
      end
      rowIndex += 1
      columnIndex = 0
    end 
    positionOfMines
  end

  def setMineHints(grid, positionOfMines)
    gridRows = getGridRows(grid)
    gridColumns = getGridColumns(grid)
    grid = initializeGridToZero(grid,gridRows,gridColumns)
    for i in 0..(positionOfMines.length - 1) do
      minePositionRow = positionOfMines[i][0]
      minePositionColumn = positionOfMines[i][1]
      # Columns code - Set +1 for the cells next to the mine
      grid[minePositionRow][minePositionColumn+1] += 1 unless minePositionColumn+1 >= gridColumns-1 or grid[minePositionRow][minePositionColumn+1] == "*"
      grid[minePositionRow][minePositionColumn-1] += 1 unless minePositionColumn-1 <= 0 or grid[minePositionRow][minePositionColumn-1] == "*"  
      # Rows code - Set +1 for the cells above and below the mine
      grid[minePositionRow+1][minePositionColumn] += 1 unless minePositionColumn+1 >= gridColumns-1 or grid[minePositionRow+1][minePositionColumn] == "*"
      grid[minePositionRow-1][minePositionColumn] += 1 unless minePositionColumn-1 <= 0 or grid[minePositionRow-1][minePositionColumn] == "*"  
      # Diagonals code - Set +1 for cells top right, top left, down right, down left
    end
    puts grid
  end

  def initializeGridToZero(grid,rows,columns)
    initializedGrid = Array.new(rows) { Array.new(columns) }
    i = 0
    grid.each do |row|
      j = 0
      row.each do |cell|
        if cell != "*"
          initializedGrid[i][j] = 0
        else
          initializedGrid[i][j] = "*"
        end
        j += 1
      end
      i += 1
    end
    initializedGrid
  end

  def getGridRows(grid)
    grid.length
  end

  def getGridColumns(grid)
    grid.each do |row|
      return row.length
    end
  end
end
