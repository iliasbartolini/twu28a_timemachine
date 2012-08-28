$(function() {
    $.mobile.ajaxEnabled = false;

    var favorite = new FavoriteTimesheet();

    $("#existingFavorites li").each(function() {
       favorite.addExistingFavoriteName($(this).text());
    });

    window.db = favorite;

    $.validator.addMethod("duplicateFavorite", function(value) {
        return !favorite.isDuplicated(value);
    });

    $("#new_favorite_form").validate({
        rules: {
            name: {
                duplicateFavorite : true,
                required: true
            }
        },
        messages: {
            name: {
                required: "Name field cannot be left blank.",
                duplicateFavorite: "Duplicate name. Please try another name."
            }
        }
    });
});