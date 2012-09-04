function Activity () {
    this.search = function(searchCriteria, callback)
    {
        if(searchCriteria.length <=2)
            throw new Error("Enter atleast 2 characters");

        $.post( "", { s: searchCriteria },
            function( data ) {

            var activities = JSON.parse(data);
            callback(activities);
        });

    };
}


