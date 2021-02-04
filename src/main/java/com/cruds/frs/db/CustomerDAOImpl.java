package com.cruds.frs.db;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cruds.frs.entity.Flight;
import com.cruds.frs.entity.Route;
import com.cruds.frs.entity.Schedule;

@Repository
public class CustomerDAOImpl implements CustomerDAO {


	@Autowired
	SessionFactory sessionfactory;


	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}


	public ArrayList<Schedule> viewScheduleByRoute(String source,String destination,String days,String seats) {

		Session session=sessionfactory.openSession();
		session.beginTransaction();
		try
		{

			Criteria criteria=session.createCriteria(Schedule.class,"Schedule");
			criteria.createAlias("Schedule.routeid","routeid");
			criteria.createAlias("Schedule.flightid","flightid");

			criteria.add(Restrictions.eq("routeid.Source", source));
			criteria.add(Restrictions.eq("routeid.Destination",destination));
			
			//this % in  like operator is very important

			//by using % on both side when it will search whole column for days
			
			criteria.add(Restrictions.like("Schedule.availabledays", "%"+days+"%"));
			
			criteria.add(Restrictions.ge("flightid.reservationcapacity",Integer.valueOf(seats)));

			

			List<Schedule> slist= criteria.list();

			System.out.println(slist);

			session.getTransaction().commit();
			session.close();

			return  (ArrayList<Schedule>) slist;
		}catch (org.hibernate.QueryException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;

		}


	}


	public Flight viewbyflightid(String flightid) {
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		try
		{
			Flight flightbean=(Flight) session.get(Flight.class, flightid);



			session.getTransaction().commit();
			session.close();
			return flightbean;
		}
		catch (HibernateException e) {
			
			System.out.println(e.getMessage());

			return null;

		}

	}


	public Route virebyRouteid(String routeid) {

		Session session=sessionfactory.openSession();
		session.beginTransaction();
		try
		{
			Route routebean=(Route) session.get(Route.class, routeid);
			session.getTransaction().commit();
			session.close();
			return routebean;
		}
		catch (HibernateException e) {

			System.out.println(e.getMessage());
			return null;
		}
	}

}
