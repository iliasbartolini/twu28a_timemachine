<!DOCTYPE html>
<#import "/spring.ftl" as spring />
<@spring.bind "timeRecordForm" />
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
    <script type="text/javascript" src="../static/js/lib/jquery.remember-state.js"></script>

    <script>
        $(function () {
            // create a datepicker with default settings
            $("#date").scroller({ preset:'date' });
        });
        $("new_timesheet_form").rememberState({ objName: "formSavedState" }).submit(function() {
            localStorage.setObject("formSavedState", $(this).serializeArray());
            return false;
        });

    </script>
    <script type="text/javascript" src="../static/js/lib/jquery.mobile-1.2.0-alpha.1.min.js"></script>
    <script type="text/javascript" src="../static/js/lib/jquery.form.js"></script>
    <script type="text/javascript" src="../static/js/lib/jquery.validate.min.js"></script>
    <script type="text/javascript" src="../static/js/lib/jquery.cookie.js"></script>
</head>
<body>

<div data-role="page" data-theme="a">
    <div data-role="header">
        <h1>New Time Sheet</h1>
    </div>

    <form id="new_timesheet_form" modelAttribute="favoriteTimesheetForm" action="" method="post"
          class="ui-body ui-body-a ui-corner-all">


        <select name="country" id="country">
            <option diabled value="default" selected="selected">Select a country</option>
        <#list countries as country>
            <option value="${country.name}">${country.name}</option>
        </#list>
        </select>

        <select id="state" name="state" disabled="disabled">
            <option value="default" selected="selected">Select a state</option>
        <#list states as state>
            <option value="${state.state}">${state.state}</option>
        </#list>
        </select>

       <a href="search_activity" data-role="button" data-icon="search" data-ajax="false" id="searchActivityCode">Search Activity Code</a>


        <label>Billable?</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <select id="billable "name="billable"  data-role="slider">

            <option value="false">No</option>

            <option value="true">Yes</option>

        </select>





        <input type="text" name="task" placeholder="Type task" id="task" value=""/>

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


    <a href="/timemachine/timesheet/new" data-role="button" data-ajax="false">Submit Hella!</a>

    </form>
</div>

</body>
</html>

