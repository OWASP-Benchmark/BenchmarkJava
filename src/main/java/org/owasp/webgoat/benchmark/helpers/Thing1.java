package org.owasp.webgoat.benchmark.helpers;

public class Thing1 implements ThingInterface {

	@Override
	public String doSomething(String i) {
		// just assign input to return value
		String r = i;
		return r;
	}
}
