package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.domain.timesheet.forms.TimeRecordForm;
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

@Controller
public class TimeRecordController {


    @RequestMapping(value = "/timesheet/new", method = RequestMethod.GET)
    public ModelAndView newTimesheet(@ModelAttribute("timeRecordForm") TimeRecordForm timeRecordForm, BindingResult errors) {
        CountryService countryService = new CountryService();

        ModelAndView modelAndView = new ModelAndView("ui/timesheet/timeRecord");
        modelAndView.addObject("countries", countryService.getCountries());
        modelAndView.addObject("states", countryService.getStates("USA"));

        HibernateConnection.getInstance().getSession().close();

        return modelAndView;
    }

    @RequestMapping(value = "/timesheet/new", method = RequestMethod.POST)
    public ModelAndView submittedTimeSheet(@ModelAttribute("timeRecordForm") TimeRecordForm timeRecordForm, BindingResult errors) {
        LocationValidator locationValidator = new LocationValidator();
        ActivityValidator validator = new ActivityValidator();
        locationValidator.validate(timeRecordForm, errors);
        validator.validate(timeRecordForm, errors);

        if (errors.hasErrors()){
        ModelAndView modelAndView = new ModelAndView("ui/timesheet/timeRecord");
        modelAndView.addObject("errors", errors);
        CountryService countryService = new CountryService();
        modelAndView.addObject("countries", countryService.getCountries());
        modelAndView.addObject("states", countryService.getStates("USA"));

        modelAndView.addObject(timeRecordForm);
        return modelAndView;
        }
        else
        {
            ModelAndView modelAndView = new ModelAndView("ui/timesheet/timeSheet");
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
