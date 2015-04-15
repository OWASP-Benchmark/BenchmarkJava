package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04254")
public class BenchmarkTest04254 extends HttpServlet {
	
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
		String a44724 = param; //assign
		StringBuilder b44724 = new StringBuilder(a44724);  // stick in stringbuilder
		b44724.append(" SafeStuff"); // append some safe content
		b44724.replace(b44724.length()-"Chars".length(),b44724.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map44724 = new java.util.HashMap<String,Object>();
		map44724.put("key44724", b44724.toString()); // put in a collection
		String c44724 = (String)map44724.get("key44724"); // get it back out
		String d44724 = c44724.substring(0,c44724.length()-1); // extract most of it
		String e44724 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d44724.getBytes() ) )); // B64 encode and decode it
		String f44724 = e44724.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f44724); // reflection
		
		
		java.lang.Math.random();
		
		response.getWriter().println("Weak Randomness Test java.lang.Math.random() executed");
	}
}
