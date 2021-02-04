package com.cruds.frs.db;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cruds.frs.entity.Credentials;
import com.cruds.frs.entity.Profile;


@Repository
public class CredentialsDAOImpl implements CredentialsDAO{

	@Autowired
	SessionFactory sessionfactory;


	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}



	public String login(Credentials credentialsBean) {

		Session session=sessionfactory.openSession();
		session.beginTransaction();
		try
		{
		Credentials  u = (Credentials) session.createQuery("FROM Credentials C WHERE C.emailid = :emailid and C.password=:password and C.usertype=:usertype").setParameter("emailid", credentialsBean.getEmailid()).setParameter("password",credentialsBean.getPassword()
				).setParameter("usertype",credentialsBean.getUsertype())
				.uniqueResult();
		System.out.println(credentialsBean.getEmailid());
		System.out.println(credentialsBean.getPassword());

		System.out.println("password"+u.getPassword());
		session.getTransaction().commit();
		session.close();


		return "success";
		}
		catch (NullPointerException e) {
			// TODO: handle exception
			return null;
		}

	}



	public boolean Customeradd(Profile profilebean) {
		
		Session session=sessionfactory.openSession();
		session.beginTransaction();
		try
		{
		 Profile profilebean1=(Profile) session.save(profilebean);
		String userid=profilebean1.getUserid();
		Profile profileid=new Profile(userid);
		
		session.getTransaction().commit();
		session.close();
		return true;
		}
		catch (org.hibernate.exception.ConstraintViolationException e) {
			// TODO: handle exception
			System.out.println("duplicate entry not possible");
			return false;

		}
	
		
	}







}
