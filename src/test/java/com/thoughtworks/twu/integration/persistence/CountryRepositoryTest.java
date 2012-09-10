package com.thoughtworks.twu.integration.persistence;


import com.thoughtworks.twu.domain.Country;
import com.thoughtworks.twu.persistence.CountryRepository;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

public class CountryRepositoryTest {


    @Test
    public void shouldReturnListOfAllCountries()
    {
        CountryRepository repository = new CountryRepository();
        List<Country> countries = repository.loadCountries();
        assertEquals(239, countries.size());
    }

}
