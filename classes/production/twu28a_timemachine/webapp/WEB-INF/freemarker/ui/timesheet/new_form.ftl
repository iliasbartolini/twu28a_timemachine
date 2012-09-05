<!DOCTYPE html>
<html>
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
            // create a datepicker with default settings
            $("#date").scroller({ preset:'date' });


        });

    </script>
    <script type="text/javascript" src="../static/js/lib/jquery.mobile-1.2.0-alpha.1.min.js"></script>
    <script type="text/javascript" src="../static/js/lib/jquery.form.js"></script>
    <script type="text/javascript" src="../static/js/lib/jquery.validate.min.js"></script>



</head>
<body>

<div data-role="page" data-theme="a">
    <div data-role="header">
        <h1>My Time Sheet</h1>
    </div>

    <form id="new_timesheet_form" modelAttribute="favoriteTimesheetForm" action="" method="post"
          class="ui-body ui-body-a ui-corner-all">

        <label for="date">Date</label>
        <input id="date" name="date"/>


        <label for="country" class="select">Country</label>
        <select name="country" id="country">
            <option value="default" selected="selected">Select a country</option>
        <#list countries as country>
            <option value="${country.name}">${country.name}</option>
        </#list>
        </select>


            <label for="state" class="select" >State</label>
            <select id="state" name="state" disabled="disabled" >
                <option value="default" selected="selected">Select a state</option>
            <#list states as state>
                <option value="${state.state}">${state.state}</option>
            </#list>
            </select>



        <label for="activity">Activity</label>
        <input type="text" name="activity" id="activity" value=""/>

        <label for="billable">Billable?</label>
        <select name="billable" id="billable" data-role="slider">
            <option value="false">No</option>
            <option value="true">Yes</option>
        </select>

        <label for="task">Task</label>
        <input type="text" name="task" id="task" value=""/>

        <div class="ui-grid-d">
            <div class="ui-block-a">
                Mon
                <input type="text" name="monday" id="monday" value=""/></div>
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



        <button type="submit" data-theme="a" data-ajax="true" name="submit" id="submit" value="submit-value">
            Submit
        </button>
    </form>
</div>

</body>
</html>

