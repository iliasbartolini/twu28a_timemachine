function NewTimesheetState() {
    this.isNotUSA = function (countryCode) {
        if (countryCode == "USA - USA") {
            return false;
        }
        else
            return true;
    };


     this.toggleStateList = function () {
        if (this.isNotUSA($('#country').val())) {
            $("#state").selectmenu('disable');
            $("#state option[value='Select a state']").attr('selected', 'selected');
            $('#state').selectmenu('refresh');
        }
        else {
            $('#state').selectmenu('enable');
            $('#country').selectmenu('refresh');
        }


    };

}





