package com.thoughtworks.twu.controller;


import com.thoughtworks.twu.domain.timesheet.forms.TimeRecordForm;
import com.thoughtworks.twu.persistence.HibernateConnection;
import com.thoughtworks.twu.service.EmployeeService;
import com.thoughtworks.twu.service.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TimeSheetController {

    private final EmployeeService employeeService;
    private TimesheetService timesheetService;

    @Autowired
    public TimeSheetController(EmployeeService employeeService, TimesheetService timesheetService) {
        this.employeeService = employeeService;
        this.timesheetService = timesheetService;
    }

    @RequestMapping(value = "/timesheet/timeSheet", method = RequestMethod.GET)
    public ModelAndView getTimesheet() {
        ModelAndView modelAndView = new ModelAndView("ui/timesheet/timeSheet");
        TimeRecordForm timeRecordForm = new TimeRecordForm();
        modelAndView.addObject("timeRecordForm" ,timeRecordForm) ;
        HibernateConnection.getInstance().getSession().close();
        return modelAndView;
    }


    @RequestMapping(value = "/timesheet/datepicker", method = RequestMethod.GET)
    public ModelAndView pickDate() {

        ModelAndView modelAndView = new ModelAndView("ui/timesheet/date_picker");

        HibernateConnection.getInstance().getSession().close();

        return modelAndView;
    }

    @RequestMapping(value = "/timesheet/newtimesheet", method = RequestMethod.GET)
    public ModelAndView newTimeSheet(HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView("ui/timesheet/newtimesheet");

        modelAndView.addObject("employee", employeeService.getEmployeeByLogin(request.getRemoteUser()));
        modelAndView.addObject("timesheet", timesheetService.createNewTimesheet());
        HibernateConnection.getInstance().getSession().close();
        return modelAndView;
    }
}



