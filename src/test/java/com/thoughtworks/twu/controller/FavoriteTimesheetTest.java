package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.persistence.FavoriteTimesheet;
import com.thoughtworks.twu.persistence.HibernateConnection;
import com.thoughtworks.twu.service.FavoriteTimesheetService;
import org.junit.After;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class FavoriteTimesheetTest {


    @Test
    public void shouldRetrieveMyFavoriteTimesheets()
    {
        //Given
        FavoriteTimesheetService timesheetService = new FavoriteTimesheetService();
        //When
        List<FavoriteTimesheet> timesheets = timesheetService.getFavoriteTimesheets();
        //Then
        assertNotNull(timesheets);
    }

    @Test
    public void shouldSaveMyFavoriteTimesheet()
    {
        //Given
        FavoriteTimesheetService favoriteTimesheetService= new FavoriteTimesheetService();
        FavoriteTimesheet favoriteTimesheet= new FavoriteTimesheet("TW");
        //When
        int sizeBeforeInsert = favoriteTimesheetService.getFavoriteTimesheets().size();
        favoriteTimesheetService.save(favoriteTimesheet);
        int sizeAfterInsert = favoriteTimesheetService.getFavoriteTimesheets().size();
        //Then
        assertThat(sizeAfterInsert,is(sizeBeforeInsert+1));
    }

    @After
    public void tearDown() throws Exception {
        HibernateConnection.getInstance().getSession().close();
    }
}
