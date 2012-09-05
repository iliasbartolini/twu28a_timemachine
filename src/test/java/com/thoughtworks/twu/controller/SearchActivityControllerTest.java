package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.domain.Message;
import org.json.JSONException;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;

public class SearchActivityControllerTest {

    @Test
    public void shouldLoadSearchActivityView() {
        SearchActivityController controller = new SearchActivityController();
        assertEquals("ui/timesheet/search_activity", controller.loadSearchActivityView().getViewName());
    }

    @Test
    public void shouldLoadMessages() throws Exception {
        SearchActivityController controller = new SearchActivityController();

        Map<String, Object> model = controller.loadSearchActivityView().getModel();
        List<Message> messages = (List<Message>) model.get("messages");
        assertThat(messages.size(), is(2));
    }
}
