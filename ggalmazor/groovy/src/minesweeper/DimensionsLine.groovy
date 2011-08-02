package minesweeper

class DimensionsLine extends BaseLine {
	static final DIMENSIONS_SEPARATOR = " "

	DimensionsLine(contents) {
		this.contents = contents
	}

	void visit(Field field) {
		def space = contents.indexOf(DIMENSIONS_SEPARATOR)
		field.setWidth contents[space + 1..-1].toInteger()
		field.setHeight contents[0..space - 1].toInteger()
	}
}
