package com.thoughtworks.twu.service;

import com.thoughtworks.twu.domain.Country;

import com.thoughtworks.twu.domain.LocationPresences;
import com.thoughtworks.twu.persistence.CountryRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CountryServiceTest {

    private List<Country> countries = new ArrayList<Country>();
    private CountryRepository countryRepository;
    private CountryService countryService;

    @Before
    public void setUp() throws Exception {
        Country country = new Country();
        country.setName("Beautiful City");
        country.setCode("Porto Alegre");
        countries.add(country);

        countryRepository = mock(CountryRepository.class);
        countryService = new CountryService(countryRepository);

    }

        @Test
        public void testGetCountries() throws Exception {
            when(countryRepository.loadCountries()).thenReturn(countries);

            assertThat(countryService.loadCountryList().size(), is(1));
        }
    }