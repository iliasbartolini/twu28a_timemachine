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

    $.validator.addMethod("isDuplicate", function(value) {
        return !favorite.existsFavoriteName(value);
    });


    $("#new_favorite_form").validate({
        groups: {
            hours: "monday tuesday wednesday thursday friday saturday sunday"
        },
        rules: {
            name: {
                isDuplicate : true,
                required: true
            },

            monday: {
                required : true,
                number: true
            },

            tuesday: {
                required : true,
                number: true
            },

            wednesday: {
                required : true,
                number: true
            },

            thursday: {
                required : true,
                number: true
            },

            friday: {
                required : true,
                number: true
            },

            saturday: {
                required : true,
                number: true
            },

            sunday: {
                required : true,
                number: true
            }

        },
        messages: {
            name: {
                required: "Name field cannot be left blank.",
                isDuplicate: "Duplicate name. Please try another name."
            }
        },
        errorPlacement: function(error, element) {
            if(element.attr("name") == "name") {
                error.insertAfter("#name");
            } else {
                error.insertAfter( $("#sunday").parent().parent());
            }


        }
    });
});
