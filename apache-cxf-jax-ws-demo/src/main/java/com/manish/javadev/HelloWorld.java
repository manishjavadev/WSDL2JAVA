package com.manish.javadev;

import javax.jws.WebService;

@WebService
public interface HelloWorld {
	String sayHi(Employee emp);
}
