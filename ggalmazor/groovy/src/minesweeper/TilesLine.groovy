package minesweeper

class TilesLine extends BaseLine {
	TilesLine(contents) {
		this.contents = contents
	}

	void visit(Field field) {
		contents.each { tile -> field.addTile tile }
	}
}
