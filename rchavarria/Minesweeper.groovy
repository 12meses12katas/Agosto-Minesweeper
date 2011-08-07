
class Minesweeper {
    
    def play(def field){
        if(field.size == 1) return translate(field[0])
        
        def result = field.clone()
        
        field.eachWithIndex { line, i -> 
            line.eachWithIndex { square, j -> 
                result[i][j] = countAdjacentMines(field, i, j)
            }
        }
        field
    }
    
    private translate(def square){
        square == "*" ? ["*"]: ["0"]
    }
    
    private countAdjacentMines(def field, def row, def column){
        def mines = minesInSquare(field, row, column)
        if(mines) return "*"
        
        def adjacentMines = 0
        
        def rowRange = ((row-1)..(row+1))
        rowRange.each { adjacentMines += countRow(field, it, column) }
        adjacentMines -= mines
        
        adjacentMines.toString()
    }
    
    private minesInSquare(def field, def row, def column){
        def squareValue = translate(field[row][column])[0]
        return (squareValue == "*") ? 1 : 0
    }
    
    private countRow(def field, def row, def column){
        def validRow = (row >= 0 && row < field.size)
        if(!validRow) return 0
        
        def minesInRow = 0
        def columnRange = ((column-1)..(column+1))
        columnRange.each { minesInRow += countRowColumn(field, row, it) }
        
        minesInRow
    }
    
    private countRowColumn(def field, def row, def column){
        def columns = field[0].size
        def validColumn = (column >= 0 && column < columns)
        validColumn ? minesInSquare(field, row, column) : 0
    }
}
