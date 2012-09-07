package com.thoughtworks.twu.service;


import com.thoughtworks.twu.domain.Country;
import com.thoughtworks.twu.domain.LocationPresences;
<<<<<<< HEAD
import com.thoughtworks.twu.persistence.CountryRepository;
import com.thoughtworks.twu.persistence.HibernateConnection;
import com.thoughtworks.twu.persistence.LocationPresencesRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
=======

import com.thoughtworks.twu.persistence.CountryRepository;
import com.thoughtworks.twu.persistence.LocationPresencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
>>>>>>> Willa/Felipe Finished country/state repository and service

import java.util.*;

@Service
public class CountryService {

<<<<<<< HEAD

    private List<Country> countries;
    private List<LocationPresences> locationPresences;
    private CountryRepository countryRepository;
    private LocationPresencesRepository locationPresencesRepository;

=======
    private CountryRepository countryRepository;
    private LocationPresencesRepository locationPresencesRepository;
    @SuppressWarnings(value = "unused")
    public CountryService() {
    }
>>>>>>> Willa/Felipe Finished country/state repository and service

    @Autowired
    public CountryService(CountryRepository countryRepository, LocationPresencesRepository locationPresencesRepository) {
        this.countryRepository = countryRepository;
        this.locationPresencesRepository = locationPresencesRepository;
    }

<<<<<<< HEAD
    public List<Country> loadCountryList() {
        return this.countryRepository.loadCountries();
    }

    public CountryService() {
    }

    private List<Country> getCountries() {

        return countryRepository.loadCountries();
    }

    public List<LocationPresences> getStates(String countryCode) {

        return locationPresencesRepository.getStates(countryCode);
    }



    public List<Country> loadCountryListWithTWPresence() {

        return countryRepository.loadCountriesWithTWPresence();
=======
    @Transactional
    public List<Country> getCountries() {
        return countryRepository.getCountries();
    }

    @Transactional
    public List<LocationPresences> getStates(String countryCode) {
        return locationPresencesRepository.getStates(countryCode);
    }

    @Transactional
    public List<String> getCountryNames() throws Exception {
        List<Country> countries = getCountries();
        List<String> countryNames = new ArrayList<String>();
        countryNames.add("Select a country");
        for (Country country : countries) {
            countryNames.add(country.getCode() + " - " + country.getName());
        }
        return countryNames;
    }

    @Transactional
    public List<String> getStateName(String countrycode) throws Exception {
        List<LocationPresences> locationPresences = getStates(countrycode);
        List<String> stateNames = new ArrayList<String>();
        stateNames.add("Select a state");
        for (LocationPresences state : locationPresences) {
            stateNames.add(state.getState());
        }
        return stateNames;
    }

    @Transactional
    public List<String> getCountryCodes() throws Exception {
        List<Country> countries = getCountries();
        List<String> countryCodes = new ArrayList<String>();
        countryCodes.add("first select");
        for (Country country : countries) {
            countryCodes.add(country.getCode());
        }
        return countryCodes;
>>>>>>> Willa/Felipe Finished country/state repository and service
    }

}
