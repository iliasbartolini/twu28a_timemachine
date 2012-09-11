var Messages = {
    Alteast2CharsForSearch : "Alteast2CharsForSearch",
    NoMatchingActivity : "NoMatchingActivity",
    WeekCannotBeUnspecified : "WeekCannotBeUnspecified",
    messages: [],
    loadMessages : function() {
        $("#messages li").each(function() {
            var $current = $(this);
            Messages.messages[ $current.data("message-id") ] = $current.text();
        });
    },
    getMessage : function(messageId){
        return Messages.messages[messageId];
    }
};

$(function(){
    Messages.loadMessages();
});



