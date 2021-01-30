package com.cruds.frs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cruds.frs.entity.Flight;
import com.cruds.frs.entity.Route;
import com.cruds.frs.entity.Schedule;
import com.cruds.frs.service.ScheduleService;

@Controller
public class ScheduleController {
	
	@Autowired
	ScheduleService service;
	
	@RequestMapping(value="/Scheduleadd",method=RequestMethod.GET)
	public String showScheduleform(Model model)
	{
		model.addAttribute("command",new Schedule());
		return "scheduleadd";
		
	}
	
	
	@RequestMapping(value="/Scheduleadd",method=RequestMethod.POST)
	public String getscheduleform(@RequestParam("scheduleid") String scheduleid,@RequestParam("flightid") String flightid,@RequestParam("routeid") String routeid, @RequestParam("travelduration") String travelduration
			,@RequestParam("availabledays") String availabledays,@RequestParam("departuretime") String departuretime,HttpServletRequest request)
	{
		
		Flight flightbean=new Flight(flightid);
		Route routebean=new Route(routeid);
		Schedule schedulebean=new Schedule(scheduleid,flightbean, routebean, Integer.parseInt(travelduration), availabledays, departuretime);
		
		System.out.println(schedulebean);
		
		if(service.addSchedule(schedulebean) != null)
		{
			request.setAttribute("MESSAGE","Insertion Success");
			return "scheduleadd";
			
		}
		
		
		else 
		{
			request.setAttribute("MESSAGE","Inseration Failed may be due to  duplicate entry or flightid & routeid not found in their respective table ");
			return "scheduleadd";
		}
				
	}
	
	@RequestMapping(value="/Schedulelist",method=RequestMethod.GET)
	public String getScheduleviewtable(Model model)
	{
		model.addAttribute("SCHEDULE_LIST",service.viewByAllSchedule());
		
		return "schedulelist";
		
	}
	
	@RequestMapping(value="/Scheduledel",method=RequestMethod.GET)
	public String showDeletepage(@RequestParam("Scheduleid")String scheduleid,@RequestParam("Flightid")String flightid,@RequestParam("Routeid")String routeid,@RequestParam("AvailableDays") String availabledays,
		@RequestParam("Travelduration")String travelduration,@RequestParam("Departuretime")String departuretime,HttpSession session)
	{
		session.setAttribute("Scheduleid", scheduleid);
		session.setAttribute("Flightid",flightid);
		session.setAttribute("Routeid", routeid);
		session.setAttribute("Availabledays",availabledays);
		session.setAttribute("Travelduration",travelduration);
		session.setAttribute("Departuretime",departuretime);
		
		return "scheduledelete";
		
	}
	
	@RequestMapping(value="/scheduledelete" ,method=RequestMethod.GET)
	 public String dodeleteSchedule(HttpSession session,HttpServletRequest request,Model model)
	{
		
		String scheduleid=(String) session.getAttribute("Scheduleid");
		
		if(service.removeSchedule(scheduleid)!=0)
		{
			model.addAttribute("SCHEDULE_LIST",service.viewByAllSchedule());
			//session.invalidate();
			request.setAttribute("MESSAGE", "Deleted Success");
			return "schedulelist";	
		}
		else
		{
			request.setAttribute("MESSAGE","Deleted Failed");
			return "scheduledelete";
			
		}
		
	}
	@RequestMapping(value="/ScheduleModify",method=RequestMethod.GET)
	public String getmodifyschdedulepage(@RequestParam("Scheduleid")String scheduleid,@RequestParam("Flightid")String flightid,@RequestParam("Routeid")String routeid,@RequestParam("AvailableDays") String availabledays,
			@RequestParam("Travelduration")String travelduration,@RequestParam("Departuretime")String departuretime,HttpSession session)
	{
		
		session.setAttribute("Scheduleid", scheduleid);
		session.setAttribute("Flightid",flightid);
		session.setAttribute("Routeid", routeid);
		session.setAttribute("Availabledays",availabledays);
		session.setAttribute("Travelduration",travelduration);
		session.setAttribute("Departuretime",departuretime);
		
		return "schedulemodify";
	}
	
	@RequestMapping(value="/schedulemodify",method=RequestMethod.POST)
	public String domodifySchedule(@RequestParam("Flightid")String flightid,@RequestParam("Routeid")String routeid,@RequestParam("Availabledays") String availabledays,
			@RequestParam("Travelduration")String travelduration,@RequestParam("Departuretime")String departuretime,HttpSession session ,HttpServletRequest request,Model model)
	{
		String Scheduleid=(String) session.getAttribute("Scheduleid");
		
		Flight flightbean=new Flight(flightid);
		
		Route routebean=new Route(routeid);
		
		
		Schedule scheduleBean=new Schedule(Scheduleid, flightbean, routebean, Integer.parseInt(travelduration), availabledays, departuretime);
		
		if(service.modifySchedule(scheduleBean))
		{
			request.setAttribute("MESSAGE","Updated Success");
			model.addAttribute("SCHEDULE_LIST",service.viewByAllSchedule());
			return "schedulelist";	
		}
		else
		{
			
			request.setAttribute("MESSAGE","UPdation Failed");
			return "schedulemodify";
			
		}
		
	
		
	}
	


}
