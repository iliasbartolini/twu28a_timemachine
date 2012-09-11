function TimeRecord() {
    this.validateHours = function (hours) {

        var totalHours = 0,
            hour = 0;

        for(var i = 0; i < hours.length; i++) {

            hour = isNaN(parseFloat(hours[i])) ? 0 : parseFloat(hours[i]);
            totalHours += hour;
        }

        console.log("Total Hours => " + totalHours);

        if( totalHours == 0){
            throw new Error(Messages.HoursCannotBeZero);
        }

        if ( totalHours < 40 ) {
            throw new Error(Messages.HoursLessThan40);
        }
    };
}