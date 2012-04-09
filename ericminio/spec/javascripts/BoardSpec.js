describe("Board", function() {

	var renderer = new Board();
	
	describe("table", function() {
		beforeEach(function(){
			renderer.createBoard();
		});
		afterEach(function() {
			renderer.removeBoard();
		});
		it("has visible cells", function() {
			expect(element("board").border).toEqual('1');
		});
		it ("has simple borders", function() {
			expect(element("board").cellPadding).toEqual('0');
			expect(element("board").cellSpacing).toEqual('0');	
		})
		it("leaves room in the cells", function() {
			renderer.render(new Field(["."]));
			expect(element("cell00").width).toEqual('50');
		})
		it("centers the cell content", function() {
			renderer.render(new Field(["."]));
			expect(element("cell00").align).toEqual('center');
		});
	});
	
	describe("rendering", function() {
		afterEach(function() {
			renderer.removeBoard();
		});
		it("can display a complete blind field", function() {
			renderer.render(new Field(["..", ".."]));
			expect(element("cell00").innerHTML).toContain("click");
			expect(element("cell01").innerHTML).toContain("click");
			expect(element("cell10").innerHTML).toContain("click");
			expect(element("cell11").innerHTML).toContain("click");	
		});
		it("gives the player a way to play", function() {
			renderer.render(new Field(["*."]));
			expect(element("cell00").innerHTML).toEqual("<a href=\"javascript:game.play(0, 0)\">click</a>");
		})
		it("can update content", function() {
			renderer.render(new Field([".."]));
			renderer.assignContent("toto", 0, 0);
			expect(renderer.contentAt(0, 0)).toEqual("toto");
		});
	});
});