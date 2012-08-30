package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.service.UserService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class HomeControllerTest {

    @Test
    public void shouldLoadHomepage() {

        UserService mockService = mock(UserService.class);

        HomeController controller = new HomeController(mockService);

        assertEquals("example/home", controller.homepage("").getViewName());

    }

}
