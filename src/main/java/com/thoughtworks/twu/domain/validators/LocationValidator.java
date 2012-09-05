package com.thoughtworks.twu.domain.validators;

import com.thoughtworks.twu.domain.timesheet.forms.TimeSheetForm;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class LocationValidator implements Validator {

    public boolean supports(Class<?> clazz) {
        return TimeSheetForm.class.isAssignableFrom(clazz);
    }

    public void validate(Object object, Errors errors){
        TimeSheetForm timeSheetForm = (TimeSheetForm) object;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "field.required");


        if (timeSheetForm.getCountry() == "USA" && timeSheetForm.getState()== null) {
            errors.rejectValue("state", "StateCannotBeUnspecified");
        }

    }


}
