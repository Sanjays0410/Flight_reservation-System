package com.cruds.frs.db;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cruds.frs.entity.Flight;
import com.cruds.frs.exception.FRSException;

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
		try
		{


			session.save(flightBean);

			session.getTransaction().commit();
			session.close();
			return "success";

		}
		catch (FRSException e) {
		// TODO: handle exception
		e.printStackTrace();
		if(e.getMessage().contains("Duplicate"))
		{
			throw new FRSException(flightBean.getFlightid() +" already exists! duplicate entry");
		}
		else
		{   
			throw new FRSException(e.getMessage() +"please contact system admin");
		}
	}
		catch (org.hibernate.exception.ConstraintViolationException e) {
			// TODO: handle exception
			System.out.println("duplicate entry not possible");

		}
		return null;


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

		try
		{
			Flight f=(Flight) session.load(Flight.class, flightID);
			session.delete(f);

			session.getTransaction().commit();
			session.close();


			return 1;
		}
		catch ( java.lang.IllegalArgumentException e) {

			System.out.println("null pointer exception"+e.getMessage());
			// TODO: handle exception
			return 0;
		}
	}


	public boolean modifyFlight(Flight flightbean) {


		Session session=sessionfactory.openSession();
		session.beginTransaction();
		try
		{
			session.update(flightbean);
			session.getTransaction().commit();
			session.close();
			return true ;
		}
		catch ( java.lang.NumberFormatException e) {

			System.out.println("nullformat exception");
			return false;
		}
		catch (org.hibernate.TransientObjectException e) {
			// TODO: handle exception
			return false;
		}


	}



}
