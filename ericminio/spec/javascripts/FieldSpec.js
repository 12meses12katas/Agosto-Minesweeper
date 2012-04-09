describe("Field", function(){
	it("gives access to line count", function(){
		expect(new Field(["."]).lineCount()).toEqual(1);
		expect(new Field([".", "*"]).lineCount()).toEqual(2);
	});
	it("gives access to column count", function(){
		expect(new Field(["."]).columnCount()).toEqual(1);
		expect(new Field([".."]).columnCount()).toEqual(2);
	});
	it("gives access to the content", function() {
		expect(new Field(["A"]).contentAt(0, 0)).toEqual('A');
		expect(new Field(["A"]).contentAt(-1, 0)).toEqual(undefined);
	});
});
