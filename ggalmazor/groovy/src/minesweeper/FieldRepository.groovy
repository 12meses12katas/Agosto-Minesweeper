package minesweeper

class FieldRepository {
    static fields = []

    static createField() {
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

    static getAll() {
        return fields
    }
}
