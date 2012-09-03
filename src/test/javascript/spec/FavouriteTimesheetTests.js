
describe("Favourite Timesheet", function() {

    it("should be able to identify duplicated favorite name", function() {
        var favorite = new FavoriteTimesheet();
        favorite.addExistingFavoriteName("TWU");

        expect(favorite.isDuplicated("TWU")).toEqual(true);
    });

    it("should not accept duplicate name plus space", function() {
        var favorite = new FavoriteTimesheet();
        favorite.addExistingFavoriteName("TWU");

        expect(favorite.isDuplicated("TWU ")).toEqual(false);
    });
});


