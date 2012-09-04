package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.domain.NewTimesheetForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.RequestToViewNameTranslator;

import javax.servlet.http.HttpServletRequest;

@Controller
public class NewTimesheetController {
    @RequestMapping(value =  "timesheet/newTimesheet", method = RequestMethod.GET)
    public ModelAndView getTimesheet() {
        ModelAndView modelAndView = new ModelAndView("timesheet/newTimesheet");
        return modelAndView;
    }

    @RequestMapping(params = "newActivity", method = RequestMethod.POST)
    public ModelAndView displayTimeSheet(@ModelAttribute("newTimeSheetForm") NewTimesheetForm newTimesheetForm) {
        ModelAndView modelAndView = new ModelAndView("new_form");
        return modelAndView;
    }

//    @RequestMapping(params ="savedActivity", method = RequestMethod.POST)
//    public ModelAndView selectActivity(HttpServletRequest request, @ModelAttribute("newTimeSheetForm") NewTimesheetForm newTimesheetForm) {
//        ModelAndView modelAndView = new ModelAndView("new_form");
//
//        return  null;
//    }


}
