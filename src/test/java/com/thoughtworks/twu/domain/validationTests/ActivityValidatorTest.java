package com.thoughtworks.twu.domain.validationTests;

import com.thoughtworks.twu.domain.validators.ActivityValidator;
import com.thoughtworks.twu.domain.timesheet.forms.TimeSheetForm;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BindException;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class ActivityValidatorTest {
    private Validator activityValidator;

     @Before
    public void setUp(){
         activityValidator = new ActivityValidator();
    }

    @Test
    public void supportOnlyTimeSheetForm(){
        assertTrue(activityValidator.supports(TimeSheetForm.class));
        assertFalse(activityValidator.supports(Object.class));
    }

    @Test
    public void activityIsValid(){
        TimeSheetForm timeSheetForm = new TimeSheetForm();
        timeSheetForm.setActivity("Scuba Diving for Research");
        BindException errors = new BindException(timeSheetForm,"activity" );
        ValidationUtils.invokeValidator(activityValidator, timeSheetForm,errors);
        assertFalse(errors.hasErrors());
    }

    @Test
    public void activityShouldNotBeNul(){
        TimeSheetForm timeSheetForm = new TimeSheetForm();
        timeSheetForm.setActivity("");
        BindException errors = new BindException(timeSheetForm ,"activity");
        ValidationUtils.invokeValidator(activityValidator,timeSheetForm,errors);
        assertTrue(errors.hasErrors());
    }

}

