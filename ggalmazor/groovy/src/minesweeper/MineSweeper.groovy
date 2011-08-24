package minesweeper

class MineSweeper {
	void solve(input) {
		parseLines(input)
		revealFields()
	}

	void parseLines(ArrayList<String> input) {
		def field
		for (line in input.collect { LineFactory.create(it) }) {
			if (line.isEOF())
				break
			if (line instanceof DimensionsLine)
				field = FieldRepository.newField()
			line.visit(field)
		}
	}

	void revealFields() {
		FieldRepository.fields.eachWithIndex { field, number ->
			revealTiles(field)
		}
	}

	void revealTiles(Field field) {
		for (def y = 0; y < field.height; y++) {
			for (def x = 0; x < field.width; x++) {
				revealTile(x, y, field)
			}
		}
	}

	void revealTile(int x, int y, Field field) {
		if (field.isPositionSafe(x, y))
			field.setMinesAt(x, y, field.countMinesAt(x, y))
	}

	String getAllSolutions() {
		def solution = ""
		FieldRepository.fields.eachWithIndex { field, number ->
			solution += "Field #${number + 1}:\n"
			solution += getSolution(field)
			solution += "\n"
		}
		return solution
	}

	String getSolution(Field field) {
		String solution = ""
		for (def y = 0; y < field.height; y++) {
			for (def x = 0; x < field.width; x++) {
				solution += field.getTileAtPosition(x, y)
			}
			solution += "\n"
		}
		return solution
	}
}
