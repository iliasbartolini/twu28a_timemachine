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
public class FavoriteTimesheetController {

    FavoriteTimesheetService favoriteTimesheetService = new FavoriteTimesheetService();

    @RequestMapping(value = "/timesheet/favorite/new", method = RequestMethod.GET)
    public ModelAndView newFavorite() {
        CountryService countryService = new CountryService();

        ModelAndView modelAndView = new ModelAndView("ui/timesheet/favorite/new_form");
        modelAndView.addObject("countries", countryService.getCountries());
        modelAndView.addObject("existingFavorites", favoriteTimesheetService.getFavoriteTimesheets());

        HibernateConnection.getInstance().getSession().close();

        return modelAndView;
    }

    @RequestMapping(value = "/timesheet/favorite/new", method = RequestMethod.POST)
    public ModelAndView doNewFavorite(@ModelAttribute("favoriteTimesheetForm") FavoriteTimesheetForm form) {

        FavoriteTimesheet favorite = form.toFavoriteTimesheet();
        favoriteTimesheetService.save(favorite);

        HibernateConnection.getInstance().getSession().close();

        return list();
    }

    @RequestMapping(value = "/timesheet/favorite/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("ui/timesheet/favorite/favorite_list");
        modelAndView.addObject("favoriteTimesheets", favoriteTimesheetService.getFavoriteTimesheets());
        return modelAndView;
    }
}
