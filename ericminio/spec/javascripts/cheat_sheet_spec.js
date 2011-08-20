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