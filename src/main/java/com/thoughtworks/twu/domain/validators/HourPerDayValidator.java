package com.thoughtworks.twu.domain.validators;

import com.sun.xml.internal.ws.developer.MemberSubmissionAddressing;
import com.thoughtworks.twu.domain.timesheet.forms.TimeSheetForm;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created with IntelliJ IDEA.
 * User: ewonou
 * Date: 31/8/12
 * Time: 5:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class HourPerDayValidator implements Validator {
    public boolean supports(Class<?> clazz) {
        return TimeSheetForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        TimeSheetForm timeSheetForm = (TimeSheetForm) object;

        if ((timeSheetForm.getMonday()*4)!= ((int)(timeSheetForm.getMonday()*4))){
            errors.rejectValue("monday","Should Be in Increment Of 0.25");
        }

    }
}
