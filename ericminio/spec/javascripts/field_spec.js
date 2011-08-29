describe("Field", function() {

    var field;

    beforeEach(function() {
        field = new Field(["**.", ".*."]);
    });

    it("gives access to line count", function() {
        expect(field.lineCount()).toEqual(2);
    });

    it("gives access to column count", function() {
        expect(field.columnCount()).toEqual(3);
    });

    it("can access content", function() {
        expect(field.contentAt(0, 0)).toEqual("*");
        expect(field.contentAt(0, 1)).toEqual("*");
        expect(field.contentAt(0, 2)).toEqual(".");
        expect(field.contentAt(1, 0)).toEqual(".");
        expect(field.contentAt(1, 1)).toEqual("*");
        expect(field.contentAt(1, 2)).toEqual(".");
    });

    it("can access content", function() {
        expect(field.contentAt(-1, 0)).toEqual(undefined);
        expect(field.contentAt(-1, -1)).toEqual(undefined);
    });


});