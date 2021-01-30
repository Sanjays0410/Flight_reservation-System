package com.cruds.frs.db;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cruds.frs.entity.Schedule;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	
	@Autowired
	SessionFactory sessionfactory;


	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}


	public ArrayList<Schedule> viewScheduleByRoute(String source, String destination, String days) {
		
		
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		String hql="select s.availabledays,s.departuretime,s.travelduration,r.source,r.destination,r.fare,f.flightname,f.reservationcapacity from Schedule s INNER JOIN s.Flight f INNER JOIN s.Route r where s.availabledays=:days,r.source=:source,r.destination=:destination";
		Query query=session.createQuery(hql);
		ArrayList<Schedule> slist=(ArrayList<Schedule>) query.list();
		session.getTransaction().commit();
		session.close();
		
		return slist;
	
	}

}
