function Activity () {

    this.getMessages = function() {

        var messages = [];

        $("#messages li").each(function() {
            var $current = $(this);
            messages[$current.data("message-id")] = $current.text();
        });

        return messages;
    };

    this.search = function(searchCriteria, callback)
    {
        if(searchCriteria.length <= 2) {


        }

        $.post( "", { s: searchCriteria },function( data ) {

                var activities = JSON.parse(data);
                callback(activities);
        });

    };
}


