package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.persistence.HibernateConnection;
import com.thoughtworks.twu.service.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class SearchActivityController {

    @RequestMapping(value = "/timesheet/search)activity", method = RequestMethod.GET)
    public ModelAndView newFavorite() {
        CountryService countryService = new CountryService();

        ModelAndView modelAndView = new ModelAndView("ui/timesheet/favorite/new_form");
        

        HibernateConnection.getInstance().getSession().close();

        return modelAndView;
    }
}
