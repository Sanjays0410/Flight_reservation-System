package com.cruds.frs.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruds.frs.db.RouteDAO;
import com.cruds.frs.entity.Route;

@Service
public class RouteService {

	@Autowired
	RouteDAO routeDAO;
	
	public String addRoute(Route Routebean)
	{
		return routeDAO.addRoute(Routebean);
	}
	public ArrayList<Route> viewByAllRoute()
	{
		return routeDAO.viewByAllRoute();
	}
	
	public int  removeRoute(String routeId)
	{
		return routeDAO.removeRoute(routeId);
	}
	public boolean modifyRoute(Route routeBean)
	{
		return routeDAO.modifyRoute(routeBean);
	}
	
	
}
