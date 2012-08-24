$(function() {
    $.mobile.ajaxEnabled = false;

    var favorite = new FavoriteTimesheet();


    $.validator.addMethod("isDuplicate", function(value) {
        return !favorite.existsFavoriteName(value);
    });

    $("#new_favorite_form").validate({

        rules: {
            name: {
                isDuplicate : true,
                required: true
            }
        },
        messages: {
            name: {
                required: "Name field cannot be left blank.",
                isDuplicate: "Duplicate name. Please try another name."
            }
        }
    });
});