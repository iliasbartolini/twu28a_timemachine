package com.thoughtworks.twu.domain.validationTests;


import com.thoughtworks.twu.domain.timesheet.forms.TimeRecordForm;
import com.thoughtworks.twu.domain.validators.LocationValidator;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BindException;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class LocationValidatorTest {
    Validator locationValidator;

    @Before
    public void setUp(){
        locationValidator = new LocationValidator();
    }

    @Test
    public void supportOnlyTimeSheetForm(){
        assertTrue(locationValidator.supports(TimeRecordForm.class));
        assertFalse(locationValidator.supports(Object.class));
    }

    @Test
    public void CountryIsValid(){
        TimeRecordForm timeRecordForm = new TimeRecordForm();
        timeRecordForm.setCountry("IND - India");
        BindException errors = new BindException(timeRecordForm,"country" );
        ValidationUtils.invokeValidator(locationValidator, timeRecordForm, errors);
        assertFalse(errors.hasErrors());
    }

    @Test
    public void CountryShouldNotBeNull(){
        TimeRecordForm timeRecordForm = new TimeRecordForm();
        timeRecordForm.setCountry("Select a country");
        BindException errors = new BindException(timeRecordForm,"country");
        ValidationUtils.invokeValidator(locationValidator, timeRecordForm,errors);


        assertTrue(errors.hasErrors());
    }

    @Test
    public void stateShouldBeNullWhenCountryIsNotUSA(){
        TimeRecordForm timeRecordForm = new TimeRecordForm();
        timeRecordForm.setCountry("IND - India");
        BindException errors = new BindException(timeRecordForm,"state");
        ValidationUtils.invokeValidator(locationValidator, timeRecordForm,errors);
        assertFalse(errors.hasErrors());

    }

    @Test
    public void stateShouldNotBeNullWhenCountryIsUSA() {

        TimeRecordForm timeRecordForm = new TimeRecordForm();
        timeRecordForm.setCountry("USA - USA");
        timeRecordForm.setState("Select a state");
        BindException errors = new BindException(timeRecordForm,"state");
        ValidationUtils.invokeValidator(locationValidator, timeRecordForm,errors);
        assertTrue(errors.hasErrors());

    }

}


