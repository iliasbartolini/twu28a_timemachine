package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.domain.forms.FavoriteTimeSheetForm;
import com.thoughtworks.twu.domain.timesheet.TimeSheetEntry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FavoriteTimeSheetController {

    @RequestMapping(value = "timesheet/favorite/new", method = RequestMethod.GET)
    public ModelAndView newFavorite() {
        ModelAndView modelAndView = new ModelAndView("timesheet/favorite/new");
        modelAndView.addObject("favoriteTimeSheetForm", new FavoriteTimeSheetForm());
        return modelAndView;
    }

    @RequestMapping(value = "timesheet/favorite/new", method = RequestMethod.POST)
    public ModelAndView doNewFavorite(@ModelAttribute("favoriteTimeSheetForm") FavoriteTimeSheetForm favoriteTimeSheetForm){

        ModelAndView modelAndView = new ModelAndView("timesheet/favorite/save_status");

        System.out.println("=========================TimeEntries==========================");

            if(favoriteTimeSheetForm.getTimeEntry() != null)
                System.out.println(favoriteTimeSheetForm.getTimeEntry().toString());
            else
                System.out.println("Time Entry is NULL!!!");

        System.out.println("===================================================");

        if(favoriteTimeSheetForm.getName().isEmpty()) {
            modelAndView.addObject("success", false);
        }
        else {
            modelAndView.addObject("success", true);
        }

        modelAndView.addObject("favoriteName", favoriteTimeSheetForm.getName());
        return modelAndView;
    }

//    @RequestMapping (value = "timesheet/favorite/new", method = RequestMethod.POST)
//    public ModelAndView doEntryFavorite(@ModelAttribute("timeEntry") TimeSheetEntry timeSheetEntry){
//        ModelAndView modelAndView = new ModelAndView("timesheet/favorite/time_entries");
//        System.out.println(timeSheetEntry.toString());
//        modelAndView.addObject("timeEntry",timeSheetEntry.toString());
//        return modelAndView;
//
//    }


}
