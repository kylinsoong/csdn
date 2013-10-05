package com.kylin.jaxws.helloworld;

import java.rmi.Remote;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface HelloWorld extends Remote {
	
   @WebMethod
   public String helloworld();
}
