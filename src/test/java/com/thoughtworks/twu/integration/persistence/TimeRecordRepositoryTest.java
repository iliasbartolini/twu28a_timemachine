package com.thoughtworks.twu.integration.persistence;

import com.thoughtworks.twu.domain.TimeRecord;
import com.thoughtworks.twu.persistence.CountryRepository;
import com.thoughtworks.twu.persistence.TimeRecordRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TimeRecordRepositoryTest.Config.class)
@TransactionConfiguration(transactionManager = "repoTransactionManager", defaultRollback = false)
@Transactional
public class TimeRecordRepositoryTest {

    @Autowired
    private SessionFactory sessionFactory;

    private TimeRecordRepository timeRecordRepository;
    private int timesheetId;
    private TimeRecord newTimeRecords;


    @Before
    public void setup() {
        newTimeRecords = new TimeRecord();
        newTimeRecords.setId(0);
        newTimeRecords.setProject("TWU");
        newTimeRecords.setCountry("USA");

    }

    @Test
    public void shouldBeAbleToReturnAllTimerecordBasedOnTimesheetId() throws Exception {
        timesheetId = 6411;
        timeRecordRepository = new TimeRecordRepository(sessionFactory);
        List<TimeRecord> allRecords = timeRecordRepository.getAllTimeRecords(timesheetId);

        assertThat(allRecords.size(), is(2));
    }

    @Test
    public void shouldBeAbleToSaveTimeRecordObjectBackToDatabase() throws Exception {
        sessionFactory = mock(SessionFactory.class);
        Session session = mock(Session.class);
        when(sessionFactory.getCurrentSession()).thenReturn(session);

        timeRecordRepository = new TimeRecordRepository(sessionFactory);
        timeRecordRepository.save(newTimeRecords);


        verify(session).save(newTimeRecords);


    }

    @Test
    public void shouldBeAbleToSave() {
        timeRecordRepository = new TimeRecordRepository(sessionFactory);
        timeRecordRepository.save(newTimeRecords);

        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();

        List<TimeRecord> allTimeRecords = timeRecordRepository.getAllTimeRecords(newTimeRecords.getId());
        assertThat(allTimeRecords.size(), is(1));
    }


    @Configuration
    static class Config extends RepositoryContextConfiguration {
        Config() {
            super("classpath:twu_database/te/TIME_RECORDS_DATA_TABLE.sql");
        }
    }
}
