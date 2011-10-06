class BoardConfiguration {

	public static final String SPACE = ' '
	
	public static final Integer HEIGHT_POSITION = 0
	public static final Integer WIDTH_POSITION = 1

	Integer height
	Integer width

	private header
	
	public BoardConfiguration(String input) {
 		this.header = input.split(SPACE)
		parseHeight()
		parseWidth()
	}
	
	public Boolean lastBoard() {
		return (height == 0 && width == 0)
	}
	
	private Boolean valid(Integer line, Integer place) {
		if (!validLine(line)) {
			return false
		}
		return place >= 0 && place < width
	}

	private Boolean validLine(Integer line) {
		return line >= 0 && line < height
	}	

	private void parseHeight() {
		this.height = Integer.valueOf(header[HEIGHT_POSITION])
	}

	private void parseWidth() {
		this.width = Integer.valueOf(header[WIDTH_POSITION])
	}
}