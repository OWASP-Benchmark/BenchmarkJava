package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01454")
public class BenchmarkTest01454 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a67064 = param; //assign
		StringBuilder b67064 = new StringBuilder(a67064);  // stick in stringbuilder
		b67064.append(" SafeStuff"); // append some safe content
		b67064.replace(b67064.length()-"Chars".length(),b67064.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map67064 = new java.util.HashMap<String,Object>();
		map67064.put("key67064", b67064.toString()); // put in a collection
		String c67064 = (String)map67064.get("key67064"); // get it back out
		String d67064 = c67064.substring(0,c67064.length()-1); // extract most of it
		String e67064 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d67064.getBytes() ) )); // B64 encode and decode it
		String f67064 = e67064.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f67064); // reflection
		
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String^,java.lang.Object)
		request.getSession().setAttribute( bar, "foo");
	}
}
