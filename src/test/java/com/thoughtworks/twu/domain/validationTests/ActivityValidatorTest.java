package com.thoughtworks.twu.domain.validationTests;


import com.thoughtworks.twu.domain.timesheet.forms.TimeRecordForm;
import com.thoughtworks.twu.domain.validators.ActivityValidator;
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

        assertTrue(activityValidator.supports(TimeRecordForm.class));
        assertFalse(activityValidator.supports(Object.class));
    }

    @Test
    public void activityIsValid(){

        TimeRecordForm timeRecordForm = new TimeRecordForm();
        timeRecordForm.setActivity("Scuba Diving for Research");
        BindException errors = new BindException(timeRecordForm,"activity" );
        ValidationUtils.invokeValidator(activityValidator, timeRecordForm,errors);
        assertFalse(errors.hasErrors());
    }

    @Test

    public void activityShouldNotBeNul(){
        TimeRecordForm timeRecordForm = new TimeRecordForm();
        timeRecordForm.setActivity("");
        BindException errors = new BindException(timeRecordForm,"activity");
        ValidationUtils.invokeValidator(activityValidator, timeRecordForm,errors);

        assertTrue(errors.hasErrors());
    }

}

