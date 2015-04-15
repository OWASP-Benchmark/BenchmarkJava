package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest04474")
public class BenchmarkTest04474 extends HttpServlet {
	
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
		String a84234 = param; //assign
		StringBuilder b84234 = new StringBuilder(a84234);  // stick in stringbuilder
		b84234.append(" SafeStuff"); // append some safe content
		b84234.replace(b84234.length()-"Chars".length(),b84234.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map84234 = new java.util.HashMap<String,Object>();
		map84234.put("key84234", b84234.toString()); // put in a collection
		String c84234 = (String)map84234.get("key84234"); // get it back out
		String d84234 = c84234.substring(0,c84234.length()-1); // extract most of it
		String e84234 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d84234.getBytes() ) )); // B64 encode and decode it
		String f84234 = e84234.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f84234); // reflection
		
		
		response.setHeader("SomeHeader", bar);
	}
}
