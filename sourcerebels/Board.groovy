class Board {

	private BoardConfiguration config
	
	private LineParser parser
	
	public Board(String header) {
		config = new BoardConfiguration(header)
	}
	
	public String parse(String input) {
		parser = new LineParser(input)
	}
	
	public resolve() {
		
		String result = ''
		parser.lines.eachWithIndex { line, lineCount ->
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
	
	private resolveLine(Line line, Integer lineCount) {

		def solvedLine = ''
		line.places().eachWithIndex { Place place, placeCount ->
			solvedLine = solvedLine +  resolvePlace(place, lineCount, placeCount)
		}
		return solvedLine + '\n'
	}
	
	private resolvePlace(Place place, Integer lineCount, Integer placeCount) {
		
		if (place.mine()) {
			return place.toString()
		}
		return countAdjacentMines(lineCount, placeCount)
	}
	
	private Integer countAdjacentMines(Integer line, Integer place) {
		return countMines(line, place - 1) +
		       countMines(line - 1, place - 1) +
			   countMines(line - 1, place) +
			   countMines(line - 1, place + 1) +
			   countMines(line, place + 1) +
			   countMines(line + 1, place + 1) +
			   countMines(line + 1, place) +
			   countMines(line + 1, place - 1)
	}

	private Integer countMines(Integer line, Integer place) {
		if (config.valid(line, place) &&
			isMine(line, place)) {
			return 1
		}
		return 0
	} 
	
	private Boolean isMine(Integer line, Integer place) {
 		return parser.lines[line].places[place].mine()
	}
}