function Activity () {

    var _this = this;

    this.load = function () {
        this.messages = {};
        var $list = $("#activityList");
        $list.empty();
        $("#messages li").each(function () {
            var $current = $(this);
            _this.messages[ $current.data("message-id") ] = $current.text();
        });
    };

    this.load();

    this.getMessages = function () {
        return this.messages;
    };

    this.search = function (searchCriteria, callback) {
        if (searchCriteria.length < 2) {
            console.log("reached here");
            throw new Error(this.getMessages()[Messages.Alteast2CharsForSearch]);
        }

        $.post("", { s:searchCriteria }, function (data) {
            var activities = JSON.parse(data);
            callback(activities);
        });
    };
}


