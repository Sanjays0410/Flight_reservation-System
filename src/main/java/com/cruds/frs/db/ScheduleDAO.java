package com.cruds.frs.db;

import java.util.ArrayList;

import com.cruds.frs.entity.Schedule;

public interface ScheduleDAO {
	
	
	public String addSchedule(Schedule scheduleBean);
	
	public ArrayList<Schedule> viewByAllSchedule();
	
	public int removeSchedule(String scheduleId);
	
	public boolean modifySchedule(Schedule scheduleBean);

}
