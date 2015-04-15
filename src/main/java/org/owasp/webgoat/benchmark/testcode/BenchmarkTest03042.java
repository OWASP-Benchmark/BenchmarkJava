package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03042")
public class BenchmarkTest03042 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a12059 = param; //assign
		StringBuilder b12059 = new StringBuilder(a12059);  // stick in stringbuilder
		b12059.append(" SafeStuff"); // append some safe content
		b12059.replace(b12059.length()-"Chars".length(),b12059.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map12059 = new java.util.HashMap<String,Object>();
		map12059.put("key12059", b12059.toString()); // put in a collection
		String c12059 = (String)map12059.get("key12059"); // get it back out
		String d12059 = c12059.substring(0,c12059.length()-1); // extract most of it
		String e12059 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d12059.getBytes() ) )); // B64 encode and decode it
		String f12059 = e12059.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f12059); // reflection
		
		
		Object[] obj = { "a", bar };
		
		response.getWriter().format(java.util.Locale.US,"notfoo",obj);
	}
}
