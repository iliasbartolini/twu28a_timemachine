package com.thoughtworks.twu.persistence;

import com.thoughtworks.twu.domain.Country;
import com.thoughtworks.twu.domain.LocationPresences;
import com.thoughtworks.twu.domain.TimeRecord;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TimeRecordRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public TimeRecordRepository() {
    }

    public TimeRecordRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<TimeRecord> getAllTimeRecords(int timesheetId) {
        return sessionFactory.getCurrentSession().createCriteria(TimeRecord.class).
                add(Restrictions.eq("time_sheet_id", timesheetId)).list();
    }

    public void save(TimeRecord newTimeRecords) {
        sessionFactory.getCurrentSession().save(newTimeRecords);
    }
}
