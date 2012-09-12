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
    <script type="text/javascript" src="../static/js/lib/jquery.mobile.simpledialog.min.js"></script>
    <script type="text/javascript" src="../static/js/messages/messages.js"></script>
    <script type="text/javascript" src="../static/js/timesheet/new_timesheet_state.js"></script>
    <script type="text/javascript" src="../static/js/timesheet/time_record.js"></script>
    <script type="text/javascript" src="../static/js/ui/timesheet/time_record.js"></script>
</head>
<body>
<div data-role="page" data-theme="a" id="index">

    <div data-role="header" id="header">
        <h3>New Time Record</h3>
    </div>

    <form id="new_timesheet_form" data-ajax="false" modelAttribute="favoriteTimesheetForm" action="" method="post"
          class="ui-body ui-body-a ui-corner-all">

        <!-- Country -->
        <@spring.formSingleSelect "timeRecordForm.country",countries, "class= select1" />
        <div for="country" class="colorError">
            <@spring.showErrors "<br>" />
        </div>
        <br>

        <!-- State -->
        <@spring.formSingleSelect "timeRecordForm.state",states, "class=state" />
        <div for="state" class="colorError">
            <@spring.showErrors "<br>"/>
        </div>
        <br>

        <!-- Activity code -->
        <a href="search_activity" id="searchActivity" data-role="button" data-ajax="false">Select a activity code</a>
        <input type="hidden" name="activity" value="" >
        <div for="activity" class="colorError"></div>

        <!-- Billable -->
        <label>Billable?</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <select name="billable" data-role="slider">
            <option value="false">No</option>
            <option value="true" selected="selected">Yes</option>
        </select>

        <!-- Activity Comment -->
        <input type="text" name="task" placeholder="Activity Comment" id="task" value=""/>
        <div for="task" class="colorError">
        </div>

        <!-- Hours -->
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

        <!-- Action buttons -->
        <div class="ui-grid-a">
            <div class="ui-block-a">
                <input type="submit" data-role="button" value="Submit" data-ajax="false"/>
            </div>
            <div class="ui-block-b">
                <input type="button" data-role="button" value="Cancel" data-ajax="false"/>
            </div>
        </div>
    </form>

    <ul id="messages" class="hidden">
    <#list messages as item>
        <li data-message-id='${item.getMessageId()}'>${item.getMessage()}</li>
    </#list>
    </ul>

</div>
</body>
</html>
