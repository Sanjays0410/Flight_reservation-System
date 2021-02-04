package com.cruds.frs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Credentials {
	
	
	

	private String userid;
	
	@Id
	private String emailid;
	
	@Column
	private String password;
	
	@Column
	private String usertype;
	
	@Column
	private int loginstatus;
	
	
	public Credentials() {
		// TODO Auto-generated constructor stub
	}
	

	public Credentials(String emailid, String password, String usertype, int loginstatus) {
		super();
		this.emailid = emailid;
		this.password = password;
		this.usertype = usertype;
		this.loginstatus = loginstatus;
	}
	
	


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getEmailid() {
		return emailid;
	}


	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUsertype() {
		return usertype;
	}


	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}


	public int getLoginstatus() {
		return loginstatus;
	}


	public void setLoginstatus(int loginstatus) {
		this.loginstatus = loginstatus;
	}


	@Override
	public String toString() {
		return "Credentials [userid=" + userid + ", emailid=" + emailid + ", password=" + password + ", usertype="
				+ usertype + ", loginstatus=" + loginstatus + "]";
	}
	
	
	

}
