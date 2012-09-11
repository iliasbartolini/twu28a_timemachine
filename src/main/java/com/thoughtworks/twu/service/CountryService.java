package com.thoughtworks.twu.service;


import com.thoughtworks.twu.domain.Country;
import com.thoughtworks.twu.domain.LocationPresences;
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

import java.util.*;

@Service
public class CountryService {


    private List<Country> countries;
    private List<LocationPresences> locationPresences;
    private CountryRepository countryRepository;
    private LocationPresencesRepository locationPresencesRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository, LocationPresencesRepository locationPresencesRepository) {
        this.countryRepository = countryRepository;
        this.locationPresencesRepository = locationPresencesRepository;
    }

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


    }
}
