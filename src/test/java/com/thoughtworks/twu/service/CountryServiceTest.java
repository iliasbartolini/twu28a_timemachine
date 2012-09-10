package com.thoughtworks.twu.service;

import com.thoughtworks.twu.domain.Country;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: priyanka
 * Date: 10/9/12
 * Time: 11:02 AM
 * To change this template use File | Settings | File Templates.
 */

public class CountryServiceTest {
    private CountryService countryService;

    @Before
    public void setUp()
    {
       countryService= new CountryService();
    }
    @Test
    public void shouldGetAllCountriesWithTWPresence() throws Exception {
        List<Country> country = new ArrayList<Country>();
        country=countryService.getCountriesWithTWPresence();
        assertEquals(15,country.size());

    }

    public void testGetStateName() throws Exception {


    }
}
