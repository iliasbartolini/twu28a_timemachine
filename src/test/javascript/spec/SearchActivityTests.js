
describe("Search Activity", function() {

    it("should process activities", function() {
        var searchCriteria = "TWU";
        var activity = new Activity();

        spyOn($,"ajax").andCallFake(function(params){
            params.success("[1,2,3]");
        });

        //spyOn($,"post").andReturn("[1,2,3]");

        activity.search(searchCriteria,function(activities){
            expect(activities.length).toEqual(3);
        });
    });

    /*it("should throw exception for search criteria <2 chars",function() {
        var searchCriteria = "ab" ;
        var activity = new Activity();
        expect(function() {
            activity.search(searchCriteria);
        }).toThrow("Enter atleast 2 characters");
    });  */
});
