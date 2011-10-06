class BoardParser {

	public final String ENDLINE = '\n'
	public final String SPACE = ' '
	
	public final Integer HEIGHT_POSITION = 0
	public final Integer WIDTH_POSITION = 1
	
	List<Board> boards = []
	
	private lines
	private Integer actual
	
	private Integer height
	private Integer width
	
	private header

	public BoardParser(String input) {
		parse(input)
	}
	
	private void parse(String input) {
		
		lines = readLines(input)
		actual = 0
		
		parseHeader()
		while(!isLastLine()) {

			def boardEndLine = actual + height
			addNewBoard(cutLines(actual + 1, boardEndLine))
			updateActual()
			parseHeader()
		}
	}
	
	private updateActual() {
		actual = actual + 1 + height
	}
	
	private addNewBoard(String input) {
		Board board = new Board(input)
		boards.add(board)
	}
	
	private readLines(String input) {
		return input.split(ENDLINE)
	}

	private String cutLines(Integer start, Integer end) {
		return lines[start..end].join(ENDLINE)
	}

	private void parseHeader() {
 		this.header = lines[actual].split(SPACE)
		parseHeight()
		parseWidth()
	}

	private void parseHeight() {
		this.height = Integer.valueOf(header[HEIGHT_POSITION])
	}

	private void parseWidth() {
		this.width = Integer.valueOf(header[WIDTH_POSITION])
	}
	
	private Boolean isLastLine() {
		return (height == 0 && width == 0)
	}
}