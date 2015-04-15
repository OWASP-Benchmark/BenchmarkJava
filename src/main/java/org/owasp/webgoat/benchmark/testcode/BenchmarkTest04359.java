package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04359")
public class BenchmarkTest04359 extends HttpServlet {
	
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
		String a99032 = param; //assign
		StringBuilder b99032 = new StringBuilder(a99032);  // stick in stringbuilder
		b99032.append(" SafeStuff"); // append some safe content
		b99032.replace(b99032.length()-"Chars".length(),b99032.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map99032 = new java.util.HashMap<String,Object>();
		map99032.put("key99032", b99032.toString()); // put in a collection
		String c99032 = (String)map99032.get("key99032"); // get it back out
		String d99032 = c99032.substring(0,c99032.length()-1); // extract most of it
		String e99032 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d99032.getBytes() ) )); // B64 encode and decode it
		String f99032 = e99032.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g99032 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g99032); // reflection
		
		
		response.getWriter().println(bar.toCharArray());
	}
}
