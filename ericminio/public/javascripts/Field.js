function Field(content) {
    this.content = content;
}

Field.prototype.lineCount = function() {
    return this.content.length;
};

Field.prototype.columnCount = function() {
    return this.content[0].length;
};

Field.prototype.contentAt = function(line, column) {
    var safeRow = this.content[line] == undefined ? [] : this.content[line];
    return safeRow[column];
};







