package com.cruds.frs.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruds.frs.db.ScheduleDAO;
import com.cruds.frs.entity.Schedule;

@Service
public class ScheduleService {
	
	@Autowired
	ScheduleDAO scheduleDAO;
	
	public String addSchedule(Schedule scheduleBean)
	{
		return scheduleDAO.addSchedule(scheduleBean);
	}
	
	public ArrayList<Schedule> viewByAllSchedule()
	{
		return scheduleDAO.viewByAllSchedule();
	}

	public int removeSchedule(String scheduleId)
	{
		return scheduleDAO.removeSchedule(scheduleId);
	}
	public boolean modifySchedule(Schedule scheduleBean)
	{
		return scheduleDAO.modifySchedule(scheduleBean);
	}
}
