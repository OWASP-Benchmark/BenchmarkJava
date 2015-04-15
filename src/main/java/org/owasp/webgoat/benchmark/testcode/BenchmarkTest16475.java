package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest16475")
public class BenchmarkTest16475 extends HttpServlet {
	
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

		String bar = doSomething(param);
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String,java.lang.Object^)
		request.getSession().setAttribute( "foo", bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a48125 = param; //assign
		StringBuilder b48125 = new StringBuilder(a48125);  // stick in stringbuilder
		b48125.append(" SafeStuff"); // append some safe content
		b48125.replace(b48125.length()-"Chars".length(),b48125.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map48125 = new java.util.HashMap<String,Object>();
		map48125.put("key48125", b48125.toString()); // put in a collection
		String c48125 = (String)map48125.get("key48125"); // get it back out
		String d48125 = c48125.substring(0,c48125.length()-1); // extract most of it
		String e48125 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d48125.getBytes() ) )); // B64 encode and decode it
		String f48125 = e48125.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f48125); // reflection
	
		return bar;	
	}
}
