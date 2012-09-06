package com.thoughtworks.twu.controller;



    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestMethod;
    import org.springframework.web.servlet.ModelAndView;

@Controller
    public class TimeSheetController {
        @RequestMapping(value = "/timesheet/timeSheet", method = RequestMethod.GET)
        public ModelAndView getTimesheet() {
            ModelAndView modelAndView = new ModelAndView("ui/timesheet/timeSheet");
            return modelAndView;
        }

        @RequestMapping(params = "newActivity", method = RequestMethod.GET)
        public ModelAndView displayTimeSheet() {

            ModelAndView modelAndView = new ModelAndView("timeRecord");
            return modelAndView;
        }

    }



