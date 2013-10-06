package com.kylin.jpa.helloworld.web;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.kylin.jpa.helloworld.po.User;
import com.kylin.jpa.helloworld.service.UserDao;

@Named
@RequestScoped
public class ListController {

	@Inject
	private FacesContext facesContext;

	@Inject
	private UserDao userDao;
	
	private List<User> results;
	
	public List<User> getResults() {
		return results;
	}

	public void setResults(List<User> results) {
		this.results = results;
	}

	public List<User> getUsers() {
		
		try {
			results = userDao.getUsers();
			
			facesContext.addMessage(null, new FacesMessage("get all user successfully, total size: " + results.size()));
			
			return results;
		} catch (Exception e) {
			
			facesContext.addMessage(null, new FacesMessage("get all user failed"));
			
			throw new RuntimeException(e);
		}
	}

}
