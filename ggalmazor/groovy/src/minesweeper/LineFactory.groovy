package minesweeper

class LineFactory {
    static minesweeper.Line create(contents) {
        if (isADimensionsLine(contents))
            return new DimensionsLine(contents)
        return new TilesLine(contents)
    }

    static isADimensionsLine(contents) {
        contents.contains DimensionsLine.DIMENSIONS_SEPARATOR
    }
}
