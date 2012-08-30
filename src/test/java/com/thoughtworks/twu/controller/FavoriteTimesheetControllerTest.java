package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.SetupTest;
import com.thoughtworks.twu.domain.timesheet.forms.FavoriteTimesheetForm;
import com.thoughtworks.twu.persistence.FavoriteTimesheet;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class FavoriteTimesheetControllerTest extends SetupTest {

    FavoriteTimesheetController controller;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        controller = new FavoriteTimesheetController();
    }

    @Test
    public void shouldBeAbleToGetViewNameOfController() throws Exception {
        assertEquals("ui/timesheet/favorite/new_form", controller.newFavorite().getViewName());
    }

    @Test
    public void shouldBeAbleToGetList() throws Exception {
        FavoriteTimesheetForm mockTimesheetForm = new FavoriteTimesheetForm();

        mockTimesheetForm.setName("Timemachine");

        FavoriteTimesheet mockTimesheet = mockTimesheetForm.toFavoriteTimesheet();

        Map model = this.controller.doNewFavorite(mockTimesheetForm).getModel();

        List<FavoriteTimesheet> expected = new ArrayList<FavoriteTimesheet>();
        expected.add(mockTimesheet);

        System.out.println(model);
        assertEquals(expected, model.get("favoriteTimesheets"));





    }
}
