package com.thoughtworks.twu.service;

import com.thoughtworks.twu.domain.Activity;
import com.thoughtworks.twu.persistence.HibernateConnection;
import org.hibernate.Session;
import org.hibernate.criterion.LikeExpression;
import org.hibernate.criterion.Restrictions;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ActivityService {

    private HibernateConnection connection;
    private Session session;

    public ActivityService() {
        connection = HibernateConnection.getInstance();
        session = connection.getSession();

    }

    public List<Activity> getAllActivities() {
        return session.createQuery("from com.thoughtworks.twu.domain.Activity").list();
    }

    public JSONArray getActivities(String searchCriteria) {

        connection = HibernateConnection.getInstance();
        session = connection.getSession();
        //searchCriteria = searchCriteria.toLowerCase();
        String queryString=new String();
        String[] searchStrings=searchCriteria.split("%");


//
//        List<Activity> activityList = session.createQuery("from com.thoughtworks.twu.domain.Activity where " +
//                "lower (client) like '%" + searchCriteria + "%' or lower (project) like '%" + searchCriteria + "%'" +
//                " or lower (sub_project) like '%" + searchCriteria + "%' escape '!'").list();
//

List<Activity> activityList=session.createCriteria(com.thoughtworks.twu.domain.Activity.class).
                add(Restrictions.disjunction().add(Restrictions.ilike("client","%"+searchCriteria+"%")).
                add(Restrictions.ilike("project","%"+searchCriteria+"%")).
                add(Restrictions.ilike("sub_project","%"+searchCriteria+"%"))).list();
              JSONArray jsonArray = new JSONArray();

        for(Activity activity : activityList) {
            jsonArray.put(new JSONObject(activity));
        }
        return jsonArray;
    }
}
