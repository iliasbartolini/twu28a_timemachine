function FavoriteTimesheet()
{
    this.existingFavorites = [];

    this.addExistingFavoriteName = function(name) {
        this.existingFavorites.push(name);
    };

    this.isDuplicated = function(value) {

        var response = false;

        $(this.existingFavorites).each(function(){
            if ( this.trim() == value.trim() ) {
                response = true;
            }
        });

        return response;
    };
}