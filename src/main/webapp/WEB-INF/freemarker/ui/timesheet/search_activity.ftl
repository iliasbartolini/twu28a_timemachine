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
</head>
<body>
<form action="search_activity" id="searchForm">
    <input type="text" name="s" placeholder="Search..." />
    <input type="submit" value="Search" />
</form>

<ul data-role="listview" data-theme="g" id="activityList" name="activityList">

</ul>

<!-- the result of the search will be rendered inside this div -->
<div id="result"></div>

<script>
    /* attach a submit handler to the form */
    $("#searchForm").submit(function(event) {

        /* stop form from submitting normally */
        event.preventDefault();

        /* get some values from elements on the page: */
        var $form = $( this ),
                term = $form.find( 'input[name="s"]' ).val(),
                url = $form.attr( 'action' );

        /* Send the data using post and put the results in a div */
        $.post( url, { s: term },
                function( data ) {

                    data = JSON.parse(data);

                    var $list = $("#activityList");

                    console.log(data);
                    console.log(data[0]);

                    //clear old options
                    $list.html('');
                    //fill up new options
                    //if(data){
                        for(var i in data){
                            //if(options[v].hasOwnProperty(i)){
                            //console.log(data[i].client);
                            var projectString = data[i].client + " " + data[i].project + " " + data[i].sub_project;

                            console.log('<li><a href="">' + projectString + '<\/a><\/li>');
                            //$list.append('<li><a href="">' + projectString + '<\/a><\/li>');
                            $list.append('<li><a href="">' + projectString + '<\/a><\/li>');

                            console.log($list);
                            //}
                        }
                    //}
                    $list.listview("refresh");


//
//                    var content = $( data ).find( '#content' );
//                    console.log(content);
//                    $( "#result" ).empty().append( content );
//                    console.log("Data:");
//                    console.log(data);
                });
    });
</script>

</body>
</html>

