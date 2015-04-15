package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01230")
public class BenchmarkTest01230 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a4766 = param; //assign
		StringBuilder b4766 = new StringBuilder(a4766);  // stick in stringbuilder
		b4766.append(" SafeStuff"); // append some safe content
		b4766.replace(b4766.length()-"Chars".length(),b4766.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map4766 = new java.util.HashMap<String,Object>();
		map4766.put("key4766", b4766.toString()); // put in a collection
		String c4766 = (String)map4766.get("key4766"); // get it back out
		String d4766 = c4766.substring(0,c4766.length()-1); // extract most of it
		String e4766 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d4766.getBytes() ) )); // B64 encode and decode it
		String f4766 = e4766.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f4766); // reflection
		
		
		response.getWriter().write(bar.toCharArray());
	}
}
