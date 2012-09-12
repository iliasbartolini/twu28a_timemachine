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
        var hours = [39.99, 0, 0, 0, 0, 0, 0];

        var timeRecord = new TimeRecord();

        expect(function() { timeRecord.validateHours(hours); }).toThrow(Messages.HoursLessThan40);
    });

    it("should not throw exception if greater than 40",function() {
        var hours = [20, 20, 0, 0, 0, 0, 0];

        var timeRecord = new TimeRecord();

        expect(function() { timeRecord.validateHours(hours); }).not.toThrow();
    });

    it("should not accept zero hours",function() {
        var hours = [0, 0, 0, 0, 0, 0, 0];

        var timeRecord = new TimeRecord();
        expect(function() { timeRecord.validateHours(hours); }).toThrow(Messages.HoursCannotBeZero);
    });



});