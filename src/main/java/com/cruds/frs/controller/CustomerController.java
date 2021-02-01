package com.cruds.frs.controller;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cruds.frs.entity.Flight;
import com.cruds.frs.entity.Schedule;
import com.cruds.frs.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService service;

	@RequestMapping(value="/Customersearch",method=RequestMethod.GET)
	public String viewSearchbuCustomer()
	{


		return "CustomerSearch";

	}

	@RequestMapping(value="/Customersearch",method=RequestMethod.POST)
	public String doviewSearchbyCustomer( @RequestParam("Source")String source,@RequestParam("Destination")String destination,@RequestParam("Availabledays") String days, Model model,HttpServletRequest request,HttpSession session)
	{
		if(source.equals(destination))
		{
			request.setAttribute("CHECK", "pLEASE change source or destination U entered \n"+source+"\n on both");

			return "CustomerSearch";


		}

		else if(service.viewScheduleByRoute(source, destination, days).isEmpty())
		{
			request.setAttribute("NO_FLIGHT", " NO Flight on\n"+days+"\n :(");

			return "CustomerSearch";
		}
		else 
		{
			model.addAttribute("FLIGHT_LIST",service.viewScheduleByRoute(source, destination, days));
			request.setAttribute("MESSAGE", "Flights found :)");

			return "CustomerSearch";
		}

	}
	
	@RequestMapping(value="/Viewflightonid",method=RequestMethod.GET)
	public String viewflightbasedonID(@RequestParam("flightid")String flightid)
	{
		System.out.println(flightid);
		Flight flightbean=service.viewbyflightid(flightid);
		 
		System.out.println(flightbean);
		
		System.out.println(flightbean.getFlightname());
		
		
		 
		return "CustomerSearch";
		
	}




}
