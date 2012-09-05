package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.domain.timesheet.forms.TimeSheetForm;
import com.thoughtworks.twu.domain.validators.ActivityValidator;
import com.thoughtworks.twu.domain.validators.LocationValidator;
import com.thoughtworks.twu.persistence.HibernateConnection;
import com.thoughtworks.twu.service.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TimeRecordController {


    @RequestMapping(value = "/timesheet/new", method = RequestMethod.GET)
    public ModelAndView newTimesheet(@ModelAttribute("timeSheetForm") TimeSheetForm timeSheetForm, BindingResult errors) {
        CountryService countryService = new CountryService();

        ModelAndView modelAndView = new ModelAndView("ui/timesheet/new_form");
        modelAndView.addObject("countries", countryService.getCountries());
        modelAndView.addObject("states", countryService.getStates("USA"));

        HibernateConnection.getInstance().getSession().close();

        return modelAndView;
    }

    @RequestMapping(value = "/timesheet/new", method = RequestMethod.POST)
    public ModelAndView saveTimeSheetAsDraft(@ModelAttribute("timeSheetForm") TimeSheetForm timeSheetForm, BindingResult errors) {

        LocationValidator locationValidator = new LocationValidator();
        ActivityValidator validator = new ActivityValidator();
        locationValidator.validate(timeSheetForm, errors);
        validator.validate(timeSheetForm, errors);

        if (errors.hasErrors()){
        ModelAndView modelAndView = new ModelAndView("ui/timesheet/new_form");
        modelAndView.addObject("errors", errors);
        CountryService countryService = new CountryService();
        modelAndView.addObject("countries", countryService.getCountries());
        modelAndView.addObject("states", countryService.getStates("USA"));
        modelAndView.addObject(timeSheetForm);
         return modelAndView;
        }
        else
        {

          ModelAndView modelAndView = new ModelAndView("newTimesheet");
          return modelAndView;
        }


    }

    @RequestMapping(value = "/timesheet/datepicker", method = RequestMethod.GET)
    public ModelAndView pickDate() {

        ModelAndView modelAndView = new ModelAndView("ui/timesheet/date_picker");

        HibernateConnection.getInstance().getSession().close();

        return modelAndView;
    }
}
