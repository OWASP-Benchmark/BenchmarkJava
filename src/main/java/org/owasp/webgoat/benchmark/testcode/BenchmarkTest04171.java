package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04171")
public class BenchmarkTest04171 extends HttpServlet {
	
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
		String a72193 = param; //assign
		StringBuilder b72193 = new StringBuilder(a72193);  // stick in stringbuilder
		b72193.append(" SafeStuff"); // append some safe content
		b72193.replace(b72193.length()-"Chars".length(),b72193.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map72193 = new java.util.HashMap<String,Object>();
		map72193.put("key72193", b72193.toString()); // put in a collection
		String c72193 = (String)map72193.get("key72193"); // get it back out
		String d72193 = c72193.substring(0,c72193.length()-1); // extract most of it
		String e72193 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d72193.getBytes() ) )); // B64 encode and decode it
		String f72193 = e72193.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f72193); // reflection
		
		
		java.io.File file = new java.io.File(bar);
	}
}
