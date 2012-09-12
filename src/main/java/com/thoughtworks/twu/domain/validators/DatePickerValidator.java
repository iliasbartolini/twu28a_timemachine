package com.thoughtworks.twu.domain.validators;

import com.thoughtworks.twu.domain.Employee;
import com.thoughtworks.twu.domain.Message;
import com.thoughtworks.twu.domain.timesheet.forms.TimesheetForm;
import com.thoughtworks.twu.service.DatePickerService;
import com.thoughtworks.twu.service.MessageService;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class DatePickerValidator implements Validator {


    private DatePickerService datePickerService;
    private Employee employee;
    private MessageService messageService;

    public DatePickerValidator(DatePickerService datePickerService, Employee employee, MessageService messageService) {
        this.datePickerService = datePickerService;
        this.employee = employee;
        this.messageService = messageService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return TimesheetForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        TimesheetForm timesheetForm = (TimesheetForm) target;

        Message emptyWeekEndingTimesheet = messageService.getMessageById("WeekCannotBeUnspecified");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "weekEndingDate", emptyWeekEndingTimesheet.getMessage());

        if ( !errors.hasErrors() ) {
            boolean hasWeekEndingDate = datePickerService.hasWeekEndingDate(timesheetForm.getWeekEndingDate(), employee);

            if ( hasWeekEndingDate ) {
                Message duplicateTimesheetForWeek = messageService.getMessageById("DuplicateTimesheetForWeek");
                errors.rejectValue("weekEndingDate", duplicateTimesheetForWeek.getMessage());
            }
        }
    }
}
