package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04285")
public class BenchmarkTest04285 extends HttpServlet {
	
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
		String a9942 = param; //assign
		StringBuilder b9942 = new StringBuilder(a9942);  // stick in stringbuilder
		b9942.append(" SafeStuff"); // append some safe content
		b9942.replace(b9942.length()-"Chars".length(),b9942.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map9942 = new java.util.HashMap<String,Object>();
		map9942.put("key9942", b9942.toString()); // put in a collection
		String c9942 = (String)map9942.get("key9942"); // get it back out
		String d9942 = c9942.substring(0,c9942.length()-1); // extract most of it
		String e9942 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d9942.getBytes() ) )); // B64 encode and decode it
		String f9942 = e9942.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g9942 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g9942); // reflection
		
		
		Object[] obj = { "a", bar };
		
		response.getWriter().format(java.util.Locale.US,"notfoo",obj);
	}
}
