package com.thoughtworks.twu.controller;




    import org.junit.Before;
import org.junit.Test;

import static org.testng.Assert.assertEquals;


    public class TimeSheetControllerTest {
        TimeSheetController controller;

        @Before
        public void setUp() throws Exception {
            controller = new TimeSheetController();
        }

        @Test
        public void shouldBeAbleToGetViewNameOfController() throws Exception {

            TimeSheetController timeSheetForm = new TimeSheetController();
            assertEquals("timeRecord", controller.displayTimeSheet().getViewName());
        }

        @Test
        public void shouldBeAbleToDisplayDatePickerDialog() throws Exception {
            assertEquals("ui/timesheet/date_picker", controller.pickDate().getViewName());
        }
    }

