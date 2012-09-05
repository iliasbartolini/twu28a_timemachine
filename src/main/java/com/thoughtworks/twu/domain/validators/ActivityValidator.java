package com.thoughtworks.twu.domain.validators;

import com.thoughtworks.twu.domain.timesheet.forms.TimeRecordForm;
import com.thoughtworks.twu.service.MessageService;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
public class ActivityValidator implements Validator {
    MessageService messageService = new MessageService();

    public boolean supports(Class<?> clazz) {
        return TimeRecordForm.class.isAssignableFrom(clazz);
    }

    public void validate(Object object, Errors errors){

        TimeRecordForm timeRecordForm = (TimeRecordForm) object;
        ValidationUtils.rejectIfEmptyOrWhitespace( errors,"activity","field.required",messageService.getMessageForField(9));
    }
}
