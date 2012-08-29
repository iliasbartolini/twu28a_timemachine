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
