function Game() {
};

Game.prototype.renderWith = function(renderer) {
	this.renderer = renderer;
}

Game.prototype.playWith = function(field) {
	this.field = field;
};

Game.prototype.start = function() {
	this.renderer.render(this.field);
};

Game.prototype.play = function(line, column) {
	var threat = this.revealThreatAt(line, column);
	if (threat == '*') {
		this.revealAllThreats();
	}
}

Game.prototype.revealAllThreats = function() {
	for (var line=0; line<this.field.lineCount(); line ++) {
		for (var column=0; column<this.field.columnCount(); column++) {
			this.revealThreatAt(line, column);
		}
	}
}

Game.prototype.revealThreatAt = function(line, column) {
	var threat = this.threatAt(line, column);
	this.renderer.assignContent(threat, line, column);
	return threat;
}

Game.prototype.threatAt = function(line, column) {
	var threat = '*';
	if (this.field.contentAt(line, column) == '.') {
		threat = 0;
		var arround = [ [0,1], [0,-1], [-1,0], [-1,-1], [-1,1], [1,-1], [1,0], [1,1] ];
		for (var i=0; i<arround.length; i++) {
			if (this.field.contentAt(line+arround[i][0], column+arround[i][1]) == '*') {
				threat ++;
			}
		}
	}
	return threat;
}
