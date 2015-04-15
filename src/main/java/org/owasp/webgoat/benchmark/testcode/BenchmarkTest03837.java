package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03837")
public class BenchmarkTest03837 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			param = map.get("foo")[0];
		}
		
		
		
		// Chain a bunch of propagators in sequence
		String a96214 = param; //assign
		StringBuilder b96214 = new StringBuilder(a96214);  // stick in stringbuilder
		b96214.append(" SafeStuff"); // append some safe content
		b96214.replace(b96214.length()-"Chars".length(),b96214.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map96214 = new java.util.HashMap<String,Object>();
		map96214.put("key96214", b96214.toString()); // put in a collection
		String c96214 = (String)map96214.get("key96214"); // get it back out
		String d96214 = c96214.substring(0,c96214.length()-1); // extract most of it
		String e96214 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d96214.getBytes() ) )); // B64 encode and decode it
		String f96214 = e96214.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f96214); // reflection
		
		
		double stuff = new java.util.Random().nextGaussian();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextGaussian() executed");
	}
}
