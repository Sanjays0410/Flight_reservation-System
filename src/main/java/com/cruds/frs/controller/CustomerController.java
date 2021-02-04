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
import com.cruds.frs.entity.Route;
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
	public String doviewSearchbyCustomer( @RequestParam("Source")String source,@RequestParam("Destination")String destination,@RequestParam("Availabledays") String days,@RequestParam("Seats") String seats, Model model,HttpServletRequest request,HttpSession session)
	{
		int Seats=Integer.parseInt(seats);
		System.out.println(Seats);
		if(source.equals(destination))
		{
			request.setAttribute("CHECK", "pLEASE change source or destination U entered \n"+source+"\n on both");

			return "CustomerSearch";


		}

		else if(service.viewScheduleByRoute(source, destination, days,seats).isEmpty())
		{
			request.setAttribute("NO_FLIGHT", " NO Flight on\n"+days+"\n :(");

			return "CustomerSearch";
		}
		else 
		{
			model.addAttribute("FLIGHT_LIST",service.viewScheduleByRoute(source, destination, days,seats));
			request.setAttribute("MESSAGE", "FLIGHTS FOUND :)");

			return "CustomerSearch";
		}

	}
	
	@RequestMapping(value="/Viewflightbyid",method=RequestMethod.GET)
	public String viewflightbasedonID(@RequestParam("flightid")String flightid,Model model)
	{
		System.out.println(flightid);
		
		Flight flightbean=service.viewbyflightid(flightid);
		
		model.addAttribute("FLIGHT_ID",flightbean.getFlightid());
		model.addAttribute("FLIGHT_NAME",flightbean.getFlightname());
		model.addAttribute("SEATS_AVAILABLE",flightbean.getReservationcapacity());
		
		int seats=flightbean.getReservationcapacity()-5;
		
		System.out.println(seats);
		
		
		 
		return "CustomerFlightbyid";
		
	}
	
	
	@RequestMapping(value="/ViewRoutebyid",method=RequestMethod.GET)
	public String viewRoutebasedonID(@RequestParam("routeid")String Routeid,Model model)
	{
		System.out.println(Routeid);
		
		Route routebean=service.viewbyRouteid(Routeid);
		
		model.addAttribute("ROUTE_ID",routebean.getRouteid());
		model.addAttribute("SOURCE",routebean.getSource());
		model.addAttribute("DESTINATION",routebean.getDestination());
		model.addAttribute("DISTANCE",routebean.getDistance());
		model.addAttribute("FARE",routebean.getFare());
		
		
		 
		return "CustomerRoutebyid";
		
	}
	
	



}
