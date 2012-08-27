package com.thoughtworks.twu.service;

import com.thoughtworks.twu.domain.Country;

import java.util.ArrayList;
import java.util.List;

public class CountryService {

    private List<Country> countryList = new ArrayList<Country>();

    public CountryService() {
        countryList.add(new Country("India"));
        countryList.add(new Country("USA"));
        countryList.add(new Country("Australia"));
        countryList.add(new Country("Brazil"));
        countryList.add(new Country("China"));
    }

    public List<Country> getCountries() {
        return countryList;
    }


}
