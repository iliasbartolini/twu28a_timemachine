package com.thoughtworks.twu.domain.validators;


import com.thoughtworks.twu.domain.timesheet.forms.TimeRecordForm;
import com.thoughtworks.twu.domain.timesheet.forms.TimeSheetRecord;
import com.thoughtworks.twu.service.MessageService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class LocationValidator implements Validator {
    MessageService messageService = new MessageService();
    public boolean supports(Class<?> clazz) {
        return TimeRecordForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object object, Errors errors){

        TimeRecordForm timeRecordForm = (TimeRecordForm) object;
        if(timeRecordForm.getCountry().equals("Select a country"))
        {
            errors.rejectValue("country","CountryCannotBeUnspecified",messageService.getMessageForField(7));
        }
       if (timeRecordForm.getCountry().equals("USA - USA") && timeRecordForm.getState().equals("Select a state"))

       {
           errors.rejectValue("state","StateCannotBeUnspecified",messageService.getMessageForField(8));
       }
    }


}
