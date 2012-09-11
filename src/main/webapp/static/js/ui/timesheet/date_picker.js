$('#index').live("pageinit", function () {

    console.log(Messages.getMessage(Messages.WeekCannotBeUnspecified));

    $("#newtimesheet").validate({
            rules: {
                weekEndingDate: {
                    required: true
                }
            },
            messages: {
                weekEndingDate: Messages.getMessage(Messages.WeekCannotBeUnspecified)
            },
            errorPlacement: function(error, element) {
                error.insertAfter("#datepickerdiv");
            }
        });
});
