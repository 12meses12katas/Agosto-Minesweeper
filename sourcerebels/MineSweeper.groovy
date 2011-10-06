class MineSweeper {

	private BoardParser parser
	
	public MineSweeper(String input) {
		
		parser = new BoardParser(input)
	}
	
	public String resolve() {
		
		def result = ""
		parser.boards.eachWithIndex { board, count ->
			result += solutionHeader(count)
			result += board.resolve()
			result += endLineIfNoLastBoard(count)
		}
		return result
	}
	
	private String solutionHeader(Integer count) {
		return 'Field #' + (count + 1) + ":" + BoardParser.ENDLINE
	}
	
	private String endLineIfNoLastBoard(Integer count) {
		if (count < boards.size() - 1) {
			return BoardParser.ENDLINE
		}
		return ""
	}	
}