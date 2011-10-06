class Board {

	private final String ENDLINE = '\n'
	private final String SAFE_PLACE = '.'
	private final String MINE = '*'
	private List board
	
	private BoardConfiguration config
	
	public Board(String header) {
		config = new BoardConfiguration(header)
	}
	
	public String parse(String input) {
		board = []
		def lines = readLines(input)
		lines.each { line ->
			def parsedLine = parseLine(line)
			board.add(parsedLine)
		}
	}
	
	public resolve() {
		
		String result = ''
		board.eachWithIndex { line, lineCount ->
			result = result + resolveLine(line, lineCount)
		}
		return result
	}
	
	public Boolean lastBoard() {
		return config.lastBoard()
	}
	
	public Integer getHeight() {
		return config.height
	}
	
	public Integer getWidth() {
		return config.width
	}
	
	private resolveLine(String line, Integer lineCount) {

		def solvedLine = ''
		line.eachWithIndex { place, placeCount ->
			solvedLine = solvedLine +  resolvePlace(place, lineCount, placeCount)
		}
		return solvedLine + '\n'
	}
	
	private resolvePlace(String place, Integer lineCount, Integer placeCount) {
		
		if (place == MINE) {
			return MINE
		}
		return countAdjacentMines(lineCount, placeCount)
	}
	
	private Integer countAdjacentMines(Integer line, Integer place) {
		Integer count = countWestMines(line, place)
		count += countNorthWestMines(line, place)
		count += countNorthMines(line, place)
		count += countNorthEastMines(line, place)
		count += countEastMines(line, place)
		count += countSouthEastMines(line, place)
		count += countSouthMines(line, place)
		count += countSouthWestMines(line, place)
		return count
	}
	
	private Integer countWestMines(Integer line, Integer place) {
		return countMines(line, place - 1)
	}
	
	private Integer countNorthWestMines(Integer line, Integer place) {
		return countMines(line - 1, place - 1)
	}
	
	private Integer countNorthMines(Integer line, Integer place) {
		return countMines(line - 1, place)
	}

	private Integer countNorthEastMines(Integer line, Integer place) {
		return countMines(line - 1, place + 1)
	}
	
	private Integer countEastMines(Integer line, Integer place) {
		return countMines(line, place + 1)
	}

	private Integer countSouthEastMines(Integer line, Integer place) {
		return countMines(line + 1, place + 1)
	}
	
	private Integer countSouthMines(Integer line, Integer place) {
		return countMines(line + 1, place)
	}
	
	private Integer countSouthWestMines(Integer line, Integer place) {
		return countMines(line + 1, place - 1)
	}

	private Integer countMines(Integer line, Integer place) {
		
		def res = validPlace(line, place)
		if (validPlace(line, place) &&
			isMine(line, place)) {
			return 1
		}
		return 0
	} 
	
	private Boolean isMine(Integer line, Integer place) {
 		return board[line][place] == MINE
	}
	
	private Boolean validPlace(Integer line, Integer place) {
		if (!validLine(line)) {
			return false
		}
		return place >= 0 && place < board[line].size()
	}

	private Boolean validLine(Integer line) {
		return line >= 0 && line < board.size()
	}
	
	private String parseLine(String input) {
		String line = ''
		input.each { place ->
			line = line + initializePlace(place)
		}
		return line
	}
	
	private String initializePlace(String place) {
		if (place == SAFE_PLACE) {
			return '0'
		}
		return place
	}
	
	private readLines(String input) {
		return input.split(ENDLINE)
	}
}