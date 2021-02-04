package com.cruds.frs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruds.frs.db.CustomerDAO;
import com.cruds.frs.entity.Flight;
import com.cruds.frs.entity.Route;
import com.cruds.frs.entity.Schedule;

@Service
public class CustomerService {
	
	@Autowired
	CustomerDAO customerDAO;
	
	public ArrayList<Schedule> viewScheduleByRoute(String source,String destination,String days,String seats)
	{
		return customerDAO.viewScheduleByRoute(source,destination,days,seats);
		
	}
	public Flight viewbyflightid(String flightid){
		
		return customerDAO.viewbyflightid(flightid);
	}
	
	public Route viewbyRouteid( String routeid)
	{
		return customerDAO.virebyRouteid(routeid);
	}

}
