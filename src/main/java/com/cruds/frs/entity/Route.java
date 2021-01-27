package com.cruds.frs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Route {

	@Id
	private String Routeid;
	
	@Column
	private String Source;
	
	@Column
	private String Destination;
	
	@Column
	private int Distance;
	
	@Column
	private int fare;
	
	public Route() {
		// TODO Auto-generated constructor stub
	}

	public Route(String routeid, String source, String destinstion, int distance, int fare) {
		super();
		Routeid = routeid;
		Source = source;
		Destination = destinstion;
		Distance = distance;
		this.fare = fare;
	}

	public String getRouteid() {
		return Routeid;
	}

	public void setRouteid(String routeid) {
		Routeid = routeid;
	}

	public String getSource() {
		return Source;
	}

	public void setSource(String source) {
		Source = source;
	}

	

	public String getDestination() {
		return Destination;
	}

	public void setDestination(String destination) {
		Destination = destination;
	}

	public int getDistance() {
		return Distance;
	}

	public void setDistance(int distance) {
		Distance = distance;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	@Override
	public String toString() {
		return "Route [Routeid=" + Routeid + ", Source=" + Source + ", Destination=" + Destination + ", Distance="
				+ Distance + ", fare=" + fare + "]";
	}

	
	
	
	
}
