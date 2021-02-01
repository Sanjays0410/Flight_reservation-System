package com.cruds.frs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Flight {

	@Id
	private String flightid;
	@Column
	private String flightname;
	@Column
	private int seatingcapacity ;
	
	@Column
	private int reservationcapacity;
	
	public Flight() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Flight(String flightid) {
		super();
		this.flightid = flightid;
	}



	public Flight(String flightid, String flightname, int seatingcapacity, int reservationcapacity) {
		super();
		this.flightid = flightid;
		this.flightname = flightname;
		this.seatingcapacity = seatingcapacity;
		this.reservationcapacity = reservationcapacity;
	}

	public String getFlightid() {
		return flightid;
	}

	public void setFlightid(String flightid) {
		this.flightid = flightid;
	}

	public String getFlightname() {
		return flightname;
	}

	public void setFlightname(String flightname) {
		this.flightname = flightname;
	}

	public int getSeatingcapacity() {
		return seatingcapacity;
	}

	public void setSeatingcapacity(int seatingcapacity) {
		this.seatingcapacity = seatingcapacity;
	}

	public int getReservationcapacity() {
		return reservationcapacity;
	}

	public void setReservationcapacity(int reservationcapacity) {
		this.reservationcapacity = reservationcapacity;
	}



	@Override
	public String toString() {
		return  flightid;
	}

	
	
}
