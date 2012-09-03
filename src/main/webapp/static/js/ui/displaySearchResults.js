$(function() {

    $("#searchForm").submit(function(event) {

        event.preventDefault();
        console.log("Submit event send");

        var $form = $( this ),
            searchCriteria = $form.find( 'input[name="searchCriteria"]' ).val(),
            url = $form.attr( 'action' );

        var activity = new Activity();

        try{

        activity.search(searchCriteria, function(activities) {
            var $list = $("#activityList");

            $list.empty();

            for(var i in activities){
                var projectString = activities[i].client + " " + activities[i].project + " " + activities[i].sub_project;
                $list.append('<li><a href="">' + projectString + '<\/a><\/li>');
            }

            $list.listview("refresh");
        });


        }catch(err){
               var $list = $("#activityList")
               $list.empty().append("Enter atleast 2 characters");
        }

        return false;
    });

});

