package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.constants.URLPaths;

import com.thoughtworks.twu.domain.*;
import com.thoughtworks.twu.domain.timesheet.forms.TimeRecordForm;
import com.thoughtworks.twu.domain.validators.ActivityValidator;
import com.thoughtworks.twu.domain.validators.HourPerDayValidator;
import com.thoughtworks.twu.domain.validators.LocationValidator;
import com.thoughtworks.twu.service.CountryService;

import com.thoughtworks.twu.service.MessageService;
import com.thoughtworks.twu.service.TimeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TimeRecordController {

    private CountryService countryService;
    private MessageService messageService;

    private TimeRecordService timeRecordService;


    public TimeRecordController() {
    }

    @Autowired
    public TimeRecordController(CountryService countryService, TimeRecordService timeRecordService, MessageService messageService) {

        this.countryService = countryService;
        this.timeRecordService = timeRecordService;
        this.messageService = messageService;
    }

    @RequestMapping(value = URLPaths.TIME_RECORD_PATH, method = RequestMethod.GET)
    public ModelAndView newTimeRecord(@ModelAttribute("timeRecordForm") TimeRecordForm timeRecordForm, BindingResult errors) throws Exception {

        return showTimeRecord();
    }

    @RequestMapping(value = URLPaths.TIME_RECORD_PATH, method = RequestMethod.POST)
    public ModelAndView submittedTimeRecord(@ModelAttribute("timeRecordForm") TimeRecordForm timeRecordForm, BindingResult errors, HttpServletRequest request) throws Exception {

        LocationValidator locationValidator = new LocationValidator();
        ActivityValidator activityValidator = new ActivityValidator();
        HourPerDayValidator hourPerDayValidator = new HourPerDayValidator();

        locationValidator.validate(timeRecordForm, errors);
        activityValidator.validate(timeRecordForm, errors);
        hourPerDayValidator.validate(timeRecordForm, errors);

        if (errors.hasErrors()) {
            return showTimeRecord();
        } else {
            //Danza Kuduro
            List<TimeRecordForm> timeRecordForms = (List<TimeRecordForm>) request.getSession().getAttribute("timeRecordsList");

            if (timeRecordForms == null) {
                timeRecordForms = new ArrayList<TimeRecordForm>();
            }

            timeRecordForms.add(timeRecordForm);
            request.getSession().setAttribute("timeRecordsList", timeRecordForms);

            return new ModelAndView(new RedirectView("new"));
        }
    }

    public List<String> loadCountryNames(List<Country> countries) {
        List<String> countryNames = new ArrayList<String>();
        countryNames.add("Select a country");
        for (Country country : countries) {
            countryNames.add(country.getCode() + " - " + country.getName());
        }
        return countryNames;
    }

    public List<String> loadStateNames(List<LocationPresences> locationPresences) {

        List<String> stateNames = new ArrayList<String>();
        stateNames.add("Select a state");
        for (LocationPresences state : locationPresences) {
            stateNames.add(state.getState());
        }
        return stateNames;
    }

    public void save(TimeRecordForm timeRecordForm, int timesheetID) {
        TimeRecord timeRecord = timeRecordForm.toTimeRecord(timesheetID);
        timeRecordService.save(timeRecord);

    }


    private ModelAndView showTimeRecord() {
        List<Message> messages = new ArrayList<Message>();
        messages.add(messageService.getMessageById("HoursLessThan40"));
        messages.add(messageService.getMessageById("HoursCannotBeZero"));
        messages.add(messageService.getMessageById("TaskCommentCannotBeUnspecified"));
        messages.add(messageService.getMessageById("ActivityCannotBeUnspecified"));

        ModelAndView modelAndView = new ModelAndView("ui/timesheet/time_record");

        modelAndView.addObject("countries", loadCountryNames(countryService.loadCountryListWithTWPresence()));
        modelAndView.addObject("states", loadStateNames(countryService.getStates("USA")));
        modelAndView.addObject("messages", messages);


        return modelAndView;
    }


}
