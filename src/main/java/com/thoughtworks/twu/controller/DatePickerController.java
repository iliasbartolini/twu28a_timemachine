package com.thoughtworks.twu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DatePickerController {

    @RequestMapping(value = "/timesheet/datepicker", method = RequestMethod.GET)
    public ModelAndView getDatePicker() {
        ModelAndView modelAndView = new ModelAndView("ui/timesheet/date_picker");
        return modelAndView;
    }


}
