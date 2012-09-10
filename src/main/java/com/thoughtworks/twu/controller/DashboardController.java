package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.constants.URLPaths;
import com.thoughtworks.twu.persistence.HibernateConnection;
import com.thoughtworks.twu.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DashboardController {

    @RequestMapping(value = URLPaths.DASHBOARD_PATH, method = RequestMethod.GET)
    public ModelAndView show(HttpServletRequest request) {

        EmployeeService service = new EmployeeService();

        ModelAndView modelAndView = new ModelAndView("ui/dashboard/dashboard");
        modelAndView.addObject("employee", service.getEmployeeByLogin(request.getRemoteUser()));
        modelAndView.addObject("datepicker_path", URLPaths.DATEPICKER_PATH);
        HibernateConnection.getInstance().getSession().close();
        return modelAndView;
    }
}


