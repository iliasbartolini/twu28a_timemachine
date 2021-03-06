<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Test UI</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../static/css/base.css" />
    <link rel="stylesheet" href="../static/css/jquery.mobile-1.2.0-alpha.1.min.css" />

    <script type="text/javascript" src="../static/js/lib/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="../static/js/lib/jquery.mobile-1.2.0-alpha.1.min.js"></script>
    <script type="text/javascript" src="../static/js/lib/jquery.form.js"></script>
    <script type="text/javascript" src="../static/js/lib/jquery.validate.min.js"></script>
    <script type="text/javascript" src="../static/js/lib/jquery.cookie.js"></script>
    <script type="text/javascript" src="../static/js/messages/messages.js"></script>
    <script type="text/javascript" src="../static/js/timesheet/search_activity.js"></script>
    <script type="text/javascript" src="../static/js/ui/timesheet/display_search_results.js"></script>
</head>
<body>
<div data-role="page" data-theme="a">
    <form action="search_activity" id="searchForm">
        <fieldset class="ui-grid-a">
            <div class="ui-block-a" style="" id="home">
                <input type="search" id="searchCriteria" name="searchCriteria" style="width:80%"
                       placeholder="Search...Type in 2 or more characters">
                <ul data-role="listview" data-theme="g" id="activityList"></ul>
            </div>

            <div class="ui-block-b" style=" max-width: 70px">
                <a href="timerecord" data-ajax="false" data-role="button" data-inline="true" data-theme="b"
                   style="height:32px;padding-bottom:7px">Cancel</a>
            </div>
        </fieldset>
    </form>
    <div id="result" style="color:red;"></div>
    <ul id="messages" class="hidden">
    <#list messages as item>
        <li data-message-id='${item.getMessageId()}'>${item.getMessage()}</li>
    </#list>
    </ul
</div>


</body>
</html>

