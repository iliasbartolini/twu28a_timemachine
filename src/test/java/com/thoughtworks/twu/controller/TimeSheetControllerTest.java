package com.thoughtworks.twu.controller;


import com.thoughtworks.twu.domain.Employee;
import com.thoughtworks.twu.domain.Timesheet;
import com.thoughtworks.twu.service.EmployeeService;
import com.thoughtworks.twu.service.TimesheetService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;


    public class TimeSheetControllerTest {
        TimeSheetController controller;
        Employee expectedEmployee;
        Timesheet expectedTimesheet;
        HttpServletRequest request;

        @Before
        public void setUp() throws Exception {

            expectedEmployee = new Employee();
            expectedTimesheet = new Timesheet();

            EmployeeService employeeService = mock(EmployeeService.class);
            when(employeeService.getEmployeeByLogin("batman")).thenReturn(expectedEmployee);


            TimesheetService timesheetService = mock(TimesheetService.class);
            when(timesheetService.createNewTimesheet()).thenReturn(expectedTimesheet);


            request = mock(HttpServletRequest.class);
            when(request.getRemoteUser()).thenReturn("batman");

            controller = new TimeSheetController(employeeService, timesheetService);
        }

        @Ignore
        @Test
        public void shouldBeAbleToGetViewNameOfController() throws Exception {
            assertEquals("ui/timesheet/timeSheet", controller.getTimesheet().getViewName());
        }

        @Test
        public void shouldBeAbleToDisplayDatePickerDialog() throws Exception {
            assertEquals("ui/timesheet/date_picker", controller.pickDate().getViewName());
        }

        @Test
        public void shouldDisplayNewTimeSheetView() {
            assertEquals("ui/timesheet/newtimesheet", controller.newTimeSheet(request).getViewName());
        }

        @Test
        public void shouldAddEmployeeToModel() {



            ModelAndView modelAndView = controller.newTimeSheet(request);
            Employee actualEmployee = (Employee) modelAndView.getModel().get("employee");

            assertThat(actualEmployee, is(expectedEmployee));

        }

        @Test
        public void shouldAddTimesheetToModel() {


            ModelAndView modelAndView = controller.newTimeSheet(request);
            Timesheet actualTimesheet = (Timesheet) modelAndView.getModel().get("timesheet");

            assertThat(actualTimesheet, is(expectedTimesheet));

        }

    }

