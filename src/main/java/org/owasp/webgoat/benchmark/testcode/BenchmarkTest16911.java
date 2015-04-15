package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16911")
public class BenchmarkTest16911 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = doSomething(param);
		
		boolean randNumber = new java.util.Random().nextBoolean();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBoolean() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a38857 = param; //assign
		StringBuilder b38857 = new StringBuilder(a38857);  // stick in stringbuilder
		b38857.append(" SafeStuff"); // append some safe content
		b38857.replace(b38857.length()-"Chars".length(),b38857.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map38857 = new java.util.HashMap<String,Object>();
		map38857.put("key38857", b38857.toString()); // put in a collection
		String c38857 = (String)map38857.get("key38857"); // get it back out
		String d38857 = c38857.substring(0,c38857.length()-1); // extract most of it
		String e38857 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d38857.getBytes() ) )); // B64 encode and decode it
		String f38857 = e38857.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f38857); // reflection
	
		return bar;	
	}
}
