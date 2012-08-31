package com.thoughtworks.twu.domain;

import com.thoughtworks.twu.service.CountryService;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

public class CountryServiceTest {

    @Test
    public void shouldReturnListOfCountries() {
        CountryService service = new CountryService();
        List<Country> result = service.getCountries();
        assertEquals(239, result.size());
    }

    @Test
    public void shouldReturnUSAStates() {
        CountryService service = new CountryService();
        List<LocationPresences> result = service.getStates("USA");
        assertEquals(55, result.size());
    }

    @Test
    public void shouldReturnEmptyListForNonUS() {
        CountryService service = new CountryService();
        List<LocationPresences> result = service.getStates("AUS");
        assertEquals(0, result.size());
    }
}
