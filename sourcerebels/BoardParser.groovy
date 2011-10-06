class BoardParser {

	public static final String ENDLINE = '\n'
	
	//Eliminar
	public static final String SPACE = ' '
	
	//Eliminar
	public static final Integer HEIGHT_POSITION = 0
	
	//Eliminar
	public static final Integer WIDTH_POSITION = 1
	
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
		
		BoardConfiguration config = new BoardConfiguration(lines[actual])
		while(!config.lastBoard()) {

			def boardEndLine = actual + height
			addNewBoard(cutLines(actual + 1, boardEndLine))
			updateActual()
			config = new BoardConfiguration(lines[actual])
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
}