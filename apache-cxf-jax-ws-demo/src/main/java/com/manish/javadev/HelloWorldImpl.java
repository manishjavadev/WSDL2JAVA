
package com.manish.javadev;

import javax.jws.WebService;

@WebService(endpointInterface = "com.manish.javadev.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	public String sayHi(Employee emp) {
		return "Hello " + emp.getFname();
	}
}
