package com.thoughtworks.twu.service;

import com.thoughtworks.twu.domain.Activity;
import com.thoughtworks.twu.domain.Time_Sheets;
import org.json.JSONArray;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ewonou
 * Date: 4/9/12
 * Time: 4:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class DraftTimesheetServiceTest {
    @Test
    public void shouldFetchListOfAllDrafts() {
        DraftTimesheetService service = new DraftTimesheetService();
        List<Time_Sheets> drafts = service.getAllDrafts();
        assertEquals(2, drafts.size());
    }




}
