describe("New Timesheet", function () {

    it("should check if the country is selected as USA", function () {
        var testStateChange=new NewTimesheetState();
        var returnValue=testStateChange.isNotUSA("USA - USA");
        expect(returnValue).toEqual(false);

    });

    it("should return true if the country selected is not USA", function(){
        var testStateChange=new NewTimesheetState();
        var returnValue=testStateChange.isNotUSA("IND");
        expect(returnValue).toEqual(true);
    });

    it("should ask for confirmation when total hours is less than 40",function() {
        var hours = [0, 0, 0, 0, 0, 0, 0];

        var timeRecord = new TimeRecord();

        expect(function() { timeRecord.validateHours(hours); }).toThrow();
    });
});