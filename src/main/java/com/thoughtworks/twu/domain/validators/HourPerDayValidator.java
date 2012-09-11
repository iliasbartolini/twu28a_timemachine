package com.thoughtworks.twu.domain.validators;

import com.thoughtworks.twu.domain.timesheet.forms.TimeRecordForm;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import org.springframework.validation.Errors;


public class HourPerDayValidator implements Validator {
    public boolean supports(Class<?> clazz) {

        return TimeRecordForm.class.isAssignableFrom(clazz);

    }

    @Override
    public void validate(Object object, Errors errors) {

        TimeRecordForm timeRecordForm = (TimeRecordForm) object;

        if ((timeRecordForm.getMonday()*4)!= ((int)(timeRecordForm.getMonday().floatValue()*4))){
            errors.rejectValue("monday","Should Be in Increment Of 0.25","Should be an increment of .25");
        }

    }


}
