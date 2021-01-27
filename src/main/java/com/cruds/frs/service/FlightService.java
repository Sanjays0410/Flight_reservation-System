package com.cruds.frs.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruds.frs.db.FlightDAO;
import com.cruds.frs.entity.Flight;

@Service
public class FlightService {
	
	@Autowired
	FlightDAO flightDAO;
	
	public String addFlight(Flight flightBean)
	{
		return flightDAO.addFlight(flightBean);
	}

	public ArrayList<Flight>  viewByAllFlights()
	{
		return flightDAO.viewByAllFlights();
	}
	public int removeFlight(String flightID)
	{
		return flightDAO.removeFlight(flightID);
	}
	
	public boolean modifyFlight(Flight flightbean)
	{
		return flightDAO.modifyFlight(flightbean);
	}
}
