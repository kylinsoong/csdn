package com.kylin.jpa.helloworld.web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.kylin.jpa.helloworld.po.User;
import com.kylin.jpa.helloworld.service.UserDao;

@Named
@RequestScoped
public class GreetController {

   @Inject
   private UserDao userDao;

   private String username;
   
   private String greeting;

   public void greet() {
      User user = userDao.getForUsername(username);
      if (user != null) {
         greeting = "Hello, " + user.getFirstName() + " " + user.getLastName() + "!";
      } else {
         greeting = "No such user exists! Use 'admin' or 'kylin'";
      }
   }
   
   public String getUsername() {
      return username;
   }
   
   public void setUsername(String username) {
      this.username = username;
   }
   
   public String getGreeting() {
      return greeting;
   }
   
}
