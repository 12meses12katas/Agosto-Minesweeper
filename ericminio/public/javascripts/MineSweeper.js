function MineSweeper() {
}

MineSweeper.prototype.inspect = function(field) {
    this.field = field;
};

MineSweeper.prototype.surroundingContentOf = function(line, column) {
    var threat = [];
    threat.push(this.field.contentAt(line - 1, column - 1));
    threat.push(this.field.contentAt(line - 1, column));
    threat.push(this.field.contentAt(line - 1, column + 1));
    threat.push(this.field.contentAt(line, column - 1));
    threat.push(this.field.contentAt(line, column + 1));
    threat.push(this.field.contentAt(line + 1, column - 1));
    threat.push(this.field.contentAt(line + 1, column));
    threat.push(this.field.contentAt(line + 1, column + 1));
    return threat;
};

MineSweeper.prototype.threatAt = function(line, column) {
    if (this.field.contentAt(line, column) == '.') {
        var threat = this.surroundingContentOf(line, column);
        var count = 0;
        for (var i = 0; i < threat.length; i++) {
            if (threat[i] == '*') {
                count ++;
            }
        }
        return new String(count);
    }
    return '*';
};

MineSweeper.prototype.bombCount = function() {
    var count = 0;
    for (var line = 0; line < this.field.lineCount(); line++) {
        for (var column = 0; column < this.field.columnCount(); column++) {
            if (this.field.contentAt(line, column) == '*') {
                count ++;
            }
        }
    }
    return count;
};