<!DOCTYPE html>
<#import "/spring.ftl" as spring />
<#--<@spring.bind "timeRecordForm" />-->
<html>
<head>
    <title>Test UI</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../static/css/base.css"/>
    <link rel="stylesheet" href="../static/css/jquery.mobile-1.2.0-alpha.1.min.css"/>
    <link rel="stylesheet" href="../static/css/mobiscroll-2.0.1.custom.min.css"/>

    <script type="text/javascript" src="../static/js/lib/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="../static/js/mobiscroll-2.0.1.custom.min.js"></script>

    <script type="text/javascript" src="/timemachine/static/js/lib/jqm-datebox-1.1.0.core.js"></script>
    <script type="text/javascript" src="/timemachine/static/js/lib/jqm-datebox-1.1.0.mode.calbox.js"></script>
    <script type="text/javascript" src="/timemachine/static/js/lib/jquery.mobile.datebox.i18n.en_US.utf8.js"></script>

    <script>


    </script>
    <script type="text/javascript" src="../static/js/lib/jquery.mobile-1.2.0-alpha.1.min.js"></script>
    <script type="text/javascript" src="../static/js/lib/jquery.form.js"></script>
    <script type="text/javascript" src="../static/js/lib/jquery.validate.min.js"></script>


</head>


<div data-role="page" data-theme="a">
    <div data-role="header">
        <h1>My New Timesheet</h1>
    </div>

    <form id="new_timesheet_form" action="submit" data-ajax="false" method="POST"
          class="ui-body ui-body-a ui-corner-all">

        <div>Employee name: ${employee.name}</div>
        <div>Employee login: ${employee.login}</div>
        <div>Employee number: ${employee.employee_decimal}</div>
        <label>Week Ending</label>
        <input type="text" name="weekEndingDate" id="weekEndingDate" value="${weekEndingDate}" />
        <br>
        <br>


        <a href="timerecord" id="timeRecord" data-ajax="false" data-role="button" data-theme="a"  value="addtimeRecord" data-icon="plus">New Activity</a>
        <br>



        <button type="submit" data-theme="a" data-ajax="true" name="submit" id="submit" value="submit-value">
            Submit
        </button>
    </form>
</div>

</body>
</html>