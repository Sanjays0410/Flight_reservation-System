package com.cruds.frs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Schedule {
	
	@Id
	private String scheduleid;
	
	@ManyToOne
	@JoinColumn(name="flightid")
	private Flight flightid;
	

	@ManyToOne
	@JoinColumn(name="routeid")
	private Route routeid;
	
	@Column
	private int travelduration;
	
	@Column
	private String availabledays;
	
	@Column
	private String departuretime;
	
	
	public Schedule() {
		// TODO Auto-generated constructor stub
	}


	public Schedule(String scheduleid, Flight flightid, Route routeid, int travelduration, String availabledays,
			String departuretime) {
		super();
		this.scheduleid = scheduleid;
		this.flightid = flightid;
		this.routeid = routeid;
		this.travelduration = travelduration;
		this.availabledays = availabledays;
		this.departuretime = departuretime;
	}


	public String getScheduleid() {
		return scheduleid;
	}


	public void setScheduleid(String scheduleid) {
		this.scheduleid = scheduleid;
	}


	public Flight getFlightid() {
		return flightid;
	}


	public void setFlightid(Flight flightid) {
		this.flightid = flightid;
	}


	public Route getRouteid() {
		return routeid;
	}


	public void setRouteid(Route routeid) {
		this.routeid = routeid;
	}


	public int getTravelduration() {
		return travelduration;
	}


	public void setTravelduration(int travelduration) {
		this.travelduration = travelduration;
	}


	public String getAvailabledays() {
		return availabledays;
	}


	public void setAvailabledays(String availabledays) {
		this.availabledays = availabledays;
	}


	public String getDeparturetime() {
		return departuretime;
	}


	public void setDeparturetime(String departuretime) {
		this.departuretime = departuretime;
	}


	@Override
	public String toString() {
		return "Schedule [scheduleid=" + scheduleid + ", flightid=" + flightid + ", routeid=" + routeid
				+ ", travelduration=" + travelduration + ", availabledays=" + availabledays + ", departuretime="
				+ departuretime + "]";
	}
	
	
	
	
}
