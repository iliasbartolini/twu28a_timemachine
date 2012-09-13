package com.thoughtworks.twu.controller;


import com.thoughtworks.twu.constants.URLPaths;

import com.thoughtworks.twu.domain.Employee;

import com.thoughtworks.twu.domain.Timesheet;
import com.thoughtworks.twu.domain.timesheet.forms.TimesheetForm;
import com.thoughtworks.twu.domain.validators.DatePickerValidator;
import com.thoughtworks.twu.persistence.HibernateConnection;
import com.thoughtworks.twu.service.DatePickerService;
import com.thoughtworks.twu.service.EmployeeService;
import com.thoughtworks.twu.service.MessageService;
import com.thoughtworks.twu.service.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TimeSheetController {

    private final EmployeeService employeeService;
    private TimesheetService timesheetService;
    private DatePickerService datePickerService;
    private MessageService messageService;

    @Autowired
    public TimeSheetController(DatePickerService datePickerService, EmployeeService employeeService, TimesheetService timesheetService, MessageService messageService) {
        this.employeeService = employeeService;
        this.timesheetService = timesheetService;
        this.datePickerService = datePickerService;
        this.messageService = messageService;
    }

    @RequestMapping(value = URLPaths.NEW_TIMESHEET_PATH, method = RequestMethod.GET)
    public ModelAndView newTimeSheet(HttpServletRequest request, @ModelAttribute("timesheetForm") TimesheetForm timesheet, BindingResult errors) {

        String weekEndingDate = (String) request.getSession().getAttribute("weekEndingDate");
        timesheet.setWeekEndingDate(weekEndingDate == null ? "" : weekEndingDate);

        ModelAndView modelAndView = new ModelAndView("ui/timesheet/newtimesheet");

        modelAndView.addObject("employee", employeeService.getEmployeeByLogin(request.getRemoteUser()));
        modelAndView.addObject("errors", errors);

        return modelAndView;
    }

    @RequestMapping(value = "timesheet/save_partial", method = RequestMethod.POST)
    @ResponseBody
    public String savePartialData(HttpServletRequest request, TimesheetForm timesheetForm) {
        request.getSession().setAttribute("weekEndingDate", timesheetForm.getWeekEndingDate());
        return "true";
    }

    @RequestMapping(value = "/timesheet/submit", method = RequestMethod.POST)
    public ModelAndView submitTimesheet(@ModelAttribute("timesheetForm") TimesheetForm timesheetForm, BindingResult errors, HttpServletRequest request) {

        Employee employee = employeeService.getEmployeeByLogin(request.getRemoteUser());

        DatePickerValidator datePickerValidator = new DatePickerValidator(datePickerService, employee, messageService);
        datePickerValidator.validate(timesheetForm, errors);

        if (!errors.hasErrors()) {
            Timesheet timesheet = timesheetForm.toTimesheet(employee);
            timesheetService.saveTimesheet(timesheet);
            return new ModelAndView("redirect:/");
        } else {
            return newTimeSheet(request, timesheetForm, errors);
        }

//
//        //WW
//        Timesheet unsubmittedSheet = timesheetService.getTimeSheetById(Integer.valueOf(timesheetForm.getId()));
//        unsubmittedSheet.setIsSubmitted(true);
//        timesheetService.saveTimesheet(unsubmittedSheet);
//        return "redirect:/";
    }

    public void saveTimesheet(TimesheetForm timesheetForm, HttpServletRequest request) {

        Employee employee = employeeService.getEmployeeByLogin(request.getRemoteUser());

        Timesheet newTimesheet = timesheetForm.toTimesheet(employee);
        timesheetService.saveTimesheet(newTimesheet);
    }
}



