<!DOCTYPE html>
<html>
<head>
    <title>Test UI</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../static/css/base.css" />
    <link rel="stylesheet" href="../static/css/jquery.mobile-1.2.0-alpha.1.min.css" />
    <script type="text/javascript" src="../static/js/lib/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="../static/js/lib/jquery.mobile-1.2.0-alpha.1.min.js"></script>
    <script type="text/javascript" src="../static/js/lib/jquery.form.js" ></script>
    <script type="text/javascript" src="../static/js/lib/jquery.validate.min.js"></script>
    <script type="text/javascript" src="../static/js/favorite_timesheet.js"></script>
    <script type="text/javascript" src="../static/js/ui/new_favorite.js"></script>
</head>
<body>

<div data-role="page" data-theme="a">
    <div data-role="header">
        <h1>My Favourites</h1>
    </div>

    <ul data-role="listview" data-theme="a">
        <#list favoriteTimesheets as item>
            <li><a href="#">${item.name}</a></li>
        </#list>
    </ul>

    <!--<button type="add" data-theme="a" name="add" value="add_favorite" data-icon="plus">Add favorite</button>-->
    <a href="new" data-role="button" type="add" data-theme="a" name="add" value="add_favorite" data-icon="plus">Add favorite</a>


</div>

</body>
</html>

