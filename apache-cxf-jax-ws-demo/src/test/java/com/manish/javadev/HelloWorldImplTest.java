
package com.manish.javadev;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HelloWorldImplTest {

	@Test
	public void testSayHi() {
		HelloWorldImpl helloWorldImpl = new HelloWorldImpl();
		Employee emp = new Employee();
		emp.setFname("Manish");
		String response = helloWorldImpl.sayHi(emp);
		assertEquals("HelloWorldImpl not properly saying hi", "Hello Manish", response);
	}
}
