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


    </script>
    <script type="text/javascript" src="../static/js/lib/jquery.mobile-1.2.0-alpha.1.min.js"></script>
    <script type="text/javascript" src="../static/js/lib/jquery.form.js"></script>
    <script type="text/javascript" src="../static/js/lib/jquery.validate.min.js"></script>
    <script type="text/javascript" src="../static/js/favorite_timesheet.js"></script>


</head>
<body>

<div data-role="page" data-theme="a">
    <div data-role="header">
        <h1>New Time Sheet</h1>
    </div>
     <#if spring.status.error>
            <div class="errors">
                There were problems with the data you entered:
                <ul>
                    <#list spring.status.errorMessages as error>
                        <li>${error}</li>
                    </#list>
                </ul>
            </div>
        </#if>


    <form id="new_timesheet_form" modelAttribute="favoriteTimesheetForm" action="" method="post"
          class="ui-body ui-body-a ui-corner-all">


         <label for="country" class="select">Country</label>
                 <select name="country" id="country">
                     <option value="" selected="selected"></option>
                 <#list countries as country>
                     <option value="${country.name}">${country.name}</option>
                 </#list>
          </select>


        <label for="State" class="select">State</label>
        <select id="state" name="state">
            <option value="" selected="selected"></option>
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
            OK
        </button>
    </form>
</div>

</body>
</html>

