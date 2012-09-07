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

    <link rel="stylesheet" type="text/css" href="../static/css/jqm-datebox.min.css" />
    <script type="text/javascript" src="../static/js/lib/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="../static/js/lib/jquery.mobile-1.2.0-alpha.1.min.js"></script>
    <script type="text/javascript" src="../static/js/lib/jquery.form.js"></script>
    <script type="text/javascript" src="../static/js/lib/jquery.validate.min.js"></script>
    <script type="text/javascript" src="../static/js/lib/jquery.cookie.js"></script>

    <script type="text/javascript" src="../static/js/mobiscroll-2.0.1.custom.min.js"></script>
    <script type="text/javascript" src="../static/js/ui/newTimesheetState.js"></script>
    <script type="text/javascript" src="/timemachine/static/js/lib/jqm-datebox-1.1.0.core.js"></script>
    <script type="text/javascript" src="/timemachine/static/js/lib/jqm-datebox-1.1.0.mode.calbox.js"></script>
    <script type="text/javascript" src="/timemachine/static/js/lib/jquery.mobile.datebox.i18n.en_US.utf8.js"></script>


    <script>
        $(document).ready(function(){

//            $("#new_timesheet_form").validate();
            $("#new_timesheet_form")
                    .validate({
                        rules: {
                            wecal: {
                                required: true
                            }
                        },
                        messages: {
                            wecal: "Week ending date is required."
                        },
                        errorPlacement: function(error, element) {

                            error.insertAfter("#datepickerdiv");



                        }
                    });
        });
        function readCookie(name) {
            var nameEQ = name + "=";
            var ca = document.cookie.split(';');
            for(var i=0;i < ca.length;i++) {
                var c = ca[i];
                while (c.charAt(0)==' ') c = c.substring(1,c.length);
                if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
            }
            return null;

        }
    </script>


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
                $("#activityButton").click(function(){
                    alert("Barfi!");
                });
            });
        </script>



    <form id="new_timesheet_form" data-ajax="false" modelAttribute="favoriteTimesheetForm" action="" method="post"
          class="ui-body ui-body-a ui-corner-all">


   <br>

   <input type="button" data-ajax="false" value="Search Activity Code" id="searchActivityCode" />
   <br>
        Week Ending Date:
        <div id="datepickerdiv">
         <input name="wecal" type="text" data-role="datebox" id="wecal" data-options='{"mode":"calbox", "blackDays": [1,2,3,4,5,6], "highDays": [0], "overrideCalStartDay": 1, "overrideDateFormat": "%-d-%b-%Y" }'/>
        </div>
        <br>
        Country:
    <@spring.formSingleSelect "timeRecordForm.country",countries, "class= select1" />
     <div id="error" style="color: red;">
     <@spring.showErrors "<br>"     />
        </div>
    <br>
    State:
    <@spring.formSingleSelect "timeRecordForm.state",states, "class=state" />
        <div id="error" style="color: red;">
        <@spring.showErrors "<br><br>"     />
        </div>


        <label>Billable?</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <select id="billable "name="billable"  data-role="slider">

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

    <input type="submit" data-role="button" value="Submit" data-ajax="false" />


    </form>
</div>


</body>
</html>

