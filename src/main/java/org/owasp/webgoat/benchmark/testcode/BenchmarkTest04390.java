package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04390")
public class BenchmarkTest04390 extends HttpServlet {
	
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
		String a58389 = param; //assign
		StringBuilder b58389 = new StringBuilder(a58389);  // stick in stringbuilder
		b58389.append(" SafeStuff"); // append some safe content
		b58389.replace(b58389.length()-"Chars".length(),b58389.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map58389 = new java.util.HashMap<String,Object>();
		map58389.put("key58389", b58389.toString()); // put in a collection
		String c58389 = (String)map58389.get("key58389"); // get it back out
		String d58389 = c58389.substring(0,c58389.length()-1); // extract most of it
		String e58389 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d58389.getBytes() ) )); // B64 encode and decode it
		String f58389 = e58389.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g58389 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g58389); // reflection
		
		
		response.getWriter().write(bar);
	}
}
