package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18843")
public class BenchmarkTest18843 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

		String bar = doSomething(param);
		
		double rand = new java.util.Random().nextDouble();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextDouble() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a82745 = param; //assign
		StringBuilder b82745 = new StringBuilder(a82745);  // stick in stringbuilder
		b82745.append(" SafeStuff"); // append some safe content
		b82745.replace(b82745.length()-"Chars".length(),b82745.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map82745 = new java.util.HashMap<String,Object>();
		map82745.put("key82745", b82745.toString()); // put in a collection
		String c82745 = (String)map82745.get("key82745"); // get it back out
		String d82745 = c82745.substring(0,c82745.length()-1); // extract most of it
		String e82745 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d82745.getBytes() ) )); // B64 encode and decode it
		String f82745 = e82745.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f82745); // reflection
	
		return bar;	
	}
}
