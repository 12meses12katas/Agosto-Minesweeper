class BoardParser {

	public static final String ENDLINE = '\n'
	
	List<Board> boards = []
	
	private lines
	private Integer actual

	public BoardParser(String input) {
		parse(input)
	}
	
	private void parse(String input) {
		initializeParser(input)
		Board board = readNextBoard()
		
		while(!board.lastBoard()) {
			parseBoard(board)
			updateCounters(board)
			board = readNextBoard()
		}
	}
	
	private Board readNextBoard() {
		return new Board(header())
	}
	
	private parseBoard(Board board) {
		if (!board.lastBoard()) {
			board.parse(readBoard(board.height))
			boards.add(board)
		}
	}
	
	private String header() {
		return lines[actual]
	}
	
	private initializeParser(String input) {
		readLines(input)
		actual = 0
	}
	
	private updateCounters(Board parsedBoard) {
		actual = actual + parsedBoard.height + 1
	}
		
	private readLines(String input) {
		lines = input.split(ENDLINE)
	}
	
	private readBoard(Integer height) {
		def nextLine = actual + 1
		def boardEndLine = actual + height
		cutLines(nextLine, boardEndLine)
	}

	private String cutLines(Integer start, Integer end) {
		return lines[start..end].join(ENDLINE)
	}
}