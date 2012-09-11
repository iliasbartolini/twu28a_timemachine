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

    <script type="text/javascript" src="../static/js/mobiscroll-2.0.1.custom.min.js"></script>
    <script type="text/javascript" src="../static/js/ui/newTimesheetState.js"></script>
    <script>
        $(function () {


            var nameEQ = "activity_code=";
            var ca = document.cookie.split(';');
            for (var i = 0; i < ca.length; i++) {
                var c = ca[i];
                while (c.charAt(0) == ' ') c = c.substring(1, c.length);
                if (c.indexOf(nameEQ) == 0) {
                    $("#header").children("h3").text(c.substring(nameEQ.length, c.length));
                } else {
                    $("#header").children("h3").text("New Time Record");
                }

            }


        });

        function readCookie(name) {


        }
    </script>
    <script type="text/javascript" src="../static/js/lib/jquery.mobile-1.2.0-alpha.1.min.js"></script>
    <script type="text/javascript" src="../static/js/lib/jquery.form.js"></script>
    <script type="text/javascript" src="../static/js/lib/jquery.validate.min.js"></script>
    <script type="text/javascript" src="../static/js/lib/jquery.cookie.js"></script>

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
                            }
                        },
                        messages: {
                            country: "Country is required.",
                            state:"State is required"
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
                <input type="text" name="monday" id="monday" value=""/>
            </div>
            <div class="ui-block-b">
                Tues
                <input type="text" name="tuesday" id="tuesday" value=""/>
            </div>
            <div class="ui-block-c">
                Weds
                <input type="text" name="wednesday" id="wednesday" value=""/>
            </div>
            <div class="ui-block-d">
                Thur
                <input type="text" name="thursday" id="thursday" value=""/>
            </div>
            <div class="ui-block-e">
                Fri
                <input type="text" name="friday" id="friday" value=""/>
            </div>
        </div>

        <div class="ui-grid-d">
            <div class="ui-block-a">
                Sat
                <input type="text" name="saturday" id="saturday" value=""/>
            </div>
            <div class="ui-block-b">
                Sun
                <input type="text" name="sunday" id="sunday" value=""/>
            </div>
        </div>

        <input type="submit" data-role="button" value="Submit" data-ajax="false"/>

    </form>
</div>
</body>
</html>

