package com.thoughtworks.twu.domain.validationTests;

import com.thoughtworks.twu.domain.timesheet.forms.TimeSheetForm;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.Validator;

import java.util.Date;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: ewonou
 * Date: 31/8/12
 * Time: 7:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class DateValidatorTest {
    private Validator dateValidator;

    @Before
    public void setUp(){
       dateValidator = new DateValidator();
    }
    @Test
    public void shouldSupportTimeSheetForm(){
        assertTrue(dateValidator.supports(TimeSheetForm.class));
        assertFalse(dateValidator.supports(Object.class));
    }

    @Test
    public void shouldNotAllowDuplicateDateOnTimeSheet(){
       TimeSheetForm timeSheetForm = new TimeSheetForm();
        Date date = new Date(112,8,30);
        timeSheetForm.setDate();


    }

}
