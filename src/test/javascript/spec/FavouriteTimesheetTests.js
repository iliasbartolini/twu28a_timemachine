
describe("Favourite Timesheet", function() {

    it("should be able to identify duplicated favorite name", function() {
        var favorite = new FavoriteTimesheet();
        favorite.addExistingFavoriteName("TWU");

        expect(favorite.isNotDuplicated("TWU")).toEqual(false);
    });

});


