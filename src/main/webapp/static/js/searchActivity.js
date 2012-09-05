function Activity () {
    this.search = function(searchCriteria, callback)
    {
        var activityList = document.getElementById("activityList");
      // var noMatchingActivity = document.getElementById("NoMatchingActivity").value;
        //var alteast2CharsForSearch = document.getElementById("Alteast2CharsForSearch").value;
        if(searchCriteria.length <=2){
         //   activityList.innerHTML = alteast2CharsForSearch;
            return;
        }

        $.post( "", { s: searchCriteria },
            function( data ) {

                var activities = JSON.parse(data);
                if(activities.length > 0){
                    callback(activities);
                }
                else{

          //          activityList.innerHTML =  noMatchingActivity;

                }
        });

    };
}


