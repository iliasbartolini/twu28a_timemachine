<!DOCTYPE html>
<#import "/spring.ftl" as spring />
<@spring.bind "datePickerForm" />
<@spring.bind "errors" />

<html>
<head>
    <title>Test UI</title>
    <link rel="stylesheet" href="../static/css/base.css?1" />
    <link rel="stylesheet" href="../static/css/jquery.mobile-1.2.0-alpha.1.min.css" />

    <link rel="stylesheet" type="text/css" href="../static/css/jqm-datebox.min.css" />


    <script type="text/javascript" src="../static/js/lib/jquery-1.7.2.min.js?1"></script>
    <script type="text/javascript" src="../static/js/lib/jquery.mobile-1.2.0-alpha.1.min.js"></script>
    <script type="text/javascript" src="../static/js/lib/jquery.form.js" ></script>
    <script type="text/javascript" src="../static/js/lib/jquery.validate.min.js"></script>
    <script type="text/javascript" src="../static/js/messages.js"></script>

    <script type="text/javascript" src="/timemachine/static/js/lib/jqm-datebox-1.1.0.core.js"></script>
    <script type="text/javascript" src="/timemachine/static/js/lib/jqm-datebox-1.1.0.mode.calbox.js"></script>
    <script type="text/javascript" src="/timemachine/static/js/lib/jquery.mobile.datebox.i18n.en_US.utf8.js"></script>


    <script>
        $(function(){

            console.log(Messages.getMessage(Messages.WeekCannotBeUnspecified));

            $("#newtimesheet")
                    .validate({
                        rules: {
                            weekEndingDate: {
                                required: true
                            }
                        },
                        messages: {
                            weekEndingDate: Messages.getMessage(Messages.WeekCannotBeUnspecified)
                        },
                        errorPlacement: function(error, element) {
                            error.insertAfter("#datepickerdiv");
                        }
                    });
        });
    </script>
</head>
<body>
<div data-role="dialog" data-theme="a">

    <form id="newtimesheet" action="" data-ajax="false" method="post"
          class="ui-body ui-body-a ui-corner-all">

        <div data-role="fieldcontain" id="datepickerdiv">
            <input name="weekEndingDate" type="text" data-role="datebox" id="weekEndingDate" data-options='{"mode":"calbox", "blackDays": [1,2,3,4,5,6], "highDays": [0], "overrideCalStartDay": 1, "overrideDateFormat": "%-d-%b-%Y" }'/>
            <#if errors.hasErrors() >
                <div for="weekEndingDate" class="error">${errors.getFieldError("weekEndingDate").getCode()}</div>
            </#if>
        </div>
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