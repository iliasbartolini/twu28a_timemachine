<!DOCTYPE html>
<#import "/spring.ftl" as spring />
<@spring.bind "timeRecordForm" />
<@spring.bind "countries" />
<@spring.bind "states" />
<head>
    <title>Test UI</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../static/css/base.css"/>
    <link rel="stylesheet" href="../static/css/jquery.mobile-1.2.0-alpha.1.min.css"/>
    <link rel="stylesheet" href="../static/css/mobiscroll-2.0.1.custom.min.css"/>

    <script type="text/javascript" src="../static/js/lib/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="../static/js/lib/mobiscroll-2.0.1.custom.min.js"></script>
    <script type="text/javascript" src="../static/js/lib/jquery.mobile-1.2.0-alpha.1.min.js"></script>
    <script type="text/javascript" src="../static/js/lib/jquery.form.js"></script>
    <script type="text/javascript" src="../static/js/lib/jquery.validate.min.js"></script>
    <script type="text/javascript" src="../static/js/lib/jquery.cookie.js"></script>
    <script type="text/javascript" src="../static/js/timesheet/new_timesheet_state.js"></script>
    <script type="text/javascript" src="../static/js/timesheet/time_record.js"></script>

    <script>
        $(function () {
            var activityCode = $.cookie("activity_code");

            if ( activityCode ) {
                $("#header").children("h3").text(activityCode);
                $.removeCookie('activity_code');
            } else {
                $("#header").children("h3").text("New Time Record");
            }
        });
    </script>
</head>
<body>

<div data-role="page" data-theme="a" id="index">

    <div data-role="header" id="header">
        <h3>New Time Record</h3>
    </div>

    <script type="text/javascript">
        $.validator.addMethod("valueNotEquals", function(value, element, arg){
            return arg != value;
        }, "Value must not equal arg.");
        $("#index").die("pageinit");
        $('#index').live("pageinit", function () {
            $('#new_timesheet_form').validate({
                        rules: {
                            country: {
                               valueNotEquals:"Select a country"
                            },
                            state: {
                                valueNotEquals:"Select a state"
                            } ,
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
                            }
                        },
                        messages: {
                            country: "Country is required.",
                            state:"State is required",
                            monday:{
                                digits: "Enter a number",
                                max: "Enter a value less than or equal to 24"
                            },
                            tuesday:{
                                digits: "Enter a number",
                                max: "Enter a value less than or equal to 24"
                            },
                            wednesday:{
                                digits: "Enter a number",
                                max: "Enter a value less than or equal to 24"
                            },
                            thursday:{
                                digits: "Enter a number",
                                max: "Enter a value less than or equal to 24"
                            },
                            friday:{
                                digits: "Enter a number",
                                max: "Enter a value less than or equal to 24"
                            },
                            saturday:{
                                digits: "Enter a number",
                                max: "Enter a value less than or equal to 24"
                            },
                            sunday:{
                                digits: "Enter a number",
                                max: "Enter a value less than or equal to 24"
                            }

                        },
                        errorPlacement: function(error, element) {
                            $(".colorError[for=" + $(element).attr("name") + "]").html(error);
                        }
                    });
            $('#state').selectmenu('disable');
            var changeState = new NewTimesheetState();
            changeState.toggleStateList();

            $(".select1").change(function () {
                changeState.toggleStateList();
            });

            $("#new_timesheet_form").submit(function() {

                var hours = [];
                $(".hour").each(function() {
                    hours.push($(this).val());
                });

                console.log(hours);

                try {
                    var timeRecord = new TimeRecord();
                    timeRecord.validateHours(hours);
                } catch(err) {

                    console.log(err);

                    var response = prompt("Do you really want to submit less than 40 hours? Why you don't work this week?");

                    if ( response ) {
                        alert("Are you sure?");
                    }
                    else {
                        alert("I'm afraid");
                    }
                }
            });
        });
    </script>


    <form id="new_timesheet_form" data-ajax="false" modelAttribute="favoriteTimesheetForm" action="" method="post"
          class="ui-body ui-body-a ui-corner-all">

    <@spring.formSingleSelect "timeRecordForm.country",countries, "class= select1" />
        <div for="country" class="colorError">
        <@spring.showErrors "<br>" />
        </div>
        <br>
    <@spring.formSingleSelect "timeRecordForm.state",states, "class=state" />
        <div for="state" class="colorError">
        <@spring.showErrors "<br>"/>
        </div>
        <br>

        <a href="search_activity" data-role="button" data-ajax="false">Select a activity code</a>
        <label>Billable?</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <select name="billable" data-role="slider">

            <option value="false">No</option>

            <option value="true">Yes</option>

        </select>


        <input type="text" name="task" placeholder="Type task" id="task" value=""/>

        <div class="ui-grid-d">
            <div class="ui-block-a">
                Mon
                <input type="text" class="hour" name="monday" id="monday" value=""/>
                <div for="monday" class="colorError"></div>
            </div>
            <div class="ui-block-b">
                Tues
                <input type="text" class="hour" name="tuesday" id="tuesday" value=""/>
                <div for="tuesday" class="colorError"></div>
            </div>
            <div class="ui-block-c">
                Weds
                <input type="text" class="hour" name="wednesday" id="wednesday" value=""/>
                <div for="wednesday" class="colorError"></div>
            </div>
            <div class="ui-block-d">
                Thur
                <input type="text" class="hour" name="thursday" id="thursday" value=""/>
                <div for="thursday" class="colorError"></div>
            </div>
            <div class="ui-block-e">
                Fri
                <input type="text" class="hour" name="friday" id="friday" value=""/>
                <div for="friday" class="colorError"></div>
            </div>
        </div>

        <div class="ui-grid-d">
            <div class="ui-block-a">
                Sat
                <input type="text" class="hour" name="saturday" id="saturday" value=""/>
                <div for="saturday" class="colorError"></div>
            </div>
            <div class="ui-block-b">
                Sun
                <input type="text" class="hour" name="sunday" id="sunday" value=""/>
                <div for="sunday" class="colorError"></div>
            </div>
        </div>
        <div class="ui-grid-a">
            <div class="ui-block-a">
                <input type="submit" data-role="button" value="Submit" data-ajax="false"/>
             </div>
            <div class="ui-block-b">
                <input type="button" data-role="button" value="Cancel" data-ajax="false"/>
            </div>
    </form>
</div>
</body>
</html>