package com.cruds.frs.db;

import java.util.ArrayList;

import com.cruds.frs.entity.Flight;

public interface FlightDAO {

	
	public String addFlight(Flight flightBean);  
	
	public ArrayList<Flight> viewByAllFlights();
	
	public int removeFlight(String flightID);
	
	
	//return type changes
	public boolean modifyFlight(Flight flightbean);

}
