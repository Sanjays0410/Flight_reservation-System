package com.cruds.frs.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruds.frs.db.CustomerDAO;
import com.cruds.frs.entity.Schedule;

@Service
public class CustomerService {
	
	@Autowired
	CustomerDAO customerDAO;
	
	public ArrayList<Schedule> viewScheduleByRoute(String source, String destination, String days)
	{
		return customerDAO.viewScheduleByRoute(source, destination, days);
		
	}

}
