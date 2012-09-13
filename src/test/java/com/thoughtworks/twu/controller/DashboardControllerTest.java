package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.service.EmployeeService;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DashboardControllerTest {


    @Test
    public void shouldShowDashboard(){
        DashboardController dashboardController = new DashboardController();

        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getRemoteUser()).thenReturn("test.twu");

        ModelAndView modelAndView = dashboardController.show(request);

        assertThat(modelAndView.getViewName(), is("ui/dashboard/dashboard"));
    }

    @Test
    public void shouldRedirectToErrorPageWhenNoMatchingRecordsFound()
    {
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getRemoteUser()).thenReturn("test");
        EmployeeService employeeService= mock(EmployeeService.class);
        when(employeeService.getEmployeeByLogin("test")).thenReturn(null);
        DashboardController dashboardController = new DashboardController();
        ModelAndView modelAndView = dashboardController.show(request);
        assertThat(modelAndView.getViewName(),is("ui/error"));
    }


}
