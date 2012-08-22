<html>
<head>
	<title>TimeSheet - New Favorite</title>
</head>
<body>
	<h1>Create New Favorite Timesheet</h1>
    <form action="" modelAttribute="favoriteTimeSheetForm" method="post">
        FavoriteName: <input name="name" value="${favoriteTimeSheetForm.name}"/> <br/>

        Country
        <select name="timeEntry.country">
            <option value="US">US</option>
            <option value="IND">INDIA</option>
            <option value="TG">TOGO</option>
        </select> <br/>

        State
        <select name="timeEntry.state">
            <option value="RS">RS</option>
            <option value="SP">SP</option>
            <option value="RJ">RJ</option>
        </select> <br/>
        Activity
        <input type="text" name="timeEntry.activity"> <br/>

        Billable?
        <input type="radio" name="timeEntry.billable" value="true">yes
        <input type="radio" name="timeEntry.billable" value="false">no <br/>
        Task Comment
        <input type="text" name="timeEntry.taskComment"> <br/>

        Mon
        <input type="text" name="timeEntry.days[0]"> <br/>

        Tue
        <input type="text" name="timeEntry.days[1]"> <br/>

        <input type="submit">
    </form>
</body>
</html>