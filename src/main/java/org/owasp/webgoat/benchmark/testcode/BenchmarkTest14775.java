package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14775")
public class BenchmarkTest14775 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		java.io.File file = new java.io.File(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a70638 = param; //assign
		StringBuilder b70638 = new StringBuilder(a70638);  // stick in stringbuilder
		b70638.append(" SafeStuff"); // append some safe content
		b70638.replace(b70638.length()-"Chars".length(),b70638.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map70638 = new java.util.HashMap<String,Object>();
		map70638.put("key70638", b70638.toString()); // put in a collection
		String c70638 = (String)map70638.get("key70638"); // get it back out
		String d70638 = c70638.substring(0,c70638.length()-1); // extract most of it
		String e70638 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d70638.getBytes() ) )); // B64 encode and decode it
		String f70638 = e70638.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f70638); // reflection
	
		return bar;	
	}
}
