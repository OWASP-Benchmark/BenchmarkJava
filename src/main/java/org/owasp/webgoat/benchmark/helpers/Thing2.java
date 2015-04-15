package org.owasp.webgoat.benchmark.helpers;

public class Thing2 implements ThingInterface {

	@Override
	public String doSomething(String i) {
		// reverse input
		String r = new StringBuilder(i).reverse().toString();
		return r;
	}
}
