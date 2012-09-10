package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.domain.Timesheet;
import com.thoughtworks.twu.service.TimesheetService;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

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
//
//    @Test
//    public void shouldLoadTimesheets() throws Exception {
//        TimesheetService timesheetService = mock(TimesheetService.class);
//
//        DashboardController controller = new DashboardController(timesheetService);
//
//        HttpServletRequest request = mock(HttpServletRequest.class);
//
//        ModelAndView modelAndView = controller.show(request);
//
//        List<Timesheet> timesheets = (List<Timesheet>) modelAndView.getModel().get("timesheets");
//        assertThat(timesheets.size(), is(1));
//    }
}
