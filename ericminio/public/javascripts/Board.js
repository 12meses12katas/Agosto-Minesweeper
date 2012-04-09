function Board() {
};

Board.prototype.removeBoard = function() {
	var table = element("board");
	table.parentNode.removeChild(table);
}

Board.prototype.createBoard = function() {
	var board = document.createElement("table");
	board.id = "board";
	board.border = '1';
	board.cellSpacing = '0';
	board.cellPadding = '0';
	document.body.appendChild(board);
};

Board.prototype.render = function(field) {
	this.createBoard();
	var table = element("board");
	for (var line=0; line<field.lineCount(); line ++) {
		var tr = table.insertRow(-1);
		for (var column=0; column<field.columnCount(); column++) {
			var td = tr.insertCell(column);
			td.id = "cell" + line + column;
			td.width = '50'
			td.align = 'center';
			td.innerHTML = "<a href=\"javascript:game.play(" + line + ", " + column + ")\" >click</a>";
		}
	}
};

Board.prototype.assignContent = function(content, line, column) {
	element("cell"+line+column).innerHTML = content;
};

Board.prototype.contentAt = function(line, column) {
	return element("cell"+line+column).innerHTML;
};