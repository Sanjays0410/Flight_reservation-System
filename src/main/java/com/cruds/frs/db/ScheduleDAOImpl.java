package com.cruds.frs.db;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cruds.frs.entity.Schedule;
import com.cruds.frs.exception.FRSException;

@Repository
public class ScheduleDAOImpl implements ScheduleDAO {
	
	
	@Autowired
	SessionFactory sessionfactory;


	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	public String addSchedule(Schedule scheduleBean) {
		
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		try
		{
			
		
		session.save(scheduleBean);
		session.getTransaction().commit();
		session.close();
		return "success";
		}
		catch (FRSException e) {
			// TODO: handle exception
			e.printStackTrace();
			if(e.getMessage().contains("Duplicate"))
			{
				throw new FRSException(scheduleBean.getScheduleid() +" already exists! duplicate entry");
			}
			else
			{   
				throw new FRSException(e.getMessage() +"please contact system admin");
			}
		}
			catch (org.hibernate.exception.ConstraintViolationException e) {
				// TODO: handle exception
				System.out.println("duplicate entry or flight id not there or route id not there");

			}
			return null;
	}

	public ArrayList<Schedule> viewByAllSchedule() {
		
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		ArrayList<Schedule>  slist=(ArrayList<Schedule>) session.createQuery("from Schedule").list();
		session.getTransaction().commit();
		session.close();
		return slist;
	}

	public int removeSchedule(String scheduleId) {
		
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		try
		{
		 Schedule schedulebean=(Schedule) session.load(Schedule.class,scheduleId);
		 session.delete(schedulebean);
		 session.getTransaction().commit();
		 session.close();
		return 1;
		}
		catch ( java.lang.NumberFormatException e) {

			System.out.println("nullformat exception");
			return 0;
		}
		catch (org.hibernate.TransientObjectException e) {
			// TODO: handle exception
			return 0;
		}
		
	}

	public boolean modifySchedule(Schedule scheduleBean) {
		
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		try
		{
		session.update(scheduleBean);
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
