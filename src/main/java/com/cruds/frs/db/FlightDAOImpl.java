package com.cruds.frs.db;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cruds.frs.entity.Flight;

@Repository
public class FlightDAOImpl  implements FlightDAO{
	
	@Autowired
	SessionFactory sessionfactory;
	

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}


	public String addFlight(Flight flightBean) {
		
	Session session=sessionfactory.openSession();
	session.beginTransaction();
	session.save(flightBean);
	session.getTransaction().commit();
	session.close();
		
		return "success";
	}


	public ArrayList<Flight> viewByAllFlights() {
		
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		ArrayList<Flight> flist=(ArrayList<Flight>) session.createQuery("from Flight").list();
		session.getTransaction().commit();
		session.close();
		return flist;
		
	}


	public int removeFlight(String flightID) {
		
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		Flight f=(Flight) session.load(Flight.class, flightID);
		session.delete(f);
		session.getTransaction().commit();
		session.close();
		return 1;
	}


	public boolean modifyFlight(Flight flightBean) {
		
		
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		session.update(flightBean);
		session.getTransaction().commit();
		session.close();
		
		
		return true;
	}
	
	

}
