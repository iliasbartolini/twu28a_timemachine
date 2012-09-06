package com.thoughtworks.twu.domain.validators;

import com.thoughtworks.twu.domain.timesheet.forms.TimeRecordForm;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class LocationValidator implements Validator {

    public boolean supports(Class<?> clazz) {
        return TimeRecordForm.class.isAssignableFrom(clazz);
    }

    public void validate(Object object, Errors errors){
        TimeRecordForm timeRecordForm = (TimeRecordForm) object;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "field.required");


        if (timeRecordForm.getCountry() == "USA" && timeRecordForm.getState()== null) {
            errors.rejectValue("state", "StateCannotBeUnspecified");
        }

    }


}
