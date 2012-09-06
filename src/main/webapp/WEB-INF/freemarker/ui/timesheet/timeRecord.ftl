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

</head>
<body>

<div data-role="page" data-theme="a" id="index">

    <div data-role="header">
        <h1>New Time Sheet</h1>
    </div>

    <script type="text/javascript">
           $("#index").die("pageinit");
            $('#index').live("pageinit",function(){

                $('#state').selectmenu('disable');
               var changeState = new NewTimesheetState();
                 changeState.toggleStateList();
                $(".select1").change(function () {


                    changeState.toggleStateList();
                });
            });
        </script>



    <form id="new_timesheet_form" data-ajax="false" modelAttribute="favoriteTimesheetForm" action="" method="post"
          class="ui-body ui-body-a ui-corner-all">

        <label for="date">Week Ending</label>
        <input id="date" name="date"/>
   Country:

    <@spring.formSingleSelect "timeRecordForm.country",countries, "class= select1" />
    <@spring.showErrors "<br>" />
    <br>
    State:
    <@spring.formSingleSelect "timeRecordForm.state",states, "class=state" />
    <@spring.showErrors "<br>" />
        <br>
        Activity:

         <@spring.formInput "timeRecordForm.activity" />
         <@spring.showErrors "<br>" />
        <br>

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

    <a href="/timemachine/timesheet/new" data-role="button" data-ajax="false">Submit Hella!</a>

    </form>
</div>


</body>
</html>

