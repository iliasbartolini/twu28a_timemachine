package com.thoughtworks.twu.service;

import com.thoughtworks.twu.domain.Country;

import com.thoughtworks.twu.domain.LocationPresences;
import com.thoughtworks.twu.persistence.CountryRepository;
import com.thoughtworks.twu.persistence.LocationPresencesRepository;
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
<<<<<<< HEAD
    private CountryRepository countryRepository;
=======
    private List<LocationPresences> locationPresenceses = new ArrayList<LocationPresences>();
    private CountryRepository countryRepository;
    private LocationPresencesRepository locationPresencesRepository;
>>>>>>> Willa/Felipe Finished country/state repository and service
    private CountryService countryService;
    private LocationPresencesRepository locationRepository;
    private List<LocationPresences> locationPresenceList = new ArrayList<LocationPresences>();

    @Before
    public void setUp() throws Exception {
<<<<<<< HEAD
        Country countryWithoutTW = new Country();
        countryWithoutTW.setName("Beautiful City");
        countryWithoutTW.setCode("UEA");

        Country countryWithTW = new Country();
        countryWithTW.setName("United States");
        countryWithTW.setCode("USA");

        countries.add(countryWithTW);
        countries.add(countryWithoutTW);

        LocationPresences locationPresences = new LocationPresences();
        locationPresences.setCountryCode("USA");
        locationPresences.setState("GA");
        locationPresences.setThoughtworksPresence(1);
        locationPresenceList.add(locationPresences);

        countryRepository = mock(CountryRepository.class);
        locationRepository = mock(LocationPresencesRepository.class);

        countryService = new CountryService(countryRepository, locationRepository);
    }

    @Test
    public void shouldReturnCountryList() throws Exception {
        when(countryRepository.loadCountries()).thenReturn(countries);
        assertThat(countryService.loadCountryList().size(), is(2));
    }

    @Test
    public void shouldCountriesWithTWPresence() throws Exception {
        when(countryRepository.loadCountriesWithTWPresence()).thenReturn(countries);
        assertThat(countryService.loadCountryListWithTWPresence().size(), is(2));
    }

    @Test
    public void shouldReturnStateListForTheCountry() throws Exception {
        when(locationRepository.getStates("USA")).thenReturn(locationPresenceList);
        assertThat(countryService.getStates("USA").size(), is(1));
    }

}
=======
        Country country = new Country();
        country.setName("Beautiful City");
        country.setCode("Porto Alegre");
        countries.add(country);

        LocationPresences locationPresences = new LocationPresences();
        locationPresences.setCountryCode("USA");
        locationPresences.setState("NY");
        locationPresences.setThoughtworksPresence(1);
        locationPresenceses.add(locationPresences);

        countryRepository = mock(CountryRepository.class);
        locationPresencesRepository = mock(LocationPresencesRepository.class);
        countryService = new CountryService(countryRepository, locationPresencesRepository);

    }

    @Test
    public void testGetCountries() throws Exception {
        when(countryRepository.getCountries()).thenReturn(countries);
        assertThat(countryService.getCountries().size(), is(1));
    }

    @Test
    public void testGetStates() throws Exception {
        when(locationPresencesRepository.getStates("USA")).thenReturn(locationPresenceses);

        List<LocationPresences> states = countryService.getStates("USA");
        assertThat(states.size(), is(1));
    }

    @Test
    public void testGetStateNames() throws Exception {
        when(locationPresencesRepository.getStates("USA")).thenReturn(locationPresenceses);

        List<String> states = countryService.getStateName("USA");
        assertThat(states.toString(), is("[Select a state, NY]"));
    }

    @Test
    public void testGetCountryNames() throws Exception {
        when(countryRepository.getCountries()).thenReturn(countries);

        assertThat(countryService.getCountryNames().toString(), is("[Select a country, Porto Alegre - Beautiful City]"));
    }
}

>>>>>>> Willa/Felipe Finished country/state repository and service
