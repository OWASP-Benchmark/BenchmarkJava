package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04175")
public class BenchmarkTest04175 extends HttpServlet {
	
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
		String a86037 = param; //assign
		StringBuilder b86037 = new StringBuilder(a86037);  // stick in stringbuilder
		b86037.append(" SafeStuff"); // append some safe content
		b86037.replace(b86037.length()-"Chars".length(),b86037.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map86037 = new java.util.HashMap<String,Object>();
		map86037.put("key86037", b86037.toString()); // put in a collection
		String c86037 = (String)map86037.get("key86037"); // get it back out
		String d86037 = c86037.substring(0,c86037.length()-1); // extract most of it
		String e86037 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d86037.getBytes() ) )); // B64 encode and decode it
		String f86037 = e86037.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g86037 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g86037); // reflection
		
		
		java.io.File file = new java.io.File(bar);
	}
}
