package com.thoughtworks.twu.controller;


import com.thoughtworks.twu.domain.Employee;
import com.thoughtworks.twu.domain.Timesheet;
import com.thoughtworks.twu.domain.timesheet.forms.TimesheetForm;
import com.thoughtworks.twu.service.EmployeeService;
import com.thoughtworks.twu.service.TimesheetService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import static org.testng.Assert.assertEquals;


public class TimeSheetControllerTest {
    TimeSheetController controller;
    Employee expectedEmployee;
    Timesheet expectedTimesheet;
    HttpServletRequest request;
    private Timesheet timesheet;

    @Before
    public void setUp() throws Exception {

        expectedEmployee = new Employee();
        expectedEmployee.setEmployeeNumber("5678");
        expectedTimesheet = new Timesheet();

        EmployeeService employeeService = mock(EmployeeService.class);
        when(employeeService.getEmployeeByLogin("batman")).thenReturn(expectedEmployee);


        TimesheetService timesheetService = mock(TimesheetService.class);
        when(timesheetService.createNewTimesheet()).thenReturn(expectedTimesheet);



        request = mock(HttpServletRequest.class);
        when(request.getRemoteUser()).thenReturn("batman");
        when(request.getParameter("weekEndingDate")).thenReturn("10-SEP-2012");

        controller = new TimeSheetController(employeeService, timesheetService);
    }

    @Test
    public void shouldDisplayNewTimeSheetView() throws ParseException {
        assertEquals("ui/timesheet/newtimesheet", controller.newTimeSheet(request).getViewName());
    }

    @Test
    public void shouldAddEmployeeToModel() throws ParseException {

        ModelAndView modelAndView = controller.newTimeSheet(request);
        Employee actualEmployee = (Employee) modelAndView.getModel().get("employee");

        assertThat(actualEmployee, is(expectedEmployee));
    }

    @Test
    public void shouldSaveTimeSheet() throws Exception {
        TimesheetForm timesheetForm = new TimesheetForm();
        timesheetForm.setWeekEndingDate("15-Sep-12");

        expectedTimesheet.setWeekEndingDate(new SimpleDateFormat("dd-MMM-yy").parse("15-Sep-12"));
        expectedTimesheet.setEmployeeNumber(String.valueOf(expectedEmployee.getEmployeeNumber()));

        TimesheetService timesheetService = mock(TimesheetService.class);
        EmployeeService employeService = mock(EmployeeService.class);

        when(employeService.getEmployeeByLogin("batman")).thenReturn(expectedEmployee);

        TimeSheetController controller = new TimeSheetController(employeService, timesheetService);
        controller.submitTimesheet(timesheetForm, request);

        verify(timesheetService).saveTimesheet(expectedTimesheet);
    }
}

