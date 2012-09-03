describe("New Timesheet", function () {

    it("should check if the country is selected as USA", function () {
        var testStateChange=new NewTimesheetState();
        var returnValue=testStateChange.isNotUSA("USA");
        expect(returnValue).toEqual(false);

    });

    it("should return true if the country selected is not USA", function(){
        var testStateChange=new NewTimesheetState();
        var returnValue=testStateChange.isNotUSA("IND");
        expect(returnValue).toEqual(true);
    });

});