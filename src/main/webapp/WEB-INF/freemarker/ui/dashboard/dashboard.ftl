<!DOCTYPE html>
<html>
<head>
    <title>TimeMachine Dashboard</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="./static/css/base.css" />
    <link rel="stylesheet" href="./static/css/jquery.mobile-1.2.0-alpha.1.min.css" />

    <script type="text/javascript" src="./static/js/lib/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="./static/js/lib/jquery.mobile-1.2.0-alpha.1.min.js"></script>
    <script type="text/javascript" src="./static/js/lib/jquery.form.js" ></script>
    <script type="text/javascript" src="./static/js/lib/jquery.validate.min.js"></script>
</head>
<body>

<div data-role="page" data-theme="a">
    <div data-role="header" id="header">
        <h1>Welcome ${employee.name}</h1>
    </div>

    <a href="timesheet/week-ending-date" id="new_timesheet" data-inline="true" data-rel="dialog" data-transition="pop" data-ajax="false" data-role="button" type="add" data-theme="a" name="add" value="add_timesheet" data-icon="plus">New timesheet</a>

    <ul data-role="listview" id="timesheet_list" data-divider-theme="a">
        <li data-role="list-divider">Week Ending</li>
        <#list timesheets as item >
            <li>
                <div class ="ui-grid-a">
                    <div class="ui-block-a">${item.weekEndingDate?string("dd-MMM-yy")}</div>
                    <div class="ui-block-b">${item.createdAt?string("dd-MMM-yy")}</div>
                </div>
            </li>
        </#list>
    </ul>
</div>
</body>
</html>
