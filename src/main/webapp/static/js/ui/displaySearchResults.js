$(function() {

    $("#searchForm").submit(function(event) {

        event.preventDefault();


        var $form = $( this ),
            searchCriteria = $form.find( 'input[name="searchCriteria"]' ).val(),
            url = $form.attr( 'action' );

        try {
            var activity = new Activity();
            $("#result").text("");
            activity.search(searchCriteria, function(activities) {

                var $list = $("#activityList");
                $list.empty();


                if ( activities.length == 0 ) {
                    $("#result").text(activity.getMessages()[Messages.NoMatchingActivity]);
                    return;
                }

                for(var i in activities) {
                    var $item = $("<li><a/></li>"),
                    $a = $item.find("a");

                    var projectString = activities[i].client + " " + activities[i].project + " " + activities[i].sub_project ;

                    $a.html('<h3 class="ui-li-heading">' + projectString + '</h3><p class="ui-li-desc">' + activities[i].sub_project_name +'</p>');
                    $a.attr("href", "new");
                    $a.attr("text",projectString);
                    $item.attr("data-icon", "check");

                    $a.click(function() {
                        $.cookie("ActivityCode", projectString, { path: '/' });
                    });

                    $list.append($item);
                    $list.listview("refresh");
                }

                $list.listview("refresh");
            });
        } catch(error) {
            $("#result").text(error.message);
        }

        return false;
    });
});

