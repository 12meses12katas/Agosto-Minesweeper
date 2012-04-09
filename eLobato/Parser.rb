class Parser
  @@rawInput 

  def readFileToString(filePath)
    file = File.open(filePath, "rb")
    @@rawInput = file.read
  end

  def getRowsFromRawInput
    @@rawInput[0]
  end

  def getColumnsFromRawInput
    @@rawInput[2]
  end

  def getGrid
    @@rawInput[4...@@rawInput.length]
  end
end        
