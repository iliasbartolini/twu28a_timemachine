package com.thoughtworks.twu.service;

import com.thoughtworks.twu.domain.TimeRecord;
import com.thoughtworks.twu.persistence.TimeRecordRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.isNull;
import static org.mockito.Mockito.*;

public class TimeRecordServiceTest {

    private List<TimeRecord> timeRecords;
    private TimeRecordRepository timeRecordRepository;
    private TimeRecordService timeRecordService;
    private TimeRecord newTimeRecords;

    @Before
    public void setup(){
        newTimeRecords = new TimeRecord();
        timeRecords = new ArrayList<TimeRecord>();
        newTimeRecords.setTime_sheet_id(0);
        newTimeRecords.setId(0);
        newTimeRecords.setProject("TWU");

        timeRecords.add(newTimeRecords);
        timeRecordRepository = mock(TimeRecordRepository.class);
        timeRecordService = new TimeRecordService(timeRecordRepository);
    }
    @Test
    public void shouldBeAbleToReturnAllTimeRecordsBasedOnTimesheetID() throws Exception {

        timeRecordService.getAllTimeRecords(0);

        verify(timeRecordRepository).getAllTimeRecords(0);

    }

    @Test
    public void shouldBeAbleToSaveTimeRecordBackToDataBase() throws Exception {

        timeRecordService.save(newTimeRecords);

        verify(timeRecordRepository).save(newTimeRecords);

    }
}

