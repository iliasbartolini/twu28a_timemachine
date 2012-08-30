package com.thoughtworks.twu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController {

    public static final String DASHBOARD_PAGE = "ui/dashboard/dashboard";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView show() {
        return new ModelAndView(DASHBOARD_PAGE);
    }
}


