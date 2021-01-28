package com.cruds.frs.db;

import java.util.ArrayList;

import com.cruds.frs.entity.Route;

public interface RouteDAO {

	public String addRoute(Route Routebean);
	
	 public ArrayList<Route> viewByAllRoute();
	 
	 public int removeRoute(String routeId);
	 
	 public boolean modifyRoute(Route routebean);
}
