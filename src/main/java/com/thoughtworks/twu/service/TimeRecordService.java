package com.thoughtworks.twu.service;

import com.thoughtworks.twu.domain.TimeRecord;
import com.thoughtworks.twu.domain.Timesheet;
import com.thoughtworks.twu.persistence.HibernateConnection;
import com.thoughtworks.twu.persistence.TimeRecordRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TimeRecordService {

    @Autowired
    private TimeRecordRepository timeReportRepository;

    public TimeRecordService() {

    }

    public TimeRecordService(TimeRecordRepository timeRecordRepository) {
        this.timeReportRepository = timeRecordRepository;

    }

    public List<TimeRecord> getAllTimeRecords(int timesheetID) {
        return this.timeReportRepository.getAllTimeRecords(timesheetID);
    }

    public void save(TimeRecord newTimeRecords) {
        this.timeReportRepository.save(newTimeRecords);

    }
}