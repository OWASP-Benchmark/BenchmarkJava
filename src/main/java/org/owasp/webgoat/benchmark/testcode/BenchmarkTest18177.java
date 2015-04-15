package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18177")
public class BenchmarkTest18177 extends HttpServlet {
	
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
		
		boolean randNumber = new java.util.Random().nextBoolean();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBoolean() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a75199 = param; //assign
		StringBuilder b75199 = new StringBuilder(a75199);  // stick in stringbuilder
		b75199.append(" SafeStuff"); // append some safe content
		b75199.replace(b75199.length()-"Chars".length(),b75199.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map75199 = new java.util.HashMap<String,Object>();
		map75199.put("key75199", b75199.toString()); // put in a collection
		String c75199 = (String)map75199.get("key75199"); // get it back out
		String d75199 = c75199.substring(0,c75199.length()-1); // extract most of it
		String e75199 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d75199.getBytes() ) )); // B64 encode and decode it
		String f75199 = e75199.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f75199); // reflection
	
		return bar;	
	}
}
