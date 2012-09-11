$(function () {
    var activityCode = $.cookie("activity_code");

    if (activityCode) {
        $("#header").children("h3").text(activityCode);
        $.removeCookie('activity_code');
    } else {
        $("#header").children("h3").text("New Time Record");
    }
});

$.validator.addMethod("valueNotEquals",
    function (value, element, arg) {
        return arg != value;
    }, "Value must not equal arg.");

$('#index').live("pageinit", function () {
    $('#new_timesheet_form').validate({
        rules:{
            country:{
                valueNotEquals:"Select a country"
            },
            state:{
                valueNotEquals: "Select a state"
            },
            monday:{
                digits:true,
                max:24
            },
            tuesday:{
                digits:true,
                max:24
            },
            wednesday:{
                digits:true,
                max:24
            },
            thursday:{
                digits:true,
                max:24
            },
            friday:{
                digits:true,
                max:24
            },
            saturday:{
                digits:true,
                max:24
            },
            sunday:{
                digits:true,
                max:24
            },
            task:{
                required:true
            }
        },
        messages:{
            country: "Country is required.",
            state: "State is required",
            monday:{
                digits:"Enter a number",
                max:"Enter a value less than or equal to 24"
            },
            tuesday:{
                digits:"Enter a number",
                max:"Enter a value less than or equal to 24"
            },
            wednesday:{
                digits:"Enter a number",
                max:"Enter a value less than or equal to 24"
            },
            thursday:{
                digits:"Enter a number",
                max:"Enter a value less than or equal to 24"
            },
            friday:{
                digits:"Enter a number",
                max:"Enter a value less than or equal to 24"
            },
            saturday:{
                digits:"Enter a number",
                max:"Enter a value less than or equal to 24"
            },
            sunday:{
                digits:"Enter a number",
                max:"Enter a value less than or equal to 24"
            },
            task:{
                required: Messages.getMessage(Messages.TaskCommentCannotBeUnspecified)
            }
        },
        errorPlacement:function (error, element) {
            $(".colorError[for=" + $(element).attr("name") + "]").html(error);
        },
        submitHandler : function(form) {

            var hours = [];
            $(".hour").each(function () {
                hours.push($(this).val());
            });

            try {
                var timeRecord = new TimeRecord();
                timeRecord.validateHours(hours);

                form.submit();
            } catch (err) {

                if ( err.message == Messages.HoursLessThan40 ) {
                    var response = confirm(Messages.getMessage(Messages.HoursLessThan40));

                    if (response) {
                        console.log("YES, I want to submit less than 40 hours");
                        form.submit();
                    }
                    else {
                        console.log("NO, I don't want to submit less than 40 hours");
                    }
                }

                if ( err.message == Messages.HoursCannotBeZero ) {
                    alert(Messages.getMessage(Messages.HoursCannotBeZero));
                }
            }
        }
    });
    $('#state').selectmenu('disable');
    var changeState = new NewTimesheetState();
    changeState.toggleStateList();

    $(".select1").change(function () {
        changeState.toggleStateList();
    });
});