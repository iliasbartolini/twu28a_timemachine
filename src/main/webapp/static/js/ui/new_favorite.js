$(function() {
    $.mobile.ajaxEnabled = false;

    var favorite = new FavoriteTimesheet();

<<<<<<< HEAD

    $.validator.addMethod("isDuplicate", function(value) {
        return !favorite.existsFavoriteName(value);
    });
=======
    $.validator.addMethod("duplicateFavorite", favorite.isNotDuplicated);
>>>>>>> 0110c7b2a46f24a22c69557d06f93dd55022ba61

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