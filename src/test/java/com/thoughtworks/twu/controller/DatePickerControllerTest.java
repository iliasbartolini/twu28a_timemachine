package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.service.TimesheetService;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DatePickerControllerTest {

   @Test
    public void shouldGetDatePickerModelAndView(){
       DatePickerController datePickerController = new DatePickerController();
       ModelAndView modelAndView = datePickerController.getDatePicker();

       assertThat(modelAndView.getViewName(),is("ui/timesheet/date_picker"));
   }

//
//    @Test
//    public void shouldAddDateToModel(){
//        DatePickerService datePickerService = mock(DatePickerService.class);
//        when(datePickerService.selectDate()).thenReturn("");
//
//        DatePickerController datePickerController = new DatePickerController();
//        ModelAndView modelAndView = datePickerController.getDate();
//
//
//        assertThat(modelAndView.getModel().get("datePicker"),is());
//
//    }


}
