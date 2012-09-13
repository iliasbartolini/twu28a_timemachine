$(function() {
    $("#timeRecord").click(function() {
        $.post("save_partial", $("form").serialize(), function() {
        });
    });
});