package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.persistence.HibernateConnection;
import com.thoughtworks.twu.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DashboardController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView show(HttpServletRequest request) {

        //System.out.println(request.getRemoteUser());
        EmployeeService service = new EmployeeService();

        ModelAndView modelAndView = new ModelAndView("ui/dashboard/dashboard");

       // modelAndView.addObject("employee", "Andy");
        //System.out.println(service.getEmployeeByLogin(request.getRemoteUser())+"----------------");
        modelAndView.addObject("employee", service.getEmployeeByLogin(request.getRemoteUser()));

        HibernateConnection.getInstance().getSession().close();
//        modelAndView.addObject("test", "Andy");
        //modelAndView.getModelMap().addAttribute("test", "Andy");
        return modelAndView;
    }



}


