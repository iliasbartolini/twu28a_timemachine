package com.thoughtworks.twu.controller;

import org.junit.Test;

import static org.testng.Assert.assertEquals;

public class SearchActivityControllerTest {

    @Test
    public void shouldLoadSearchActivityView() {
        SearchActivityController controller = new SearchActivityController();
        assertEquals("ui/timesheet/search_activity", controller.loadSearchActivityView().getViewName());
    }


}
