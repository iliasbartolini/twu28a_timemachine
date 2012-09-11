package com.thoughtworks.twu.domain.validationTests;

import com.thoughtworks.twu.domain.Employee;
import com.thoughtworks.twu.domain.timesheet.forms.DatePickerForm;
import com.thoughtworks.twu.domain.validators.DatePickerValidator;
import com.thoughtworks.twu.service.DatePickerService;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.springframework.validation.BindException;

public class DatePickerValidatorTest {

    private DatePickerForm datePickerForm;
    private BindException errors;
    private String WEEK_ENDING_DATE;
    private Employee employee;
    private DatePickerService datePickerService;

    @Before
    public void setUp() throws Exception {

        datePickerForm = new DatePickerForm();
        errors = new BindException(datePickerForm, "datePickerForm");
        WEEK_ENDING_DATE = "15-Sep-12";
        employee = new Employee();
        datePickerForm.setWeekEndingDate(WEEK_ENDING_DATE);

        datePickerService = mock(DatePickerService.class);
    }

    @Test
    public void shouldFailValidationIfTimesheetWithSameWeekEndingDateExists(){

        when(datePickerService.hasWeekEndingDate(WEEK_ENDING_DATE, employee)).thenReturn(true);

        DatePickerValidator datePickerValidator = new DatePickerValidator(datePickerService, employee);
        datePickerValidator.validate(datePickerForm, errors);

        assertEquals(true, errors.hasErrors());
        assertEquals("Duplicated week ending date.", errors.getFieldError("weekEndingDate").getCode());
    }

    @Test
    public void shouldNotFailValidationIfTimesheetWithSameWeekEndingDateDoesNotExists(){

        when(datePickerService.hasWeekEndingDate(WEEK_ENDING_DATE, employee)).thenReturn(false);

        DatePickerValidator datePickerValidator = new DatePickerValidator(datePickerService, employee);
        datePickerValidator.validate(datePickerForm, errors);

        assertEquals(false,errors.hasErrors());
    }

}
