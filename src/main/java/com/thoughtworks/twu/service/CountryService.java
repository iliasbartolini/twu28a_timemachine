package com.thoughtworks.twu.service;


import com.thoughtworks.twu.domain.Country;
import com.thoughtworks.twu.domain.LocationPresences;
import com.thoughtworks.twu.persistence.CountryRepository;
import com.thoughtworks.twu.persistence.LocationPresencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryService {

    private CountryRepository countryRepository;
    private LocationPresencesRepository locationPresencesRepository;

    @SuppressWarnings(value = "unused")
    public CountryService() {
    }

    @Autowired
    public CountryService(CountryRepository countryRepository, LocationPresencesRepository locationPresencesRepository) {
        this.countryRepository = countryRepository;
        this.locationPresencesRepository = locationPresencesRepository;
    }

    @Transactional
    public List<Country> getCountries() {
        return countryRepository.getCountries();
    }

    @Transactional
    public List<LocationPresences> getStates(String countryCode) {
        return locationPresencesRepository.getStates(countryCode);
    }
}
