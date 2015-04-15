package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04574")
public class BenchmarkTest04574 extends HttpServlet {
	
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
		String a13547 = param; //assign
		StringBuilder b13547 = new StringBuilder(a13547);  // stick in stringbuilder
		b13547.append(" SafeStuff"); // append some safe content
		b13547.replace(b13547.length()-"Chars".length(),b13547.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map13547 = new java.util.HashMap<String,Object>();
		map13547.put("key13547", b13547.toString()); // put in a collection
		String c13547 = (String)map13547.get("key13547"); // get it back out
		String d13547 = c13547.substring(0,c13547.length()-1); // extract most of it
		String e13547 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d13547.getBytes() ) )); // B64 encode and decode it
		String f13547 = e13547.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f13547); // reflection
		
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String^,java.lang.Object)
		request.getSession().setAttribute( bar, "foo");
	}
}
