package com.cruds.frs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruds.frs.db.CredentialsDAO;
import com.cruds.frs.entity.Credentials;
import com.cruds.frs.entity.Profile;

@Service
public class CredentialsService {
	
	@Autowired
	CredentialsDAO credentialsDAO;
	
	public String login(Credentials credentialsBean) {
		
		return credentialsDAO.login(credentialsBean);
	}
	public boolean Customeradd(Profile profilebean) {
		
		return credentialsDAO.Customeradd(profilebean);
	}

}
