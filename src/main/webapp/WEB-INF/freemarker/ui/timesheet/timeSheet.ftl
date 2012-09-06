<!DOCTYPE html>

<html>
<head>
    <title>Test UI</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../static/css/base.css"/>
    <link rel="stylesheet" href="../static/css/jquery.mobile-1.2.0-alpha.1.min.css"/>
    <link rel="stylesheet" href="../static/css/mobiscroll-2.0.1.custom.min.css"/>

    <script type="text/javascript" src="../static/js/lib/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="../static/js/mobiscroll-2.0.1.custom.min.js"></script>

    <script>

        var options = {

        }

        function changelist(v) {

            var $t = $("#state");

            //clear old options
            $t.html('');
            //fill up new options
            if (options[v]) {
                for (var i in options[v]) {
                    if (options[v].hasOwnProperty(i)) {
                        $t.append('<option value="' + options[v][i] + '">' + i + '<\/option>');
                    }
                }
            }
            $t.selectmenu('refresh');
        }

        function newActivity() {

        }
    </script>
    <script type="text/javascript" src="../static/js/lib/jquery.mobile-1.2.0-alpha.1.min.js"></script>
    <script type="text/javascript" src="../static/js/lib/jquery.form.js"></script>
    <script type="text/javascript" src="../static/js/lib/jquery.validate.min.js"></script>
    <script type="text/javascript" src="../static/js/favorite_timesheet.js"></script>
    <script type="text/javascript" src="../static/js/ui/new_timesheet.js"></script>


</head>
<div data-role="page" data-theme="a">
    <div data-role="header">
        <h1>My New Timesheet</h1>
    </div>

    <form id="new_timesheet_form"
          class="ui-body ui-body-a ui-corner-all">


        <label>Week Ending</label>
        <input type="text" name="task" id="task" value=""/>
        <br>
        <br>

        <input type="button" value="New Activity">
        <br>




        <button type="submit" data-theme="a" data-ajax="true" name="submit" id="submit" value="submit-value">
            Submit
        </button>
    </form>
</div>

</body>
</html>