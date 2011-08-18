describe("Learning javascript", function() {

    describe("arrays", function() {

        it("detection", function() {
            expect(1 instanceof Array).toBe(false);
            expect([1] instanceof Array).toBe(true);
        });
        it("elements", function() {
            expect(["1"][0]).toEqual("1");
            expect(["1"][1]).toEqual(undefined);
            expect(["1"][-1]).toEqual(undefined);
            expect(["1", 2][1]).toEqual(2);
            expect([][0]).toEqual(undefined);
            expect([][-1]).toEqual(undefined);
        });
        it("size", function() {
            expect(["1", "2"].length).toEqual(2);
            expect(["1", "2"].size()).toEqual(2);
        });
    });
});

describe("MineSweeper", function() {

    describe("Internal representation", function() {

        it("accept an array as input", function() {
            var mineSweeper = new MineSweeper(["*"]);
            expect(mineSweeper.row(0)).toEqual("*");
        });

        it("accept a multi-line field", function() {
            var field = ["**...", ".....", ".*..."];
            var mineSweeper = new MineSweeper(field);
            expect(mineSweeper.contentAt(1, 0)).toEqual(".");
            expect(mineSweeper.contentAt(1, 1)).toEqual(".");
            expect(mineSweeper.contentAt(1, 2)).toEqual(".");
            expect(mineSweeper.contentAt(1, 3)).toEqual(".");
            expect(mineSweeper.contentAt(1, 4)).toEqual(".");
        });

        it("gives access to line count", function() {
            var field = ["**...", ".....", ".*..."];
            var mineSweeper = new MineSweeper(field);
            expect(mineSweeper.lineCount()).toEqual(3);
        });

        it("knows the bomb count", function() {
            var field = ["**...", ".....", ".*..."];
            var mineSweeper = new MineSweeper(field);
            expect(mineSweeper.bombCount()).toEqual(3);
        });
    });

    describe("Threat detection", function() {

        it("detects one mine", function() {
            var mineSweeper = new MineSweeper(["*"]);
            expect(mineSweeper.threatAt(0, 0)).toEqual("*");
        });

        it("detects one mine proximity", function() {
            var mineSweeper = new MineSweeper([".*"]);
            expect(mineSweeper.threatAt(0, 0)).toEqual("1");
        });

        it("detects two mines proximity", function() {
            var mineSweeper = new MineSweeper(["*.*"]);
            expect(mineSweeper.threatAt(0, 1)).toEqual("2");
        });

        it("detects when there is no mine", function() {
            var mineSweeper = new MineSweeper(["."]);
            expect(mineSweeper.threatAt(0, 0)).toEqual("0");
        });

        it("detects mine proximity with two rows", function() {
            var mineSweeper = new MineSweeper([".", "*"]);
            expect(mineSweeper.threatAt(0, 0)).toEqual("1");
        });

        it("deals well with more complicated cases", function() {
            var field = ["**...", ".....", ".*..."];
            var mineSweeper = new MineSweeper(field);
            expect(mineSweeper.threatAt(1, 0)).toEqual("3");
            expect(mineSweeper.threatAt(1, 1)).toEqual("3");
            expect(mineSweeper.threatAt(1, 2)).toEqual("2");
            expect(mineSweeper.threatAt(1, 3)).toEqual("0");
            expect(mineSweeper.threatAt(1, 4)).toEqual("0");
        });
    });

    describe("Rendering", function() {
        var mineSweeper;

        beforeEach(function() {
            var board = document.createElement("table");
            board.id = "board";
            document.body.appendChild(board);
            var status = document.createElement("span");
            status.id = "status";
            document.body.appendChild(status);

            mineSweeper = new MineSweeper(["*.", ".*"]);
            mineSweeper.render();
        });

        afterEach(function() {
            var status = document.getElementById("status");
            status.parentNode.removeChild(status);
            var board = document.getElementById("board");
            board.parentNode.removeChild(board);
        });

        describe("The field", function() {

            it("renders the field", function() {
                expect($("play00").innerHTML).toEqual("click");
                expect($("play01").innerHTML).toEqual("click");
                expect($("play10").innerHTML).toEqual("click");
                expect($("play11").innerHTML).toEqual("click");
            });

            it("leaves room for user interaction", function() {
                expect($("cell00").width).toEqual("50");
                expect($("cell00").align).toEqual("center");
            });
        });

        describe("The kata feature", function() {

            it("can show all detection", function() {
                mineSweeper.show();
                expect($("cell00").innerHTML).toEqual("*");
                expect($("cell01").innerHTML).toEqual("2");
                expect($("cell10").innerHTML).toEqual("2");
                expect($("cell11").innerHTML).toEqual("*");
            })
        });

        describe("User interactions", function() {

            it("bombs are hidden", function() {
                expect(mineSweeper.hiddenCellCount()).toEqual(4);
            });

            it("user can play each cell", function() {
                expect($("play01").href).toContain("mineSweeper.play(0, 1)");
            });

            it("playing reveals the content", function() {
                mineSweeper.play(0, 1);
                expect($("cell01").innerHTML).toEqual("2");
            });

            it("user looses when playing on a bomb", function() {
                mineSweeper.play(0, 0);
                expect($("status").innerHTML).toEqual("You loose");
            });

            it("user wins when only bombs remain hidden", function() {
                mineSweeper.play(0, 1);
                expect($("status").innerHTML).toEqual("");
                mineSweeper.play(1, 0);
                expect($("status").innerHTML).toEqual("You win :)");
            });
        });
    });

});



