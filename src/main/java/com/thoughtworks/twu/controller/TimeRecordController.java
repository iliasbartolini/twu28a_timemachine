package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.domain.timesheet.forms.TimeRecordForm;
import com.thoughtworks.twu.domain.validators.ActivityValidator;
import com.thoughtworks.twu.domain.validators.LocationValidator;
import com.thoughtworks.twu.persistence.HibernateConnection;
import com.thoughtworks.twu.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TimeRecordController {

    private TimeRecordForm timeRecordForm = new TimeRecordForm();
    private CountryService countryService;

    @Autowired
    public TimeRecordController(CountryService countryService) {
        this.countryService = countryService;
    }

    @RequestMapping(value = "/timesheet/timeRecord", method = RequestMethod.GET)
    public ModelAndView newTimesheet() {


        ModelAndView modelAndView = createTimeRecordModelAndView(null);

        HibernateConnection.getInstance().getSession().close();

        return modelAndView;
    }

    private ModelAndView createTimeRecordModelAndView(BindingResult errors) {
        ModelAndView modelAndView = new ModelAndView("ui/timesheet/timeRecord");
        modelAndView.addObject("countries", countryService.getCountries());
        modelAndView.addObject("states", countryService.getStates("USA"));
        modelAndView.addObject("errors",errors);
        modelAndView.addObject("timeRecordForm",timeRecordForm);
        return modelAndView;
    }

    @RequestMapping(value = "/timesheet/timeRecord", method = RequestMethod.POST)
    public ModelAndView submittedTimeSheet() {
        LocationValidator locationValidator = new LocationValidator();
        ActivityValidator validator = new ActivityValidator();
        BindingResult errors= null;
        locationValidator.validate(timeRecordForm, errors);
        validator.validate(timeRecordForm, errors);
        return createTimeRecordModelAndView(errors);
    }


}
