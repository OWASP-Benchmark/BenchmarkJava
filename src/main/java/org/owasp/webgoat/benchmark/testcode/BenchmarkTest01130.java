package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01130")
public class BenchmarkTest01130 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a81732 = param; //assign
		StringBuilder b81732 = new StringBuilder(a81732);  // stick in stringbuilder
		b81732.append(" SafeStuff"); // append some safe content
		b81732.replace(b81732.length()-"Chars".length(),b81732.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map81732 = new java.util.HashMap<String,Object>();
		map81732.put("key81732", b81732.toString()); // put in a collection
		String c81732 = (String)map81732.get("key81732"); // get it back out
		String d81732 = c81732.substring(0,c81732.length()-1); // extract most of it
		String e81732 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d81732.getBytes() ) )); // B64 encode and decode it
		String f81732 = e81732.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g81732 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g81732); // reflection
		
		
		Object[] obj = { "a", bar };
		
		response.getWriter().format(java.util.Locale.US,"notfoo",obj);
	}
}
