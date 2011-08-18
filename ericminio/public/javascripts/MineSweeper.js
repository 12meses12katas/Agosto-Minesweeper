function MineSweeper(content) {
    if (content instanceof Array) {
        this.field = content;
    }
    else {
        this.field = [content];
    }
}

MineSweeper.prototype.lineCount = function() {
    return this.field.length;
}

MineSweeper.prototype.row = function(number) {
    return this.field[number];
}

MineSweeper.prototype.contentAt = function(line, column) {
    var safeLine = this.row(line) == undefined ? [] : this.row(line);
    return safeLine[column];
}

MineSweeper.prototype.bombCount = function() {
    var count = 0;
    for (var line = 0; line < this.lineCount(); line++) {
        for (var column = 0; column < this.row(line).length; column++) {
            if (this.contentAt(line, column) == '*') {
                count ++;
            }
        }
    }
    return count;
}

MineSweeper.prototype.threatAt = function(line, column) {
    if (this.contentAt(line, column) == '.') {
        var count = 0;
        if (this.contentAt(line - 1, column) == '*') {
            count ++;
        }
        if (this.contentAt(line - 1, column + 1) == '*') {
            count ++;
        }
        if (this.contentAt(line - 1, column - 1) == '*') {
            count ++;
        }
        if (this.contentAt(line, column + 1) == '*') {
            count ++;
        }
        if (this.contentAt(line, column - 1) == '*') {
            count ++;
        }
        if (this.contentAt(line + 1, column + 1) == '*') {
            count ++;
        }
        if (this.contentAt(line + 1, column - 1) == '*') {
            count ++;
        }
        if (this.contentAt(line + 1, column) == '*') {
            count ++;
        }
        return new String(count);
    }
    return '*';
}

MineSweeper.prototype.render = function() {
    var table = $("board");
    for (var i = 0; i < table.rows.length; i++) {
        table.deleteRow(0);
    }

    for (var line = 0; line < this.lineCount(); line++) {
        var tr = table.insertRow(-1);
        for (var column = 0; column < this.row(line).length; column++) {
            var td = tr.insertCell(column);
            td.id = "cell" + line + column;
            td.width = "50";
            td.align = "center";
            td.innerHTML = "<a id=play" + line + column + " href='javascript:mineSweeper.play(" + line + ", " + column + ")'>click</a>";
        }
    }
}

MineSweeper.prototype.revealThreatAt = function(line, column) {
    var detected = this.threatAt(line, column);
    var cell = $("cell" + line + column);
    cell.innerHTML = detected;
    return detected;
}

MineSweeper.prototype.show = function() {
    for (var line = 0; line < this.lineCount(); line++) {
        for (var column = 0; column < this.row(line).length; column++) {
            this.revealThreatAt(line, column);
        }
    }
}

MineSweeper.prototype.play = function(line, column) {
    var detected = this.revealThreatAt(line, column);

    if (this.hiddenCellCount() == this.bombCount()) {
        $("status").innerHTML = "You win :)";
    }

    if (detected == '*') {
        $("status").innerHTML = "You loose";
    }
}


MineSweeper.prototype.hiddenCellCount = function() {
    var count = 0;
    for (var line = 0; line < this.lineCount(); line++) {
        for (var column = 0; column < this.row(line).length; column++) {
            var cell = $("cell" + line + column);
            if (cell.innerHTML.indexOf("click") != -1) {
                count ++;
            }
        }
    }
    return count;
}

