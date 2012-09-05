
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

  /*  it("should get messages",function(){

        spyOn(window, "$").andReturn($("<li></li>"));

        var activity = new Activity();
        var messages = activity.getMessages();

        expect(messages.length).toEqual(2);
    });
        */

});
