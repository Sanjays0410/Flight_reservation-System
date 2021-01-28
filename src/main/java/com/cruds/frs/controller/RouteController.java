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
			request.setAttribute("MESSAGE","Insertion Failed  duplicate key!!\n"+routeid+"\nalready there");
			return "Routeadd";

		}

	}
	
	@RequestMapping(value="/Routelist",method=RequestMethod.GET)
	public String ViewRoutetable(Model model)
	{
		model.addAttribute("ROUTE_LIST",service.viewByAllRoute());
		
		return "Routelist";
		
	}
	
	@RequestMapping(value="/Routedel",method=RequestMethod.GET)
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
	public String dodeleteRoute(HttpSession session,HttpServletRequest request,Model model)
	{
		
		 String routeid=(String)session.getAttribute("Routeid");
		 System.out.println(routeid);
		
		
		if(service.removeRoute(routeid)!=0)
		{
			request.setAttribute("MESSAGE", "succuessfully deleted");
			/*session.removeAttribute("Routeid");
			session.removeAttribute("f");
			session.removeAttribute("seatingcapacity");
			session.removeAttribute("reservationcapacity");*/
		
			
			//session.invalidate();
			model.addAttribute("ROUTE_LIST",service.viewByAllRoute());
			return "Routelist";
			
		}
		
		else
		{
			request.setAttribute("MESSAGE", "unsuccessfull delete");
			return "Routedelete";
			
		}
		
	}
	
	@RequestMapping(value="/RouteModify",method=RequestMethod.GET)
	public String showroutemodifyform( HttpServletRequest request,HttpSession session)
	{
		String Routeid=request.getParameter("Routeid");
		String Source=request.getParameter("Source");
		String Destination=request.getParameter("Destination");
		String Distance=request.getParameter("Distance");
		String Fare=request.getParameter("Fare");
		
		
		session.setAttribute("Routeid",Routeid);
		session.setAttribute("Source",Source);
		session.setAttribute("Destination",Destination);
		session.setAttribute("Distance",Distance);
		session.setAttribute("Fare",Fare);
		
		return "Routemodify";
			
	}
	
	@RequestMapping(value="Routemodify",method=RequestMethod.POST)
	public String doRoutemodifyform(HttpSession session ,HttpServletRequest request,Model model )
	{
		String Routeid=(String) session.getAttribute("Routeid");
		String Source=request.getParameter("Source");
		String Destination=request.getParameter("Destination");
		String Distance=request.getParameter("Distance");
		String Fare=request.getParameter("Fare");
		
		
		String sessionfare=(String) session.getAttribute("Fare");
		
		System.out.println(sessionfare);
		
		Route routebean=new Route(Routeid, Source,Destination,Integer.valueOf( Distance), Integer.valueOf(Fare));
		
		System.out.println(routebean);
		 if(Source.equals(Destination))
			{
				request.setAttribute("MESSAGE", "please change source or destination ");
				return "Routemodify";

			}
		
		else if(service.modifyRoute(routebean))
		{
			request.setAttribute("MESSAGE","Updated Success");
			//session.invalidate();
			model.addAttribute("ROUTE_LIST",service.viewByAllRoute());
			return "Routelist";
			
		}
		else
		{
			request.setAttribute("MESSAGE","Updated Failed");
			return "redirect:Routemodify";
			
		}
		
		
	}
	
	
	






}
