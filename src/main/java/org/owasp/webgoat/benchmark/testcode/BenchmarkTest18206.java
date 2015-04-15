package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18206")
public class BenchmarkTest18206 extends HttpServlet {
	
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
		
		double stuff = new java.util.Random().nextGaussian();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextGaussian() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a4192 = param; //assign
		StringBuilder b4192 = new StringBuilder(a4192);  // stick in stringbuilder
		b4192.append(" SafeStuff"); // append some safe content
		b4192.replace(b4192.length()-"Chars".length(),b4192.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map4192 = new java.util.HashMap<String,Object>();
		map4192.put("key4192", b4192.toString()); // put in a collection
		String c4192 = (String)map4192.get("key4192"); // get it back out
		String d4192 = c4192.substring(0,c4192.length()-1); // extract most of it
		String e4192 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d4192.getBytes() ) )); // B64 encode and decode it
		String f4192 = e4192.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g4192 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g4192); // reflection
	
		return bar;	
	}
}
