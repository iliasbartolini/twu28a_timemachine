<!DOCTYPE html>
<html>
<head>
    <title>Test UI</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../../static/css/base.css" />
    <link rel="stylesheet" href="../../static/css/jquery.mobile-1.2.0-alpha.1.min.css" />
    <script type="text/javascript" src="../../static/js/lib/jquery-1.7.2.min.js"></script>
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

    <form id="new_favorite_form" action="" method="post" data-ajax="true" class="ui-body ui-body-a ui-corner-all">
        <label for="name">Name</label>
        <input type="text" name="name" id="name" value="" />



        <!--
        <label for="country" class="select">Country</label>
        <select name="country" id="country">
            <#list countries as country>
                <option value=${country.name}>${country.name}</option>
            </#list>
        </select>

        <label for="state" class="select">State</label>
        <select name="state" id="state">
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

        <label for="monday">Monday</label>
        <input type="text" name="monday" id="monday" value=""  />

        <label for="tuesday">Tuesday</label>
        <input type="text" name="tuesday" id="tuesday" value=""  />

        <label for="wednesday">Wednesday</label>
        <input type="text" name="wednesday" id="wednesday" value=""  />

        <label for="thursday">Thursday</label>
        <input type="text" name="thursday" id="thursday" value=""  />

        <label for="friday">Friday</label>
        <input type="text" name="friday" id="friday" value=""  />

        <label for="saturday">Saturday</label>
        <input type="text" name="saturday" id="saturday" value=""  />

        <label for="sunday">Sunday</label>
        <input type="text" name="sunday" id="sunday" value=""  /> -->


        <button type="submit" data-theme="a" data-ajax="true" name="submit" id="submit" value="submit-value">Submit</button>
    </form>
</div>

</body>
</html>

