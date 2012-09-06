
describe("Search Activity", function() {

    it("should process activities", function() {
        var searchCriteria = "TWU";
        var activity = new Activity();

        spyOn($,"ajax").andCallFake(function(params){
            params.success("[1,2,3]");
        });

        activity.search(searchCriteria,function(activities){
            expect(activities.length).toEqual(3);
        });

    });

    it("should throw an exception for search criteria less than 2 chars",function(){
        var searchCriteria ="T";
        var activity = new Activity();

        expect(function() { activity.search(searchCriteria) }).toThrow();

    });


    it("should throw an exception when no matching activity is found",function(){
        var searchCriteria ="gfvgfjff";
        var activity = new Activity();
        activity.search(searchCriteria,function(activities){
            expect(activities.length).toEqual(0);
        });


    });


});

