<!DOCTYPE html>
<#import "/spring.ftl" as spring />
<@spring.bind "timeSheetForm" />
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
    <script type="text/javascript" src="../static/js/lib/jquery.cookie.js"></script>
    <script type="text/javascript" src="../static/js/favorite_timesheet.js"></script>

</head>
<body>

<div data-role="page" data-theme="a">
    <div data-role="header">
        <h1>New Time Sheet</h1>
    </div>

    <form id="new_timesheet_form" modelAttribute="favoriteTimesheetForm" action="" method="post"
          class="ui-body ui-body-a ui-corner-all">

        <label for="date">Week Ending</label>
        <input id="date" name="date"/>


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

        Activity:
         <@spring.formInput "timeSheetForm.activity" />
         <@spring.showErrors "<br>" />



        <#--<div data-role="fieldcontain">-->
            <#--<fieldset data-role="controlgroup" data-type="horizontal">-->
                <#--<input type="radio" name="radio" id="billable"/>-->
                <#--<label for="billable">Billable</label>-->
                <#--<input type="radio" name="radio" id="nonbillable" checked="checked"/>-->
                <#--<label for="nonbillable">Non-Billable</label>-->
            <#--</fieldset>-->
        <#--</div>-->

        <label>Billable?</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <select name="billable"  data-role="slider">

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


        <button type="submit" data-theme="a" data-ajax="true" name="submit" id="submit" value="submit-value">
            Submit
        </button>
    </form>
</div>

</body>
</html>

