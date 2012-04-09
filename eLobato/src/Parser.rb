class Parser
  @@rawInput 

  def readFileToString(filePath)
    file = File.open(filePath, "rb")
    @@rawInput = file.read
  end

  def getRowsFromRawInput
    rows = Integer(@@rawInput.scan(/\d+/)[0])
    if rows < 0 or rows > 100
      return "error"
    end
    rows
  end

  def getColumnsFromRawInput
    columns = Integer(@@rawInput.scan(/\d+/)[1])
    if columns < 0 or columns > 100
      return "error"
    end
    columns
  end

  def getGrid
    @@rawInput.lines.to_a[1..-1].join
  end

  def gridToTwoDimensionalArray(rows,columns,gridString)
    gridArrayMock = Array.new(rows) { Array.new(columns) }
    gridArray = Array.new(rows) { Array.new(columns) }
    i,k = 0,0
    gridArrayMock.each do |row|
      # gridString starts at 1 and 1 has to be added in each line to
      # overcome the " " of the carrier return
      j = 0
      row.each do |cell|
        gridArray[i][j] = gridString[k]
        j += 1
        k += 1
      end
      i += 1
      k += 1
    end
    gridArray
  end
end        
