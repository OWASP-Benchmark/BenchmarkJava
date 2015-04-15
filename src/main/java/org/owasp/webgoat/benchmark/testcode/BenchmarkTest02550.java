package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02550")
public class BenchmarkTest02550 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}
		
		
		// Chain a bunch of propagators in sequence
		String a99085 = param; //assign
		StringBuilder b99085 = new StringBuilder(a99085);  // stick in stringbuilder
		b99085.append(" SafeStuff"); // append some safe content
		b99085.replace(b99085.length()-"Chars".length(),b99085.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map99085 = new java.util.HashMap<String,Object>();
		map99085.put("key99085", b99085.toString()); // put in a collection
		String c99085 = (String)map99085.get("key99085"); // get it back out
		String d99085 = c99085.substring(0,c99085.length()-1); // extract most of it
		String e99085 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d99085.getBytes() ) )); // B64 encode and decode it
		String f99085 = e99085.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f99085); // reflection
		
		
		boolean randNumber = new java.util.Random().nextBoolean();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBoolean() executed");
	}
}
