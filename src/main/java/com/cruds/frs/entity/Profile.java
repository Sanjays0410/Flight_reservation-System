package com.cruds.frs.entity;




import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Profile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String userid;
	
	@Column
	private String firstname;
	
	@Column
	private String lastname;
	
	@Column
	private Date DOB;
	@Column
	private String gender;
	
	@Column
	private String street;
	
	@Column
	private String location;
	
	@Column
	private String city;
	
	@Column
	private String state;
	
	@Column
	private String pincode;
	
	@Column
	private String mobileno;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	
	public Profile() {
		// TODO Auto-generated constructor stub
	}

	
	

	public Profile(String userid) {
		super();
		this.userid = userid;
	}




	public Profile(String firstname, String lastname, Date dOB, String gender, String street, String location,
			String city, String state, String pincode, String mobileno, String email, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		DOB = dOB;
		this.gender = gender;
		this.street = street;
		this.location = location;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.mobileno = mobileno;
		this.email = email;
		this.password = password;
	}




	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	

	public Date getDOB() {
		return DOB;
	}




	public void setDOB(Date dOB) {
		DOB = dOB;
	}




	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	public String getMobileno() {
		return mobileno;
	}


	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Profile [userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname + ", DOB=" + DOB
				+ ", gender=" + gender + ", street=" + street + ", location=" + location + ", city=" + city + ", state="
				+ state + ", pincode=" + pincode + ", mobileno=" + mobileno + ", email=" + email + ", password="
				+ password + "]";
	}
	
	

}
