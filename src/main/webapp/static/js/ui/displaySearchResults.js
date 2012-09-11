

$(function() {



    $("#searchForm").submit(function(event) {

        event.preventDefault();



        var $form = $( this ),
            searchCriteria = $form.find( 'input[name="searchCriteria"]' ).val(),
            url = $form.attr( 'action' );

        try {
            var activity = new Activity();
            $("#result").text("");
            searchCriteria = $.trim(searchCriteria);

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
                    $a.attr("href", "timerecord");
                    $a.attr("text",projectString);
                    $a.attr("data-ajax", "false");
                    $a.attr("id", "activity" + i);

                    $item.attr("data-icon", "check");

                    $a.click(function() {

                        var selectedvalue = $(this).find("h3").text();


                        createCookie('activity_code',selectedvalue,30)  ;
                    });

                    $list.append($item);
                    $list.listview("refresh");

                    $('#activityList').children('a').on('click', function () {
                        alert('Selected Value=' + $(this).text());
                    });
                }

                $list.listview("refresh");
            });
        } catch(error) {
            $("#result").text(error.message);
        }

        return false;
    });

    function createCookie(name,value,days) {
        if (days) {
            var date = new Date();
            date.setTime(date.getTime()+(days*24*60*60*1000));
            var expires = "; expires="+date.toGMTString();
        }
        else var expires = "";
        document.cookie = name+"="+value+expires+"; path=/";
    }

});


