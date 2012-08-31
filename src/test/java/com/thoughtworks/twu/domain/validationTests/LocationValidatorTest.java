package com.thoughtworks.twu.domain.validationTests;

import com.thoughtworks.twu.domain.timesheet.forms.TimeSheetForm;
import com.thoughtworks.twu.domain.validators.LocationValidator;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BindException;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: ewonou
 * Date: 31/8/12
 * Time: 10:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class LocationValidatorTest {
    Validator locationValidator;

    @Before
    public void setUp(){
        locationValidator = new LocationValidator();
    }

    @Test
    public void supportOnlyTimeSheetForm(){
        assertTrue(locationValidator.supports(TimeSheetForm.class));
        assertFalse(locationValidator.supports(Object.class));
    }

    @Test
    public void CountryIsValid(){
        TimeSheetForm timeSheetForm = new TimeSheetForm();
        timeSheetForm.setCountry("India");
        BindException errors = new BindException(timeSheetForm,"country" );
        ValidationUtils.invokeValidator(locationValidator, timeSheetForm, errors);
        assertFalse(errors.hasErrors());
    }

    @Test
    public void CountryShouldNotBeNull(){
        TimeSheetForm timeSheetForm = new TimeSheetForm();
        timeSheetForm.setCountry("");
        BindException errors = new BindException(timeSheetForm ,"country");
        ValidationUtils.invokeValidator(locationValidator,timeSheetForm,errors);
        assertTrue(errors.hasErrors());
    }


    @Test
    public void stateShouldBeNullWhenCountryIsNotUSA(){
        TimeSheetForm timeSheetForm = new TimeSheetForm();
        timeSheetForm.setCountry("India");
        BindException errors = new BindException(timeSheetForm ,"state");
        ValidationUtils.invokeValidator(locationValidator,timeSheetForm,errors);

        assertFalse(errors.hasErrors());

    }

    @Test
    public void stateShouldNotBeNullWhenCountryIsUSA() {
        TimeSheetForm timeSheetForm = new TimeSheetForm();
        timeSheetForm.setCountry("USA");
        BindException errors = new BindException(timeSheetForm ,"state");
        ValidationUtils.invokeValidator(locationValidator,timeSheetForm,errors);

        assertTrue(errors.hasErrors());

    }

}


