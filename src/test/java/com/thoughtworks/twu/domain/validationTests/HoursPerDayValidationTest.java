package com.thoughtworks.twu.domain.validationTests;


import com.thoughtworks.twu.domain.timesheet.forms.TimeRecordForm;
import com.thoughtworks.twu.domain.validators.HourPerDayValidator;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BindException;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;
public class HoursPerDayValidationTest {

private Validator hourPerDayValidator;

@Before
public void setUp(){
    hourPerDayValidator = new HourPerDayValidator();

}
@Test
 public void shouldSupportTimeSheetForm(){
  assertTrue(hourPerDayValidator.supports(TimeRecordForm.class));
    assertFalse(hourPerDayValidator.supports(Object.class));
}
@Test
 public void shouldNotAcceptDayHoursInputNotInIncrementOfPointTwentyFive(){
   TimeRecordForm timeRecordForm = new TimeRecordForm();
    timeRecordForm.setMonday(2.33f);
    BindException errors = new BindException(timeRecordForm,"monday");
    ValidationUtils.invokeValidator(hourPerDayValidator, timeRecordForm,errors);
    assertTrue(errors.hasErrors());
}
@Test
public void shouldAcceptedBlankInput(){
    TimeRecordForm timeRecordForm = new TimeRecordForm();

    BindException errors = new BindException(timeRecordForm,"monday");
    ValidationUtils.invokeValidator(hourPerDayValidator, timeRecordForm,errors);
    assertFalse(errors.hasErrors());

}
@Test
   public void shouldAcceptInputInIncrementOfPointTwentyFive(){
    TimeRecordForm timeRecordForm = new TimeRecordForm() ;
    timeRecordForm.setMonday(2.25f);
    BindException errors = new BindException(timeRecordForm, "monday");
    ValidationUtils.invokeValidator(hourPerDayValidator, timeRecordForm,errors);
    assertFalse(errors.hasErrors());
}
}
