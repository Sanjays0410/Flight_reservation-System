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
			,@RequestParam("seatingcapacity")int seatingcapacity,@RequestParam("reservationcapacity") int reservationcapacity,
			HttpServletRequest request,RedirectAttributes redirectattribute)
	{
		Flight flightBean=new Flight(flightid, flightname, seatingcapacity, reservationcapacity);


		System.out.println(flightBean); 

		if(seatingcapacity<reservationcapacity)
		{	
			request.setAttribute("MESSAGE","Reservation capacity is more than Seating capacity are u a idiot to enter like that " );
			return "flight";

		}
		else if(flightBean!=null&&service.addFlight(flightBean)!=null)
		{
			request.setAttribute("MESSAGE","Inseration Success");

			return "flight";


		}
		else
		{
			request.setAttribute("MESSAGE","Insertion Failed  duplicate key!!\n"+flightid+"\nalready there");
			return "flight";
		}
	}




	@RequestMapping(value="/flightlist",method=RequestMethod.GET)
	public String viewallflights(Model model)
	{
		model.addAttribute("FLIGHT_LIST",service.viewByAllFlights());

		//jsp
		return "flightlist";

	}

	//@RequestMapping(value="/flightdelete",method=RequestMethod.GET)


	@RequestMapping(value="/flightdelete",method=RequestMethod.GET)
	public String showflightdeleteform( HttpServletRequest request,HttpSession session)
	{

		//	model.addAttribute("FLIGHT_LIST",service.viewByAllFlights());

		String flightid=request.getParameter("flightid");
		String flightname=request.getParameter("flightname");
		String seatingcapacity=request.getParameter("seatingcapacity");
		String reservationcapacity=request.getParameter("reservationcapacity");

		session.setAttribute("flightid",flightid);
		session.setAttribute("flightname",flightname);
		session.setAttribute("seatingcapacity",seatingcapacity);
		session.setAttribute("reservationcapacity",reservationcapacity);


		//jsp
		return "flightdel";

	} 
	@RequestMapping(value="/flightdel",method=RequestMethod.GET)
	public String getflightDeleteform( 
			HttpServletRequest request,HttpSession session,Model model)
	{

		String flightid=(String)session.getAttribute("flightid");
		System.out.println(flightid);


		if(service.removeFlight(flightid)!=0)
		{
			request.setAttribute("MESSAGE", "succuessfully deleted");
			/*session.removeAttribute("flightid");
			session.removeAttribute("flightname");
			session.removeAttribute("seatingcapacity");
			session.removeAttribute("reservationcapacity");
			 */

			//session.invalidate();

			model.addAttribute("FLIGHT_LIST",service.viewByAllFlights());
			return "flightlist";
		}

		else
		{
			request.setAttribute("MESSAGE", "unsuccessfull delete its mapped with schedule");
			return "flightdel";

		}



		/*}
		catch (SMSException e) {
			// TODO: handle exception 
			 request.setAttribute("MESSAGE",e.getInfo());
		}
		return "flightdel";*/

	}



	@RequestMapping(value="/flightmodify",method=RequestMethod.GET)
	public String getModifyform(HttpServletRequest request,HttpSession session)
	{

		String flightid=request.getParameter("flightid");
		String flightname=request.getParameter("flightname");
		String seatingcapacity=request.getParameter("seatingcapacity");
		String reservationcapacity=request.getParameter("reservationcapacity");

		session.setAttribute("flightid",flightid);
		session.setAttribute("flightname",flightname);
		session.setAttribute("seatingcapacity",seatingcapacity);
		session.setAttribute("reservationcapacity",reservationcapacity);


		return "flightmodify";


	}

	@RequestMapping(value="/flightmodify",method=RequestMethod.POST)
	public String domodifyflight(HttpSession session,HttpServletRequest request,Model model)
	{

		String flightid=(String)session.getAttribute("flightid");
		String flightname=request.getParameter("flightname");
		String seatingcapacity=request.getParameter("seatingcapacity");
		String reservationcapacity=request.getParameter("reservationcapacity");



		Flight flightbean=new Flight(flightid, flightname, Integer.valueOf(seatingcapacity), Integer.valueOf(reservationcapacity));
		System.out.println(flightbean);
		if(service.modifyFlight(flightbean))
		{
			request.setAttribute("MESSAGE","Updated Success");
			//session.invalidate();
			model.addAttribute("FLIGHT_LIST",service.viewByAllFlights());

			return "flightlist";

		}
		else
		{
			request.setAttribute("MESSAGE","Updated Failed");
			return "redirect:flightmodify";

		}





	}



}
