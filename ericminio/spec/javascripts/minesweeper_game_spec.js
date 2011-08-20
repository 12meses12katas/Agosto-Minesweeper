describe("Game", function() {

    var game;

    beforeEach(function() {
        var board = document.createElement("table");
        board.id = "board";
        document.body.appendChild(board);
        var status = document.createElement("span");
        status.id = "status";
        document.body.appendChild(status);

        var field = new Field(["*.", ".*"]);
        var mineSweeper = new MineSweeper();

        game = new MineSweeperGame();
        game.use(mineSweeper);
        game.present(field);
    });

    afterEach(function() {
        var status = document.getElementById("status");
        status.parentNode.removeChild(status);
        var board = document.getElementById("board");
        board.parentNode.removeChild(board);
    });


    describe("The kata feature", function() {

        it("can show all detections", function() {
            game.showAll();
            expect(FieldRenderer.contentOf(0, 0)).toEqual("*");
            expect(FieldRenderer.contentOf(0, 1)).toEqual("2");
            expect(FieldRenderer.contentOf(1, 0)).toEqual("2");
            expect(FieldRenderer.contentOf(1, 1)).toEqual("*");
        })
    });

    describe("User interactions", function() {

        it("playing reveals the content", function() {
            game.play(0, 1);
            expect(FieldRenderer.contentOf(0, 1)).toEqual("2");
        });

        it("user looses when playing on a bomb", function() {
            game.play(0, 0);
            expect($("status").innerHTML).toEqual("You loose");
        });

        it("user wins when only bombs remain hidden", function() {
            game.play(0, 1);
            expect($("status").innerHTML).toEqual("");
            game.play(1, 0);
            expect($("status").innerHTML).toEqual("You win :)");
        });

    });

    describe("Status", function() {

        it("starts with empty", function() {
            expect($("status").innerHTML).toEqual("");
        });

        it("comes back to empty with a new field", function() {
            $("status").innerHTML = "toto";
            game.present(new Field(["*"]));
            expect($("status").innerHTML).toEqual("");
        });
    });
});