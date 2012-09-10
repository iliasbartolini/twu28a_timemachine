<!DOCTYPE html>
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

    <script type="text/javascript" src="/timemachine/static/js/lib/jqm-datebox-1.1.0.core.js"></script>
    <script type="text/javascript" src="/timemachine/static/js/lib/jqm-datebox-1.1.0.mode.calbox.js"></script>
    <script type="text/javascript" src="/timemachine/static/js/lib/jquery.mobile.datebox.i18n.en_US.utf8.js"></script>


    <script>
        $(document).ready(function(){

            $("#newtimesheet")
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



    </script>


</head>
<body>

<div data-role="dialog" data-theme="a">

    <form id="newtimesheet" action="new" method="get"
          class="ui-body ui-body-a ui-corner-all">

        <div data-role="fieldcontain" id="datepickerdiv">
            <input name="wecal" type="text" data-role="datebox" id="wecal" data-options='{"mode":"calbox", "blackDays": [1,2,3,4,5,6], "highDays": [0], "overrideCalStartDay": 1, "overrideDateFormat": "%-d-%b-%Y" }'/>
        </div>



        <div class="ui-grid-a">
            <div class="ui-block-a"><button type="submit" data-theme="a" data-ajax="true" name="submit" id="submit" value="submit-value">OK</button></div>
            <div class="ui-block-b"><a href="/timemachine/" data-role="button" id="cancel">Cancel</a></div>
        </div>
    </form>
</div>



<script>

</script>

</body>
</html>

