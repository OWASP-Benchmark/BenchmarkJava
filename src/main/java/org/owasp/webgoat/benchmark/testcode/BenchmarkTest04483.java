package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04483")
public class BenchmarkTest04483 extends HttpServlet {
	
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
		String a22139 = param; //assign
		StringBuilder b22139 = new StringBuilder(a22139);  // stick in stringbuilder
		b22139.append(" SafeStuff"); // append some safe content
		b22139.replace(b22139.length()-"Chars".length(),b22139.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map22139 = new java.util.HashMap<String,Object>();
		map22139.put("key22139", b22139.toString()); // put in a collection
		String c22139 = (String)map22139.get("key22139"); // get it back out
		String d22139 = c22139.substring(0,c22139.length()-1); // extract most of it
		String e22139 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d22139.getBytes() ) )); // B64 encode and decode it
		String f22139 = e22139.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g22139 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g22139); // reflection
		
		
		response.setHeader(bar, "SomeValue");
	}
}
