package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19474")
public class BenchmarkTest19474 extends HttpServlet {
	
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
		
		int r = new java.util.Random().nextInt();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextInt() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a12066 = param; //assign
		StringBuilder b12066 = new StringBuilder(a12066);  // stick in stringbuilder
		b12066.append(" SafeStuff"); // append some safe content
		b12066.replace(b12066.length()-"Chars".length(),b12066.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map12066 = new java.util.HashMap<String,Object>();
		map12066.put("key12066", b12066.toString()); // put in a collection
		String c12066 = (String)map12066.get("key12066"); // get it back out
		String d12066 = c12066.substring(0,c12066.length()-1); // extract most of it
		String e12066 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d12066.getBytes() ) )); // B64 encode and decode it
		String f12066 = e12066.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g12066 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g12066); // reflection
	
		return bar;	
	}
}
