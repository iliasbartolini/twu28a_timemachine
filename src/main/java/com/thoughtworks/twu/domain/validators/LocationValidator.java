package com.thoughtworks.twu.domain.validators;

import com.thoughtworks.twu.domain.timesheet.forms.TimeSheetForm;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created with IntelliJ IDEA.
 * User: ewonou
 * Date: 31/8/12
 * Time: 10:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class LocationValidator implements Validator {

    public boolean supports(Class<?> clazz) {
        return TimeSheetForm.class.isAssignableFrom(clazz);
    }

    public void validate(Object object, Errors errors){
        TimeSheetForm timesheetform = (TimeSheetForm) object;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "field.required","Country Should Be Selected");
        if (timesheetform.getCountry() == "USA" && timesheetform.getState()== null) {
            errors.rejectValue("state", "StateCannotBeUnspecified","State Should Be Selected");
        }

    }


}
