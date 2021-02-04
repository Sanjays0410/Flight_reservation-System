package com.cruds.frs.db;

import com.cruds.frs.entity.Credentials;
import com.cruds.frs.entity.Profile;


public interface CredentialsDAO {
	
	
	public boolean Customeradd(Profile profilebean);
	
	 public String login(Credentials credentialsBean);

}
