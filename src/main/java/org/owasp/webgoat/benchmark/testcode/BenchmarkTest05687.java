package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05687")
public class BenchmarkTest05687 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;
		
		
		// Chain a bunch of propagators in sequence
		String a68697 = param; //assign
		StringBuilder b68697 = new StringBuilder(a68697);  // stick in stringbuilder
		b68697.append(" SafeStuff"); // append some safe content
		b68697.replace(b68697.length()-"Chars".length(),b68697.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map68697 = new java.util.HashMap<String,Object>();
		map68697.put("key68697", b68697.toString()); // put in a collection
		String c68697 = (String)map68697.get("key68697"); // get it back out
		String d68697 = c68697.substring(0,c68697.length()-1); // extract most of it
		String e68697 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d68697.getBytes() ) )); // B64 encode and decode it
		String f68697 = e68697.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f68697); // reflection
		
		
		float rand = new java.util.Random().nextFloat();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextFloat() executed");
	}
}
