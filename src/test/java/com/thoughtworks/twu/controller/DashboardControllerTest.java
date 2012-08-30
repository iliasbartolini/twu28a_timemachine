package com.thoughtworks.twu.controller;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DashboardControllerTest {

    @Test
    public void shouldShowDashboard(){
        DashboardController dashboardController = new DashboardController();

        assertThat(dashboardController.showDashboard().getViewName(), is("ui/dashboard/dashboard"));
    }
}
