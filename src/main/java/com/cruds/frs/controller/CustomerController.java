package com.cruds.frs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String doviewSearchbyCustomer( @RequestParam("Source")String source,@RequestParam("Destination")String destination,@RequestParam("Days")String days, Model model,HttpServletRequest request)
	{
		if(service.viewScheduleByRoute(source, destination, days) != null){
		
		model.addAttribute("SEARCH_LIST",service.viewScheduleByRoute(source, destination, days));
		request.setAttribute("MESSAGE","Successes");
		
		return "CustomerSearch";
		}
		else
		{
			request.setAttribute("MESSAGE","Failed");
			return "CustomerSearch";	
		}
		
	}
	
	
	

}
