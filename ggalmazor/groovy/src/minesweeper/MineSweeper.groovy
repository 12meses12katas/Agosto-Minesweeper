package minesweeper

class MineSweeper {
    def solve(input) {
        def lines = parseLines(input)
        createFieldsWith(lines)
        revealAllFields()
    }

    def parseLines(input) {
        input.collect { LineFactory.create(it) }
    }

    def createFieldsWith(lines) {
        def field
        for (line in lines) {
            if (line.isEOF())
                break
            if (line instanceof DimensionsLine)
                field = FieldRepository.createField()
            line.visit field
        }
    }

    def revealAllFields() {
        FieldRepository.all.each { field -> field.reveal() }
    }

    def renderSolutions() {
        def number = 1
        return FieldRepository.all.inject("") { solution, field ->
            solution += "Field #${number++}:\n${field.render()}\n"
        }
    }
}
