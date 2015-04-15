package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04320")
public class BenchmarkTest04320 extends HttpServlet {
	
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
		String a71504 = param; //assign
		StringBuilder b71504 = new StringBuilder(a71504);  // stick in stringbuilder
		b71504.append(" SafeStuff"); // append some safe content
		b71504.replace(b71504.length()-"Chars".length(),b71504.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map71504 = new java.util.HashMap<String,Object>();
		map71504.put("key71504", b71504.toString()); // put in a collection
		String c71504 = (String)map71504.get("key71504"); // get it back out
		String d71504 = c71504.substring(0,c71504.length()-1); // extract most of it
		String e71504 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d71504.getBytes() ) )); // B64 encode and decode it
		String f71504 = e71504.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g71504 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g71504); // reflection
		
		
		Object[] obj = { "a", bar};
		response.getWriter().print(obj);
	}
}
