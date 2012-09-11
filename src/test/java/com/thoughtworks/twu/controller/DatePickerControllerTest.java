package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.domain.Employee;
import com.thoughtworks.twu.domain.Message;
import com.thoughtworks.twu.domain.timesheet.forms.DatePickerForm;
import com.thoughtworks.twu.service.DatePickerService;
import com.thoughtworks.twu.service.EmployeeService;
import com.thoughtworks.twu.service.MessageService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DatePickerControllerTest {

    private DatePickerService datePickerService;
    private EmployeeService employeeService;
    private BindingResult errors;
    private HttpServletRequest httpServletRequest;
    private String USER_NAME = "test.twu1";
    private DatePickerController datePickerController;
    private DatePickerForm datePickerForm;
    private Employee employee;
    private MessageService messageService;
    private Message duplicateTimesheetForWeek;


    @Before
    public void setUp() throws Exception {

        mockEmployee();
        mockHttpRequest();
        mockMessageService();
        datePickerService = mock(DatePickerService.class);
        datePickerController = new DatePickerController(datePickerService, employeeService, messageService);

        datePickerForm = new DatePickerForm();
        datePickerForm.setWeekEndingDate("15-Sep-12");

        errors = new BindException(datePickerForm, "datePickerForm");
    }

    private void mockMessageService() {
        messageService = mock(MessageService.class);
        duplicateTimesheetForWeek = new Message("Duplicated week ending date", "DuplicateTimesheetForWeek");
        when(messageService.getMessageMessageById("DuplicateTimesheetForWeek")).thenReturn(duplicateTimesheetForWeek);
    }

    private void mockHttpRequest() {
        httpServletRequest = mock(HttpServletRequest.class);
        when(httpServletRequest.getRemoteUser()).thenReturn(USER_NAME);
    }

    private void mockEmployee() {
        employeeService = mock(EmployeeService.class);
        employee = new Employee();
        when(employeeService.getEmployeeByLogin(USER_NAME)).thenReturn(employee);
    }

    @Test
    public void shouldGetDatePickerModelAndView(){
       ModelAndView modelAndView = datePickerController.getDatePicker(datePickerForm, errors);

       assertThat(modelAndView.getViewName(),is("ui/timesheet/date_picker"));
   }

    @Test
    public void shouldDisplayErrorsIfWeekEndingDateAlreadyExists() throws Exception {
        //Arrange
        when(datePickerService.hasWeekEndingDate("15-Sep-12", employee)).thenReturn(true);

        //Act
        ModelAndView modelAndView = datePickerController.submitWeekendDate(datePickerForm, errors, httpServletRequest);

        //Assert
        BindException errorsModelAndView = (BindException) modelAndView.getModel().get("errors");
        assertThat(errorsModelAndView.hasErrors(),is(true));
        assertThat(modelAndView.getViewName(), is("ui/timesheet/date_picker"));
    }

    @Test
    public void shouldRedirectIfWeekEndingDateNotExists() throws Exception {
        //Arrange
        when(datePickerService.hasWeekEndingDate("15-Sep-12", employee)).thenReturn(false);

        //Act
        ModelAndView modelAndView = datePickerController.submitWeekendDate(datePickerForm, errors, httpServletRequest);

        //Assert
        BindException errorResult = (BindException) modelAndView.getModel().get("errors");
        assertNull(errorResult);
        assertThat(modelAndView.getViewName(), is("redirect:/timesheet/new?weekEndingDate="+datePickerForm.getWeekEndingDate()));
    }
}
