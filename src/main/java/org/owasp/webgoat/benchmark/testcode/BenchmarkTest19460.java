package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19460")
public class BenchmarkTest19460 extends HttpServlet {
	
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

		String bar = doSomething(param);
		
		double stuff = new java.util.Random().nextGaussian();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextGaussian() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a67105 = param; //assign
		StringBuilder b67105 = new StringBuilder(a67105);  // stick in stringbuilder
		b67105.append(" SafeStuff"); // append some safe content
		b67105.replace(b67105.length()-"Chars".length(),b67105.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map67105 = new java.util.HashMap<String,Object>();
		map67105.put("key67105", b67105.toString()); // put in a collection
		String c67105 = (String)map67105.get("key67105"); // get it back out
		String d67105 = c67105.substring(0,c67105.length()-1); // extract most of it
		String e67105 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d67105.getBytes() ) )); // B64 encode and decode it
		String f67105 = e67105.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f67105); // reflection
	
		return bar;	
	}
}
