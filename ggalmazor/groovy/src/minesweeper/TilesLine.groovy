package minesweeper

class TilesLine extends BaseLine {
	TilesLine(contents) {
		this.contents = contents
	}

	def visit(field) {
		contents.each { tile -> field.addTile tile }
	}
}
