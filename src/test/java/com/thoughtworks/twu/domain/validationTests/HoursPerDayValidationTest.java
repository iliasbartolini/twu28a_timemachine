package com.thoughtworks.twu.domain.validationTests;

import com.thoughtworks.twu.domain.timesheet.forms.TimeSheetForm;
import com.thoughtworks.twu.domain.validators.HourPerDayValidator;
import org.apache.ibatis.binding.BindingException;
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
 * Time: 5:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class HoursPerDayValidationTest {

private Validator hourPerDayValidator;

@Before
public void setUp(){
    hourPerDayValidator = new HourPerDayValidator();

}
@Test
 public void shouldSupportTimeSheetForm(){
    assertTrue(hourPerDayValidator.supports(TimeSheetForm.class));
    assertFalse(hourPerDayValidator.supports(Object.class));
}
@Test
 public void shouldNotAcceptDayHoursInputNotInIncrementOfPointTwentyFive(){
   TimeSheetForm timeSheetForm = new TimeSheetForm();
    timeSheetForm.setMonday(2.33f);
    BindException errors = new BindException(timeSheetForm,"monday");
    ValidationUtils.invokeValidator(hourPerDayValidator,timeSheetForm,errors);
    assertTrue(errors.hasErrors());
}
@Test
public void shouldAcceptedBlankInput(){
    TimeSheetForm timeSheetForm = new TimeSheetForm();

    BindException errors = new BindException(timeSheetForm,"monday");
    ValidationUtils.invokeValidator(hourPerDayValidator,timeSheetForm,errors);
    assertFalse(errors.hasErrors());

}
@Test
   public void shouldAcceptInputInIncrementOfPointTwentyFive(){
    TimeSheetForm timeSheetForm = new TimeSheetForm() ;
    timeSheetForm.setMonday(2.25f);
    BindException errors = new BindException(timeSheetForm, "monday");
    ValidationUtils.invokeValidator(hourPerDayValidator,timeSheetForm,errors);
    assertFalse(errors.hasErrors());
}
}
