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
		session.getTransaction();
		 ArrayList<Route> routelist=(ArrayList<Route>) session.createQuery("from Route").list();
		 session.beginTransaction().commit();
		 session.close();
		 
		return routelist;
	}

}
