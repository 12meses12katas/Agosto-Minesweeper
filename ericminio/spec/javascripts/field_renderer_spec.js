describe("FieldRenderer", function() {

    beforeEach(function() {
        var board = document.createElement("table");
        board.id = "board";
        document.body.appendChild(board);

        FieldRenderer.renderField(new Field(["*.", ".*"]));
    });

    afterEach(function() {
        var board = document.getElementById("board");
        board.parentNode.removeChild(board);
    });


    it("offers a way to play", function() {
        expect($("cell00").innerHTML).toEqual("<a href=\"javascript:game.play(0, 0)\">click</a>");
        expect($("cell10").innerHTML).toEqual("<a href=\"javascript:game.play(1, 0)\">click</a>");
        expect($("cell01").innerHTML).toEqual("<a href=\"javascript:game.play(0, 1)\">click</a>");
        expect($("cell11").innerHTML).toEqual("<a href=\"javascript:game.play(1, 1)\">click</a>");
    });

    it("leaves room for user interaction", function() {
        expect($("cell00").width).toEqual("50");
        expect($("cell00").align).toEqual("center");
    });

    it("offers utility access to cell content", function() {
        FieldRenderer.updateCell(0, 0, "toto");
        expect(FieldRenderer.contentOf(0, 0)).toEqual("toto");
    });

    it("can count hidden cells", function() {
        expect(FieldRenderer.hiddenCellCount()).toEqual(4);
        FieldRenderer.updateCell(0, 0, "toto");
        expect(FieldRenderer.hiddenCellCount()).toEqual(3);
    });


});