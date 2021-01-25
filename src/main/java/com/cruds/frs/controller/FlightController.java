package com.cruds.frs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.cruds.frs.entity.Flight;
import com.cruds.frs.service.FlightService;

@Controller
public class FlightController {
	
	@Autowired
	FlightService service;

	
	@RequestMapping(value="/flight",method=RequestMethod.GET)
	public String showFlightform(Model model)
	{
		model.addAttribute("command", new Flight());
		
		
		///jsp
		return "flight";
		
	}

	@RequestMapping(value="/flight",method=RequestMethod.POST)
	public String doFlight( @RequestParam("flightid") String flightid,@RequestParam("flightname") String flightname
			,@RequestParam("seatingcapacity")int seatingcapacity,@RequestParam("reservationcapacity") int reservationcapacity)
	{
		Flight flightBean=new Flight(flightid, flightname, seatingcapacity, reservationcapacity);
		
		service.addFlight(flightBean);
		
		System.out.println(flightBean); 
		
		//jsp
		return "success";
	
	}
	
	@RequestMapping(value="/flightlist",method=RequestMethod.GET)
	public String viewallflights(Model model)
	{
		model.addAttribute("FLIGHT_LIST",service.viewByAllFlights());
		
		//jsp
		return "flightlist";
		
	}
	
	//@RequestMapping(value="/flightdelete",method=RequestMethod.GET)
	@RequestMapping(value="/flightdelete-{flightid}",method=RequestMethod.GET)
	public String doflightdelete(@PathVariable String flightid)
	{
		
		service.removeFlight(flightid);
		
		//jsp
		return "redirect:flightlist";
			
	}
	
	@RequestMapping(value="/flightmodify-${f}",method=RequestMethod.POST)
	public String doflightModify( @RequestParam("flightid") String flightid,@RequestParam("flightname") String flightname
			,@RequestParam("seatingcapacity")int seatingcapacity,@RequestParam("reservationcapacity") int reservationcapacity) 
	{
		
		Flight flightbean=new Flight(flightid, flightname, seatingcapacity, reservationcapacity);
		
		service.modifyFlight(flightbean);
		
		
		//jsp
		return "flightmodify";
		
	}
	
	
	
	
	
}
