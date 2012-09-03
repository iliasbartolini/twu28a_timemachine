function NewTimesheetState() {


    this.isNotUSA = function (countryCode) {
        if (countryCode == "USA") {
            return false;
        }
        else
            return true;
    };


     this.toggleStateList = function () {
        if (this.isNotUSA($('#country').val())) {
            $("#state").selectmenu('disable');

            $("#state option[value='']").attr('selected', 'selected');
            $('#state').selectmenu('refresh');
        }
        else {
            $("#state").selectmenu('enable');
            $('#country').selectmenu('refresh');
        }
    };

}

$(function(){
    var changeState = new NewTimesheetState();

    $("#country").change(function () {
        changeState.toggleStateList();
    });

});


