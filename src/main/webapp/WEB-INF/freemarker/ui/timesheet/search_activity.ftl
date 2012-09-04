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
    <script type="text/javascript" src="../static/js/searchActivity.js"></script>
    <script type="text/javascript" src="../static/js/ui/displaySearchResults.js"></script>
</head>
<body>
<form action="search_activity" id="searchForm">
    <input type="search" name="searchCriteria" placeholder="Search...type in more than 2 chars" width="20"/>
    <input type="submit" value="Search" />
</form>
<ul data-role="listview" data-theme="g" id="activityList" name="activityList">
</ul>

<div id="result"></div>

</body>
</html>

