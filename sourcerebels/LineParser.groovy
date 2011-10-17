class LineParser {
	
	private final String ENDLINE = '\n'
	
	List<Line> lines
	
	public LineParser(String input) {
		initializeParser()
		parse(input)
	}
	
	public Integer size() {
		return lines.size()
	}
	
	private void parse (String input) {
		readLines(input).each { line ->
			def parsedLine = new Line(line)
			lines.add(parsedLine)
		}
	}
	
	private void initializeParser() {
		lines = []
	}

	private readLines(String input) {
		return input.split(ENDLINE)
	}
}