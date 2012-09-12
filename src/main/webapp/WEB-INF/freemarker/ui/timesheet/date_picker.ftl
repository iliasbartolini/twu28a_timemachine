<!DOCTYPE html>
<#import "/spring.ftl" as spring />
<@spring.bind "datePickerForm" />
<@spring.bind "errors" />

<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Test UI</title>
    <link rel="stylesheet" href="../static/css/base.css?1" />
    <link rel="stylesheet" href="../static/css/jquery.mobile-1.2.0-alpha.1.min.css" />

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
</head>
<body>
<div data-role="dialog" data-theme="a" id="index">

    <form id="newtimesheet" action="" data-ajax="false" method="post"
          class="ui-body ui-body-a ui-corner-all">

        <div data-role="fieldcontain" id="datepickerdiv">
            <input name="weekEndingDate" type="text" data-role="datebox" id="weekEndingDate" data-options='{"mode":"calbox", "blackDays": [1,2,3,4,5,6], "highDays": [0], "overrideCalStartDay": 1, "overrideDateFormat": "%d-%b-%y" }'/>
        </div>
        <#if errors.hasErrors() >
            <div for="weekEndingDate" class="colorError">${errors.getFieldError("weekEndingDate").getCode()}</div>
        <#else>
            <div for="weekEndingDate" class="colorError error"></div>
        </#if>
        <div class="ui-grid-a">
            <div class="ui-block-a"><button type="submit" data-theme="a" data-ajax="true" name="submit" id="submit" value="submit-value">OK</button></div>
            <div class="ui-block-b"><a href="/timemachine/" data-role="button" id="cancel">Cancel</a></div>
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