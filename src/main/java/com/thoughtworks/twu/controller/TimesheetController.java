package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.domain.timesheet.forms.FavoriteTimesheetForm;
import com.thoughtworks.twu.persistence.FavoriteTimesheet;
import com.thoughtworks.twu.persistence.HibernateConnection;
import com.thoughtworks.twu.service.CountryService;
import com.thoughtworks.twu.service.FavoriteTimesheetService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TimesheetController {

    FavoriteTimesheetService favoriteTimesheetService = new FavoriteTimesheetService();

    @RequestMapping(value = "/timesheet/new", method = RequestMethod.GET)
    public ModelAndView newTimesheet() {
        CountryService countryService = new CountryService();

        ModelAndView modelAndView = new ModelAndView("ui/timesheet/new_form");
        modelAndView.addObject("countries", countryService.getCountries());

        HibernateConnection.getInstance().getSession().close();

        return modelAndView;
    }
}
