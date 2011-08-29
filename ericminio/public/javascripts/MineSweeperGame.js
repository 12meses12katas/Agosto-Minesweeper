function MineSweeperGame() {
}

MineSweeperGame.prototype.use = function(mineSweeper) {
    this.mineSweeper = mineSweeper;
};

MineSweeperGame.prototype.present = function(field) {
    this.field = field;
    FieldRenderer.renderField(field);
    this.mineSweeper.inspect(field);
    $("status").innerHTML = "";
};

MineSweeperGame.prototype.showAll = function() {
    for (var line = 0; line < this.field.lineCount(); line++) {
        for (var column = 0; column < this.field.columnCount(); column++) {
            FieldRenderer.updateCell(line, column, this.mineSweeper.threatAt(line, column));
        }
    }
};

MineSweeperGame.prototype.play = function(line, column) {
    var threat = this.mineSweeper.threatAt(line, column);
    FieldRenderer.updateCell(line, column, threat);

    if (FieldRenderer.hiddenCellCount() == this.mineSweeper.bombCount()) {
        $("status").innerHTML = "You win :)";
    }

    if (threat == '*') {
        $("status").innerHTML = "You loose";
    }
};