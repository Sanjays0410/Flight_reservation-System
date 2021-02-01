package com.cruds.frs.db;

import java.util.ArrayList;

import com.cruds.frs.entity.Flight;
import com.cruds.frs.entity.Route;
import com.cruds.frs.entity.Schedule;

public interface CustomerDAO {
	
	public ArrayList<Schedule> viewScheduleByRoute(String source,String Destination,String days);

	public Flight viewbyflightid(String flightid);
	
	public Route virebyRouteid(String routeid);
}
