package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04440")
public class BenchmarkTest04440 extends HttpServlet {
	
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
		
		
		// Chain a bunch of propagators in sequence
		String a84190 = param; //assign
		StringBuilder b84190 = new StringBuilder(a84190);  // stick in stringbuilder
		b84190.append(" SafeStuff"); // append some safe content
		b84190.replace(b84190.length()-"Chars".length(),b84190.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map84190 = new java.util.HashMap<String,Object>();
		map84190.put("key84190", b84190.toString()); // put in a collection
		String c84190 = (String)map84190.get("key84190"); // get it back out
		String d84190 = c84190.substring(0,c84190.length()-1); // extract most of it
		String e84190 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d84190.getBytes() ) )); // B64 encode and decode it
		String f84190 = e84190.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g84190 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g84190); // reflection
		
		
		int randNumber = new java.util.Random().nextInt(99);
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextInt(int) executed");
	}
}
