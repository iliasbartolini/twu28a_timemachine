package com.thoughtworks.twu.controller;

import org.json.JSONException;
import org.junit.Ignore;
import org.junit.Test;

import static org.testng.Assert.assertEquals;

public class SearchActivityControllerTest {

    @Test
    public void shouldLoadSearchActivityView() {
        SearchActivityController controller = new SearchActivityController();
        assertEquals("ui/timesheet/search_activity", controller.loadSearchActivityView().getViewName());
    }

    @Test
    @Ignore("Not yet Complete")
    public void shouldReturnActivityList() throws JSONException {
        SearchActivityController controller = new SearchActivityController();
        assertEquals(6,controller.searchActivities("TWU").length());
    }
}
