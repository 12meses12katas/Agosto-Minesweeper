package minesweeper

class DimensionsLine extends BaseLine {
	static final DIMENSIONS_SEPARATOR = " "

	DimensionsLine(contents) {
		this.contents = contents
	}

	def visit(field) {
		def space = contents.indexOf(DIMENSIONS_SEPARATOR)
		field.setCols contents[space + 1..-1].toInteger()
		field.setRows contents[0..space - 1].toInteger()
	}
}
