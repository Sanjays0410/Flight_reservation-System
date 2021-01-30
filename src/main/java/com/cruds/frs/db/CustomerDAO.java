package com.cruds.frs.db;

import java.util.ArrayList;

import com.cruds.frs.entity.Schedule;

public interface CustomerDAO {
	
	public ArrayList<Schedule> viewScheduleByRoute(String source, String destination, String days);

}
