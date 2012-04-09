describe("Basics", function(){
	it("can launch Jasmine tests", function() {
		expect(true).toBe(true);
	});
	it("can create a Game", function(){
		var game = new Game();
		expect(game).toNotBe(null);
	});
});

describe("Game start", function() {

	var game = new Game();
	var field = new Field(["."]);
	var renderer = new Board();

	beforeEach(function(){
		game.playWith(field);
		game.renderWith(renderer);
	});
	afterEach(function() {
		renderer.removeBoard();
	});

	it("tells the renderer to display the field", function() {
		spyOn(renderer, 'render');		
		game.start();
		expect(renderer.render).toHaveBeenCalledWith(field);
	});
});

describe("Playing", function() {
	var game = new Game();
	var renderer = new Board();

	beforeEach(function(){
		game.renderWith(renderer);
	});
	afterEach(function() {
		renderer.removeBoard();
	});
	
	describe("with one line field", function() {
		beforeEach(function() {
			game.playWith(new Field(["*...*."]));
			game.start();
		});
		it("can reveal a bomb", function() {
			game.play(0, 0);
			expect(renderer.contentAt(0, 0)).toEqual('*');
		});
		it("can reveal a position with no threat", function() {
			game.play(0, 2);
			expect(renderer.contentAt(0, 2)).toEqual('0');
		})
		it("can reveal a one bomb threat from the left", function() {
			game.play(0, 3);
			expect(renderer.contentAt(0, 3)).toEqual('1');
		})
		it("can reveal a one bomb threat from the right", function() {
			game.play(0, 5);
			expect(renderer.contentAt(0, 5)).toEqual('1');
		})
	});
	
	describe("with multi line field", function() {
		beforeEach(function() {
			game.playWith(new Field(["***", "...", "...", "***"]));
			game.start();
		});
		it("can reveal the threats from the line above", function() {
			game.play(1, 1);
			expect(renderer.contentAt(1, 1)).toEqual('3');
		});
		it("can reveal the threats from the line below", function() {
			game.play(2, 1);
			expect(renderer.contentAt(2, 1)).toEqual('3');
		});
	});
	
	describe("and loosing", function() {
		beforeEach(function() {
			game.playWith(new Field(["*."]));
			game.start();
		});
		it("de-blind the field", function() {
			game.play(0, 0);
			expect(renderer.contentAt(0, 1)).toEqual('1');
		})
	});
});