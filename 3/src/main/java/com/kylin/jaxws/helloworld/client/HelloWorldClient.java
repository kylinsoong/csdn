package com.kylin.jaxws.helloworld.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.kylin.jaxws.helloworld.HelloWorld;

public class HelloWorldClient {
	public static void main(String[] args) throws Exception {

		final QName serviceName = new QName("com.kylin.jaxws.helloworld", "HelloWorldService");
		final URL wsdlURL = new URL("http://localhost:8080/jaxws-helloworld/HelloWorldService/HelloWorldService?wsdl");

		final Service service = Service.create(wsdlURL, serviceName);
		final HelloWorld helloworld = (HelloWorld) service.getPort(HelloWorld.class);
		
		System.out.println(helloworld.helloworld());
		
	}
}
