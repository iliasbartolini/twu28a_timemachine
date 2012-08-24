function FavoriteTimesheet()
{
    this.existingFavorites = ["TWU"];

    this.addExistingFavoriteName = function(name) {
        this.existingFavorites.push(name);
    };

    this.existsFavoriteName = function(value) {

        var existsFavoriteName = false;

        $(this.existingFavorites).each(function(){
            if ( this == value ) {
                existsFavoriteName = true;
            }
        });

        return existsFavoriteName;
    };
}