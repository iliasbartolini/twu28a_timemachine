package com.thoughtworks.twu.service;

import com.thoughtworks.twu.domain.Country;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CountryServiceTest {
    @Test
    public void testGetCountries() throws Exception {
        Country country = new Country();
        country.setName("Beautiful Country");

        CountryService countryService = expectedService(country);

        List<Country> countries = countryService.getCountries();
        assertThat(countries.size(), is(1));
        assertThat(countries.get(0), is(country));
    }

    private CountryService expectedService(Country ... countries) {
        CountryRepository repository = new InMemoryCountryRepository(countries);

        return new CountryService(repository);
    }

    private class InMemoryCountryRepository extends CountryRepository {

        private List<Country> countries = new ArrayList<Country>();

        private InMemoryCountryRepository(Country... countries) {
            super(null);
            for(Country country : countries) {
                this.countries.add(country);
            }
        }

        @Override
        public List<Country> getCountries() {
            return countries;
        }
    }
}
