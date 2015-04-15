package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15525")
public class BenchmarkTest15525 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		java.lang.Math.random();
		
		response.getWriter().println("Weak Randomness Test java.lang.Math.random() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a87868 = param; //assign
		StringBuilder b87868 = new StringBuilder(a87868);  // stick in stringbuilder
		b87868.append(" SafeStuff"); // append some safe content
		b87868.replace(b87868.length()-"Chars".length(),b87868.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map87868 = new java.util.HashMap<String,Object>();
		map87868.put("key87868", b87868.toString()); // put in a collection
		String c87868 = (String)map87868.get("key87868"); // get it back out
		String d87868 = c87868.substring(0,c87868.length()-1); // extract most of it
		String e87868 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d87868.getBytes() ) )); // B64 encode and decode it
		String f87868 = e87868.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f87868); // reflection
	
		return bar;	
	}
}
