package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.constants.URLPaths;
import com.thoughtworks.twu.domain.Employee;
import com.thoughtworks.twu.domain.timesheet.forms.DatePickerForm;
import com.thoughtworks.twu.domain.validators.DatePickerValidator;
import com.thoughtworks.twu.service.DatePickerService;
import com.thoughtworks.twu.service.EmployeeService;
import com.thoughtworks.twu.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DatePickerController {

    private final DatePickerService datePickerService;
    private final EmployeeService employeeService;
    private MessageService messageService;

    @Autowired
    public DatePickerController(DatePickerService datePickerService, EmployeeService employeeService, MessageService messageService) {
        this.datePickerService = datePickerService;
        this.employeeService = employeeService;
        this.messageService = messageService;
    }

    @RequestMapping(value = URLPaths.DATEPICKER_PATH, method = RequestMethod.GET)
    public ModelAndView getDatePicker(@ModelAttribute("datePickerForm") DatePickerForm date, BindingResult errors) {
        ModelAndView modelAndView = new ModelAndView("ui/timesheet/date_picker");
        modelAndView.addObject("errors", errors);
        return modelAndView;
    }

    @RequestMapping(value = URLPaths.DATEPICKER_PATH, method = RequestMethod.POST)
    public ModelAndView submitWeekendDate(@ModelAttribute("datePickerForm") DatePickerForm date, BindingResult errors, HttpServletRequest request) {


        Employee employee = employeeService.getEmployeeByLogin(request.getRemoteUser());

        Validator datePickerValidator = new DatePickerValidator(datePickerService, employee, messageService);
        datePickerValidator.validate(date, errors);

        if(errors.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("ui/timesheet/date_picker");
            modelAndView.addObject("errors", errors);
            return modelAndView;
        }
        else {
            return new ModelAndView("redirect:/timesheet/new?weekEndingDate=" + date.getWeekEndingDate());
        }
    }
}
