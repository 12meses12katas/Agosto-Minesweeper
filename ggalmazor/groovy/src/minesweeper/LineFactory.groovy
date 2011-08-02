package minesweeper

class LineFactory {
	static minesweeper.Line create(contents) {
		if (contents.contains(DimensionsLine.DIMENSIONS_SEPARATOR))
			return new DimensionsLine(contents)
		return new TilesLine(contents)
	}
}
