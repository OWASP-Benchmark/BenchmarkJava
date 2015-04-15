package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05775")
public class BenchmarkTest05775 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;
		
		
		// Chain a bunch of propagators in sequence
		String a84269 = param; //assign
		StringBuilder b84269 = new StringBuilder(a84269);  // stick in stringbuilder
		b84269.append(" SafeStuff"); // append some safe content
		b84269.replace(b84269.length()-"Chars".length(),b84269.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map84269 = new java.util.HashMap<String,Object>();
		map84269.put("key84269", b84269.toString()); // put in a collection
		String c84269 = (String)map84269.get("key84269"); // get it back out
		String d84269 = c84269.substring(0,c84269.length()-1); // extract most of it
		String e84269 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d84269.getBytes() ) )); // B64 encode and decode it
		String f84269 = e84269.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g84269 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g84269); // reflection
		
		
		response.getWriter().write(bar);
	}
}
