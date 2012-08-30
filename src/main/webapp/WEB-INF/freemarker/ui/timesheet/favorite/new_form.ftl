<!DOCTYPE html>
<html>
<head>
    <title>Test UI</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../../static/css/base.css" />
    <link rel="stylesheet" href="../../static/css/jquery.mobile-1.2.0-alpha.1.min.css" />
    <link rel="stylesheet" href="../../static/css/mobiscroll-2.0.1.custom.min.css" />

    <script type="text/javascript" src="../../static/js/lib/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="../../static/js/mobiscroll-2.0.1.custom.min.js"></script>

    <script>
        $(function(){
            // create a datepicker with default settings
            $("#date").scroller({ preset: 'date' });


        });

        var options = {
            "USA" : {
                'State One': 'http://www.apple.com/ihphone3g',
                'State Two': 'http://www.apple.com/iphone4'
            }
        }

        function changelist(v) {

            var $t = $("#state");

            //clear old options
            $t.html('');
            //fill up new options
            if(options[v]){
                for(var i in options[v]){
                    if(options[v].hasOwnProperty(i)){
                        $t.append('<option value="' + options[v][i] + '">' + i + '<\/option>');
                    }
                }
            }
            $t.selectmenu('refresh');
        }



    </script>
    <script type="text/javascript" src="../../static/js/lib/jquery.mobile-1.2.0-alpha.1.min.js"></script>
    <script type="text/javascript" src="../../static/js/lib/jquery.form.js" ></script>
    <script type="text/javascript" src="../../static/js/lib/jquery.validate.min.js"></script>
    <script type="text/javascript" src="../../static/js/favorite_timesheet.js"></script>
    <script type="text/javascript" src="../../static/js/ui/new_favorite.js"></script>


</head>
<body>

<div data-role="page" data-theme="a">
    <div data-role="header">
        <h1>My Favourite Time Sheet</h1>
    </div>

    <form id="new_favorite_form" modelAttribute="favoriteTimesheetForm" action="" method="post" class="ui-body ui-body-a ui-corner-all">
        <label for="name">Name</label>
        <input type="text" name="name" id="name" value="" />

        <label for="name">Date</label>
        <input id="date" name="date" />








        <select id="country" name="country" onchange="changelist(this.value)">
            <option value="AUS">AUS - Australia</option>
            <option value="USA">USA - United States</option>
        </select>

        <select id="state" name="state">
            <option value="" selected="selected"></option>
        </select>






        <label for="activity">Activity</label>
        <input type="text" name="activity" id="activity" value=""  />

        <label for="billable">Billable?</label>
        <select name="billable" id="billable" data-role="slider">
            <option value="false">No</option>
            <option value="true">Yes</option>
        </select>

        <label for="comments">Comments</label>
        <input type="text" name="comments" id="comments" value=""  />

        <div class="ui-grid-d">
            <div class="ui-block-a">
                Mon
                <input type="text" name="monday" id="monday" value=""  /></div>
            <div class="ui-block-b">
                Tues
                <input type="text" name="tuesday" id="tuesday" value=""  />
            </div>
            <div class="ui-block-c">
                Weds
                <input type="text" name="wednesday" id="wednesday" value=""  />
            </div>
            <div class="ui-block-d">
                Thur
                <input type="text" name="thursday" id="thursday" value=""  />
            </div>
            <div class="ui-block-e">
                Fri
                <input type="text" name="friday" id="friday" value=""  />
            </div>
        </div>

        <div class="ui-grid-d">
            <div class="ui-block-a">
                Sat
                <input type="text" name="saturday" id="saturday" value=""  />
            </div>
            <div class="ui-block-b">
                Sun
                <input type="text" name="sunday" id="sunday" value=""  />
            </div>
        </div>





        <button type="submit" data-theme="a" data-ajax="true" name="submit" id="submit" value="submit-value">Submit</button>
    </form>
</div>

</body>
</html>

