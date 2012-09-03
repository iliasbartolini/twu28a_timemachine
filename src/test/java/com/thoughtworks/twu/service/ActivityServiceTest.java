package com.thoughtworks.twu.service;

import com.thoughtworks.twu.domain.Activity;
import org.json.JSONArray;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

public class ActivityServiceTest {

    @Test
    public void shouldFetchListOfAllActivities() {
        ActivityService service = new ActivityService();
        List<Activity> activities = service.getAllActivities();
        assertEquals(11151, activities.size());
    }

    @Test
    public void shouldReturnListOfActivitiesContainingTWU() {
        ActivityService service = new ActivityService();
        JSONArray activities = service.getActivities("TWU");
        assertEquals(7, activities.length());
    }

    @Test
    public void shouldReturnListOfActivitiesContainingCaseInsensitiveTWU() {
        ActivityService service = new ActivityService();
        JSONArray  activities = service.getActivities("twu");
        assertEquals(7, activities.length());
    }

    @Test
    public void shouldReturnEmptyListForAAA() {
        ActivityService service = new ActivityService();
        JSONArray  activities = service.getActivities("AAA");
        assertEquals(0, activities.length());
    }




}
