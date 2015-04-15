package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17591")
public class BenchmarkTest17591 extends HttpServlet {
	
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
		

		String bar = doSomething(param);
		
		long l = new java.util.Random().nextLong();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextLong() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a66709 = param; //assign
		StringBuilder b66709 = new StringBuilder(a66709);  // stick in stringbuilder
		b66709.append(" SafeStuff"); // append some safe content
		b66709.replace(b66709.length()-"Chars".length(),b66709.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map66709 = new java.util.HashMap<String,Object>();
		map66709.put("key66709", b66709.toString()); // put in a collection
		String c66709 = (String)map66709.get("key66709"); // get it back out
		String d66709 = c66709.substring(0,c66709.length()-1); // extract most of it
		String e66709 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d66709.getBytes() ) )); // B64 encode and decode it
		String f66709 = e66709.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g66709 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g66709); // reflection
	
		return bar;	
	}
}
