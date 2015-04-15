package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18223")
public class BenchmarkTest18223 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		long l = new java.util.Random().nextLong();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextLong() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a81996 = param; //assign
		StringBuilder b81996 = new StringBuilder(a81996);  // stick in stringbuilder
		b81996.append(" SafeStuff"); // append some safe content
		b81996.replace(b81996.length()-"Chars".length(),b81996.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map81996 = new java.util.HashMap<String,Object>();
		map81996.put("key81996", b81996.toString()); // put in a collection
		String c81996 = (String)map81996.get("key81996"); // get it back out
		String d81996 = c81996.substring(0,c81996.length()-1); // extract most of it
		String e81996 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d81996.getBytes() ) )); // B64 encode and decode it
		String f81996 = e81996.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f81996); // reflection
	
		return bar;	
	}
}
