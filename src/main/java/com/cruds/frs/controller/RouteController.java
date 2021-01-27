package com.cruds.frs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cruds.frs.entity.Route;
import com.cruds.frs.service.RouteService;

@Controller
public class RouteController {

	@Autowired
	RouteService service;


	@RequestMapping(value="/Routeadd",method=RequestMethod.GET)
	public String showrouteform(Model model)
	{
		model.addAttribute("command", new Route());

		return "Routeadd";
	}


	@RequestMapping(value="/Routeadd",method=RequestMethod.POST)
	public String doRouteForm(@RequestParam("routeid") String routeid,@RequestParam("source") String source,@RequestParam("destination") String destination
			,@RequestParam("distance")int distance,@RequestParam("farepermile")int farepermile ,HttpServletRequest request)
	{
		int fare=distance*farepermile;
		System.out.println(fare);
		Route Routebean=new Route(routeid, source, destination, distance, fare);
		System.out.println(Routebean);

	  if(source.equals(destination))
		{
			request.setAttribute("MESSAGE", "please change source or destination ");
			return "Routeadd";

		}
	  else if(service.addRoute(Routebean)!=null)

		{
			request.setAttribute("MESSAGE","Insertion Successfully ");

			return "Routeadd";

		}

		else 
		{
			request.setAttribute("MESSAGE","Insertion Failed");
			return "Routeadd";

		}

	}
	
	@RequestMapping(value="/Routelist",method=RequestMethod.GET)
	public String ViewRoutetable(Model model)
	{
		model.addAttribute("ROUTE_LIST",service.viewByAllRoute());
		
		return "Routelist";
		
	}
	
	@RequestMapping(value="/Routedelete",method=RequestMethod.GET)
	public String showDeletepage(HttpServletRequest request,HttpSession session)
	{
		String Routeid=request.getParameter("Routeid");
		String Source=request.getParameter("Source");
		String Destination=request.getParameter("Destination");
		String Distance=request.getParameter("Distance");
		String Fare=request.getParameter("Fare");
		
		
		session.setAttribute("Routeid",Routeid);
		session.setAttribute("Source",Source);
		session.setAttribute("Destination",Destination);
		session.setAttribute("Distance",Integer.parseInt(Distance));
		session.setAttribute("Fare",Integer.parseInt(Fare));
		
		
		
		return "Routedelete";
		
	}
	
	@RequestMapping(value="/Routedelete",method=RequestMethod.GET)
	public String dodeleteRoute(HttpSession session,HttpServletRequest request)
	{
		
		 String flightid=(String)session.getAttribute("flightid");
		 System.out.println(flightid);
		
		
		/*if(service.(flightid)!=0)
		{
			request.setAttribute("MESSAGE", "succuessfully deleted");
			session.removeAttribute("flightid");
			session.removeAttribute("flightname");
			session.removeAttribute("seatingcapacity");
			session.removeAttribute("reservationcapacity");
		
			
			session.invalidate();
			return "Routedelete";
		}
		
		else
		{
			request.setAttribute("MESSAGE", "unsuccessfull delete");
			return "Routedelete";
			
		}*/
		
		return "Routedelete";
		
	}
	
	






}
