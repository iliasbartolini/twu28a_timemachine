function FavoriteTimesheet()
{
    this.existingFavorites = ["TWU"];

    this.addExistingFavoriteName = function(name) {
        this.existingFavorites.push(name);
    };

    this.isNotDuplicated = function(value) {

        var isNotDuplicated = true;

        $(this.existingFavorites).each(function(){
            if ( this == value ) {
                isNotDuplicated = false;
            }
        });

        return isNotDuplicated;
    };
}