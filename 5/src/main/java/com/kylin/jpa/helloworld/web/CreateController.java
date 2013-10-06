package com.kylin.jpa.helloworld.web;

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
public class CreateController {

   @Inject
   private FacesContext facesContext;
   
   @Inject
   private UserDao userDao;
   
   @Named
   @Produces
   @RequestScoped
   private User newUser = new User();

   public void create() {
      try {
         userDao.createUser(newUser);
         facesContext.addMessage(null, new FacesMessage("A new user with id " + newUser.getId() + " has been created successfully"));
      } catch (Exception e) {
         facesContext.addMessage(null, new FacesMessage("An error has occured while creating the user (see log for details)"));
      }
   }
}
