package minesweeper

interface Line {
	public static EOF_DEFINITION = "0 0"
	void visit(Field field)

	boolean isEOF()
}