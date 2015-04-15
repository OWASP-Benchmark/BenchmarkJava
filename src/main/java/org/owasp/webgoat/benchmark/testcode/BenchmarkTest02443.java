package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02443")
public class BenchmarkTest02443 extends HttpServlet {
	
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
		String a9551 = param; //assign
		StringBuilder b9551 = new StringBuilder(a9551);  // stick in stringbuilder
		b9551.append(" SafeStuff"); // append some safe content
		b9551.replace(b9551.length()-"Chars".length(),b9551.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map9551 = new java.util.HashMap<String,Object>();
		map9551.put("key9551", b9551.toString()); // put in a collection
		String c9551 = (String)map9551.get("key9551"); // get it back out
		String d9551 = c9551.substring(0,c9551.length()-1); // extract most of it
		String e9551 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d9551.getBytes() ) )); // B64 encode and decode it
		String f9551 = e9551.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f9551); // reflection
		
		
		Object[] obj = { "a", "b" };
		
		response.getWriter().format(bar,obj);
	}
}
