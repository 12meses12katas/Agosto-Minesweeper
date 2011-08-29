package minesweeper

class Field {
    static final SAFE_TILE = "."
    static final MINE_TILE = "*"
    def cols, rows
    def tiles = []

    def addTile(tile) {
        tiles << tile
    }

    def reveal() {
        (0..rows - 1).each { revealRow it }
    }

    def revealRow(row) {
        (0..cols - 1).each { revealTileAt it, row }
    }

    def revealTileAt(col, row) {
        if (isSafeAt(col, row))
            setMinesNextTo col, row, countMinesAt(col, row)
    }

    def isSafeAt(col, row) {
        SAFE_TILE == getTileAtPosition(col, row)
    }

    def setMinesNextTo(col, row, mines) {
        tiles[getPosition(col, row)] = mines
    }

    def countMinesAt(col, row) {
        def mines = 0
        mines += isMineAt(col - 1, row - 1) ? 1 : 0
        mines += isMineAt(col, row - 1) ? 1 : 0
        mines += isMineAt(col + 1, row - 1) ? 1 : 0
        mines += isMineAt(col - 1, row) ? 1 : 0
        mines += isMineAt(col + 1, row) ? 1 : 0
        mines += isMineAt(col - 1, row + 1) ? 1 : 0
        mines += isMineAt(col, row + 1) ? 1 : 0
        mines += isMineAt(col + 1, row + 1) ? 1 : 0
        return mines
    }

    def isMineAt(col, row) {
        MINE_TILE == getTileAtPosition(col, row)
    }

    def getTileAtPosition(col, row) {
        if (isOutOfBounds(col, row))
            return null
        return tiles[getPosition(col, row)]
    }

    def isOutOfBounds(col, row) {
        return col < 0 || col >= cols || row < 0 || row >= rows
    }

    def getPosition(col, row) {
       return col + row * cols
    }

    def render() {
        return (0..rows - 1).inject("") { solution, row -> solution += "${renderRow(row)}\n" }
    }

    def renderRow(row) {
        return (0..cols - 1).inject("") { solution, col -> solution += getTileAtPosition(col, row) }
    }
}
