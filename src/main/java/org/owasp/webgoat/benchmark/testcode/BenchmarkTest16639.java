package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16639")
public class BenchmarkTest16639 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		new java.io.File(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir),bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a19801 = param; //assign
		StringBuilder b19801 = new StringBuilder(a19801);  // stick in stringbuilder
		b19801.append(" SafeStuff"); // append some safe content
		b19801.replace(b19801.length()-"Chars".length(),b19801.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map19801 = new java.util.HashMap<String,Object>();
		map19801.put("key19801", b19801.toString()); // put in a collection
		String c19801 = (String)map19801.get("key19801"); // get it back out
		String d19801 = c19801.substring(0,c19801.length()-1); // extract most of it
		String e19801 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d19801.getBytes() ) )); // B64 encode and decode it
		String f19801 = e19801.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f19801); // reflection
	
		return bar;	
	}
}
