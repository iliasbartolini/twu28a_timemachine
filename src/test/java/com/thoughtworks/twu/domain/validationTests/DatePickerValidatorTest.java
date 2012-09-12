package com.thoughtworks.twu.domain.validationTests;

import com.thoughtworks.twu.domain.Employee;
import com.thoughtworks.twu.domain.Message;
import com.thoughtworks.twu.domain.timesheet.forms.TimesheetForm;
import com.thoughtworks.twu.domain.validators.DatePickerValidator;
import com.thoughtworks.twu.service.DatePickerService;
import com.thoughtworks.twu.service.MessageService;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.springframework.validation.BindException;

public class DatePickerValidatorTest {

    private TimesheetForm timesheetForm = new TimesheetForm();
    private BindException errors;
    private String WEEK_ENDING_DATE = "15-Sep-12";
    private Employee employee;
    private DatePickerService datePickerService;
    private MessageService messageService;
    private Message duplicateTimesheetForWeek;
    private DatePickerValidator datePickerValidator;
    private Message weekEndingDateCanNotBeNotEmpty;

    @Before
    public void setUp() throws Exception {

        errors = new BindException(timesheetForm, "timesheetForm");
        employee = new Employee();

        datePickerService = mock(DatePickerService.class);
        mockMessages();

        datePickerValidator = new DatePickerValidator(datePickerService, employee, messageService);
    }

    private void mockMessages() {
        messageService = mock(MessageService.class);

        duplicateTimesheetForWeek = new Message("Duplicated week ending date", "DuplicateTimesheetForWeek");
        weekEndingDateCanNotBeNotEmpty = new Message("Week ending date is required.", "WeekCannotBeUnspecified");

        when(messageService.getMessageById("DuplicateTimesheetForWeek")).thenReturn(duplicateTimesheetForWeek);
        when(messageService.getMessageById("WeekCannotBeUnspecified")).thenReturn(weekEndingDateCanNotBeNotEmpty);
    }

    @Test
    public void shouldFailValidationIfTimesheetWithSameWeekEndingDateExists() {
        //Given
        timesheetForm.setWeekEndingDate(WEEK_ENDING_DATE);
        when(datePickerService.hasWeekEndingDate(WEEK_ENDING_DATE, employee)).thenReturn(true);

        //When
        datePickerValidator.validate(timesheetForm, errors);

        //Then
        assertEquals(true, errors.hasErrors());
        assertEquals(duplicateTimesheetForWeek.getMessage(), errors.getFieldError("weekEndingDate").getCode());
    }

    @Test
    public void shouldNotFailValidationIfTimesheetWithSameWeekEndingDateDoesNotExists() {
        //Given
        timesheetForm.setWeekEndingDate(WEEK_ENDING_DATE);
        when(datePickerService.hasWeekEndingDate(WEEK_ENDING_DATE, employee)).thenReturn(false);

        //When
        datePickerValidator.validate(timesheetForm, errors);

        //Then
        assertEquals(false, errors.hasErrors());
    }

    @Test
    public void shouldNotAcceptEmptyDateField() throws Exception {
        //Given
        timesheetForm.setWeekEndingDate("");

        //When
        datePickerValidator.validate(timesheetForm, errors);

        //Then
        assertEquals(weekEndingDateCanNotBeNotEmpty.getMessage(), errors.getFieldError("weekEndingDate").getCode());
    }
}
