package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03841")
public class BenchmarkTest03841 extends HttpServlet {
	
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
		String a6696 = param; //assign
		StringBuilder b6696 = new StringBuilder(a6696);  // stick in stringbuilder
		b6696.append(" SafeStuff"); // append some safe content
		b6696.replace(b6696.length()-"Chars".length(),b6696.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map6696 = new java.util.HashMap<String,Object>();
		map6696.put("key6696", b6696.toString()); // put in a collection
		String c6696 = (String)map6696.get("key6696"); // get it back out
		String d6696 = c6696.substring(0,c6696.length()-1); // extract most of it
		String e6696 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d6696.getBytes() ) )); // B64 encode and decode it
		String f6696 = e6696.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g6696 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g6696); // reflection
		
		
		double stuff = new java.util.Random().nextGaussian();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextGaussian() executed");
	}
}
