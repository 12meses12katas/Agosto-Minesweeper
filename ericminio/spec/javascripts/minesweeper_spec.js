describe("MineSweeper", function() {

    var mineSweeper;

    beforeEach(function() {
        mineSweeper = new MineSweeper();
    });

    it("detects one mine", function() {
        mineSweeper.inspect(new Field(["*"]));
        expect(mineSweeper.threatAt(0, 0)).toEqual("*");
    });

    it("detects one mine proximity", function() {
        mineSweeper.inspect(new Field([".*"]));
        expect(mineSweeper.threatAt(0, 0)).toEqual("1");
    });

    it("detects two mines proximity", function() {
        mineSweeper.inspect(new Field(["*.*"]));
        expect(mineSweeper.threatAt(0, 1)).toEqual("2");
    });

    it("detects when there is no mine", function() {
        mineSweeper.inspect(new Field(["."]));
        expect(mineSweeper.threatAt(0, 0)).toEqual("0");
    });

    it("detects mine proximity with two rows", function() {
        mineSweeper.inspect(new Field([".", "*"]));
        expect(mineSweeper.threatAt(0, 0)).toEqual("1");
    });

    it("detect with more complicated cases", function() {
        mineSweeper.inspect(new Field(["**...", ".....", ".*..."]));
        expect(mineSweeper.threatAt(1, 0)).toEqual("3");
        expect(mineSweeper.threatAt(1, 1)).toEqual("3");
        expect(mineSweeper.threatAt(1, 2)).toEqual("2");
        expect(mineSweeper.threatAt(1, 3)).toEqual("0");
        expect(mineSweeper.threatAt(1, 4)).toEqual("0");
    });

    it("can calculate the bomb count", function() {
        mineSweeper.inspect(new Field(["**...", "....."]));
        expect(mineSweeper.bombCount()).toEqual(2);
    });



});



