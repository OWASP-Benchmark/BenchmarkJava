package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02734")
public class BenchmarkTest02734 extends HttpServlet {
	
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
		String a68289 = param; //assign
		StringBuilder b68289 = new StringBuilder(a68289);  // stick in stringbuilder
		b68289.append(" SafeStuff"); // append some safe content
		b68289.replace(b68289.length()-"Chars".length(),b68289.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map68289 = new java.util.HashMap<String,Object>();
		map68289.put("key68289", b68289.toString()); // put in a collection
		String c68289 = (String)map68289.get("key68289"); // get it back out
		String d68289 = c68289.substring(0,c68289.length()-1); // extract most of it
		String e68289 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d68289.getBytes() ) )); // B64 encode and decode it
		String f68289 = e68289.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f68289); // reflection
		
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String,java.lang.Object^)
		request.getSession().setAttribute( "foo", bar);
	}
}
