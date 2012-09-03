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
    <script type="text/javascript" src="../static/js/ui/searchAcitivity.js"></script>
</head>
<body>
<form action="search_activity" id="searchForm">
    <input type="text" name="searchCriteria" placeholder="Search..." />
    <input type="submit" value="Search" />
</form>

<ul data-role="listview" data-theme="g" id="activityList" name="activityList">

</ul>

<!-- the result of the search will be rendered inside this div -->
<div id="result"></div>

<script>

</body>
</html>
