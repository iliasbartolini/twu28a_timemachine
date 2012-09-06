package com.thoughtworks.twu.controller;


import com.thoughtworks.twu.domain.Timesheet;
import com.thoughtworks.twu.persistence.HibernateConnection;
import com.thoughtworks.twu.service.EmployeeService;
import com.thoughtworks.twu.service.TimesheetService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

    @Controller
    public class TimeSheetController {
        @RequestMapping(value = "/timesheet/timeSheet", method = RequestMethod.GET)
        public ModelAndView getTimesheet() {
            ModelAndView modelAndView = new ModelAndView("ui/timesheet/timeSheet");
            return modelAndView;
        }


    @RequestMapping(value = "/timesheet/datepicker", method = RequestMethod.GET)
    public ModelAndView pickDate() {

        ModelAndView modelAndView = new ModelAndView("ui/timesheet/date_picker");

        HibernateConnection.getInstance().getSession().close();

        return modelAndView;
    }

    @RequestMapping(value = "/timesheet/temp_new_timesheet", method = RequestMethod.GET)
    public ModelAndView temporaryNewTimesheet(HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView("ui/timesheet/tempTimesheet");

        EmployeeService employeeService = new EmployeeService();

        TimesheetService timesheetService = new TimesheetService();
        Timesheet timesheet = timesheetService.addNewTimeSheet();

        modelAndView.addObject("employee", employeeService.getEmployeeByLogin(request.getRemoteUser()));
        modelAndView.addObject("timesheet", timesheet);

        HibernateConnection.getInstance().getSession().close();

        return modelAndView;
    }
    }



