package com.thoughtworks.twu.domain.validators;

import com.thoughtworks.twu.domain.timesheet.forms.TimeSheetForm;
import com.thoughtworks.twu.domain.timesheet.forms.TimeSheetForm;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created with IntelliJ IDEA.
 * User: ewonou
 * Date: 30/8/12
 * Time: 11:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class ActivityValidator implements Validator {

    public boolean supports(Class<?> clazz) {
        return TimeSheetForm.class.isAssignableFrom(clazz);
    }

    public void validate(Object object, Errors errors){
        TimeSheetForm timeSheetForm = (TimeSheetForm) object;
        ValidationUtils.rejectIfEmptyOrWhitespace( errors,"activity","field.required");
    }
}
