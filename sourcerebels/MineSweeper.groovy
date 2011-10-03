class MineSweeper {
	
	List<Board> boards = []
	
	private final String ENDLINE = '\n'
	private final String SPACE = ' '
	
	private final Integer HEIGHT_POSITION = 0
	private final Integer WIDTH_POSITION = 1
	
	public MineSweeper(String input) {
		
		def lines = readLines(input)

		boolean readedLastLine = false
		Integer actual = 0

		while(!readedLastLine) {
			
			String header = lines[actual]

			Integer height = parseHeight(header)
			Integer width = parseWidth(header)
			
			if (isLastLine(height, width)) {
				readedLastLine = true;
				continue;
			}
			
			def nextLine = actual + 1
			def boardEndLine = actual + height

			addNewBoard(cutLines(lines, nextLine, boardEndLine))
			actual = nextLine + height
		}
	}
	
	public String resolve() {
		
		def result = ''
		boards.eachWithIndex { board, count ->
			result += solutionHeader(count)
			result += board.resolve()
			result += endLineIfNoLastBoard(count)
		}
		return result
	}
	
	private addNewBoard(String input) {
		Board board = new Board(input)
		boards.add(board)
	}
	
	private String cutLines(def lines, Integer start, Integer end) {
		return lines[start..end].join(ENDLINE)
	}
	
	private Boolean isLastLine(Integer height, Integer width) {
		return (height == 0 && width == 0)
	}
	
	private String solutionHeader(Integer count) {
		return 'Field #' + (count + 1) + ":" + ENDLINE
	}
	
	private String endLineIfNoLastBoard(Integer count) {
		if (count < boards.size() - 1) {
			return ENDLINE
		}
		return ''
	}
	
	private readLines(String input) {
		return input.split(ENDLINE)
	}
	
	private Integer parseHeight(String header) {
		return Integer.valueOf(parseHeader(header)[HEIGHT_POSITION])
	}

	private Integer parseWidth(String header) {
		return Integer.valueOf(parseHeader(header)[WIDTH_POSITION])
	}
	
	private parseHeader(String header) {
		return header.split(SPACE)
	}
}