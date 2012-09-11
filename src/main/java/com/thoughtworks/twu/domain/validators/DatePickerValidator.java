package com.thoughtworks.twu.domain.validators;

import com.thoughtworks.twu.domain.Employee;
import com.thoughtworks.twu.domain.Message;
import com.thoughtworks.twu.domain.timesheet.forms.DatePickerForm;
import com.thoughtworks.twu.domain.timesheet.forms.TimeRecordForm;
import com.thoughtworks.twu.service.DatePickerService;
import com.thoughtworks.twu.service.EmployeeService;
import com.thoughtworks.twu.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        return DatePickerForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        DatePickerForm datePickerForm = (DatePickerForm) target;

        boolean hasWeekEndingDate = datePickerService.hasWeekEndingDate(datePickerForm.getWeekEndingDate(), employee);

        if ( hasWeekEndingDate ) {
            Message message = messageService.getMessageMessageById("DuplicateTimesheetForWeek");
            errors.rejectValue("weekEndingDate", message.getMessage());
        }
    }
}
