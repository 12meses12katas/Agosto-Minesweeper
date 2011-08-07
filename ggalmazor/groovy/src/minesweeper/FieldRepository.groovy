package minesweeper

class FieldRepository {
	static fields = []

	static Field newField() {
		def field = new Field()
		fields << field
		return field
	}

	static getAt(index) {
		fields[index]
	}

	static reset() {
		fields = []
	}
}
