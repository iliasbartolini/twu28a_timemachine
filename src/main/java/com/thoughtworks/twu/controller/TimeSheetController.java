package com.thoughtworks.twu.controller;


import com.thoughtworks.twu.constants.URLPaths;
import com.thoughtworks.twu.domain.Timesheet;
import com.thoughtworks.twu.domain.timesheet.forms.TimeRecordForm;
import com.thoughtworks.twu.domain.timesheet.forms.TimesheetForm;
import com.thoughtworks.twu.persistence.HibernateConnection;
import com.thoughtworks.twu.service.EmployeeService;
import com.thoughtworks.twu.service.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class TimeSheetController {

    private final EmployeeService employeeService;
    private TimesheetService timesheetService;

    @Autowired
    public TimeSheetController(EmployeeService employeeService, TimesheetService timesheetService) {
        this.employeeService = employeeService;
        this.timesheetService = timesheetService;
    }


    @RequestMapping(value = URLPaths.DATEPICKER_PATH, method = RequestMethod.GET)
    public ModelAndView weekEndingDate() {

        ModelAndView modelAndView = new ModelAndView("ui/timesheet/date_picker");
        return modelAndView;
    }

    @RequestMapping(value = "/timesheet/timeSheet", method = RequestMethod.GET)
    public ModelAndView getTimesheet() {
        ModelAndView modelAndView = new ModelAndView("ui/timesheet/timeSheet");
        HibernateConnection.getInstance().getSession().close();
        return modelAndView;
    }


//    @RequestMapping(value = "/timesheet/datepicker", method = RequestMethod.GET)
//    public ModelAndView pickDate() {
//
//        ModelAndView modelAndView = new ModelAndView("ui/timesheet/date_picker");
//
//        HibernateConnection.getInstance().getSession().close();
//
//        return modelAndView;
//    }


    @RequestMapping(value = URLPaths.NEW_TIMESHEET_PATH, method = RequestMethod.GET)
    public ModelAndView newTimeSheet(HttpServletRequest request) {
        String weekEndingDate = request.getParameter("weekEndingDate");

        ModelAndView modelAndView = new ModelAndView("ui/timesheet/newtimesheet");

        modelAndView.addObject("employee", employeeService.getEmployeeByLogin(request.getRemoteUser()));
        modelAndView.addObject("weekEndingDate", weekEndingDate);

        HibernateConnection.getInstance().getSession().close();
        return modelAndView;
    }

    @RequestMapping(value = "/timesheet/submit", method = RequestMethod.POST)
    public String submitTimesheet(@ModelAttribute("timesheet") TimesheetForm timesheet) {

        timesheetService.saveTimesheet(timesheet.toTimesheet());

        return "redirect:/";
    }
}



