package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19806")
public class BenchmarkTest19806 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();

		String bar = doSomething(param);
		
		new java.io.File(bar, "/Test.txt");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a87905 = param; //assign
		StringBuilder b87905 = new StringBuilder(a87905);  // stick in stringbuilder
		b87905.append(" SafeStuff"); // append some safe content
		b87905.replace(b87905.length()-"Chars".length(),b87905.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map87905 = new java.util.HashMap<String,Object>();
		map87905.put("key87905", b87905.toString()); // put in a collection
		String c87905 = (String)map87905.get("key87905"); // get it back out
		String d87905 = c87905.substring(0,c87905.length()-1); // extract most of it
		String e87905 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d87905.getBytes() ) )); // B64 encode and decode it
		String f87905 = e87905.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f87905); // reflection
	
		return bar;	
	}
}
