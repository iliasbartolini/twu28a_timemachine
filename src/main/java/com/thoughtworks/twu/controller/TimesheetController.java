package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.domain.timesheet.forms.TimeSheetForm;
import com.thoughtworks.twu.domain.validators.ActivityValidator;
import com.thoughtworks.twu.domain.validators.LocationValidator;
import com.thoughtworks.twu.persistence.HibernateConnection;
import com.thoughtworks.twu.service.CountryService;
import com.thoughtworks.twu.service.FavoriteTimesheetService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TimesheetController {

    FavoriteTimesheetService favoriteTimesheetService = new FavoriteTimesheetService();

    @RequestMapping(value = "/timesheet/new", method = RequestMethod.GET)
    public ModelAndView newFavorite(@ModelAttribute("timeSheetForm") TimeSheetForm timeSheetForm, BindingResult errors) {
        CountryService countryService = new CountryService();

        ModelAndView modelAndView = new ModelAndView("ui/timesheet/new_form");
        modelAndView.addObject("countries", countryService.getCountries());
        modelAndView.addObject("existingFavorites", favoriteTimesheetService.getFavoriteTimesheets());

        HibernateConnection.getInstance().getSession().close();

        return modelAndView;
    }

    @RequestMapping(value = "/timesheet/new", method = RequestMethod.POST)
    public ModelAndView submittedTimeSheet(@ModelAttribute("timeSheetForm")   TimeSheetForm timeSheetForm, BindingResult errors){
        ActivityValidator validator = new ActivityValidator();
        validator.validate(timeSheetForm, errors);
        ModelAndView modelAndView = new ModelAndView("ui/timesheet/new_form");
        modelAndView.addObject("errors",errors);
        CountryService countryService = new CountryService();
        modelAndView.addObject("countries", countryService.getCountries());
        modelAndView.addObject("existingFavorites", favoriteTimesheetService.getFavoriteTimesheets());

        modelAndView.addObject(timeSheetForm);
        return modelAndView;
    }
}
