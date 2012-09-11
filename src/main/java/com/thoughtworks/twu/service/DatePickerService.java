package com.thoughtworks.twu.service;

import com.thoughtworks.twu.domain.Employee;
import com.thoughtworks.twu.domain.Timesheet;
import com.thoughtworks.twu.persistence.HibernateConnection;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class DatePickerService {


    public boolean hasWeekEndingDate(String weekEndingDate,Employee employee) {

        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
        Session session = HibernateConnection.getInstance().getSession();
        try {
            List<Timesheet> weekEndingResult = session.createCriteria(Timesheet.class).
                    add(Restrictions.eq("weekEndingDate", dateFormat.parse(weekEndingDate))).
                    add(Restrictions.eq("employeeNumber", employee.getEmployeeNumber()))
                    .list();

            return weekEndingResult.size() >= 1;
        } catch (ParseException e) {
            return false;
        }
    }
}
