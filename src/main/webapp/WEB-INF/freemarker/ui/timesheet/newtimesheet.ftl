<!DOCTYPE html>
<#import "/spring.ftl" as spring />
<@spring.bind "timesheetForm" />
<@spring.bind "errors" />
<html>
<head>
    <title>Test UI</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../static/css/base.css"/>
    <link rel="stylesheet" href="../static/css/jquery.mobile-1.2.0-alpha.1.min.css"/>
    <link rel="stylesheet" href="../static/css/mobiscroll-2.0.1.custom.min.css"/>
    <link rel="stylesheet" type="text/css" href="../static/css/jqm-datebox.min.css" />

    <script type="text/javascript" src="../static/js/lib/jquery-1.7.2.min.js?1"></script>
    <script type="text/javascript" src="../static/js/lib/jquery.mobile-1.2.0-alpha.1.min.js"></script>
    <script type="text/javascript" src="../static/js/lib/jquery.form.js" ></script>
    <script type="text/javascript" src="../static/js/lib/jquery.validate.min.js"></script>
    <script type="text/javascript" src="../static/js/lib/jqm-datebox-1.1.0.core.js"></script>
    <script type="text/javascript" src="../static/js/lib/jqm-datebox-1.1.0.mode.calbox.js"></script>
    <script type="text/javascript" src="../static/js/lib/jquery.mobile.datebox.i18n.en_US.utf8.js"></script>
    <script type="text/javascript" src="../static/js/messages/messages.js"></script>
    <script type="text/javascript" src="../static/js/ui/timesheet/date_picker.js"></script>
    <script type="text/javascript" src="../static/js/timesheet/new_timesheet.js"></script>
</head>

<div data-role="page" data-theme="a">
    <div data-role="header">
        <h1>My New Timesheet</h1>
    </div>

    <form id="new_timesheet_form" action="submit" data-ajax="false" method="POST"
          class="ui-body ui-body-a ui-corner-all">
        <h4>Week Ending:</h4>

        <input name="weekEndingDate" value="${timesheetForm.weekEndingDate}" type="text" data-role="datebox" id="weekEndingDate" data-options='{"mode":"calbox", "blackDays": [1,2,3,4,5,6], "highDays": [0], "overrideCalStartDay": 1, "overrideDateFormat": "%d-%b-%y" }'/>

        <#if errors.hasErrors() >
            <div for="weekEndingDate" class="colorError error">${errors.getFieldError("weekEndingDate").getCode()}</div>
        <#else>
            <div for="weekEndingDate" class="colorError error"></div>
        </#if>


        <a href="timerecord" id="timeRecord" data-ajax="false" data-role="button" data-theme="a"  value="addtimeRecord" data-icon="plus">New Activity</a>
        <br>

        <ul data-role="listview">
            <#list timeRecords as item>
                <li>${item.activity}</li>
            </#list>
        </ul>

        <button type="submit" data-theme="a" data-ajax="true" name="submit" id="submit" value="submit-value">
            Submit
        </button>
    </form>
</div>

</body>
</html>