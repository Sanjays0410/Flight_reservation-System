package com.cruds.frs.db;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cruds.frs.entity.Route;
import com.cruds.frs.exception.SMSException;

@Repository
public class RouteDAOImpl implements RouteDAO {
	
	
	@Autowired
	SessionFactory sessionfactory;


	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	public String addRoute(Route Routebean) {
		
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		try
		{
		session.save(Routebean);
		session.getTransaction().commit();
		session.close();
		return "success";
		}
		catch (SMSException e) {
			// TODO: handle exception
			e.printStackTrace();
			if(e.getMessage().contains("Duplicate"))
			{
				throw new SMSException(Routebean.getRouteid() +" already exists! duplicate entry");
			}
			else
			{   
				throw new SMSException(e.getMessage() +"please contact system admin");
			}
		}
			catch (org.hibernate.exception.ConstraintViolationException e) {
				// TODO: handle exception
				System.out.println("duplicate entry not possible");

			}
		catch (org.hibernate.exception.GenericJDBCException e) {
			// TODO: handle exception
			System.out.println("error");
		}
			return null;

	}

	public ArrayList<Route> viewByAllRoute() {
	
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		 ArrayList<Route> routelist=(ArrayList<Route>) session.createQuery("from Route").list();
		 session.getTransaction().commit();
		 session.close();
		 
		return routelist;
	}

	public int removeRoute(String routeId) {
		
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		try
		{
		 Route routebean=(Route) session.load(Route.class,routeId);
		session.delete(routebean);
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

	public boolean modifyRoute(Route routebean) {
		
		
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		try
		{
		session.update(routebean);
		session.getTransaction().commit();
		session.close();
		return true;
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
