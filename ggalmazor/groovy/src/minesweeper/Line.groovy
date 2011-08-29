package minesweeper

interface Line {
    static EOF_DEFINITION = "0 0"

    def visit(field)
    def isEOF()
}