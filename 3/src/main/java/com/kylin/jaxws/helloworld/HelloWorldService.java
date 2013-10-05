package com.kylin.jaxws.helloworld;

import javax.ejb.Stateless;
import javax.jws.WebService;

import org.apache.log4j.Logger;

@Stateless
@WebService(
	endpointInterface = "com.kylin.jaxws.helloworld.HelloWorld",
	targetNamespace = "com.kylin.jaxws.helloworld", 
	serviceName = "HelloWorldService"
)
public class HelloWorldService implements HelloWorld {
	
	private static final Logger logger = Logger.getLogger(HelloWorldService.class);
	
	
	public String helloworld() {
		
		logger.info("HelloWorld Service be invoked");

		return "HelloWorld, JAX-WS!";
	}
}
