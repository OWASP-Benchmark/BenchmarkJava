package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01935")
public class BenchmarkTest01935 extends HttpServlet {
	
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
		
		
		// Chain a bunch of propagators in sequence
		String a4799 = param; //assign
		StringBuilder b4799 = new StringBuilder(a4799);  // stick in stringbuilder
		b4799.append(" SafeStuff"); // append some safe content
		b4799.replace(b4799.length()-"Chars".length(),b4799.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map4799 = new java.util.HashMap<String,Object>();
		map4799.put("key4799", b4799.toString()); // put in a collection
		String c4799 = (String)map4799.get("key4799"); // get it back out
		String d4799 = c4799.substring(0,c4799.length()-1); // extract most of it
		String e4799 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d4799.getBytes() ) )); // B64 encode and decode it
		String f4799 = e4799.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f4799); // reflection
		
		
		float rand = new java.util.Random().nextFloat();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextFloat() executed");
	}
}
