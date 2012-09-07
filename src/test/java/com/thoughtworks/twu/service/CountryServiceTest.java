package com.thoughtworks.twu.service;

import com.thoughtworks.twu.domain.Country;
import com.thoughtworks.twu.domain.LocationPresences;
import com.thoughtworks.twu.persistence.CountryRepository;
import com.thoughtworks.twu.persistence.LocationPresencesRepository;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CountryServiceTest {
    @Test
    public void testGetCountries() throws Exception {
        Country country = new Country();
        country.setName("Beautiful Country");
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(country);

        CountryRepository countryRepository = mock(CountryRepository.class);
        when(countryRepository.getCountries()).thenReturn(countries);

        CountryService countryService = new CountryService(countryRepository, null);

        assertThat(countryService.getCountries().size(), is(1));
    }

    @Test
    public void testGetStates() throws Exception {
        LocationPresences locationPresences = new LocationPresences();
        locationPresences.setCountryCode("USA");
        locationPresences.setState("NY");
        locationPresences.setThoughtworksPresence(1);

        ArrayList<LocationPresences> locationPresenceses = new ArrayList<LocationPresences>();
        locationPresenceses.add(locationPresences);

        LocationPresencesRepository locationPresencesRepository = mock(LocationPresencesRepository.class);
        when(locationPresencesRepository.getStates("USA")).thenReturn(locationPresenceses);

        CountryService countryService = new CountryService(null, locationPresencesRepository);

        List<LocationPresences> states = countryService.getStates("USA");
        assertThat(states.size(), is(1));
    }
}
